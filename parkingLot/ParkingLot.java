package parkingLot;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import parkingLot.fee.FeeStrategy;
import parkingLot.fee.FlatRateFeeStrategy;
import parkingLot.parkingSpot.ParkingSpot;
import parkingLot.vehicle.Vehical;

public class ParkingLot {

    // is there are multiple parking lot then we can use the normal way but we are only focusing on one lot
    // i am using single ton that means every thing in the system in this and can be made only once

    private static final ParkingLot INSTANCE = new ParkingLot();
    private final List<ParkingFloor> floors = new ArrayList<>();
    // Imagine multiple threads (users/cars) accessing or modifying your map at the same time.
    // map for vehival number and parking tickets
    private final Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot(){
        feeStrategy = new FlatRateFeeStrategy();
    }

    public static synchronized ParkingLot getInstance(){
        return INSTANCE;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
    }

    public synchronized ParkingTicket parkVehical(Vehical vehical) throws Exception{
        for(ParkingFloor floor: floors){
            // optional return an object that can have value or null to check if it present we use ispresent() and to get the value we use ,get()
            Optional<ParkingSpot> spotOptional = floor.getAvailableSpot(vehical);
            if(spotOptional.isPresent()){
                ParkingSpot spot = spotOptional.get();
                if(spot.assignVehical(vehical)){
                    ParkingTicket ticket = new ParkingTicket(vehical, spot);
                    activeTickets.put(vehical.getVehicalNo(),ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No avilable spots for "+ vehical.getVehicalType()); 
    }

    public synchronized double unparkVehical(String vehicalNo) throws Exception{
        ParkingTicket ticket = activeTickets.remove(vehicalNo);
        if(ticket == null) throw new Exception("Ticket not found");

        ticket.geSpot().removeVehical();
        ticket.setExitTime();

        return feeStrategy.calculateFee(ticket);
    }

}
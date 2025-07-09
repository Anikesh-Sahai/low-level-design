package parkingLot.fee;

import java.util.Map;

import parkingLot.ParkingTicket;
import parkingLot.vehicle.VehicalType;

public class VehicalBasedFeeStrategy implements FeeStrategy {

    private final Map<VehicalType, Double> hourlyRates = Map.of(
        VehicalType.CAR, 20.0,
        VehicalType.BIKE, 10.0,
        VehicalType.TRUCK, 30.0
    );

    @Override
    public double calculateFee (ParkingTicket ticket){
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * hourlyRates.get(ticket.getVehical().getVehicalType());
    }
    
}
package parkingLot;

import java.util.List;
import java.util.Optional;

import parkingLot.parkingSpot.ParkingSpot;
import parkingLot.vehicle.Vehical;

public class ParkingFloor {

    private final int floorNo;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floor , List<ParkingSpot> spots){
        this.floorNo = floor;
        this.spots = spots;
    }

    // optional here is used because it can return null pointer so prevent null pointer exception
    public synchronized Optional<ParkingSpot> getAvailableSpot(Vehical vehical){
        //-> this here represents anonymous function like in js 
        return spots.stream().filter(spot -> spot.isAvailable() && spot.canFitVehical(vehical)).findFirst();
    }

    public int getFloorNumber (){ return floorNo; }
}
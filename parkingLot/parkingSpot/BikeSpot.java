package parkingLot.parkingSpot;

import parkingLot.vehicle.Vehical;
import parkingLot.vehicle.VehicalType;

public class BikeSpot extends ParkingSpot {

    public BikeSpot(String spotId){
        super(spotId);
    }

    @Override
    public boolean canFitVehical(Vehical vehical){
        return vehical.getVehicalType() == VehicalType.BIKE;
    }
}
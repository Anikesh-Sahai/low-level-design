package parkingLot.parkingSpot;

import parkingLot.vehicle.Vehical;
import parkingLot.vehicle.VehicalType;

public class LargeSpot extends ParkingSpot {

    public LargeSpot(String id){
        super(id);
    }

    @Override
    public boolean canFitVehical(Vehical vehical){
        return vehical.getVehicalType() == VehicalType.TRUCK;
    }
}
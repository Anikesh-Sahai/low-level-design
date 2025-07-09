package parkingLot.parkingSpot;

import parkingLot.vehicle.Vehical;
import parkingLot.vehicle.VehicalType;

public class CompactSpot extends ParkingSpot {

    public CompactSpot(String id){
        super(id);
    }

    @Override
    public boolean canFitVehical(Vehical vehical){
        return vehical.getVehicalType() == VehicalType.CAR;
    }
}
package parkingLot.parkingSpot;

public class ParkingSpotFactory {
    //A factory like this doesn't need to store any data — it only builds and returns objects. So there's no need to make instances of it.
    public static ParkingSpot createParkingSpot(ParkingSpotType type, String id){
        switch (type) {
            case BIKE:
                return new BikeSpot(id);
            case COMPACT:
                return new CompactSpot(id);
            case LARGE:
                return new LargeSpot(id);
            default:
                throw new IllegalArgumentException("Unknown parking spot type: " + type);
        }
    }
}
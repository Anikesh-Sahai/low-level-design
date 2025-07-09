package parkingLot.parkingSpot;

import parkingLot.vehicle.Vehical;

public abstract class ParkingSpot {

    //we are keeping these things private so that no other class can update it
    //final means that the reference cannot be changed once it's initialized. So: means that once spotId is set in the constructor: it cannot be reassigned later in the code. that basicaly means it makes it the costant
    private final String spotId;
    private Vehical vechical;
    private Boolean isOccupied;

    public ParkingSpot(String spotId){
        this.spotId = spotId;
        this.isOccupied = false;
    }

    //To prevent race conditions when multiple threads try to modify shared resources (like counters, lists, maps, etc.).no two threads can execute this method on the same object simultaneously. only single thread is used
    public synchronized boolean isAvailable(){
        return !isOccupied;
    }

    public synchronized boolean assignVehical(Vehical vehical){
        if(isOccupied){
            return false;
        }

        this.vechical = vehical;
        isOccupied = true;
        return true;
    }

    public synchronized void removeVehical(){
        vechical = null;
        isOccupied = false;
    }

    public Vehical getVehical(){    return vechical;    }
    
    public String getSpotId(){  return spotId;  }

    // this class need to be written in extends class
    public abstract boolean canFitVehical(Vehical vehical);

}
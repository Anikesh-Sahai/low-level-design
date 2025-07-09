package parkingLot;

import java.util.Date;
import java.util.UUID;

import parkingLot.parkingSpot.ParkingSpot;
import parkingLot.vehicle.Vehical;

public class ParkingTicket {

    private final String ticketId;
    private final Vehical vehical;
    private final ParkingSpot spot;
    private final long entryTime;
    private long exitTime;

    public ParkingTicket(Vehical vehical, ParkingSpot spot){
        this.vehical = vehical;
        this.spot = spot;
        this.ticketId = UUID.randomUUID().toString();
        this.entryTime = new Date().getTime();
    }

    public String getTicketId(){ return ticketId; }
    public Vehical getVehical(){ return vehical; }
    public ParkingSpot geSpot(){ return spot; }
    public long getEntryTime(){ return entryTime; }
    public long getExitTime(){ return exitTime; }

    public void setExitTime(){
        this.exitTime = new Date().getTime();
    }
}
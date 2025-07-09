package parkingLot.fee;

import parkingLot.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy {

    public static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(ParkingTicket ticket){
        long duration = ticket.getExitTime()-ticket.getEntryTime();
        long hours = (duration/1000*60*60) +1;
        return hours* RATE_PER_HOUR;
    }
    
}
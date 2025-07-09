package parkingLot.fee;

import parkingLot.ParkingTicket;

public interface FeeStrategy {

    double calculateFee(ParkingTicket ticket);
}
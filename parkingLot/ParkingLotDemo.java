package parkingLot;

import java.util.List;

import parkingLot.fee.VehicalBasedFeeStrategy;
import parkingLot.parkingSpot.ParkingSpot;
import parkingLot.parkingSpot.ParkingSpotFactory;
import parkingLot.parkingSpot.ParkingSpotType;
import parkingLot.vehicle.Bike;
import parkingLot.vehicle.Car;
import parkingLot.vehicle.Vehical;

public class ParkingLotDemo {

    public static void run(){
        ParkingLot parkingLot = ParkingLot.getInstance();

        // creating list of praking spot on one floor
        List<ParkingSpot> parkingSpotFloor1 = List.of(
            ParkingSpotFactory.createParkingSpot(ParkingSpotType.BIKE,"101"),
            ParkingSpotFactory.createParkingSpot(ParkingSpotType.COMPACT,"102"),
            ParkingSpotFactory.createParkingSpot(ParkingSpotType.LARGE,"103")
        );

        List<ParkingSpot> parkingSpotFloor2 = List.of(
            ParkingSpotFactory.createParkingSpot(ParkingSpotType.BIKE,"201"),
            ParkingSpotFactory.createParkingSpot(ParkingSpotType.COMPACT,"202"),
            ParkingSpotFactory.createParkingSpot(ParkingSpotType.LARGE,"203")
        );

        //creating parking floors
        ParkingFloor floor1 = new ParkingFloor(1, parkingSpotFloor1);
        ParkingFloor floor2 = new ParkingFloor(2, parkingSpotFloor2);

        //adding floors to  parkign lot
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        // ading fee starategy if wan to use flat stategy dont use it
        parkingLot.setFeeStrategy(new VehicalBasedFeeStrategy());

        // create vichles
        Vehical car1 = new Car("ABCD1212");
        Vehical car2 = new Car("XYZF1212");
        Vehical bike1 = new Bike("BXSG1212");

        // park vehical
        try {
            ParkingTicket parkingTicket1 = parkingLot.parkVehical(car1);
            System.out.println("Car 1 parked, Ticket Id: " + parkingTicket1.getTicketId());

            ParkingTicket parkingTicket2 = parkingLot.parkVehical(car2);
            System.out.println("Car 2 parked, Ticket Id: " + parkingTicket2.getTicketId());

            ParkingTicket parkingTicket3 = parkingLot.parkVehical(bike1);
            System.out.println("Bike 1 parked, Ticket Id: " + parkingTicket3.getTicketId());

            // try adding new vehhical

            Vehical car3 = new Car("DL0432");
            parkingLot.parkVehical(car3);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } 
        
        // unpark Vehical

        try {
            double fee = parkingLot.unparkVehical("ABCD1212");
            System.out.println("Vehicle: " + car1.getVehicalNo() + ", Fee: " + fee);

            fee = parkingLot.unparkVehical("1"); // invalid license number
        } catch (Exception e) {
            System.out.println("Exception while unparking: " + e.getMessage());
        }
        
    }
}
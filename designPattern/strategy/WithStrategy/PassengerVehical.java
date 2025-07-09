import Strategy.NormalDriveStrategy;

public class PassengerVehical extends Vehical {
    PassengerVehical(){
        super(new NormalDriveStrategy());
    }
}

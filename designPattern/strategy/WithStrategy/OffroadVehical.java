import Strategy.SportsDriveStrategy;

public class OffroadVehical extends Vehical {
    OffroadVehical(){
        super( new SportsDriveStrategy() );
    }
}

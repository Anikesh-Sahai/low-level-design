import Strategy.SportsDriveStrategy;

public class SportsVehical extends Vehical {
    SportsVehical(){
        super(new SportsDriveStrategy()) ;
    }
}

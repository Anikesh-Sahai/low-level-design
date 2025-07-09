import Strategy.DriveStrategy;

public class Vehical {
    DriveStrategy driveObject;

    public Vehical(DriveStrategy driveObj){
        this.driveObject=driveObj;
    }

    public void drive(){
        driveObject.drive();
    }
}

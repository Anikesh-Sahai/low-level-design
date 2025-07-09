import java.util.ArrayList;
import java.util.List;



public class main {
    public static void main(String args[]) {
        List<Vehical> vehicalList= new ArrayList<>();
        vehicalList.add(new MotorCycle());
        vehicalList.add(new Car());
        vehicalList.add(new Bicycle());
        
        for (Vehical vehical: vehicalList){
            System.out.println(vehical.getNoOfWheels().toString());
        }
    }    
}
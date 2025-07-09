package parkingLot.vehicle;

public class Vehical {

    protected String vehicalNo;
    protected VehicalType type;

    public Vehical(String number, VehicalType type){
        this.vehicalNo = number;
        this.type = type;
    }

    public String getVehicalNo(){
        return vehicalNo;
    }

    public VehicalType getVehicalType(){
        return type;
    }
}
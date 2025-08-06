package carRentalSystem;

public class Car {
    private final String make;
    private final String model;
    private final int year;
    private final String carNo;
    private final double pricePerDay;
    private boolean available;

    public Car(String make, String model, int year, String carNo, double price) {
        this.carNo = carNo;
        this.make = make;
        this.model = model;
        this.year = year;
        this.pricePerDay = price;
        this.available = true;
    }

    public double getRentalPricePerDay() {
        return pricePerDay;
    }

    public String getCarNo() {
        return carNo;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
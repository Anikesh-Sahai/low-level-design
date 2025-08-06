package carRentalSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
    private final String bookingId;
    private final Car car;
    private final Customer customer;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double price;

    public Booking(String id, LocalDate startDate, LocalDate endDate, Customer customer, Car car) {
        this.bookingId = id;
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = calculatePrice();
    }

    private double calculatePrice() {
        long daysRented = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return car.getRentalPricePerDay() * daysRented;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Car getCar() {
        return car;
    }

    public double getTotalPrice() {
        return price;
    }

    public String getBookingId() {
        return bookingId;
    }

}
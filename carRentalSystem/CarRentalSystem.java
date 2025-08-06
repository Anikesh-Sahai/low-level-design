package carRentalSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import carRentalSystem.Payment.CreditCardPaymentProcessor;
import carRentalSystem.Payment.PaymentProcessor;

public class CarRentalSystem {
    private final Map<String, Car> cars;
    private final Map<String, Booking> bookings;
    private final PaymentProcessor paymentProcessor;

    public CarRentalSystem() {
        cars = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardPaymentProcessor();
    }

    public void addCar(Car car) {
        cars.put(car.getCarNo(), car);
    }

    public void removeCar(String carNo) {
        cars.remove(carNo);
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars.values()) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                if (isCarAvailable(car, startDate, endDate)) {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate) {
        for (Booking booking : bookings.values()) {
            if (booking.getCar().equals(car)) {
                if (startDate.isBefore(booking.getEndDate()) && endDate.isAfter(booking.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized Booking makeBooking(Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        if (isCarAvailable(car, startDate, endDate)) {
            String id = generateReservationId();
            Booking booking = new Booking(id, startDate, endDate, customer, car);
            bookings.put(id, booking);
            car.setAvailable(false);
            return booking;
        }
        return null;
    }

    public synchronized void cancelBooking(String bookingID) {
        Booking Booking = bookings.remove(bookingID);
        if (Booking != null) {
            Booking.getCar().setAvailable(true);
        }
    }

    public boolean processPayment(Booking Booking) {
        return paymentProcessor.processPayment(Booking.getTotalPrice());
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
package carRentalSystem;

import java.time.LocalDate;
import java.util.List;

public class CarRentalSystemDemo {

    public static void run() {
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        // Add cars to the rental system
        carRentalSystem.addCar(new Car("Toyota", "Camry", 2022, "ABC123", 50.0));
        carRentalSystem.addCar(new Car("Honda", "Civic", 2021, "XYZ789", 45.0));
        carRentalSystem.addCar(new Car("Ford", "Mustang", 2023, "DEF456", 80.0));

        // Create customers
        Customer customer1 = new Customer("John Doe", "john@example.com", "DL1234");

        // Make reservations
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        List<Car> availableCars = carRentalSystem.searchCars("Toyota", "Camry", startDate, endDate);
        if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.get(0);
            Booking booking = carRentalSystem.makeBooking(customer1, selectedCar, startDate, endDate);
            if (booking != null) {
                boolean paymentSuccess = carRentalSystem.processPayment(booking);
                if (paymentSuccess) {
                    System.out.println("Booking successful. Booking ID: " + booking.getBookingId());
                } else {
                    System.out.println("Payment failed. Booking canceled.");
                    carRentalSystem.cancelBooking(booking.getBookingId());
                }
            } else {
                System.out.println("Selected car is not available for the given dates.");
            }
        } else {
            System.out.println("No available cars found for the given criteria.");
        }
    }
}
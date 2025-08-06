package carRentalSystem.Payment;

public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        // implementation of Credit card

        return true;
    }
}
package carRentalSystem.Payment;

public class PaypalPaymentProcessor implements PaymentProcessor {

    @Override
    public boolean processPayment(double amount) {
        // implementation of Paypal

        return true;
    }
}
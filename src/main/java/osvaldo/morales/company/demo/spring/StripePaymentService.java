package osvaldo.morales.company.demo.spring;

public class StripePaymentService implements PaymentService {

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using Stripe";
    }
}

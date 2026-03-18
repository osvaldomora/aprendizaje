package osvaldo.morales.company.demo.spring;

public class PaypalPaymentService implements PaymentService {

    @Override
    public String pay(double amount) {
        return "Paid " + amount + " using PayPal";
    }
}

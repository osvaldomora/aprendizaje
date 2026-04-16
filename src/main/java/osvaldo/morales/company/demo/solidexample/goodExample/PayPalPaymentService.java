package osvaldo.morales.company.demo.solidexample.goodExample;

public class PayPalPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Paid with PayPal: " + amount);
    }
}
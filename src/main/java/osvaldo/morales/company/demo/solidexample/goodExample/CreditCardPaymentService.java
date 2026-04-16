package osvaldo.morales.company.demo.solidexample.goodExample;


public class CreditCardPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Paid with Credit Card: " + amount);
    }
}
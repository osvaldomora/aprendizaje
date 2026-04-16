package osvaldo.morales.company.demo.solidexample.goodExample;
//factory para Open/Closed Principle (OCP):
public class PaymentFactory {

    public static PaymentService getPayment(String type) {
        switch (type) {
            case "CREDIT":
                return new CreditCardPaymentService();
            case "PAYPAL":
                return new PayPalPaymentService();
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}

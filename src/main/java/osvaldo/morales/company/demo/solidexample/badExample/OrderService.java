package osvaldo.morales.company.demo.solidexample.badExample;

import osvaldo.morales.company.demo.solidexample.goodExample.PaymentService;

public class OrderService {

    public void processOrder(String paymentType, double amount) {

        /*
         ❌ Single Responsibility Principle (SRP):  violated (too many responsibilities)
        Procesa pago
        Decide tipo de pago
        Guarda orden */
        // ❌ Open/Closed Principle (OCP):  violated (if/else for new payments)
        // ❌ Interface Segregation Principle DIP: violated (depends on concrete classes) High-level depends on low-level
        //ISP (Interface Segregation Principle): No interfaces at all

        if (paymentType.equals("CREDIT")) {
            CreditCardPaymentService cc = new CreditCardPaymentService();//DIP: violated
            cc.pay(amount);
        } else if (paymentType.equals("PAYPAL")) {
            PayPalPaymentService pp = new PayPalPaymentService();
            pp.pay(amount);
        }

        // ❌ SRP violated (also saving order)
        System.out.println("Order saved to DB");
    }
}


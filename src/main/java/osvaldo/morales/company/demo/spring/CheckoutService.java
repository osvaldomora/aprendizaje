package osvaldo.morales.company.demo.spring;

import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final PaymentService paymentService;

    public CheckoutService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String checkout(double amount) {
        return paymentService.pay(amount);
    }
}
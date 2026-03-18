package osvaldo.morales.company.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PaymentConfig {

    @Bean
    @Primary
    public PaymentService paypalPaymentService() {
        return new PaypalPaymentService();
    }

    @Bean
    public PaymentService stripePaymentService() {
        return new StripePaymentService();
    }
}

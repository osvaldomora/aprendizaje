package osvaldo.morales.company.demo.solidexample.goodExample;

public class OrderService {
    private PaymentService paymentService;
    private OrderRepository orderRepository;

    public OrderService(PaymentService paymentService, OrderRepository orderRepository) {
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
    }

    public void processOrder(double amount) {
        paymentService.pay(amount);
        orderRepository.save();
    }
}

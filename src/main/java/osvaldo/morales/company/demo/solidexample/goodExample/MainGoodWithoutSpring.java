package osvaldo.morales.company.demo.solidexample.goodExample;

public class MainGoodWithoutSpring {
    public static void main(String[] args) {

        /*
✅ 1. SRP (Single Responsibility Principle)

"A class should have only one reason to change."

✔️ Applied:

OrderService → handles order processing only
OrderRepository → handles persistence
PaymentService → handles payment logic
         */

        /*
        2. OCP (Open/Closed Principle)
"Software entities should be open for extension but closed for modification."
✔️ Applied:
Add new payment → create new class implementing PaymentService
No need to modify OrderService
         */

        /*
        ✅ 3. LSP (Liskov Substitution Principle)
"Objects of a superclass should be replaceable with objects of its subclasses."
✔️ Applied:
PaymentService payment = new PayPalPaymentService();
👉 Can replace with any implementation without breaking behavior

4. ISP (Interface Segregation Principle)
"Clients should not be forced to depend on interfaces they do not use.
👉 Small, focused interface

5. DIP (Dependency Inversion Principle)
"High-level modules should not depend on low-level modules. Both should depend on abstractions."
👉 OrderService depends on abstraction, not concrete class

DIP (Dependency Inversion Principle) is different from Dependency Injection (DI).
DIP is a design principle that promotes depending on abstractions instead of concrete classes.
DI is a technique (or pattern) where the creation of objects is delegated to an external component
         */

        PaymentService payment = PaymentFactory.getPayment("CREDIT");//LSP Objects of a superclass should be replaceable with objects of its subclasses
        OrderRepository repo = new OrderRepository();

        OrderService orderService = new OrderService(payment, repo);
        orderService.processOrder(100);
    }
}

package osvaldo.morales.company.demo.inherintance.staticexample;

public class ExcecutionFlow {
    static {
        System.out.println("1. Static block");
    }

    static int x = printStatic();

    int y = printInstance();

    public ExcecutionFlow() {
        System.out.println("4. Constructor");
    }

    static int printStatic() {
        System.out.println("2. Static variable");
        return 10;
    }

    int printInstance() {
        System.out.println("3. Instance variable");
        return 20;
    }
}

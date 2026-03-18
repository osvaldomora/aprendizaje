package osvaldo.morales.company.demo.staticL;

public class StaticExample {
    static int staticVar = 10;
    int instanceVar = 20;

    static void staticMethod() {
        System.out.println(staticVar);
        // System.out.println(instanceVar); // ERROR
    }

    void instanceMethod() {
        System.out.println(staticVar);
        System.out.println(instanceVar);
    }
}

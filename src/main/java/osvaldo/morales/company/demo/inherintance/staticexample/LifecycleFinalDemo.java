package osvaldo.morales.company.demo.inherintance.staticexample;

public class LifecycleFinalDemo {

    // 2️⃣ static final → static variables initialized
    static final int STATIC_FINAL = initStaticFinal();

    // 3️⃣ static block
    static {
        System.out.println("3️⃣ Static block executed");
    }

    // 5️⃣ final instance variable (no inicializada aún)
    public final int instanceFinal;

    // 1️⃣ Class load
    static int initStaticFinal() {
        System.out.println("2️⃣ Static final initialized");
        return 100;
    }

    // 6️⃣ Constructor
    public LifecycleFinalDemo(int value) {
        System.out.println("6️⃣ Constructor executed");
        this.instanceFinal = value; // ✅ última oportunidad
    }
}

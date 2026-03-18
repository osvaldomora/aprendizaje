package osvaldo.morales.company.demo.singleton;

public class SingletonLazy {

    private static volatile  SingletonLazy instance;

    private SingletonLazy() {}

    public static synchronized SingletonLazy getInstance() {

        if (instance == null) {
            instance = new SingletonLazy();
        }

        return instance;
    }
}

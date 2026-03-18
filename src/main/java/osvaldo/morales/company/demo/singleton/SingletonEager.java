package osvaldo.morales.company.demo.singleton;

public class SingletonEager {
    private  final SingletonEager INSTANCE = new SingletonEager();

    private SingletonEager() {
        // private constructor prevents instantiation
    }

    public  SingletonEager getInstance() {
        return INSTANCE;
    }
}

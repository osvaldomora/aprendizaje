package osvaldo.morales.company.demo.singleton;

public class SingletonDCL {
    public static void main(String[] args) {

        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        System.out.println(config1.getProperty("db.url"));

        System.out.println(config1 == config2); // true
    }
}

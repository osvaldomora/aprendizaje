package osvaldo.morales.company.demo.singleton;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    

    private static volatile ConfigurationManager instance;

    private Map<String, String> config = new HashMap<>();

    private ConfigurationManager() {
        loadConfiguration();
    }

    private void loadConfiguration() {
        System.out.println("Loading configuration...");
        config.put("db.url", "jdbc:postgresql://localhost:5432/app");
        config.put("db.user", "admin");
    }

    public static ConfigurationManager getInstance() {

        if (instance == null) {

            synchronized (ConfigurationManager.class) {

                if (instance == null) {
                    instance = new ConfigurationManager();
                }

            }
        }

        return instance;
    }

    public String getProperty(String key) {
        return config.get(key);
    }
}

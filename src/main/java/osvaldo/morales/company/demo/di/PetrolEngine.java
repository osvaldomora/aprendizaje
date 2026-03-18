package osvaldo.morales.company.demo.di;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol engine started");
    }
}

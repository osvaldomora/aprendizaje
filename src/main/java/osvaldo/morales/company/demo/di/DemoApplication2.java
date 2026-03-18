package osvaldo.morales.company.demo.di;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication2 implements CommandLineRunner {

    private final Car car;

    public DemoApplication2(Car car) {
        this.car = car;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication2.class, args);
    }

    @Override
    public void run(String... args) {
        car.drive();
    }
}

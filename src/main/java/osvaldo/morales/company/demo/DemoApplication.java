package osvaldo.morales.company.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import osvaldo.morales.company.demo.spring.CheckoutService;


@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		// 2️⃣ Obtiene el bean CheckoutService
		CheckoutService checkoutService = context.getBean(CheckoutService.class);

		// 3️⃣ Usa el servicio
		System.out.println(checkoutService.checkout(5));
	}

}

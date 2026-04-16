package osvaldo.morales.company.demo.java8.anonimclass;

public class MyTask2 {

    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("Running...");
        }
    };
}

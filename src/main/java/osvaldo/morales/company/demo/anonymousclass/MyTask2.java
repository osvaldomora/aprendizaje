package osvaldo.morales.company.demo.anonymousclass;

public class MyTask2 {

    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("Running...");
        }
    };
}

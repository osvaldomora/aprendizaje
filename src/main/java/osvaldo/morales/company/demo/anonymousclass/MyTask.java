package osvaldo.morales.company.demo.anonymousclass;

public class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Running...");
    }
}
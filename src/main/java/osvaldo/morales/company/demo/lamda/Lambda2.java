package osvaldo.morales.company.demo.lamda;
import java.util.function.Consumer;

public class Lambda2 {

    public static void main(String[] args) {

        // 1️⃣ CLASE ANÓNIMA
        Ficticia sumaAnonima = new Ficticia() {
            @Override
            public double calculadora(int x, int y) {
                return x + y;
            }
        };

        System.out.println("Clase Anónima: " + sumaAnonima.calculadora(4, 5));


        // 2️⃣ LAMBDA
        Ficticia multiplicacionLambda = (x, y) -> x * y;

        System.out.println("Lambda: " + multiplicacionLambda.calculadora(4, 5));


        // 3️⃣ METHOD REFERENCE
        Ficticia restaMetodoRef = Lambda2::restar;

        System.out.println("Method Reference: " + restaMetodoRef.calculadora(4, 5));
    }

    // Método estático compatible con la firma
    public static double restar(int x, int y) {
        return x - y;
    }
}

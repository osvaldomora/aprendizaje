package osvaldo.morales.company.demo.java8.exercise.streams.streamEstudy;

import java.util.*;
import java.util.stream.*;

public class StreamConversionsExample {

    public static void main(String[] args) {

        // =========================================
        // 1. map (Object → Object)
        // =========================================
        System.out.println("=== map (Object → Object) ===");

        List<String> names = List.of("Ana", "Luis", "Pedro");


        names.stream()
                .map(n -> n.length()) // String → Integer
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        // =========================================
        // 2. mapToInt (Object → int) List<String> names
        // =========================================
        System.out.println("\n=== mapToInt (Object → int) ===");

        IntStream intStream = names.stream()
                .mapToInt(n -> n.length()); // String → int

        intStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // =========================================
        // 3. mapToDouble (Object → double) List<String> names
        // =========================================
        System.out.println("\n=== mapToDouble (Object → double) ===");

        DoubleStream doubleStream = names.stream()
                .mapToDouble(n -> n.length() * 1.5);

        doubleStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // =========================================
        // 4. mapToObj (Primitive → Object)
        // =========================================
        System.out.println("\n=== mapToObj (int → Object) ===");

        IntStream nums = IntStream.of(1, 2, 3);

        Stream<String> strStream = nums
                .mapToObj(n -> "Num:" + n); // int → String

        strStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // =========================================
        // 5. boxed (Primitive → Wrapper)
        // =========================================
        System.out.println("\n=== boxed (int → Integer) ===");

        Stream<Integer> boxedStream = IntStream.of(1, 2, 3)
                .boxed();

        boxedStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // =========================================
        // 6. map vs mapToInt vs boxed
        // =========================================
        System.out.println("\n=== Comparación ===");

        // Object → Object
        Stream<Integer> s1 = names.stream()
                .map(n -> n.length());

        // Object → primitive
        IntStream s2 = names.stream()
                .mapToInt(n -> n.length());

        // primitive → Object
        Stream<Integer> s3 = s2.boxed();

        s1.forEach(x -> System.out.print(x + " "));
        System.out.println();

        s3.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // =========================================
        // 7. Ejemplo completo (flujo real)
        // =========================================
        System.out.println("\n=== Ejemplo real ===");

        int sum = names.stream()
                .mapToInt(n -> n.length()) // String → int
                .filter(x -> x > 3)
                .sum(); // operación terminal en IntStream

        System.out.println("Sum of lengths > 3 = " + sum);

        // =========================================
        // 8. FlatMap con conversiones
        // =========================================
        System.out.println("\n=== flatMap + mapToInt ===");

        List<List<Integer>> lists = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );


        int total = lists.stream()
                .flatMapToInt(l -> l.stream()
                .mapToInt(x -> x)) // flatten + primitive
                .sum();

        System.out.println("Total = " + total);
    }
}

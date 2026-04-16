package osvaldo.morales.company.demo.generics;

import java.util.*;

public class GenericsSuperExtendsDemo {

    public static void main(String[] args) {

        System.out.println("===== ? extends (producer) =====");

        // ----------------------------------
        // ? extends Number (LEE valores)

        // ----------------? extends restricts WRITING, not ASSIGNMENT------------------
        List<? extends Number> numberss = List.of(1, 2l, 3,2.3);
        List<Double> doubles = List.of(1.5, 2.5);
        List<Integer> integers = List.of(1, 2, 3);

        printNumbers(integers);
        printNumbers(doubles);

        // ❌ No puedes agregar
        // numbers.add(10); // ERROR

        System.out.println("\n===== ? super (consumer) =====");

        // ----------------------------------
        // ? super Integer (ESCRIBE valores)
        // ----------------------------------
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        addIntegers(numbers);
        addIntegers(objects);

        System.out.println("Numbers: " + numbers);
        System.out.println("Objects: " + objects);

        // ----------------------------------
        // PERO al leer...
        // ----------------------------------
        Object obj = numbers.get(0);
        System.out.println("Leyendo como Object: " + obj);

        // Integer i = numbers.get(0); // ❌ ERROR


        System.out.println("\n===== COMPARACIÓN CLAVE =====");

        List<Integer> ints = List.of(10, 20, 30);

        processExtends(ints);
        processSuper(new ArrayList<Number>());

    }


    // ======================================
    // ? extends → SOLO LEER (producer)
    // ======================================
    public static void printNumbers(List<? extends Number> list) {

        System.out.println("Leyendo lista:");

        for (Number n : list) {
            System.out.println("Valor: " + n);
        }


        // ❌ No puedes hacer esto:
        // list.add(10); // ERROR

        System.out.println("No puedo agregar elementos aquí");
    }


    // ======================================
    // ? super → SOLO ESCRIBIR (consumer)
    // ======================================
    public static void addIntegers(List<? super Integer> list) {

        System.out.println("Agregando valores...");

        list.add(100);
        list.add(200);

        // ✔️ puedes agregar Integer

        // PERO al leer:
        Object value = list.get(0);
        System.out.println("Leído como Object: " + value);
    }


    // ======================================
    // DEMO EXTENDS
    // ======================================
    public static void processExtends(List<? extends Number> list) {

        System.out.println("\nprocessExtends:");

        Number n = list.get(0);
        System.out.println("Leído como Number: " + n);

        // ❌ No puedes agregar
        // list.add(50);
    }


    // ======================================
    // DEMO SUPER
    // ======================================
    public static void processSuper(List<? super Integer> list) {

        System.out.println("\nprocessSuper:");

        list.add(999); // ✔️ permitido

        Object obj = list.get(0);
        System.out.println("Leído como Object: " + obj);
    }
}

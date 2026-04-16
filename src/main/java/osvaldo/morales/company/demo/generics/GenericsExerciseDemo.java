package osvaldo.morales.company.demo.generics;

import java.util.*;

public class GenericsExerciseDemo {

    public static void main(String[] args) {

        System.out.println("=== Exercise 1 ===");
        processGeneric(List.of(1, 2, 3));
        processGeneric(List.of("A", "B"));

        System.out.println("\n=== Exercise 2 ===");
        processExtends(List.of(1, 2, 3));
        processExtends(List.of(1.5, 2.5));

        System.out.println("\n=== Exercise 3 ===");
        List<Number> numbers = new ArrayList<>();
        processSuper(numbers);
        System.out.println("After add: " + numbers);

        System.out.println("\n=== Exercise 4 ===");
        Integer first = getFirst(List.of(10, 20, 30));
        System.out.println("First: " + first);

        System.out.println("\n=== Exercise 5 ===");
        printClass(Integer.class);
        printClass(Double.class);

        System.out.println("\n=== Exercise 6 ===");
        List<Integer> src = List.of(1, 2, 3);
        List<Number> dest = new ArrayList<>();
        copy(dest, src);
        System.out.println("Copied: " + dest);
    }

    // ============================
    // 1. <T>
    // ============================
    public static <T> void processGeneric(List<T> list) {
        System.out.println("Generic list: " + list);
    }

    // ============================
    // 2. ? extends Number
    // ============================
    public static void processExtends(List<? extends Number> list) {
        System.out.println("Reading extends:");
        for (Number n : list) {
            System.out.println(n);
        }
    }

    // ============================
    // 3. ? super Integer
    // ============================
    public static void processSuper(List<? super Integer> list) {
        System.out.println("Writing to super:");
        list.add(10);
        list.add(20);

        Object obj = list.get(0);
        System.out.println("Read as Object: " + obj);
    }

    // ============================
    // 4. <T extends Number>
    // ============================
    public static <T extends Number> T getFirst(List<T> list) {
        return list.get(0);
    }

    // ============================
    // 5. Class<? extends Number>
    // ============================
    public static void printClass(Class<? extends Number> clazz) {
        System.out.println("Class: " + clazz.getSimpleName());
    }

    // ============================
    // 6. copy (PECS)
    // ============================
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (T value : src) {
            dest.add(value);
        }
    }
}

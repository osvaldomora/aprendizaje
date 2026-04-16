package osvaldo.morales.company.demo.generics;

import java.util.*;

public class GenericsDemo {

    public static void main(String[] args) {
         important1();

        // ================================
        // 1. LIST<NUMBER> (RIGIDO)
        // ================================
        System.out.println("=== List<Number> ===");

        List<Number> numbers = new ArrayList<>();
        numbers.add(10);      // Integer
        numbers.add(10.5);    // Double

        printListNumber(numbers);

        // List<Integer> ints = List.of(1, 2, 3);
        // printListNumber(ints); ❌ ERROR (no compila)


        // ================================
        // 2. ? EXTENDS NUMBER (READ ONLY)
        // ================================
        System.out.println("\n=== ? extends Number ===");

        List<Integer> ints = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.1, 2.2, 3.3);

        printExtends(ints);
        printExtends(doubles);


        // ================================
        // 3. ? SUPER INTEGER (WRITE)
        // ================================
        System.out.println("\n=== ? super Integer ===");

        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        addSuper(numList);
        addSuper(objList);

        System.out.println("Number list: " + numList);
        System.out.println("Object list: " + objList);


        // ================================
        // 4. GENERIC METHOD <T extends Number>
        // ================================
        System.out.println("\n=== <T extends Number> ===");

        System.out.println("Sum int: " + sum(5, 10));
        System.out.println("Sum double: " + sum(2.5, 3.5));


        // ================================
        // 5. COMPARACION FINAL
        // ================================
        System.out.println("\n=== Comparacion ===");

        compareLists();
    }

    private static void important1() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);

        Integer a = 5;
        Number b = a; // ✅ funciona

       // ❌ NO compila Generics in Java are invariant no funciona igual al Polymorphism (herencia normal)
       // List<Number> numbers = ints;
    }


    // ============================================
    // 1. List<Number> → SOLO acepta List<Number>
    // ============================================
    public static void printListNumber(List<Number> list) {
        System.out.println("Printing List<Number>");
        for (Number n : list) {
            System.out.println("Value: " + n);
        }
    }


    // ============================================
    // 2. ? extends Number → SOLO LECTURA This method accepts a list of some subtype of Number
    // ============================================
    public static void printExtends(List<? extends Number> list) {
        System.out.println("Printing ? extends Number");

        for (Number n : list) {
            System.out.println("Value: " + n);
        }


        // list.add(10); ❌ NO permitido
    }


    // ============================================
    // 3. ? super Integer → ESCRITURA
    // ============================================
    public static void addSuper(List<? super Integer> list) {//A list of some type that is Integer OR a supertype of Integer
        System.out.println("Adding values to ? super Integer");

        list.add(10);
        list.add(20);

        // Integer i = list.get(0); ❌ NO permitido //With ? super T, you lose type information when reading
        Object obj = list.get(0); // ✅ solo Object

        System.out.println("First element (as Object): " + obj);

    }


    // ============================================
    // 4. <T extends Number> → GENERIC METHOD
    // ============================================
    public static <T extends Number> double sum(T a, T b) { //T is a type that extends Number

        return a.doubleValue() + b.doubleValue();
        /*
        <T extends Number> → defines a generic type
        cannot be used inside List<> directly.
        used in method .public <T extends Number> void method(T value) { }
        used in generic class: class Box<T extends Number> { T value;}
        para listas se usa wildcard? o como abajo
        use List<T> after defining T
        use ? extends Number for flexibility
         */
    }


    // ============================================
    // 5. COMPARACION VISUAL
    // ============================================
    public static void compareLists() {

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);

        Integer a= 5;
        Number b=a;

        // ❌ NO compila Generics in Java are invariant
        // List<Number> numbers = ints;

        // ✅ SI compila
        List<? extends Number> numbersExtends = ints;

        System.out.println("Reading from ? extends:");
        for (Number n : numbersExtends) {
            System.out.println(n);
        }

        // numbersExtends.add(10); ❌

        // ==========================
        List<? super Integer> numbersSuper = new ArrayList<Number>();

        numbersSuper.add(100); // ✅

        System.out.println("Reading from ? super:");
        Object obj = numbersSuper.get(0);
        System.out.println(obj);
    }
}

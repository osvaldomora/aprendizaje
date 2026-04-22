package osvaldo.morales.company.demo.java8.exercise.streams.streamEstudy;

import java.util.*;
import java.util.stream.*;

public class StreamArraysSummary {

    static class Person {
        String name;
        Person(String name) { this.name = name; }
        public String toString() { return name; }
    }

    public static void main(String[] args) {

        // =====================================
        // 1) ARRAY DE OBJETOS (String[])
        // =====================================
        String[] stringArray = "abc we".split(" ");

        System.out.println("=== String[] ===");

        // Seguro
        Stream<String> s1 = Arrays.stream(stringArray);
        s1.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // Puede parecer igual (y muchas veces lo es)
        Stream<String> s2 = Stream.of(stringArray);
        s2.forEach(x -> System.out.print(x + " "));
        System.out.println();

        // ⚠️ Pero también puede ser distinto si fuerzas el tipo:
        Stream<String[]> s3 = Stream.<String[]>of(stringArray);
        s3.forEach(arr -> System.out.println("Length (array): " + arr.length));

        // =====================================
        // 2) LISTAS (Collections)
        // =====================================
        List<Person> lists = List.of(new Person("Ana"), new Person("Luis"));

        System.out.println("\n=== List<Person> ===");

        // ❌ Esto NO es como list.stream()
        Stream<List<Person>> wrong = Stream.of(lists); // Stream<List<Person>>

        // ✔ Esto sí
        Stream<Person> correct = lists.stream();       // Stream<Person>

        correct.forEach(p -> System.out.print(p + " "));
        System.out.println();

        // =====================================
        // 3) ARRAY DE OBJETOS (Person[])
        // =====================================
        Person[] people = {
                new Person("Ana"),
                new Person("Luis")
        };

        System.out.println("\n=== Person[] ===");

        Arrays.stream(people).forEach(p -> System.out.print(p + " "));
        System.out.println();

        // Puede comportarse igual:
        Stream.of(people).forEach(p -> System.out.print(p + " "));
        System.out.println();

        // Pero también puede cambiar:
        Stream.<Person[]>of(people)
                .forEach(p -> System.out.println("Array length: " + p.length));

        // =====================================
        // 4) PRIMITIVOS (int[])
        // =====================================
        int[] ints = {1, 2, 3};

        System.out.println("\n=== int[] ===");

        // ❌ Stream.of → Stream<int[]> (un solo elemento: el array)
        Stream.of(ints).forEach(x -> System.out.println("Stream.of(ints) → int[] length: " + x.length));

        // ✔ Arrays.stream → IntStream (elementos individuales)
        Arrays.stream(ints).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // =====================================
        // 5) PRIMITIVOS (char[])
        // =====================================
        char[] chars = {'a','b','c'};

        System.out.println("\n=== char[] ===");

        // ❌ NO existe Arrays.stream(char[])
        // Arrays.stream(chars); // <-- no compila

        // ✔ Opciones:
        // a) Como códigos Unicode (IntStream)
        new String(chars).chars().forEach(c -> System.out.print((char)c + " "));
        System.out.println();

        // b) Boxeando manualmente a Stream<Character>
        Stream<Character> sc =
                IntStream.range(0, chars.length)
                        .mapToObj(i -> chars[i]);
        sc.forEach(c -> System.out.print(c + " "));
        System.out.println();
    }
}
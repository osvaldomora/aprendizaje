package osvaldo.morales.company.demo.java8.exercise.streams.streamEstudy;

import java.util.*;
import java.util.stream.*;

public class StreamOfVsArraysStream {

    static class Person2 {
        String name;

        Person2(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        // ==============================
        // 1. ARRAY DE OBJETOS (String[])
        // ==============================
        String[] strArr = {"A", "B"};

        System.out.println("=== String[] ===");

        System.out.println("Stream.of(strArr):");
        Stream.of(strArr).forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("Arrays.stream(strArr):");
        Arrays.stream(strArr).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // Ambos parecen iguales ✔


        // ==============================
        // 2. ARRAY DE OBJETOS (Person[])
        // ==============================
        Person2[] people = {
                new Person2("Ana"),
                new Person2("Luis")
        };

        System.out.println("\n=== Person[] ===");

        System.out.println("Stream.of(people):");
        Stream.of(people).forEach(p -> System.out.print(p + " "));
        System.out.println();

        System.out.println("Arrays.stream(people):");
        Arrays.stream(people).forEach(p -> System.out.print(p + " "));
        System.out.println();

        // ==============================
        // 3. CASO CONFUSO (FORZADO)
        // ==============================
        System.out.println("\n=== FORZANDO Stream<Person[]> ===");

        Stream.<Person2[]>of(people)
                .forEach(p -> System.out.println("Array length: " + p.length));

        // Aquí p NO es Person → es Person[]


        // ==============================
        // 4. ARRAY PRIMITIVO (int[])
        // ==============================
        int[] intArr = {1, 2, 3};

        System.out.println("\n=== int[] ===");

        System.out.println("Stream.of(intArr):");
        Stream.of(intArr).forEach(x -> System.out.println(x));
        Stream<int[]> spi=Stream.of(intArr);
        // 👆 x es int[] (NO int)


        System.out.println("Arrays.stream(intArr):");
        Arrays.stream(intArr).forEach(x -> System.out.print(x + " "));
        IntStream sap=Arrays.stream(intArr);
        System.out.println();

        // =====================================
        // 4.1) PRIMITIVOS (char[])
        // =====================================
        char[] chars = {'a','b','c'};
        Stream<char[]> sc=Stream.of(chars);
        System.out.println(sc);

        System.out.println("\n=== char[] ===");

        // ❌ NO existe Arrays.stream(char[])
        // Arrays.stream(chars); // <-- no compila

        // ✔ Opciones:
        // a) Como códigos Unicode (IntStream)
       String sChar= new String(chars);
       IntStream uniS = sChar.chars();
       uniS.forEach(c -> System.out.print((char)c + " "));
        System.out.println();


        // b) Boxeando manualmente a Stream<Character>
        Stream<Character> scB =
                IntStream.range(0, chars.length)
                        .mapToObj(i -> chars[i]);
        sc.forEach(c -> System.out.print(c + " "));
        System.out.println();

        // ==============================
        // 5. EXPLICACIÓN VISUAL
        // ==============================
        System.out.println("\n=== TIPOS ===");


        Stream<int[]> s1 = Stream.of(intArr);
        System.out.println("Stream.of(intArr) → Stream<int[]>");

        IntStream s2 = Arrays.stream(intArr);
        System.out.println("Arrays.stream(intArr) → IntStream");




    }
}

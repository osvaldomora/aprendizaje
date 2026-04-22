package osvaldo.morales.company.demo.java8.exercise.streams.streamEstudy;

import java.util.*;
import java.util.stream.*;

public class StreamWrappingGuide {

    public static void main(String[] args) {

        // =========================================
        // 1. BASE DATA
        // =========================================
        List<List<Integer>> lists = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        System.out.println("=== ORIGINAL ===");
        System.out.println(lists);

        // =========================================
        // 2. map(x -> Stream.of(x)) List<List<Integer>> lists
        // =========================================
        System.out.println("\n2) map(x -> Stream.of(x))");

        Stream<Stream<List<Integer>>> s4 = lists.stream()
                .map(x -> Stream.of(x));

        s4.forEach(inner -> {
            System.out.print("Inner stream: ");
            inner.forEach(list -> System.out.print(list + " "));
            System.out.println();
        });

        // Explanation:
        // x = List<Integer>
        // Stream.of(x) → Stream<List<Integer>>
        // map → Stream<Stream<List<Integer>>>
        //
        // 👉 "We are wrapping each element into another stream"


        // =========================================
        // 3. Stream.of(lists) vs lists.stream() List<List<Integer>> lists
        // =========================================
        System.out.println("\n3) Stream.of(lists) vs lists.stream()");

        Stream<List<List<Integer>>> wrapped = Stream.of(lists);
        Stream<List<Integer>> normal = lists.stream();

        System.out.println("Stream.of(lists):");
        wrapped.forEach(l -> System.out.println("Wrapped: " + l));

        System.out.println("lists.stream():");
        normal.forEach(l -> System.out.println("Element: " + l));

        // Explanation:
        // Stream.of(lists) → ONE element (the whole list)
        // lists.stream() → MANY elements (each inner list)


        // =========================================
        // 4. SAME IDEA WITH STRING
        // =========================================
        System.out.println("\n4) With String");

        List<String> words = List.of("hi", "bye");

        System.out.println("map(x -> Stream.of(x)):");
        words.stream()
                .map(x -> Stream.of(x))
                .forEach(inner -> {
                    System.out.print("Inner: ");
                    inner.forEach(w -> System.out.print(w + " "));
                    System.out.println();
                });

        // Explanation:
        // x = "hi"
        // Stream.of(x) → Stream<String> with ONE element
        //
        // Result:
        // Stream<Stream<String>>


        // =========================================
        // 5. map(x -> x.split()) vs flatMap
        // =========================================
        System.out.println("\n5) split example");

        List<String> sentences = List.of(
                "Hello world",
                "Java streams"
        );
    /*  String[] as="abc we".split(" ");
      Stream<String> c= Arrays.stream(as);
      c.collect(Collectors.toList());*/

        System.out.println("Using map:");
        List<Stream<String>> wrong = sentences.stream()
                .map(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.toList());

        wrong.forEach(inner -> {
            System.out.print("Inner stream: ");
            inner.forEach(word -> System.out.print(word + " "));
            System.out.println();
        });

        // Explanation:
        // String → Stream<String>
        // map → Stream<Stream<String>>


        System.out.println("\nUsing flatMap:");
        List<String> correct = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.toList());

        System.out.println(correct);

        // Explanation:
        // flatMap flattens → Stream<String>


        // =========================================
        // 6. ARRAY CASE (IMPORTANT 🔥)
        // =========================================
        System.out.println("\n6) Arrays behavior");

        String[] arr = {"A", "B"};

        System.out.println("Stream.of(arr):");
        Stream<String> st=Stream.of(arr);//Stream.of(arr) puede comportarse como Arrays.stream(arr) SOLO con objetos
        Stream.of(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("Arrays.stream(arr):");
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // Explanation:
        // For String[] → both behave the same
        /*
        Esto aplica para CUALQUIER arreglo de objetos:

String[]
Integer[]
Person[]
Stream.of(array) → depende del contexto pero generalmente igual que Arrays.stream, se recomienda usar Arrays.stream
Arrays.stream(array) → siempre seguro
         */


        // =========================================
        // 7. PRIMITIVE ARRAY (KEY DIFFERENCE)
        // =========================================
        System.out.println("\n7) Primitive array");

        int[] nums = {1, 2, 3};

        System.out.println("Stream.of(nums):");
        Stream.of(nums).forEach(x -> System.out.println(x)); // prints array reference
     Stream<int[]> cc=  Stream.of(nums);

        System.out.println("Arrays.stream(nums):");
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Explanation: int[] nums = {1, 2, 3};
        // Stream.of(nums) → Stream<int[]> ❌ (one element)
        // Arrays.stream(nums) → IntStream (1,2,3) ✅

        String s="java";
        char[] chars=s.toCharArray();
        Stream<char[]> sc= Stream.of(chars);
        //Arrays.stream(chars);
        /*
        El problema principal es que Arrays.stream(c) no funciona automáticamente con arreglos de primitivos (char[]) para crear un Stream<Character>. En Java, Arrays.stream solo crea flujos de objetos (T[]) o de tipos numéricos específicos (int[], long[], double[]).
         */




        // =========================================
        // 8. MENTAL MODEL
        // =========================================
        System.out.println("\n8) Mental Model");

        System.out.println("Stream.of(x) → wraps x into a stream");
        System.out.println("stream() → iterates elements");
        System.out.println("map → transforms elements");
        System.out.println("flatMap → transforms + flattens");
    }
}

package osvaldo.morales.company.demo.java8.exercise.streams.streamEstudy;

import java.util.*;
import java.util.stream.*;
/*
    map:
yo transformo → Java envuelve

flatMap:
yo transformo a Stream → Java aplana
 */
public class StreamsQuizDemo {

    public static void main(String[] args) {

        List<List<Integer>> lists = List.of(
                List.of(1, 2),
                List.of(5, 12),
                List.of(3)
        );

        System.out.println("Lista original:");
        System.out.println(lists);
        System.out.println("====================================");

        // ----------------------------------
        // 1. lists.stream()   lists =List<List<Integer>>
        // ----------------------------------
        // Tipo: Stream<List<Integer>>
        Stream<List<Integer>> s1 = lists.stream();

        System.out.println("\n1) Stream<List<Integer>>");
        s1.forEach(x -> System.out.println("Elemento: " + x));

        // ----------------------------------
        // 2. map(x -> x)  lists =List<List<Integer>>
        // ----------------------------------
        // NO cambia nada
        System.out.println("\n2) map(x -> x)");
        System.out.println("\n2) Stream<List<Integer>> (map identidad)");
        Stream<List<Integer>> s2 = lists.stream()
                .map(x -> x);
        s2.forEach(x -> System.out.println("Elemento: " + x));

        // ----------------------------------
        // 3. map(x -> x.stream())    lists =List<List<Integer>>
        // Tipo: Stream<Stream<Integer>>
        // ----------------------------------
        System.out.println("\n3) map(x -> x.stream())");
        System.out.println("\n3) Stream<Stream<Integer>>");
        Stream<Stream<Integer>> s3 = lists.stream()
                .map(x -> x.stream());
        s3.forEach(inner -> {
            System.out.print("Stream interno: ");
            inner.forEach(n -> System.out.print(n + " "));
            System.out.println();
        });

        // ----------------------------------
        // 4. map(x -> Stream.of(x))  lists = List<List<Integer>>
        // ----------------------------------
        // Tipo: Stream<Stream<List<Integer>>>
        System.out.println("\n4) 9<Stream<List<Integer>>>");

        Stream<Stream<List<Integer>>> s4 = lists.stream()
                .map(x -> Stream.of(x));

        Stream<List<List<Integer>>> aad= Stream.of(lists); //👉 Stream.of() mete la caja en otra caja, envuelve todo el objeto a un stream
        Stream<List<Integer>> s3d = lists.stream();// 👉 stream() abre la caja Stream<List<Integer>=lists.stream();

        s4.forEach(inner -> {
            System.out.print("Stream con lista: ");
            inner.forEach(list -> System.out.print(list + " "));
            System.out.println();
        });



        // ----------------------------------
        // 5. flatMap(x -> x.stream())  lists = List<List<Integer>>
        //flatMap recibe un elemento (T)
        //y tu lambda debe devolver un Stream<R>
        // ----------------------------------
        System.out.println("\n5) flatMap(x -> x.stream())");
        Stream<Integer> s5 = lists.stream()
                .flatMap(x -> x.stream());



        System.out.println("\n5) Stream<Integer> (flatMap)");
        s5.forEach(n -> System.out.print(n + " "));
        System.out.println();
        // Tipo: Stream<Integer>


        // ----------------------------------
        // 6. map + flatMap lists = List<List<Integer>>
        // ----------------------------------
        System.out.println("\n6) map(x -> x.stream()) + flatMap(x -> x)");
        System.out.println("\n6) Stream<Integer> (map + flatMap)");

        // Igual que flatMap directo
        Stream<Integer> s6 = lists.stream()
                .map(x -> x.stream())
                .flatMap(x -> x);

        Stream<Integer> sds6 = lists.stream()
                .flatMap(x -> x.stream());

        s6.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // ----------------------------------
        // 7. flatMap(x -> Stream.of(x))  lists = List<List<Integer>>
        // ----------------------------------
        // NO aplana realmente
        Stream<List<Integer>> s7 = lists.stream()
                .flatMap(x -> Stream.of(x));
        System.out.println("\n7) Stream<List<Integer>> (NO aplana)");
        s7.forEach(x -> System.out.println("Elemento: " + x));

        // ----------------------------------
        // 8. flatMap(x -> Stream.of(x.stream()))   lists = List<List<Integer>>
        //        // ----------------------------------
        //👉 Stream.of() mete la caja en otra caja
        // 👉 stream() abre la caja
        // ----------------------------------
        // Tipo: Stream<Stream<Integer>>

        System.out.println("\n8) flatMap(x -> Stream.of(x.stream()))");
        Stream<Stream<Integer>> s8 = lists.stream()
                .flatMap(x -> Stream.of(x.stream()));
       //Stream.of(x.stream()) NO aplana nada… solo envuelve un stream dentro de otro
        System.out.println("\n8) Stream<Stream<Integer>>");
        s8.forEach(inner -> {
            System.out.print("Stream interno: ");
            inner.forEach(n -> System.out.print(n + " "));
            System.out.println();
        });

        // ----------------------------------
        // 9. recrear nivel lists = List<List<Integer>>
        // ----------------------------------
        // Tipo: Stream<List<Integer>>
        Stream<List<Integer>> s9 = lists.stream()
                .flatMap(x -> x.stream())
                .map(x -> List.of(x));

        System.out.println("\n9) Stream<List<Integer>> (recrea nivel)");
        s9.forEach(x -> System.out.println("Lista: " + x));

        // ----------------------------------
        // 10. envolver en stream otra vez List<List<Integer>>
        // ----------------------------------
        // Tipo: Stream<Stream<Integer>>

        System.out.println("\n10) flatMap + map(Stream.of(x))");
        Stream<Stream<Integer>> s10 = lists.stream()
                .flatMap(x -> x.stream())
                .map(x -> Stream.of(x));

        System.out.println("\n10) Stream<Stream<Integer>>");
        s10.forEach(inner -> {
            System.out.print("Stream: ");
            inner.forEach(n -> System.out.print(n + " "));
            System.out.println();
        });

        System.out.println("\n====================================");
        System.out.println("FIN");
    }
}
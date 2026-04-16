package osvaldo.morales.company.demo.java8.exercise.streams.streamEImp;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsLevelsExplication {

    public static void main(String[] args) {

        // ==============================
        // 1. ESTRUCTURA ORIGINAL
        // ==============================
        List<List<Integer>> lists = List.of(
                List.of(1, 2),
                List.of(5, 12, 66, 44),
                List.of(3)
        );

        // Visualmente:
        // [
        //   [1,2],
        //   [5,12,66,44],
        //   [3]
        // ]


        // ==============================
        // 2. STREAM BASE
        // ==============================
        Stream<List<Integer>> s1 = lists.stream();

        // Nivel:
        // Stream<List<Integer>>
        //
        // Cada elemento:
        // x = List<Integer>


        // ==============================
        // 3. MAP IDENTIDAD
        // ==============================
        Stream<List<Integer>> s2 = lists.stream()
                .map(x -> x);

        // NO cambia nada
        // Stream<List<Integer>>


        // ==============================
        // 4. TU DUDA PRINCIPAL 🔥
        // ==============================
        Stream<Stream<Integer>> s3 = lists.stream()
                .map(x -> x.stream());

        // IMPORTANTE:
        // x es List<Integer>
        // x.stream() es Stream<Integer>
        //
        // Entonces:
        // List<Integer> → Stream<Integer>
        //
        // Resultado:
        // Stream<Stream<Integer>>
        //
        // ❌ NO es:
        // Stream<Stream<List<Integer>>>


        // ==============================
        // 5. POR QUÉ NO ES LO QUE PENSABAS
        // ==============================
        Stream<Stream<List<Integer>>> s4 = lists.stream()
                .map(x -> Stream.of(x));

        // Aquí sí:
        // x = List<Integer>
        // Stream.of(x) = Stream<List<Integer>>
        //
        // Entonces:
        // Stream<Stream<List<Integer>>>

/*
x.stream() → "saca lo que hay dentro"
Stream.of(x) → "envuelve x como un elemento"
 */
        // ==============================
        // 6. FLATMAP (APLANAR)
        // ==============================
        Stream<Integer> s5 = lists.stream()
                .flatMap(x -> x.stream());

        // Aplana:
        // Stream<List<Integer>> → Stream<Integer>


        // ==============================
        // 7. MULTIPLES NIVELES
        // ==============================
        List<List<List<Integer>>> deepList = List.of(
                List.of(List.of(1, 2)),
                List.of(List.of(3, 4))
        );

        Stream<List<List<Integer>>> d1 = deepList.stream();

        Stream<List<Integer>> d2 = deepList.stream()
                .flatMap(x -> x.stream());

        Stream<Integer> d3 = deepList.stream()
                .flatMap(x -> x.stream())
                .flatMap(x -> x.stream());

        // Cada flatMap elimina UN nivel


        // ==============================
        // 8. YA NO PUEDES APLANAR MÁS
        // ==============================
        Stream<Integer> flat = lists.stream()
                .flatMap(x -> x.stream());

        // flatMap(x -> x.stream()) // ❌ ERROR
        // porque x es Integer


        // ==============================
        // 9. VOLVER A CREAR NIVELES 😈
        // ==============================
        Stream<Integer> recreated = lists.stream()
                .flatMap(x -> x.stream())
                .map(x -> List.of(x, x * 2))  // ahora tienes Stream<List<Integer>>
                .flatMap(x -> x.stream());    // lo vuelves a aplanar


        // ==============================
        // 10. EJECUCIÓN REAL
        // ==============================
        List<Integer> result = lists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        System.out.println(result); // [1, 2, 5, 12, 66, 44, 3]

        Stream.of("hola".split(""));
        Arrays.stream("hola".split(""));
    }
}

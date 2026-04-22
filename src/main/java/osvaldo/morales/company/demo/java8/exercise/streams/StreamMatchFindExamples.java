package osvaldo.morales.company.demo.java8.exercise.streams;

import java.util.*;
import java.util.stream.*;

public class StreamMatchFindExamples {

    public static void main(String[] args) {

        // --------------------------------------------
        // DATA SET
        // --------------------------------------------
        Map<Integer, String> map = Map.of(
                1, "Ana",
                2, "Luis",
                3, "Pedro",
                4, "Maria"
        );

        List<String> names = List.of("Ana", "Luis", "Ana", "Pedro");

        // --------------------------------------------
        // 1. anyMatch → ¿Existe al menos uno?
        // --------------------------------------------
        System.out.println("1. anyMatch:");

        boolean existsAna =
                map.entrySet()
                        .stream()
                        .anyMatch(e -> e.getValue().equals("Ana"));

        System.out.println("¿Existe 'Ana'? -> " + existsAna);


        // --------------------------------------------
        // 2. allMatch → ¿Todos cumplen?
        // --------------------------------------------
        System.out.println("\n2. allMatch:");

        boolean allLengthGreaterThan2 =
                map.entrySet()
                        .stream()
                        .allMatch(e -> e.getValue().length() > 2);

        System.out.println("¿Todos tienen longitud > 2? -> " + allLengthGreaterThan2);


        // --------------------------------------------
        // 3. noneMatch → ¿Ninguno cumple?
        // --------------------------------------------
        System.out.println("\n3. noneMatch:");

        boolean noneCarlos =
                map.entrySet()
                        .stream()
                        .noneMatch(e -> e.getValue().equals("Carlos"));

        System.out.println("¿Ninguno es 'Carlos'? -> " + noneCarlos);


        // --------------------------------------------
        // 4. findFirst → primer elemento
        // --------------------------------------------
        System.out.println("\n4. findFirst:");

        Optional<Map.Entry<Integer, String>> firstWithP =
                map.entrySet()
                        .stream()
                        .filter(e -> e.getValue().startsWith("P"))
                        .findFirst();

        firstWithP.ifPresent(e ->
                System.out.println("Primer nombre con P -> " + e)
        );


        // --------------------------------------------
        // 5. findAny → cualquier elemento
        // --------------------------------------------
        System.out.println("\n5. findAny:");

        Optional<Map.Entry<Integer, String>> anyLongName =
                map.entrySet()
                        .stream()
                        .filter(e -> e.getValue().length() > 4)
                        .findAny();

        anyLongName.ifPresent(e ->
                System.out.println("Cualquier nombre largo -> " + e)
        );


        // --------------------------------------------
        // 6. Ejercicio: detectar duplicados (anyMatch)
        // --------------------------------------------
        System.out.println("\n6. Detectar duplicados:");

        boolean hasDuplicates =
                names.stream()
                        .anyMatch(name ->
                                Collections.frequency(names, name) > 1
                        );

        System.out.println("¿Hay duplicados? -> " + hasDuplicates);


        // --------------------------------------------
        // 7. findFirst + map → obtener solo ID
        // --------------------------------------------
        System.out.println("\n7. findFirst + map:");

        Optional<Integer> id =
                map.entrySet()
                        .stream()
                        .filter(e -> e.getValue().length() > 4)
                        .map(e -> e.getKey())
                        .findFirst();

        id.ifPresent(i ->
                System.out.println("ID encontrado -> " + i)
        );


        // --------------------------------------------
        // 8. flatMap + anyMatch
        // --------------------------------------------
        System.out.println("\n8. flatMap + anyMatch:");

        boolean existsLetterA =
                names.stream()
                        .flatMap(name -> Arrays.stream(name.split("")))
                        .anyMatch(letter -> letter.equalsIgnoreCase("a"));

        System.out.println("¿Existe letra 'a'? -> " + existsLetterA);


        // --------------------------------------------
        // 9. findFirst → Optional (IMPORTANTE)
        // --------------------------------------------
        System.out.println("\n9. Optional (findFirst):");

        Optional<String> firstName =
                names.stream()
                        .filter(n -> n.startsWith("A"))
                        .findFirst();

        firstName.ifPresentOrElse(
                n -> System.out.println("Encontrado -> " + n),
                () -> System.out.println("No encontrado")
        );


        // --------------------------------------------
        // 10. DIFERENCIA findFirst vs findAny
        // --------------------------------------------
        System.out.println("\n10. findFirst vs findAny:");

        Optional<String> first =
                names.stream()
                        .filter(n -> n.length() > 3)
                        .findFirst();

        Optional<String> any =
                names.stream()
                        .filter(n -> n.length() > 3)
                        .findAny();

        System.out.println("findFirst -> " + first);
        System.out.println("findAny   -> " + any);


        // --------------------------------------------
        // RESUMEN FINAL
        // --------------------------------------------
        System.out.println("\nResumen:");
        System.out.println("anyMatch  -> boolean (al menos uno)");
        System.out.println("allMatch  -> boolean (todos)");
        System.out.println("noneMatch -> boolean (ninguno)");
        System.out.println("findFirst -> Optional<T> (primero)");
        System.out.println("findAny   -> Optional<T> (cualquiera)");

    }
}

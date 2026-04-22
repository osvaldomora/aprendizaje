package osvaldo.morales.company.demo.java8.mapas;

import java.util.*;
import java.util.stream.Collectors;

public class MapEntrySetIntegerStringExample {

    public static void main(String[] args) {

        // --------------------------------------------
        // 1. CREAR MAP<Integer, String>
        // --------------------------------------------
        Map<Integer, String> map = Map.of(
                1, "Ana",
                2, "Luis",
                3, "Pedro",
                4, "Ana",
                5, "Pedr2"
        );

        System.out.println("Original Map:");
        System.out.println(map);

        // --------------------------------------------
        // 2. entrySet()
        // --------------------------------------------
        // Convierte el mapa en pares (clave, valor)
        System.out.println("\nentrySet():");
        System.out.println(map.entrySet());

        // --------------------------------------------
        // 3. RECORRER MAPA (FORMA CORRECTA)
        // --------------------------------------------
        System.out.println("\nRecorrer con entrySet:");
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(
                    "ID: " + e.getKey() +
                            " | Nombre: " + e.getValue()
            );
        }

        // --------------------------------------------
        // 4. STREAMS
        // --------------------------------------------
        System.out.println("\nUsando streams:");
        map.entrySet()
                .stream()
                .forEach(e ->
                        System.out.println(e.getKey() + " -> " + e.getValue())
                );

        // --------------------------------------------
        // 5. FILTRAR (IDs mayores a 2)
        // --------------------------------------------
        System.out.println("\nFiltrar IDs > 2:");
        map.entrySet()
                .stream()
                .filter(e -> e.getKey() > 2)
                .forEach(System.out::println);

        // --------------------------------------------
        // 6. FILTRAR POR VALOR (nombre = "Ana")
        // --------------------------------------------
        System.out.println("\nFiltrar nombre 'Ana':");
        map.entrySet()
                .stream()
                .filter(e -> e.getValue().equals("Ana"))
                .forEach(System.out::println);

        // --------------------------------------------
        // 7. TRANSFORMAR A OTRO MAPA
        // --------------------------------------------
        System.out.println("\nNuevo mapa con nombres que empiezan con 'A':");

        Map<Integer, String> filteredMap =
                map.entrySet()
                        .stream()
                        .filter(e -> e.getValue().startsWith("A"))
                        .collect(Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue()
                        ));

        System.out.println(filteredMap);

        // --------------------------------------------
        // 8. SOLO OBTENER NOMBRES (LISTA)
        // --------------------------------------------
        System.out.println("\nLista de nombres:");

        List<String> names =
                map.entrySet()
                        .stream()
                        .map(e -> e.getValue())
                        .collect(Collectors.toList());

        System.out.println(names);

        // --------------------------------------------
        // 9. INVERTIR MAPA (String -> Integer)
        // --------------------------------------------
        System.out.println("\nInvertir mapa:");

        Map<String, Integer> inverted =
                map.entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                e -> e.getValue(),
                                e -> e.getKey(),
                                (v1, v2) -> v1 // manejar duplicados ("Ana")
                        ));

        System.out.println(inverted);

        // --------------------------------------------
        // 10. ENCONTRAR EL NOMBRE MÁS "GRANDE"         Map<Integer, String> map = Map.of(
        //                1, "Ana",
        //                2, "Luis",
        //                3, "Pedro",
        //                4, "Ana"
        //        );
        // --------------------------------------------
        System.out.println("\nNombre más largo:");

        System.out.println(
        map.entrySet().stream().map(v->v.getValue()).max((x,y)->x.compareTo(y)).get());

        map.entrySet()
                .stream()
                .max(Comparator.comparingInt(e -> e.getValue().length()))
                .ifPresent(System.out::println);

        // --------------------------------------------
        // 11. MODELO MENTAL
        // --------------------------------------------
        System.out.println("\nModelo mental:");
        System.out.println("Map: {1=Ana, 2=Luis, 3=Pedro, 4=Ana}");
        System.out.println("entrySet: [(1,Ana), (2,Luis), (3,Pedro), (4,Ana)]");
    }
}
package osvaldo.morales.company.demo.java8.mapas;

import java.util.*;
import java.util.stream.Collectors;

public class MapEntrySetExample {

    public static void main(String[] args) {

        // --------------------------------------------
        // 1. CREACIÓN DEL MAP
        // --------------------------------------------
        Map<Integer, Integer> map = Map.of(1, 2, 3, 4);

        System.out.println("Original Map:");
        System.out.println(map); // {1=2, 3=4}

        // --------------------------------------------
        // 2. ¿QUÉ ES entrySet()?
        // --------------------------------------------
        // Convierte el mapa en un Set de pares (clave, valor)
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();


        System.out.println("\nentrySet():");
        System.out.println(entries); // [1=2, 3=4]

        // --------------------------------------------
        // 3. RECORRER CON entrySet (FORMA CORRECTA)
        // --------------------------------------------
        System.out.println("\nRecorriendo con entrySet:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(
                    "Key: " + entry.getKey() +
                            " | Value: " + entry.getValue()
            );
        }

        // --------------------------------------------
        // 4. COMPARACIÓN: keySet (MENOS EFICIENTE)
        // --------------------------------------------
        System.out.println("\nRecorriendo con keySet (menos eficiente):");
        for (Integer key : map.keySet()) {
            System.out.println(
                    "Key: " + key +
                            " | Value: " + map.get(key) // lookup extra
            );
        }

        // --------------------------------------------
        // 5. USO CON STREAMS
        // --------------------------------------------
        System.out.println("\nUsando Streams con entrySet:");
        map.entrySet()
                .stream()
                .forEach(e ->
                        System.out.println(e.getKey() + ":" + e.getValue())
                );

        // --------------------------------------------
        // 6. FILTRAR ELEMENTOS
        // --------------------------------------------
        System.out.println("\nFiltrar valores > 2:");
        map.entrySet()
                .stream()
                .filter(e -> e.getValue() > 2)
                .forEach(e -> System.out.println(e));

        // --------------------------------------------
        // 7. TRANSFORMAR A OTRO MAPA
        // --------------------------------------------
        System.out.println("\nNuevo mapa con keys > 1:");

        Map<Integer, Integer> newMap =
                map.entrySet()
                        .stream()
                        .filter(e -> e.getKey() > 1)
                        .collect(Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue()
                        ));

        System.out.println(newMap);

        // --------------------------------------------
        // 8. ENCONTRAR EL MAYOR VALOR
        // --------------------------------------------
        System.out.println("\nEntrada con valor máximo:");

        map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e ->
                        System.out.println("Max -> " + e)
                );

        // --------------------------------------------
        // 9. INVERTIR EL MAPA (value -> key)
        // --------------------------------------------
        System.out.println("\nInvertir mapa:");

        Map<Integer, Integer> inverted =
                map.entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                e -> e.getValue(), // ahora es key
                                e -> e.getKey()    // ahora es value
                        ));

        System.out.println(inverted);

        // --------------------------------------------
        // 10. MAP + entrySet MENTAL MODEL
        // --------------------------------------------
        System.out.println("\nModelo mental:");
        System.out.println("Map: {1=2, 3=4}");
        System.out.println("entrySet: [(1,2), (3,4)]");

        

    }
}
package osvaldo.morales.company.demo.java8.exercise.streams.streamEstudy;

import osvaldo.morales.company.demo.java8.exercise.comparable.Persona;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsJava {

    public static void showStreamExamples() {

        // 🟦 1. Desde colección
        System.out.println("1. From Collection:");
        List<Integer> list = List.of(1, 2, 3);
        list.stream().forEach(n -> System.out.print(n + " "));
        System.out.println("\n");
        Persona[] lista = new Persona[2];
        Arrays.stream(lista);
        Persona op =new Persona(1,"");



        // 🟩 2. Desde array clases especializadas: int[]: IntStream.of(nums) o Arrays.stream(nums)
        System.out.println("2. From Array:");

// ==========================
// 🔹 ARRAY PRIMITIVO (int[])
// ==========================
        int[] arr = {4, 5, 6};

// ✅ Convierte int[] → IntStream
// Cada elemento se procesa como primitivo (int)
        Arrays.stream(arr).forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println(); // salto de línea

// ✅ También convierte int[] → IntStream
// Puede recibir array o valores sueltos
        IntStream.of(arr).forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println();

// 👉 Ambos generan EXACTAMENTE lo mismo
// Output:
// 4 5 6
// 4 5 6

// ==========================
// 🔹 ASIGNACIÓN A VARIABLES
// ==========================

// Ambos son IntStream → misma "biblioteca" de métodos
        IntStream a1 = Arrays.stream(arr);
        IntStream a2 = IntStream.of(arr);

// Ejemplo usando a1
        System.out.print("a1 filtrando >4: ");
        a1.filter(n -> n > 4).forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println();

// Ejemplo usando a2
        System.out.print("a2 multiplicando *2: ");
        a2.map(n -> n * 2).forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println();

// ⚠️ IMPORTANTE:
// Un stream NO se puede reutilizar
// Si intentas usar a1 otra vez → error en runtime
// a1.forEach(...) ❌

// ==========================
// 🔹 ARRAY DE OBJETOS
// ==========================

// Supongamos que tienes una clase Persona
// class Persona { String nombre; int edad; }

        Persona[] lista2 = {
                new Persona(20,"Ana"),
                new Persona(30,"Luis")
        };

// ✅ Arrays.stream → Stream<Persona>
        Stream<Persona> pe = Arrays.stream(lista2);

// Ejemplo: imprimir nombres
        System.out.print("Personas: ");
        pe.forEach(p -> {
            System.out.print(p.getName() + " ");
        });
        System.out.println();

// ==========================
// 🔹 WRAPPER (Integer[])
// ==========================
        Integer[] arr2 = {1, 2, 3};

// ❌ NO compila
// IntStream.of(arr2);
// Porque IntStream solo acepta int (primitivos)

// ✅ Esto sí funciona → Stream<Integer>
        Stream<Integer> sInt = Arrays.stream(arr2);

// Ejemplo: sumar valores (manual con reduce)
        int suma = sInt.reduce(0, (acum, n) -> acum + n);
        System.out.println("Suma de Integer[]: " + suma);

// ==========================
// 🔹 DIFERENCIA CLAVE
// ==========================

// int[]  → IntStream (más eficiente, métodos como sum())
// Integer[] → Stream<Integer> (más flexible pero menos directo)

// Ejemplo extra: convertir Integer[] a IntStream
        Integer[] arr3 = {10, 20, 30};

        int suma2 = Arrays.stream(arr3)
                .mapToInt(n -> n) // unboxing
                .sum();

        System.out.println("Suma usando mapToInt: " + suma2);


// ==========================
// 🧠 RESUMEN MENTAL RÁPIDO
// ==========================

// Arrays.stream(arr) → cuando tienes un array
// IntStream.of(...)  → cuando tienes valores o array primitivo
// int[]              → IntStream
// Integer[]          → Stream<Integer>

// IntStream → tiene .sum(), .average()
// Stream<T> → necesitas mapToInt() para operaciones numéricas


        // 🟨 3. Directo (Stream.of)
        System.out.println("3. Stream.of:");
        Stream.of("A", "B", "C")
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 🟥 4. Rango solo para numeros primiticvos o character no funciona para objetos
        System.out.println("4. IntStream.range:");
        IntStream.range(1, 5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 🟪 5. Rango con caracteres
        System.out.println("5. Range with chars:");

// 'a' y 'd' son caracteres, pero internamente son números (Unicode)
// 'a' = 97, 'd' = 100

        IntStream.rangeClosed('a', 'd') // genera: 97, 98, 99, 100
                .mapToObj(c -> (char) c) // convierte cada número a su carácter
                .forEach(c -> {
                    System.out.print(c + " ");
                });
        System.out.println("\n");

        // 🟫 6. Stream infinito (iterate)
        System.out.println("6. Infinite Stream (limit 5):");
        Stream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // ⚫ 7. Stream con generate
        System.out.println("7. Stream.generate:");
        Stream.generate(() -> "Hi")
                .limit(3)
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n");

        // 🔵 8. Desde archivo (opcional)
        System.out.println("8. From File (if exists):");
        try {
            Files.lines(Path.of("test.txt"))
                    .limit(3)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("File not found (skip example)");
        }

        IntStream.of(1,2,3)
                .reduce(0, Integer::sum);
    }
    public static void main(String args[]) {
        showStreamExamples();
        //filters
        List<Integer> listEO = List.of(1, 4, 3, 4, 5, 4);
        List<Integer>  distinct = listEO.stream().distinct().collect(Collectors.toList());
        System.out.println("unique values" + distinct);

        List<Integer>  even =  listEO.stream().distinct().filter(value->value%2==0).collect(Collectors.toList());
        System.out.println("even" + even);

        System.out.println("limit"+listEO.stream().limit(3).collect(Collectors.toList()));
        System.out.println("skip"+listEO.stream().skip(3).collect(Collectors.toList()));

        System.out.println("Transformation");

        List<String> names = List.of("Ana", "Luis", "Carlos");
// Convertir a longitudes
        List<Integer> lengths = names.stream()
                .map(name -> {
                    return name.length();
                }) // transforma String → Integer
                .toList();
        System.out.println("map:"+ lengths);



        int totalLength = names.stream()
                .mapToInt(name -> name.length()) // String → int
                .peek(n-> System.out.println(n))
                .sum(); // operación terminal propia de IntStream
        System.out.println("totalLength:" + totalLength);

        List<Integer> numbers = List.of(100, 2,0, 3);

        double avg = numbers.stream()
                .mapToDouble(n -> n * 1.5) // Integer → double
                .average()
                .orElse(0);

       List <List<String>> flatMap = List.of(List.of("juan","morales"), List.of("sanchez"));
        List<String> fla = flatMap.stream().flatMap(insideList->insideList.stream()).collect(Collectors.toList());
        System.out.println(fla);

        List<String> words = List.of("Hi", "Bye");

        int totalChars = words.stream()
                .flatMapToInt(word -> word.chars()) // String → IntStream
                .sum();



        List<Integer> sorted = numbers.stream()
                .sorted() // orden natural
                .toList();

        List<String> names2 = List.of("Ana", "Luis", "Carlos");

        List<String> sorted2 = names2.stream()
                .sorted((a, b) -> a.compareTo(b)) // orden descendente
                .toList();

        System.out.println(sorted2);




        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);

        int min = numbers.stream()
                .min((a,b)->a.compareTo(b))
                .orElse(0);
        numbers.stream()
                .min(Integer::compareTo)
                .orElse(0);

        System.out.println("Min: " + min);


       List<Double> list= List.of(1.5,9.4,9.0,3.4,7.6,8.3);
       Double max=0.0;
       for (int i=0;i<list.size();i++){
           if(list.get(i)>max){
              max=list.get(i);
           }
       }           System.out.println(max);

       max=0.0;
       for(Double lista: list) {
           // System.out.println(lista);
           if (lista > max) {
               max = lista;
           }

       }System.out.println("ella baila "+max);

        System.out.println(list.stream().max((a,b)->a.compareTo(b)).get());

        Map<Integer, String> map = Map.of(1,"uno",2,"dos", 3, "tres");
        map.forEach((x,y)-> System.out.println(x+y));

        for(Map.Entry<Integer, String> entry:map.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }


        //PROBLEMA 1: Contar frecuencia de palabras
        List<String> wordss = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String,Integer> frequency=new HashMap<>();
        for (String palabra: wordss){
            frequency.put(palabra,frequency.getOrDefault(palabra,0)+1);
        }

        frequency.forEach((x,y)-> System.out.println(x+y));

        wordss.stream().collect(Collectors.groupingBy(w->w,Collectors.counting()));

        Map<String, Integer> map2 = Map.of("A", 10, "B", 30, "C", 20);

        map2.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e -> System.out.println("Max: " + e.getKey() + " -> " + e.getValue()));





    }
}

package osvaldo.morales.company.demo.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsJava {
    public static void main(String args[]) {
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
                .sum(); // operación terminal propia de IntStream

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

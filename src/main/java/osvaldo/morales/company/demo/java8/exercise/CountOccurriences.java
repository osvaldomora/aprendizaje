package osvaldo.morales.company.demo.java8.exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

public class CountOccurriences {


    public static void main(String args[]){



        System.out.println("Count how many times each word appears.");
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> result =  words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        Map<String, Long> result2= words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("Count occurrences of each character in a string.");
        String text = "hello";
        Map<String, Long> result3 = Arrays.stream(text.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(result3);

        System.out.println("Count occurrences of values in a Map");
        Map<Integer,Integer> map = Map.of(1,2,3,4,4,2);
        Map<Integer, Long> result4 = map.values().stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println(result4);
// {2=2, 4=1}
    }




}

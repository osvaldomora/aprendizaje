package osvaldo.morales.company.demo.java8.exercise;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurriences2 {
    public static void main(String args[]){
        System.out.println("Count how many times each word appears.");
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String,Long> mp =  words.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
        System.out.println(mp);
        System.out.println(words.stream().collect(Collectors.groupingBy(x->x)));


        System.out.println("Count occurrences of each character in a string.");
        String text = "hello";


        System.out.println("Count occurrences of values in a Map");
        Map<Integer,Integer> map = Map.of(1,2,3,4,4,2);

// {2=2, 4=1}
    }




}

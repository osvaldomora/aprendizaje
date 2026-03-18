package osvaldo.morales.company.demo.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOccurriences {
    public static void main(String args[]){
        Map<Integer,Integer> map = Map.of(1,2,3,4);
        map.forEach((k,v)-> System.out.println("k:"+k +" v:"+v));

        map.entrySet().stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

    }




}

package osvaldo.morales.company.demo.exercise;

import java.util.List;
import java.util.stream.Collectors;

public class EvenOdd {
    public static void main(String args[]) {
        List<Integer> listEO = List.of(1, 2, 3, 4, 5, 6);
        List<Integer>  even = listEO.stream()
                .filter((n) -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> odd = listEO.stream().filter(n->{
            return n%2 !=0;
        }).toList();
    }
}

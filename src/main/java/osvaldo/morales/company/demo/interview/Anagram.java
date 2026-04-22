package osvaldo.morales.company.demo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {

    public static void main(String[] args) {

        List<String> input = List.of("eat", "tan", "tab", "ant", "nat", "ate");

        Map<String, List<String>> grouped =
                input.stream()
                        .collect(Collectors.groupingBy(word -> sortWord(word)));

        List<List<String>> result = new ArrayList<>(grouped.values());

        System.out.println(result);
    }

    private static String sortWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
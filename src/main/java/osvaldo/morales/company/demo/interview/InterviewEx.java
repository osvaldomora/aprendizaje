package osvaldo.morales.company.demo.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
input = ["listen", "silent", "enlist", "hello"]
output = [
  ["listen", "silent", "enlist"],
  ["hello"]
]

The input is a list of words, and the output is a list of groups where each group contains words that are anagrams of each other.
 */

import java.util.*;

public class InterviewEx {

    public static void main(String[] args) {

        List<String> input = List.of("listen", "silent", "enlist", "hello");

        Map<String, List<String>> map = new HashMap<>();

        for (String word : input) {

            // tu idea: generar la "firma" de la palabra
            String key = createWord(word);

            // agrupar manualmente
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        // resultado final
        List<List<String>> result = new ArrayList<>(map.values());

        System.out.println(result);
    }

    private static String createWord(String input) {

        // tu lógica corregida y completa
        String w= input.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(java.util.stream.Collectors.joining());
        return w;
    }
}

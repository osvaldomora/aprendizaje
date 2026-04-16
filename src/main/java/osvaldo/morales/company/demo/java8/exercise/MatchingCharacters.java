package osvaldo.morales.company.demo.java8.exercise;

import osvaldo.morales.company.demo.java8.exercise.comparable.Persona;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Write a Java program to Count the Number of matching characters in a pair of strings?
Input: Let's say String s1 = "abcdef"; & String s2 = "defghia";
Matching characters: [a, d, e, f]
Count: 4
 */
public class MatchingCharacters {
    public static void main(String args[]){
        String s1 = "abcdef";
        String s2 = "defghia";
       // char[] a= s1.toCharArray();


        Set<Character> set1 = new HashSet<>();//no ordena elementos unicos
        Set<Character> result = new HashSet<>();

        // Guardar caracteres de s1
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }


        // Verificar coincidencias en s2
        for (char c : s2.toCharArray()) {
            if (set1.contains(c)) {
                result.add(c); // evita duplicados
            }
        }

        // Imprimir resultados
        System.out.println("Matching characters: " + result);
        System.out.println("Count: " + result.size());

        //streams
        Set<Character> set2 = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        Set<Character> result2 = s2.chars()
                .mapToObj(c -> (char) c)
                .filter(set2::contains)
                .collect(Collectors.toSet());

        Set<Character> result3 = s2.chars()
                .mapToObj(c -> (char) c)
                .filter(ch->set2.contains(ch))
                .collect(Collectors.toSet());

        System.out.println("Matching characters: " + result2);
        System.out.println("Count: " + result2.size());
    }


}

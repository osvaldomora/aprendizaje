package osvaldo.morales.company.demo.java8.exercise.exercise2repl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Write a Java program to Count the Number of matching characters in a pair of strings?
Input: Let's say String s1 = "abcdef"; & String s2 = "defghia";
Matching characters: [a, d, e, f]
Count: 4
 */
public class MatchingCharacters2 {
    public static void main(String args[]){
        String s1 = "abcdef";
        String s2 = "defghiae";


       Set<Character> result=new HashSet<>();
       Set<Character> characters = s2.chars().mapToObj(c2->(char)c2).collect(Collectors.toSet());
        for(Character c:s1.toCharArray()){
            if(characters.contains(c)){
                result.add(c);
            }
        }
            System.out.println("result counter:"+result.size());
            System.out.println(result);

        //Streams

     Set<Character> s1Set =   s1.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
     Set<Character> s2Set= s2.chars().mapToObj(c->(char)c).filter(c->s1Set.contains(c)).collect(Collectors.toSet());

        System.out.println("matching character"+s2Set);
        System.out.println(s2Set.size());

    }


}

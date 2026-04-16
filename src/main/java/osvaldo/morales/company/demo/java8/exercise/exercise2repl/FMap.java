package osvaldo.morales.company.demo.java8.exercise.exercise2repl;

import osvaldo.morales.company.demo.compatationtipes.Person17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class FMap {
    public static void main(String args[]){
        System.out.println("1 You have a list of lists of integers. Convert it into a single list.");
        List<List<Integer>> lists = List.of(List.of(1,2), List.of(5,12,66,44),List.of(3));
        System.out.println(lists.stream().flatMap(l->l.stream()).collect(Collectors.toList()));


        System.out.println("2 Given a list of sentences, return a list of all words.");
        List<String> sentences = List.of( "Hello world", "Java streams are powerful");
        Stream<String> st=sentences.stream();
        String[] aadd="Java streams are powerful".split(" ");
        Stream<String > xa= Arrays.stream(aadd);//abre la caja
        List<String> aa=sentences.stream().flatMap(s-> Arrays.stream(s.split(" "))).collect(Collectors.toList());
        System.out.println(aa);
        //sentences.stream().flatMap();

        List<String> words = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(toList());

        System.out.println(words);


        List<String> palabras = sentences.stream()
                .map(f -> f.split(" "))        // Cada frase se vuelve un String[]
                .flatMap(Arrays::stream)       // Aplana los arreglos en un solo flujo
                .collect(toList());

        List<String> palabras2= sentences.stream()
                .map(f -> f.split(" ")) //Stream<String[]> x=
                .flatMap(f->Stream.of(f))//Arrays.stream(f)
                .collect(toList());
        System.out.println(palabras2);



        //Given a list of words, return a list of unique characters.
        List<String> words2 = Arrays.asList("java", "stream");
       // words2.stream().map(s->s.chars()).flatMapToInt(c->(char) c).
      //  words2.stream().map(s->s.toCharArray()).flatMap(c->Arrays.stream(c)).collect(Collectors.toList());


                 words2.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char) c)) // 2. Rompe "JAVA" en 'J', 'A', 'V', 'A'
                .distinct()
                .collect(toList());

        System.out.println("Extract All Emails from Users");
        Person17 p1 = new Person17("osva",10,List.of("core1@gmail.com","core2@gmail.com"));
        Person17 p2 = new Person17("osva3",1,List.of("core31@gmail.com"));
        Person17 p4 = new Person17("osva3",1,List.of("core31@gmail.com"));

        Person17 p3 = new Person17("osva4",50,List.of("core4@gmail.com","core10@gmail.com","core01@gmail.com"));
        List<Person17> pList = List.of(p1,p2,p3);
        List<String> lemail= pList.stream().map(p->p.email()).flatMap(em->em.stream()).collect(toList());
        System.out.println(lemail);

        System.out.println("Given two lists, generate all possible pairs.");
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(3, 4);

        List<String> pairs = list1.stream()
                .flatMap(i -> list2.stream()
                        .map(j -> "(" + i + "," + j + ")"))
                .collect(toList());

        System.out.println(pairs);
        List<String> lp=new ArrayList<>();
        for(Integer l1:list1)
        {
            for(Integer l2:list2){
                lp.add("(" + l1 + "," + l2 + ")");

            }
        }
        System.out.println(lp);

                 //Get only even numbers from a list.
        System.out.println("Get only even numbers from a list.");
        List<Integer> nums = List.of(1, 2, 30, 4, 5, 6);
        List<Integer> fl =nums.stream().filter(n->n%2==0).collect(toList());
        System.out.println(fl);


        System.out.println("Calculate the sum of all numbers.");
        int sum =  nums.stream().reduce(0, (a,b)->a+b);
        System.out.println(sum);

       // IntStream.of(1, 2, 3, 4, 5, 6).sum();

        System.out.println("Find the maximum number.");
        System.out.println(nums.stream().max((a,b)->a.compareTo(b)).get());;


        System.out.println("Remove duplicate elements.");
        List<Integer> numsD = List.of(1, 2, 2, 3, 3, 3);

        System.out.println(numsD.stream().collect(Collectors.toSet()));


        System.out.println("Group people by age.");
        List<Person17> people = List.of(p1,p2,p3,p4);
       Map<Integer,List<Person17>> mp= people.stream().collect(Collectors.groupingBy(p->p.age()));
        mp.forEach((x,y)-> System.out.println("k:"+x+ " V:"+y));

        Map<Integer, List<String>> mp2 = people.stream()
                .collect(Collectors.groupingBy(
                        Person17::age,                      // 1. Agrupar por edad (Key: Integer)
                        mapping(Person17::name, toList()) // 2. Transformar a nombre y guardar en Lista (Value: List<String>)
                ));


        System.out.println("Join all strings separated by comma.");
        List<String> names = List.of("Ana", "Luis");
       String name= names.stream().collect(Collectors.joining(","));

        System.out.println("count ocurrencies");
        Map<Integer,Integer> map = Map.of(1,2,3,4);
        //map.entrySet().stream().collect(Collectors.groupingBy());


        System.out.println("Find the most frequent word.");
        Map.Entry<String, Long> max = words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println(max);
// apple=3



    }



}

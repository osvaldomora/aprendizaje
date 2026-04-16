package osvaldo.morales.company.demo.java8.exercise.streams;

import osvaldo.morales.company.demo.compatationtipes.Person17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class FMap {
    public static void main(String args[]){
        List<Integer> as=List.of(1,2);
      Stream<Integer> sd=  as.stream();
        System.out.println("1 You have a list of lists of integers. Convert it into a single list");
        List<List<Integer>> lists = List.of(List.of(1,2), List.of(5,12,66,44),List.of(3));
        Stream<List<Integer>> lt= lists.stream().map(x->x);
        Stream<Stream<Integer>> lt2= lists.stream().map(x->x.stream());
        System.out.println(lists.stream().map(l->l.stream()).flatMap(x->x).collect(toList()));
        List<Integer> l=  lists.stream().flatMap(list->list.stream()).collect(toList());
        System.out.println("list:"+l);
      /*  List<Integer> ll=  lists.stream().map(l1->l1).flatMap(list->list.stream()).collect(toList());
        System.out.println("list:"+ll);*/
        //Given a list of sentences, return a list of all words.
        List<String> sentences = List.of( "Hello world",
                "Java streams are powerful");
      Stream<String> sa= sentences.stream();

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


         List<Character> lc =   words2.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char) c)) // 2. Rompe "JAVA" en 'J', 'A', 'V', 'A'
                .distinct()
                .collect(toList());

        System.out.println(lc);

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
        System.out.println("sum with intStream"+nums.stream().mapToInt(n->n).sum());
        System.out.println(sum);

       // IntStream.of(1, 2, 3, 4, 5, 6).sum();

        System.out.println("Find the maximum number.");
        System.out.println(nums.stream().max((a,b)->a.compareTo(b)).get());
        //nums.stream().mapToInt(n->n).max().getAsInt();


        System.out.println("Remove duplicate elements.");
        List<Integer> numsD = List.of(1, 2, 2, 3, 3, 3);

        System.out.println(numsD.stream().collect(Collectors.toSet()));
        System.out.println(numsD.stream().distinct().collect(toList()));


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

        List<String> words20 = List.of("Hi", "Bye");

        int totalChars = words20.stream()
                .flatMapToInt(word -> word.chars()) // String → IntStream
                .sum();



    }



}

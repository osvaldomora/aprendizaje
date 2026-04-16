package osvaldo.morales.company.demo.java8.exercise.streams.streamMapFlatMapGuide;

import java.util.*;
import java.util.stream.*;

class Employee2 {
    String name;
    int age;

    public Employee2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public String toString() {
        return name + "(" + age + ")";
    }

    public static List<Employee2> getEmployees() {
        return List.of(
                new Employee2("Ana", 25),
                new Employee2("Luis", 30),
                new Employee2("Pedro", 35)
        );
    }
}

public class StreamMapFlatMapGuide {

    public static void main(String[] args) {

        // =========================================
        // 1. INTERMEDIATE vs TERMINAL
        // =========================================
        System.out.println("1. Intermediate vs Terminal");

        List<Integer> nums = List.of(1, 2, 3);

        nums.stream()
                .map(n -> {
                    System.out.println("Mapping: " + n); // shows lazy execution
                    return n * 2;
                })
                .forEach(n -> System.out.println("Result: " + n));

        // Explanation:
        // map() is INTERMEDIATE (lazy)
        // forEach() is TERMINAL (executes everything)


        // =========================================
        // 2. MAP - BASIC
        // =========================================
        System.out.println("\n2. map() basic");

        List<String> names = List.of("ana", "luis");

        List<String> upper = names.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Uppercase: " + upper);

        // Explanation:
        // map transforms each element (1 → 1)
        // String → String


        // =========================================
        // 3. MAP with objects
        // =========================================
        System.out.println("\n3. map() with objects");

        List<Employee2> employees = Employee2.getEmployees();

        List<String> employeeNames = employees.stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());

        System.out.println("Names: " + employeeNames);

        // Explanation:
        // Employee → String


        // =========================================
        // 4. MAP chaining
        // =========================================
        System.out.println("\n4. map() chaining");

        List<Integer> lengths = employees.stream()
                .map(e -> e.getName())       // Employee → String
                .map(name -> name.length())  // String → Integer
                .collect(Collectors.toList());

        System.out.println("Name lengths: " + lengths);

        // Explanation:
        // map can be chained
        // Each step transforms the type


        // =========================================
        // 5. MAP PROBLEM (Nested structure)
        // =========================================
        System.out.println("\n5. map() problem (nested lists)");

        List<List<String>> nested = List.of(
                List.of("Ana", "Luis"),
                List.of("Pedro", "Maria")
        );

        List<Stream<String>> wrong = nested.stream()
                .map(list -> list.stream()) // ⚠️ creates Stream<Stream<String>>
                .collect(Collectors.toList());

        System.out.println("Wrong (nested streams): " + wrong);

        // Explanation:
        // map creates nested streams → BAD for flattening


        // =========================================
        // 6. FLATMAP - SOLUTION
        // =========================================
        System.out.println("\n6. flatMap() solution");

        List<String> flat = nested.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("Flattened: " + flat);

        List<String> flat2=  nested.stream()
                .map(lt->lt.stream())
                .flatMap(list -> list)
                .collect(Collectors.toList());

        // Explanation:
        // flatMap flattens structure
        // List<List<String>> → List<String>


        // =========================================
        // 7. FLATMAP mental model
        // =========================================
        System.out.println("\n7. flatMap mental model");

        nested.stream()
                .flatMap(list -> {
                    System.out.println("Processing list: " + list);
                    return list.stream();
                })
                .forEach(name -> System.out.println("Element: " + name));

        // Explanation:
        // flatMap opens each container and streams elements


        // =========================================
        // 8. MAP vs FLATMAP difference
        // =========================================
        System.out.println("\n8. map vs flatMap");

        // map → nested
        List<List<String>> mapResult = nested.stream()
                .map(list -> list)
                .collect(Collectors.toList());

        System.out.println("map result: " + mapResult);

        // flatMap → flattened
        List<String> flatResult = nested.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("flatMap result: " + flatResult);


        // =========================================
        // 9. FLATMAP with characters
        // =========================================
        System.out.println("\n9. flatMap with characters");

        List<String> words = List.of("hi", "bye");

        List<Character> chars = words.stream()
                .flatMap(word -> {
                    // convert each word to stream of chars
                    return word.chars()
                            .mapToObj(c -> (char) c);
                })
                .collect(Collectors.toList());


        System.out.println("Characters: " + chars);

        // Explanation:
        // "hi" → h, i
        // "bye" → b, y, e
        // flatMap merges all


        // =========================================
        // 10. INTERVIEW COMPARISON
        // =========================================
        System.out.println("\n10. Interview summary");

        System.out.println("map → 1 to 1 transformation");
        System.out.println("flatMap → 1 to many + flatten");

    }
}

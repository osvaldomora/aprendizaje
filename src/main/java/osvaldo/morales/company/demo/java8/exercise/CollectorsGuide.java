package osvaldo.morales.company.demo.java8.exercise;

import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    int age;
    double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public static List<Employee> empleados() {
        return List.of(
                new Employee(1, "Ana", 25, 3000),
                new Employee(2, "Luis", 30, 4000),
                new Employee(3, "Pedro", 30, 5000),
                new Employee(4, "Maria", 22, 3500)
        );
    }
}

public class CollectorsGuide {

    public static void main(String[] args) {

        List<Employee> employees = Employee.empleados();

        // ==========================
        // 1. toList()
        // ==========================
        // Collect elements into a List
        List<String> names = employees.stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());

        System.out.println("toList: " + names);


        // ==========================
        // 2. toSet()
        // ==========================
        // Collect elements into a Set (removes duplicates)
        Set<Integer> ages = employees.stream()
                .map(e -> e.getAge())
                .collect(Collectors.toSet());

        System.out.println("toSet: " + ages);


        // ==========================
        // 3. joining()
        // ==========================
        // Join elements into a single String
        String joined = employees.stream()
                .map(e -> e.getName())
                .collect(Collectors.joining(", "));

        System.out.println("joining: " + joined);


        // ==========================
        // 4. counting()
        // ==========================
        // Count number of elements
        long count = employees.stream()
                .collect(Collectors.counting());

        System.out.println("counting: " + count);


        // ==========================
        // 5. groupingBy()
        // ==========================
        // Group employees by age
        Map<Integer, List<Employee>> groupByAge = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge()));

        System.out.println("groupingBy: " + groupByAge);


        // ==========================
        // 6. partitioningBy()
        // ==========================
        // Split into two groups based on condition
        Map<Boolean, List<Employee>> partition = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        System.out.println("partitioningBy: " + partition);


        // ==========================
        // 7. toMap()
        // ==========================
        // Convert to Map (key-value)
        Map<Integer, String> map = employees.stream()
                .collect(Collectors.toMap(
                        e -> e.getId(),
                        e -> e.getName()
                ));

        System.out.println("toMap: " + map);


        // ==========================
        // 8. averagingInt()
        // ==========================
        // Calculate average
        double avgAge = employees.stream()
                .collect(Collectors.averagingInt(e -> e.getAge()));

        System.out.println("average age: " + avgAge);


        // ==========================
        // 9. summarizingInt()
        // ==========================
        // Get statistics (count, sum, min, max, avg)
        IntSummaryStatistics stats = employees.stream()
                .collect(Collectors.summarizingInt(e -> e.getAge()));

        System.out.println("stats: " + stats);


        // ==========================
        // 10. mapping()
        // ==========================
        // Transform values inside grouping
        Map<Integer, List<String>> namesByAge = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getAge(),
                        Collectors.mapping(e -> e.getName(), Collectors.toList())
                ));

        System.out.println("mapping: " + namesByAge);


        // ==========================
        // 11. collectingAndThen()
        // ==========================
        // Apply a final transformation after collecting
        List<String> unmodifiableList = employees.stream()
                .map(e -> e.getName())
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> Collections.unmodifiableList(list)
                ));

        System.out.println("collectingAndThen: " + unmodifiableList);
    }
}

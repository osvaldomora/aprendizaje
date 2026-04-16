package osvaldo.morales.company.demo.java8.exercise.streams;


import java.util.*;
import java.util.stream.*;

class Employee1 {
    int id;
    String name;
    int age;
    double salary;

    public Employee1(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public String toString() {
        return name + "(" + age + ", $" + salary + ")";
    }

    public static List<Employee1> empleados() {
        return List.of(
                new Employee1(1, "Ana", 25, 3000),
                new Employee1(2, "Luis", 30, 4000),
                new Employee1(3, "Pedro", 30, 5000),
                new Employee1(4, "Maria", 22, 3500)
        );
    }
}

public class CollectorsInterviewGuide {

    public static void main(String[] args) {

        List<Employee1> employees = Employee1.empleados();

        System.out.println("=== ORIGINAL DATA ===");
        employees.forEach(e -> System.out.println(e));

        // =========================================
        // 1. groupingBy + counting
        // =========================================
        System.out.println("\n1. Count employees by age");

        Map<Integer, Long> countByAge = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getAge(),
                        Collectors.counting()
                ));

        System.out.println(countByAge);

        // Explanation:
        // Group by age, then count how many employees per group


        // =========================================
        // 2. Max salary employee
        // =========================================
        System.out.println("\n2. Employee with max salary");

        Optional<Employee1> maxSalary = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println(maxSalary.get());

        // Explanation:
        // We compare salaries and get the max element


        // =========================================
        // 3. Average salary by age
        // =========================================
        System.out.println("\n3. Average salary by age");

        Map<Integer, Double> avgSalaryByAge = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getAge(),
                        Collectors.averagingDouble(e -> e.getSalary())
                ));

        System.out.println(avgSalaryByAge);

        // Explanation:
        // Group employees, then calculate average salary per group


        // =========================================
        // 4. Name of employee with max salary per age
        // =========================================
        System.out.println("\n4. Name of highest paid employee per age");

        Map<Integer, String> bestPaidByAge = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getAge(),
                        Collectors.collectingAndThen(
                                Collectors.maxBy((e1, e2) ->
                                        Double.compare(e1.getSalary(), e2.getSalary())),
                                opt -> opt.get().getName()
                        )
                ));

        System.out.println(bestPaidByAge);

        // Explanation:
        // Step 1: group by age
        // Step 2: find max salary per group
        // Step 3: extract name from Optional


        // =========================================
        // 5. Joining names in uppercase
        // =========================================
        System.out.println("\n5. Names in uppercase joined");

        String names = employees.stream()
                .map(e -> e.getName().toUpperCase())
                .collect(Collectors.joining(", "));

        System.out.println(names);

        // Explanation:
        // Transform names → uppercase, then join into String


        // =========================================
        // 6. FLATMAP example
        // =========================================
        System.out.println("\n6. Flatten list of lists");

        List<List<String>> nested = List.of(
                List.of("Ana", "Luis"),
                List.of("Pedro", "Maria")
        );

        List<String> flat = nested.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println(flat);

        // Explanation:
        // flatMap converts Stream<List<String>> → Stream<String>


        // =========================================
        // 7. partitioningBy
        // =========================================
        System.out.println("\n7. Partition by salary > 3500");

        Map<Boolean, List<String>> partition = employees.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getSalary() > 3500,
                        Collectors.mapping(e -> e.getName(), Collectors.toList())
                ));

        System.out.println(partition);

        // Explanation:
        // true → high salary
        // false → low salary


        // =========================================
        // 8. Sum salaries by age
        // =========================================
        System.out.println("\n8. Sum salaries by age");

        Map<Integer, Double> sumByAge = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getAge(),
                        Collectors.summingDouble(e -> e.getSalary())
                ));

        System.out.println(sumByAge);

        // Explanation:
        // Group by age, sum salaries


        // =========================================
        // 9. Longest name
        // =========================================
        System.out.println("\n9. Longest name");

        Optional<String> longestName = employees.stream()
                .map(e -> e.getName())
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(longestName.get());

        // Explanation:
        // Compare string length


        // =========================================
        // 10. grouping vs partitioning (visual)
        // =========================================
        System.out.println("\n10. grouping vs partitioning");

        Map<Integer, List<Employee1>> grouping = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge()));

        Map<Boolean, List<Employee1>> partitioning = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        System.out.println("Grouping (many keys): " + grouping);
        System.out.println("Partitioning (2 groups): " + partitioning);

        // Explanation:
        // groupingBy → many keys
        // partitioningBy → always true/false
    }
}

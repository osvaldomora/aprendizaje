package osvaldo.morales.company.demo.java8.exercise.streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupingByWithEmployee {
    public static void main(String[] args) {

        List<Employee> employees = Employee.empleados();

        // =====================================================
        // 1) groupingBy (1 argumento)
        // =====================================================
        System.out.println("=== 1 ARGUMENTO ===");

        Map<Integer, List<Employee>> byAge =
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.getAge()));

        System.out.println(byAge);

        /*
         ✔ Agrupa por edad
         ✔ Resultado SIEMPRE: Map<edad, List<Employee>>

         Ej:
         30 → [Luis, Pedro]
        */


        // =====================================================
        // 2) groupingBy (2 argumentos) ⭐
        // =====================================================
        System.out.println("\n=== 2 ARGUMENTOS ===");

        // 🔥 Promedio salario por edad
        Map<Integer, Double> avgSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getAge(),
                                Collectors.averagingDouble(e -> e.getSalary())
                        ));

        System.out.println("Average: " + avgSalary);

        // 🔥 Conteo por edad
        Map<Integer, Long> count =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getAge(),
                                Collectors.counting()
                        ));

        System.out.println("Count: " + count);

        // 🔥 Solo nombres por edad
        Map<Integer, List<String>> names =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getAge(),
                                Collectors.mapping(e -> e.getLastName(), Collectors.toList())
                        ));

        System.out.println("Names: " + names);

        /*
         ✔ Aquí decides qué hacer con cada grupo
         ✔ YA NO estás limitado a listas de Employee
        */


        // =====================================================
        // 3) groupingBy (3 argumentos)
        // =====================================================
        System.out.println("\n=== 3 ARGUMENTOS ===");

        Map<Integer, Double> avgTreeMap =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getAge(),
                                () -> new TreeMap<>(), // 👈 tipo de Map
                                Collectors.averagingDouble(e -> e.getSalary())
                        ));

        System.out.println("TreeMap: " + avgTreeMap);

        /*
         ✔ Controlas el tipo de Map
         ✔ TreeMap → ordenado por edad
        */


        // =====================================================
        // 4) DIFERENCIA CLAVE
        // =====================================================
        System.out.println("\n=== DIFERENCIA CLAVE ===");

        // 1 argumento
        Map<Integer, List<Employee>> r1 =
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.getAge()));

        // 2 argumentos
        Map<Integer, Long> r2 =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getAge(),
                                Collectors.counting()
                        ));

        System.out.println("1 arg (List): " + r1);
        System.out.println("2 arg (Count): " + r2);


        // =====================================================
        // 5) SIN averagingDouble (tu estilo)
        // =====================================================
        System.out.println("\n=== SIN averagingDouble ===");

        Map<Integer, Double> avgManual =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getAge(),
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            double sum = list.stream()
                                                    .mapToDouble(e -> e.getSalary())
                                                    .sum();
                                            return sum / list.size();
                                        }
                                )
                        ));

        System.out.println("Manual Avg: " + avgManual);
    }

}

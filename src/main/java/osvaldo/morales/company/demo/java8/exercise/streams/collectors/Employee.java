package osvaldo.morales.company.demo.java8.exercise.streams.collectors;

import java.util.List;

public class Employee {
    int id;
    String lastName;
    int age;
    double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.lastName = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public String toString() {
        return lastName + "(" + age + ", $" + salary + ")";
    }

    public static List<Employee> empleados() {
        return List.of(
                new Employee(1, "Ana", 25, 3000),
                new Employee(2, "Luis", 30, 4000),
                new Employee(3, "Pedro", 30, 5000),
                new Employee(4, "Maria", 22, 3500)
        );
    }
}

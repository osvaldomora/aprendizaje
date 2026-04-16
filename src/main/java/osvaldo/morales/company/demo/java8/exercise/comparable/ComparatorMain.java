package osvaldo.morales.company.demo.java8.exercise.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(25, "John"));
        list.add(new Student(20, "Ana"));
        list.add(new Student(30, "Mike"));

        // Sort by name
       // Comparator<Student> nameComparator = (s1, s2) -> s1.name.compareTo(s2.name);

        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        };

        Collections.sort(list, nameComparator);

        for (Student s : list) {
            System.out.println(s.name + " " + s.age);
        }
    }

}

class Student{
    int age;
    String name;

    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

package osvaldo.morales.company.demo.java8.exercise.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



    class ComparableStudent implements Comparable<ComparableStudent> {
        int age;
        String name;

        ComparableStudent(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(ComparableStudent s) {
            return this.age - s.age; // sort by age
        }
    }

    public class ComparableMain3 {
        public static void main(String[] args) {
            List<ComparableStudent> list = new ArrayList<>();
            list.add(new ComparableStudent(25, "John"));
            list.add(new ComparableStudent(20, "Ana"));
            list.add(new ComparableStudent(30, "Mike"));

            Collections.sort(list);

            for (ComparableStudent s : list) {
                System.out.println(s.name + " " + s.age);
            }
        }
}

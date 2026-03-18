package osvaldo.morales.company.demo.compatationtipes;

import java.util.HashSet;
import java.util.Set;

public class MainCompare {
    public static void main(String args[]){
        Person p1 = new Person("John", 30);
        Person p2 = new Person("John", 30);
        p1.setName("julio");

        System.out.println("Equals: " + p1.equals(p2));

        Set<Person> set = new HashSet<>();

        set.add(p1);
        set.add(p2);

        System.out.println("Set size: " + set.size());
    }
}

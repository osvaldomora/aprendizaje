package osvaldo.morales.company.demo.compatationtipes;

//record Person17(String name, int age, email) {}

import java.util.List;
import java.util.Objects;

public final class Person17 {
    private final String name;
    private final Integer age;
    private final List<String> emails;

    public Person17(String name, Integer age,List<String> email) {
        this.name = name;
        this.age = age;
        this.emails=email;
    }

    public String name() {
        return name;
    }
    public List<String> email() {
        return emails;
    }

    public Integer age() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
}

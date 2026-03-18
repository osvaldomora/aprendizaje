package osvaldo.morales.company.demo.compatationtipes;

import lombok.Setter;

import java.util.Objects;
//@Setter
public class Person {

        String name;
        int age;

        Person(String name, int age){
        this.name = name;
        this.age = age;
        }

        public void setName(String name)
        {
                this.name=name;
        }

@Override
public boolean equals(Object obj) {

        if (this == obj)
        return true;

        if (obj == null || getClass() != obj.getClass())
        return false;

        Person other = (Person) obj;

        return age == other.age &&
        name.equals(other.name);
        }

@Override
public int hashCode() {
        return Objects.hash(name, age);
        }

        }


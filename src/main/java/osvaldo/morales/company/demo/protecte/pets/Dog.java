package osvaldo.morales.company.demo.protecte.pets;

import osvaldo.morales.company.demo.animals.Animal;

  public class Dog extends Animal {

    public void printName() {
        System.out.println(name); // ✅ allowed (through inheritance)
    }
}

package osvaldo.morales.company.demo.solid;

// Parent interface
interface Bird {
    void eat();
}

// Child interface extending Bird
interface FlyingBird extends Bird {
    void fly();
}

// Sparrow can fly
class Sparrow implements FlyingBird {

    @Override
    public void eat() {
        System.out.println("Sparrow is eating.");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying.");
    }
}

// Penguin cannot fly
class Penguin implements Bird {

    @Override
    public void eat() {
        System.out.println("Penguin is eating.");
    }
}

// Main class to test everything
public class Liskov {

    public static void main(String[] args) {

        Bird penguin = new Penguin();
        penguin.eat();

        FlyingBird sparrow = new Sparrow();
        sparrow.eat();
        sparrow.fly();
    }
}
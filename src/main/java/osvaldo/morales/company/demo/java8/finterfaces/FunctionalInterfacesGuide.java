package osvaldo.morales.company.demo.java8.finterfaces;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class FunctionalInterfacesGuide {

    public static void main(String[] args) {

        // =========================================
        // 1. SUPPLIER<T> → () -> T
        // =========================================
        // Explanation:
        // Takes no input, returns a value

        Supplier<String> supplier = () -> "Hello World";
        System.out.println("Supplier: " + supplier.get());

        // Existing implementation example
        Supplier<Double> randomSupplier = ()->(Math.random());//Math::random;
        System.out.println("Random: " + randomSupplier.get());


        // =========================================
        // 2. CONSUMER<T> → (T) -> void
        // =========================================
        // Explanation:
        // Takes one input, returns nothing (side effects)

        Consumer<String> consumer = s -> System.out.println("Consumed: " + s);
        consumer.accept("Java 8");

        // Existing implementation example
        List<String> list = Arrays.asList("A", "B", "C");
        list.forEach(System.out::println); // Consumer


        // =========================================
        // 3. FUNCTION<T, R> → (T) -> R
        // =========================================
        // Explanation:
        // Transforms input into output

        Function<Integer, String> function = x -> "Number: " + x;
        System.out.println(function.apply(10));

        // Existing implementation example
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<String> mapped = numbers.stream()
                .map(n->String.valueOf(n)) // String::valueOf        Function
                .collect(Collectors.toList());
        System.out.println(mapped);


        // =========================================
        // 4. PREDICATE<T> → (T) -> boolean
        // =========================================
        // Explanation:
        // Evaluates a condition

        Predicate<Integer> predicate = x -> x > 5;
        System.out.println("Predicate: " + predicate.test(10));

        // Existing implementation example
        List<Integer> filtered = numbers.stream()
                .filter(n -> n > 1) // Predicate
                .collect(Collectors.toList());
        System.out.println(filtered);


        // =========================================
        // 5. BICONSUMER<T, U> → (T, U) -> void
        // =========================================

        BiConsumer<String, Integer> biConsumer =
                (name, age) -> System.out.println(name + " is " + age);

        biConsumer.accept("John", 30);

        // Existing implementation example
        Map<String, Integer> map = Map.of("A", 1, "B", 2);
        map.forEach((k, v) -> System.out.println(k + ":" + v)); // BiConsumer


        // =========================================
        // 6. BIFUNCTION<T, U, R> → (T, U) -> R
        // =========================================

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("Sum: " + sum.apply(3, 4));

        // Existing implementation example
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("A", 1);

        map2.compute("A", (k, v) -> v + 10); // BiFunction
        System.out.println(map2);


        // =========================================
        // 7. BIPREDICATE<T, U> → (T, U) -> boolean
        // =========================================

        BiPredicate<String, String> biPredicate = String::equals;
        System.out.println("BiPredicate: " + biPredicate.test("A", "A"));


        // =========================================
        // 8. UNARYOPERATOR<T> → (T) -> T
        // =========================================

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("Square: " + square.apply(5));

        // Existing implementation example
        List<Integer> updated = numbers.stream()
                .map(x -> x * 2) // UnaryOperator
                .collect(Collectors.toList());
        System.out.println(updated);


        // =========================================
        // 9. BINARYOPERATOR<T> → (T, T) -> T
        // =========================================

        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Multiply: " + multiply.apply(2, 3));

        // Existing implementation example
        int result = numbers.stream()
                .reduce(0, Integer::sum); // BinaryOperator
        System.out.println("Reduce sum: " + result);


        // =========================================
        // 10. PRIMITIVE SPECIALIZATIONS
        // =========================================
        // Avoid boxing/unboxing

        IntPredicate intPredicate = x -> x > 10;
        System.out.println("IntPredicate: " + intPredicate.test(15));

        IntConsumer intConsumer = System.out::println;
        intConsumer.accept(100);

        IntFunction<String> intFunction = x -> "Value: " + x;
        System.out.println(intFunction.apply(50));

        IntSupplier intSupplier = () -> 42;
        System.out.println("IntSupplier: " + intSupplier.getAsInt());
    }
}

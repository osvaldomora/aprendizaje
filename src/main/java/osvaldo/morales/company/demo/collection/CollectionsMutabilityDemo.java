package osvaldo.morales.company.demo.collection;

import java.util.*;

public class CollectionsMutabilityDemo {

    public static void main(String[] args) {

        // ================================
        // 1. MUTABLE COLLECTION
        // ================================
        System.out.println("=== MUTABLE ===");

        List<String> mutable = new ArrayList<>();
        mutable.add("A");
        mutable.add("B");

        mutable.add("C"); // ✔ allowed
        mutable.remove("A"); // ✔ allowed

        System.out.println("Mutable: " + mutable);


        // ================================
        // 2. IMMUTABLE COLLECTION
        // ================================
        System.out.println("\n=== IMMUTABLE ===");

        List<String> immutable = List.of("A", "B", "C");

        System.out.println("Immutable: " + immutable);

        try {
            immutable.add("D"); // ❌ ERROR
        } catch (Exception e) {
            System.out.println("Cannot modify immutable: " + e);
        }


        // ================================
        // 3. UNMODIFIABLE COLLECTION
        // ================================
        System.out.println("\n=== UNMODIFIABLE ===");

        List<String> original = new ArrayList<>();
        original.add("A");

        List<String> unmodifiable = Collections.unmodifiableList(original);

        System.out.println("Before change: " + unmodifiable);

        // ❌ Direct modification not allowed
        try {
            unmodifiable.add("B");
        } catch (Exception e) {
            System.out.println("Cannot modify unmodifiable directly: " + e);
        }

        // ✔ But original CAN change
        original.add("B");

        System.out.println("After modifying original: " + unmodifiable);


        // ================================
        // 4. DEFENSIVE COPY
        // ================================
        System.out.println("\n=== DEFENSIVE COPY ===");

        List<String> source = new ArrayList<>();
        source.add("A");

        List<String> copy = new ArrayList<>(source);

        source.add("B");

        System.out.println("Source: " + source);
        System.out.println("Copy: " + copy); // ✔ unaffected


        // ================================
        // 5. BEST PRACTICE (IMMUTABLE COPY)
        // ================================
        System.out.println("\n=== BEST PRACTICE ===");

        List<String> safe = List.copyOf(source);

        System.out.println("Safe: " + safe);

        try {
            safe.add("C"); // ❌
        } catch (Exception e) {
            System.out.println("Cannot modify safe copy: " + e);
        }
    }
}
package osvaldo.morales.company.demo.java8.exercise.problems;

import java.util.*;
import java.util.stream.*;

public class CoreJavaInterviewToolkit {

    public static void main(String[] args) {

        // ============================
        // 1. STRING METHODS
        // ============================
        String s = "hello world";


        System.out.println("Length: " + s.length()); // 11
        System.out.println("CharAt: " + s.charAt(1)); // e
        System.out.println("Substring+" +
                "|  : " + s.substring(0,5)); // hello
        System.out.println("Contains: " + s.contains("world")); // true
        System.out.println("Equals: " + s.equals("hello world")); // true
        System.out.println("IgnoreCase: " + "HELLO".equalsIgnoreCase("hello"));

        // Split (very common in interviews)
        String[] words = s.split(" ");
        System.out.println("Split: " + Arrays.toString(words));

        // Replace
        System.out.println("Replace: " + s.replace("world", "java"));

        // Trim
        System.out.println("Trim:" + "  hi world no  ".trim());

        // String → char stream
        System.out.println("Chars count: " +
                s.chars().count());

        // ============================
        // 2. STRING + STREAMS
        // ============================

        // Count frequency
        Map<Character, Long> freq =
                s.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("Frequency: " + freq);

        // Reverse string
        String reversed =
                IntStream.range(0, s.length())
                        .mapToObj(i -> s.charAt(s.length()-1-i))
                        .map(c -> String.valueOf(c))
                        .collect(Collectors.joining());

        System.out.println("Reversed: " + reversed);

        // ============================
        // 3. INTEGER / MATH
        // ============================

        int a = 10, b = 3;

        System.out.println("Max: " + Math.max(a,b));
        System.out.println("Min: " + Math.min(a,b));
        System.out.println("Power: " + Math.pow(2,3));
        System.out.println("Absolute: " + Math.abs(-5));
        System.out.println("Square root: " + Math.sqrt(16));

        // Parsing
        int num = Integer.parseInt("123");
        System.out.println("Parsed: " + num);

        // Integer → String
        String strNum = String.valueOf(456);
        System.out.println("To String: " + strNum);

        // ============================
        // 4. ARRAYS
        // ============================

        int[] arr = {5,2,9,1};

        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        System.out.println("Binary Search: " +
                Arrays.binarySearch(arr, 5));

        // Convert to stream
        int sum = Arrays.stream(arr).sum();
        System.out.println("Sum: " + sum);

        // ============================
        // 5. LIST (ArrayList)
        // ============================

        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));

        list.add(6);
        list.remove(Integer.valueOf(2)); // remove by value
        System.out.println("List: " + list);

        System.out.println("Contains: " + list.contains(3));

        // Sorting with lambda
        list.sort((x,y) -> y-x);
        System.out.println("Sorted desc: " + list);

        // ============================
        // 6. SET (HashSet)
        // ============================

        Set<Integer> set = new HashSet<>(List.of(1,2,2,3));

        System.out.println("Set (no duplicates): " + set);
        System.out.println("Contains: " + set.contains(2));

        // ============================
        // 7. MAP (HashMap)
        // ============================

        Map<String,Integer> map = new HashMap<>();

        map.put("a",1);
        map.put("b",2);

        System.out.println("Get: " + map.get("a"));

        // Default value
        System.out.println("GetOrDefault: " +
                map.getOrDefault("c",0));
        map.entrySet().stream().forEach(k-> System.out.println(k.getValue()+" "+k.getKey()));
        // Iterate
        map.forEach((k,v) ->
                System.out.println(k + " -> " + v));

        // ============================
        // 8. STREAMS (MOST IMPORTANT)
        // ============================

        List<Integer> nums = List.of(1,2,3,4,5,6);

        // Filter
        List<Integer> evens =
                nums.stream()
                        .filter(x -> x % 2 == 0)
                        .toList();

        System.out.println("Evens: " + evens);

        // Map
        List<Integer> squares =
                nums.stream()
                        .map(x -> x * x)
                        .toList();

        System.out.println("Squares: " + squares);

        // Reduce
        int total =
                nums.stream()
                        .reduce(0, (x,y) -> x + y);

        System.out.println("Total: " + total);

        // Grouping
        Map<Boolean, List<Integer>> partition =
                nums.stream()
                        .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        System.out.println("Partition: " + partition);

        // ============================
        // 9. OPTIONAL (VERY ASKED)
        // ============================

        Optional<Integer> opt = nums.stream().findFirst();

        System.out.println("Optional: " + opt.orElse(0));

        // ============================
        // 10. STACK (INTERVIEW CLASSIC)
        // ============================

        Stack<Character> stack = new Stack<>();

        stack.push('a');
        stack.push('b');
        System.out.println("Pop: " + stack.pop());

    }
}
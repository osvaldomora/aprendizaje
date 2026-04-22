package osvaldo.morales.company.demo.java8.exercise.problems;

import java.util.*;
import java.util.stream.*;

public class InterviewProblems {

    public static void main(String[] args) {

        // ================================

        // 1. Reverse String IntStream.range(0, 5) = for (int i = 0; i < 5; i++) {i tomará los valores 0, 1, 2, 3, 4}

        // ================================
        String orig= "hello";
        char[] originArray = orig.toCharArray();
        char[]  rev = new char[originArray.length];
        for(int i=0,  indexFina=originArray.length-1;i< originArray.length;i++,indexFina --){
            rev[i]=originArray[indexFina];
        }
        System.out.println(String.valueOf(rev));

       Stream<Character> sc = IntStream.range(0,orig.length()).mapToObj(i->orig.charAt(orig.length()-1-i));
      String f= sc.map(c->String.valueOf(c)).collect(Collectors.joining());

        System.out.println("1. Reverse: " + reverse("hello"));

        // ================================
        // 2. Palindrome anita lava la tina
        // ================================

        String pal = "racecar";
    String s2=    IntStream.range(0,pal.length()).map(i->pal.length()-1-i).mapToObj(index->String.valueOf(pal.charAt(index)))
                .collect(Collectors.joining());
    if(pal.equalsIgnoreCase(s2)){
        System.out.println(s2+ "is palindrome");
    }

    for(int i=0,j=pal.length()-1;i<pal.length()/2;i++,j--){
        if(Character.toLowerCase(pal.charAt(i)) != Character.toLowerCase(pal.charAt(j))){
            System.out.println(false);
            break;
        }
    }        System.out.println(true);


        System.out.println("2. Palindrome: " + isPalindrome("racecar"));

        // ================================
        // 3. Count Characters
        // ================================
        System.out.println("3. Char Count: " + countChars("aabbc"));

        // ================================
        // 4. First Non-Repeating Character
        // ================================
        System.out.println("4. First Unique: " + firstUnique("aabbcd"));

        // ================================
        // 5. Remove Duplicates
        // ================================
        System.out.println("5. Remove Duplicates: " + removeDuplicates("banana"));

        // ================================
        // 6. Sum of List
        // ================================
        System.out.println("6. Sum: " + sumList(List.of(1,2,3,4)));


        // ================================
        // 7. Find Max
        // ================================

        System.out.println("7. Max: " + findMax(List.of(5,2,9,1)));

        // ================================
        // 8. Sort List
        // ================================

        System.out.println("8. Sorted: " + sortList(List.of(4,2,8,1)));

        // ================================
        // 9. Filter Even Numbers
        // ================================
        System.out.println("9. Evens: " + filterEven(List.of(1,2,3,4,5)));

        // ================================
        // 10. Square Numbers
        // ================================
        System.out.println("10. Squares: " + squareList(List.of(1,2,3)));

        // ================================
        // 11. Group By Length
        // ================================
        System.out.println("11. Group Length: " + groupByLength(List.of("a","bb","va","ccc")));
        // ================================
        // 12. Count Words
        // ================================
        System.out.println("12. Word Count: " + countWords("hello world hello"));
        System.out.println(Arrays.stream("hello world hello".split(" ")).collect(Collectors.groupingBy(w->w,Collectors.counting())));

        // ================================
        // 13. Anagram Check
        // ================================
        System.out.println("13. Anagram: " + isAnagram("listen","silent"));

        // ================================
        // 14. Flatten List
        // ================================
        System.out.println("14. Flatten: " + flatten(List.of(List.of(1,2), List.of(3,4))));

        // ================================
        // 15. Find Duplicate Numbers
        // ================================
        System.out.println("15. Duplicates: " + findDuplicates(List.of(1,2,2,3,3,3)));


        // ================================
        // 16. Frequency Map
        // ================================
        System.out.println("16. Frequency: " + frequencyMap(List.of("a","b","a")));

        // ================================
        // 17. Longest String
        // ================================

        System.out.println("17. Longest: " + longestString(List.of("a","abcd","abc")));

        // ================================
        // 18. Partition Even/Odd
        // ================================
        System.out.println(List.of(1,2,3,4).stream().collect(Collectors.partitioningBy(i->i%2==0)));


        // ================================
        // 19. Top N Elements
        // ================================
        System.out.println("19. Top 2: " + topN(List.of(5,1,9,2),2));
        // ================================
        // 20. Merge Maps
        // ================================
        Map<String,Integer> m1 = Map.of("a",1,"b",2);
        Map<String,Integer> m2 = Map.of("a",3,"c",4);
        System.out.println("20. Merge Maps: " + mergeMaps(m1,m2));
        Map<String,Integer> newMap= new HashMap<>();
        for(Map.Entry<String, Integer> mp:m1.entrySet()){
            if(m2.containsKey(mp.getKey())){
                newMap.put(mp.getKey(),mp.getValue()+m2.get(mp.getKey()));
            }else{
                newMap.put(mp.getKey(),mp.getValue());
            }

        }
        for(Map.Entry<String, Integer> mp:m2.entrySet()){
            if(!m1.containsKey(mp.getKey())){
                newMap.put(mp.getKey(),mp.getValue());
            }

        }
        System.out.println("mi mapa" + newMap);

        // ================================
        // 21–30 Advanced
        // ================================
        System.out.println("21. Sliding Window Max simple: " + slidingMax(List.of(1,3,2,5,4),3));
        System.out.println("22. Rotate Array: " + Arrays.toString(rotate(new int[]{1,2,3,4},2)));

        System.out.println("23. Two Sum: " + Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
        System.out.println("24. Fibonacci: " + fibonacci(7));

        System.out.println("25. Factorial: " + factorial(5));
        System.out.println("26. Binary Search: " + binarySearch(new int[]{1,2,3,4,5},4));
        System.out.println("27. Merge Sorted Arrays: " + Arrays.toString(mergeSorted(new int[]{1,3}, new int[]{2,4})));
        System.out.println("28. Subarray Sum: " + subarraySum(new int[]{2,1,3},5));
        System.out.println("29. Reverse Words: " + reverseWords("hello world cruel"));
      List<String> st=  Arrays.stream("hello world cruel".split(" ")).collect(Collectors.toList());
     StringBuilder sb= new StringBuilder();
      for(int i=st.size()-1;i>=0;i--){
          sb.append(st.get(i)+" ");
      }
        System.out.println(sb);


        System.out.println("30. Balanced Parentheses: " + isBalanced("()[]{}"));
    }

    // 1 Reverse
    static String reverse(String s){
        return IntStream.range(0,s.length())
                .mapToObj(i -> s.charAt(s.length()-1-i))
                .map(c -> String.valueOf(c))
                .collect(Collectors.joining());
    }
    // EN: reverse using stream
    // ES: invertir usando stream

    // 2 Palindrome
    static boolean isPalindrome(String s){
        return s.equals(reverse(s));
    }

    // 3 Count chars
    static Map<Character,Long> countChars(String s){
        return s.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    // 4 First unique
    static Character firstUnique(String s){

        // 1. Contamos frecuencias (suponiendo ASCII/Extendido)
        int[] freq = new int[256];
        s.chars().forEach(c -> freq[c]++);

        // 2. Buscamos el primero con frecuencia 1 en el string original
        s.chars()
                .filter(c -> freq[c] == 1)
                .findFirst()
                .ifPresent(c -> System.out.println((char) c));


        //v2
        return s.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst().orElse(null);
    }

    // 5 Remove duplicates
    static String removeDuplicates(String s){
        "banana".chars().mapToObj(ascci->String.valueOf((char)ascci)).collect(Collectors.toSet()).stream().collect(Collectors.joining());

        return s.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.joining());
    }

    // 6 Sum
    static int sumList(List<Integer> list){
        List.of(1,2,3,4).stream().mapToInt(x->x).sum();
        return list.stream().reduce(0, (a,b) -> a+b);
    }

    // 7 Max
    static int findMax(List<Integer> list){
        List.of(5,2,9,1).stream().mapToInt(x->x).max();

        return list.stream().max((a,b)->a-b).orElse(0);
    }

    // 8 Sort
    static List<Integer> sortList(List<Integer> list){
        return list.stream().sorted((a,b)->a-b).toList();
    }

    // 9 Filter even
    static List<Integer> filterEven(List<Integer> list){list.stream().map(x->x^2).collect(Collectors.toList());
        return list.stream().filter(x -> x%2==0).toList();
    }

    // 10 Square
    static List<Integer> squareList(List<Integer> list){
        return list.stream().map(x -> x*x).toList();
    }

    // 11 Group by length
    static Map<Integer,List<String>> groupByLength(List<String> list){
        return list.stream().collect(Collectors.groupingBy(s -> s.length()));
    }

    // 12 Count words
    static Map<String,Long> countWords(String s){
        return Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
    }

    // 13 Anagram
    static boolean isAnagram(String a, String b){

      String aa=  a.chars().sorted().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
      String bb =  b.chars().sorted().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
      System.out.println(aa.equalsIgnoreCase(bb));

        return sort(a).equals(sort(b));
    }
    static String sort(String s){
        return s.chars().sorted()
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.joining());
    }

    // 14 Flatten
    static List<Integer> flatten(List<List<Integer>> list){
        return list.stream()
                .flatMap(l -> l.stream())
                .toList();
    }

    // 15 Duplicates
    static Set<Integer> findDuplicates(List<Integer> list){
        System.out.println(List.of(1,2,2,3,3,3).stream().collect(Collectors.groupingBy(x->x,Collectors.counting())).entrySet().stream()
                .filter(n->n.getValue()>1l).map(map->String.valueOf(map.getKey())).collect(Collectors.joining(",")));
        return list.stream()
                .filter(x -> Collections.frequency(list,x)>1)
                .collect(Collectors.toSet());
    }

    // 16 Frequency
    static Map<String,Long> frequencyMap(List<String> list){
        return list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
    }

    // 17 Longest
    static String longestString(List<String> list){
        System.out.println(list.stream()
                .max((a,b)->a.compareTo(b))
                .get());

        System.out.println(list.stream().max((a,b)->Integer.compare(a.length(),b.length())).get());
        return list.stream()
                .max((a,b)->a.length()-b.length()).orElse("");
    }

    // 18 Partition
    static Map<Boolean,List<Integer>> partitionEvenOdd(List<Integer> list){
        return list.stream()
                .collect(Collectors.partitioningBy(x -> x%2==0));
    }

    // 19 Top N
    static List<Integer> topN(List<Integer> list, int n){
        System.out.println(List.of(5,1,9,2).stream().sorted((a,b)->b.compareTo(a)).limit(2).collect(Collectors.toList()));

        return list.stream()
                .sorted((a,b)->b-a)
                .limit(n)
                .toList();
    }

    // 20 Merge maps
    static Map<String,Integer> mergeMaps(Map<String,Integer> m1, Map<String,Integer> m2){


        return Stream.concat(m1.entrySet().stream(), m2.entrySet().stream())
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue(),
                        (v1,v2) -> v1+v2
                ));
    }

    // 21 Sliding window max (simple)
    static int slidingMax(List<Integer> list, int k){
        return list.subList(0,k).stream().max((a,b)->a-b).orElse(0);
    }

    // 22 Rotate array
    static int[] rotate(int[] arr, int k){

        int[] newArray= new int[arr.length];
        for(int i=0,j=k;i<arr.length-2;i++,j++){
            newArray[i]=arr[j];
        }
        for(int i=k,j=0;j<k;i++,j++){
            newArray[i]=arr[j];
        }
        System.out.println(Arrays.toString(newArray));

        int n = arr.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[(i+k)%n] = arr[i];
        }
        return res;
    }

    // 23 Two sum
    static int[] twoSum(int[] nums, int target){
for (int j=0;j< nums.length;j++) {
    for (int i = 1; i < nums.length; i++) {
        if (nums[j] + nums[i] == target) {
            System.out.println("sum:"+nums[j]+" "+nums[i]);
        }

    }
}

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // 24 Fibonacci
    static int fibonacci(int n){
        if(n<=1) return n;
        return fibonacci(n-1)+fibonacci(n-2);//2,1 1 0 +1
    }
    /*
            //f0=0 f1 =1 f2=1 f3=2 f4=3 f5=5 f6=8
        int n=7,fib=0;
        int fn1=1, fn2=1;
        if(n==1 || n==2)
            fib= 1;
        for(int i=3;i<=n;i++){
           fib=fn1+fn2;
           fn1=fn2;
           fn2=fib;
        }
        System.out.println(fib);
     */


    // 25 Factorial
    static int factorial(int n){

        if(n==1)
            return n;
        int fact=n;
        for(int i=n-1;i>1;i--){
            fact=fact*i;
        }
        System.out.println(fact);

        long factorial = 1;

        // Usamos un bucle for para multiplicar desde 1 hasta n
        for (int i = 1; i <= n; i++) {
            factorial *= i; // Es lo mismo que: factorial = factorial * i;
        }


        return IntStream.rangeClosed(1,n)//for (int i = 1; i <= n; i++) {
                .reduce(1,(a,b)->a*b);
    }

    // 26 Binary search
    static int binarySearch(int[] arr, int target){
        for(int i=0; i<arr.length;i++){
            if(arr[i]==target){
                System.out.printf("Value: %d was found in position: %d",arr[i],i);
            }
        }
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }

    // 27 Merge sorted arrays
    static int[] mergeSorted(int[] a, int[] b){
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .sorted()
                .toArray();
    }

    // 28 Subarray sum
    static boolean subarraySum(int[] arr, int target){//new int[]{2,1,3},5


        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==target) return true;
            }
        }
        return false;
    }

    // 29 Reverse words
    static String reverseWords(String s){//hello world cruel  cruel world hello
        return Arrays.stream(s.split(" "))
                .reduce("", (a,b)->b+" "+a).trim();
    }

    // 30 Balanced parentheses
    static boolean isBalanced(String s){// ()[]{}
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('||c=='['||c=='{') st.push(c);
            else{
                if(st.isEmpty()) return false;
                char top = st.pop();
                if((c==')'&&top!='(') ||
                        (c==']'&&top!='[') ||
                        (c=='}'&&top!='{')) return false;
            }
        }
        return st.isEmpty();
    }
}

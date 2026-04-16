package osvaldo.morales.company.demo.java8.exercise;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prime {
    public static void main(String args[]){
        System.out.println("insert number");
        Scanner scanner= new Scanner(System.in);
        int x=scanner.nextInt();

        //int x=5;

        Boolean prime=isPrime(x);
        System.out.println(prime);
    }

    private static Boolean isPrime(int number) {
        if(number==1)
            return false;
       return IntStream.rangeClosed(2,(int)Math.sqrt(number)).noneMatch((res)->number%res==0);
       /* return IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .noneMatch(i -> number % i == 0);*/
    }

    private static Boolean isPrime2(int number){

        for (int i=2; i<=number;i++){
            if(number%i==0)
                return false;
        }

        return true;
    }
}

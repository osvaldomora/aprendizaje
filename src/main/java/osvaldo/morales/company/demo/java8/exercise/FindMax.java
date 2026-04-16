package osvaldo.morales.company.demo.java8.exercise;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class FindMax {
    public static void main(String args[]){

        List<Integer> listNumber = List.of(6,1,9,4);
        Integer aux=0;
        for(int i=0; i<listNumber.size();i++){
            //System.out.println(listNumber.get(i));
            if(listNumber.get(i)>aux)
             aux=listNumber.get(i);
        }
       // System.out.println(aux);
        AtomicInteger auxAtomic=new AtomicInteger(0);
        listNumber.stream().forEach(x->{
            if(x>auxAtomic.get()){
                auxAtomic.set(x);
            }

        });
       // System.out.println(auxAtomic);
        listNumber.stream()
                .max(Integer::compare) // Devuelve un Optional<Integer>
                .ifPresent(System.out::println);

      /*  for (Integer alias : listNumber) {
            System.out.println(alias);
        }*/

        //System.out.println(listNumber.stream().max((x,y)->x.compareTo(y)).get());
       // listNumber.stream().max((x,y)->x.compareTo(y)).ifPresent(max-> System.out.println(max));
        listNumber.stream()
                // 1. Definimos la regla: comparamos un número A con un número B
                .max((numA, numB) -> numA.compareTo(numB))

                // 2. El 'ganador' de todas las comparaciones llega aquí como 'elMaximo'
                .ifPresent(elMaximo -> System.out.println("El número más grande es: " + elMaximo));

//sum two numbers
        System.out.println(listNumber.stream().reduce(0,(a,b)->a+b));

         listNumber.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(listNumber.stream().mapToInt(x->x).sum());







    }
}

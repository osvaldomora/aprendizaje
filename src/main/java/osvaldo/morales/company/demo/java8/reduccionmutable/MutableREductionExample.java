package osvaldo.morales.company.demo.java8.reduccionmutable;

import osvaldo.morales.company.demo.java8.exercise.collect.Employee;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MutableREductionExample {
    public static void main(String arg[]){
       // Supplier<ArrayList<String>> proveedor = ()->new ArrayList<>();
        Supplier<ArrayList<String>> proveedor = ArrayList::new;
       // BiConsumer<ArrayList<String>, String> acumulador = (lista, str) -> lista.add(str);
        BiConsumer<ArrayList<String>, String> acumulador = ArrayList::add;
        //BiConsumer<ArrayList<String>, ArrayList<String>> combinador = (list1, list2) -> list1.addAll(list2);
        BiConsumer<ArrayList<String>, ArrayList<String>> combinador = ArrayList::addAll;

      //  ArrayList<String> nombres =
                Employee.empleados()
                .stream()
                .map(Employee::getName)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


        Supplier<ArrayList<String>> proveedor2 = ()->new ArrayList<>();
        BiConsumer<ArrayList<String>, String> acumulador2 = (lista, str) -> lista.add(str);
        BiConsumer<ArrayList<String>, ArrayList<String>> combinador2 = (list1, list2) -> list1.addAll(list2);
        Employee.empleados()
                .stream()
                .map(Employee::getName)
                .collect(proveedor2, acumulador2, combinador2);



        ArrayList<String> resultado =
                Employee.empleados()
                        .stream()
                        .map(e -> e.getName())
                        .collect(
                                () -> new ArrayList<>(), // supplier  get()
                                (lista, str) -> lista.add(str), // accumulator Accept(H,T)
                                (l1, l2) -> l1.addAll(l2) // combiner Accept(H,T)
                        );

        System.out.println(resultado);


        ArrayList<String> resultado2 =
                Stream.of("Ana", "Luis", "Pedro")
                        .collect(
                                () -> new ArrayList<>(), // supplier

                                // 🔹 accumulator
                                (lista, nombre) -> lista.add(nombre),

                                // 🔹 combiner
                                (lista1, lista2) -> lista1.addAll(lista2)
                        );

        System.out.println(resultado2);



    }


}


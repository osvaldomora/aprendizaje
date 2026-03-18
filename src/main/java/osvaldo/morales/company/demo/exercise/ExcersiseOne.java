package osvaldo.morales.company.demo.exercise;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


import java.util.stream.Stream;
public class ExcersiseOne { //output: planets:Mercury,Venus,Mars

	public static void main(String[] args) {
	/*	String[] input = { "Mercury", "Venus", "Mars"};
        Predicate<String> pr= x->x.equals("planets:");
		
		String st=  Arrays.stream(input).reduce("planets:",(s1,s2)->{
			if(pr.test(s1))
				return s1+s2;
			
            return s1+","+s2;
			
		});
		System.out.println(st);

	 */

		Integer[] array = {1,2,3,4};
		Stream.of(array).reduce(0,(a,b)->a+b);
		String[] arr = new String[]{",",""};
		List<Integer> lis = List.of(1,2,3);
		Optional<Integer> x=	lis.stream().reduce((a, b)->a+b);
		System.out.println(x.get());

	/*	List<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list.stream().reduce(0,(a,z)->a+z )); */
		 

	
	
	}
	
	


}

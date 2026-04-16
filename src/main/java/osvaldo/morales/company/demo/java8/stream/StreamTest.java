package osvaldo.morales.company.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		List<Integer> numeros = Arrays.asList(1,2,3,4,5);
		Stream<Integer> numStream = numeros.stream();
		
		int suma = numStream
				.filter(n->n%2==1)
				.map(n->n*n)
				.reduce(0, (n1,n2)->n1+n2);
		
		System.out.println(suma);

	}

}

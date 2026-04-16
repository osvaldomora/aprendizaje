package osvaldo.morales.company.demo.java8.exercise.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenation {

	public static void main(String[] args) {

		List<Persona> per = new ArrayList<>();
		per.add(new Persona(1,"oe"));
		per.add(new Persona(2,"per2"));
		per.add(new Persona(3,"an"));
		
		Collections.sort(per);
		
		per.stream().forEach(x->System.out.println(x));
				
	}

}

package osvaldo.morales.company.demo.java8.finterfaces.predicate;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Evaluator {
public	List<Estudiante> evaluar(List<Estudiante> students, Predicate<Estudiante> predicate){
	
	
	List<Estudiante> studentMoreWage= new LinkedList<Estudiante>();
	for(Estudiante st: students)
	{
		if(predicate.test(st))
			studentMoreWage.add(st);
		
	}
		
		return studentMoreWage;
		
	
}
}

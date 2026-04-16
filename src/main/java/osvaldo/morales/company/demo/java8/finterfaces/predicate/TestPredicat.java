package osvaldo.morales.company.demo.java8.finterfaces.predicate;

import java.util.Arrays;
import java.util.List;

public class TestPredicat {

	public static void main(String[] args) {
	
		List<Estudiante> studentsl=  Arrays.asList(
				new Estudiante("kagel", 10),
				new Estudiante("valdo", 20),
				new Estudiante("valdo2", 40));
		
		System.out.println("Students withs wages >15");
		Evaluator evalua = new  Evaluator();
		
		List<Estudiante> goodWage= evalua.evaluar(studentsl,(Estudiante estudiante)->
//		{
			estudiante.getAverage()>10);
//			if(estudiante.getAverage()>10)
//			{System.out.println(estudiante.getName());
//				return true;
//			}
//			else return false;
//		});
		
		for(Estudiante em:goodWage)
		{
			System.out.println(em.toString());
			
		}
		
		
		System.out.println("Employees with start with k");
		
		List<Estudiante> startK= evalua.evaluar(studentsl,(Estudiante estudiante)->{
			if(estudiante.getName().startsWith("k"))
			{
				return true;
			}
			else return false;
		});
		for(Estudiante em:startK)
		{
			System.out.println(em.toString());
			
		}
		

	}
	

	

}

package osvaldo.morales.company.demo.java8.exercise.collect;


import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProcessingEmployees
{
   public static void main(String[] args)
   {
//	   List<String> nombres = Employee.empleados()
//			   .stream()
//			   .map(emp-> emp.getDepartment())//Employee::getName
//			   .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
	   
	   Set<String> nombres = Employee.empleados()
			   .stream()
			   .map(emp-> emp.getDepartment())//Employee::getName
			   .collect(Collectors.toSet());
//			   .collect(Collectors.toCollection(TreeSet::new));
			   
			   nombres.forEach(val->System.out.println(val));
			   
			   
			   System.out.println("Example Map"); 
			   Map<Double, String> idEmployMap= Employee.empleados()
					   .stream()
					   .collect(Collectors.toMap(sal->sal.getSalary(), emp->emp.getFirstName()));
			   System.out.println("printing map with set");
			   Set<Double> prueba=idEmployMap.keySet();
			   for(Double alias:prueba) {
				   System.out.println("Key: " + alias + ": Value: " + idEmployMap.get(alias));
			   }
			   
			   System.out.println("printing map with collect");
			   idEmployMap.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
			   
			   
			   
   } // end main
} // end class ProcessingEmployees


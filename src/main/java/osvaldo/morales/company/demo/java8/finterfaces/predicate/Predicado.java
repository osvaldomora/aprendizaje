package osvaldo.morales.company.demo.java8.finterfaces.predicate;

import java.util.function.Predicate;
import java.util.jar.Attributes.Name;

public class Predicado {

	public static void main(String[] args) {
		
//		Generico<String>  gen = new Generico<String>("hola");
		Predicate<Integer> pred = name -> {
			
			if(name.equals(19))
			return true;
			else return false;
		};
		
		
		System.out.println(pred.test(19));
		System.out.println(pred.test(9));
				
//				new Predicate<T>() {
//
//			@Override
//			public boolean test(T t) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		};

	}

}

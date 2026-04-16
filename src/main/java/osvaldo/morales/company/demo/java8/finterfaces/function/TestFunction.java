package osvaldo.morales.company.demo.java8.finterfaces.function;

import java.util.function.*;
public class TestFunction {

	public static void main(String[] args) {

		
		Function<Integer, String> convertidor= x->Integer.toString(x);
		System.out.println(convertidor.apply(5).length());
		
		
		Function<Integer, String> abc= new Function<Integer, String>() {
			@Override
			public String apply(Integer t) {
				// TODO Auto-generated method stub
				return String.valueOf(t+10);
			}
		};

		System.out.println(abc.apply(5));
	
		
	}

}

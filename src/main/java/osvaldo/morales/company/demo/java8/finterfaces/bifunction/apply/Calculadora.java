package osvaldo.morales.company.demo.java8.finterfaces.bifunction.apply;

import java.util.function.BiFunction;

public class Calculadora {

	public String calc(BiFunction<Integer, Integer, String> biF, int i, int j) {
		// TODO Auto-generated method stub
		return biF.apply(i, j);
		
	}

}

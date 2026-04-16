package osvaldo.morales.company.demo.java8.finterfaces.unaryOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorTest {

	public static void main(String[] args) {

		List<Integer> lista = Arrays.asList(1,2,3,4);
		List<Integer> comeBack= operadorUnary(arg->arg*arg, lista);
		comeBack.forEach(num->System.out.println(num));
		
	}
	
	public static List<Integer> operadorUnary(UnaryOperator<Integer> unaryOpt,List<Integer> lista)
	{ 
		
		List<Integer> listaUpdate = new ArrayList<>();
		lista.forEach(num->listaUpdate.add(unaryOpt.apply(num)));
		
		return listaUpdate;
	}

}

package osvaldo.morales.company.demo.java8.finterfaces.BinaryOperator;

import java.util.function.BinaryOperator;

public class NinaryOperatorTest {

	public static void main(String[] args) {
		
		
		BinaryOperator<Integer> bOperator = (num1,num2) ->num1*num2;
		int resultado = bOperator.apply(10, 20);
		System.out.println("the result is" + resultado );
		
		//use metodMinby
		BinaryOperator<Integer> bOperatorMin=
				BinaryOperator.minBy((Integer t1, Integer t2)->t1.compareTo(t2));
		System.out.println("the minor num is:"+bOperatorMin.apply(40, 3));

	}

}

package osvaldo.morales.company.demo.java8.lamda.lambda3;

public class LambdaTest3 {
	public static void main(String args[]) {
		
		
		operaciones((x,y) -> x+y);
		operaciones((x,y) -> x*y);
		operaciones((x,y) -> x/y);
		operaciones((x,y) -> x%y);
//		Engine engine=(n1,n2)->System.out.println();
//		operaciones(engine);
		
	}
	
	public static void operaciones(Calculadora cal)
	{int x=2, y=9;
	 
	System.out.println(cal.operacion(x,y));
	
		
	}

}

package osvaldo.morales.company.demo.java8.lamda.lambda4;

public class LambdaTest3 {
	public static void main(String args[]) {
		Calculadora2 c2= (x,y) -> x+y;
		Calculadora c1= (x,y) -> x+y;
		
		Calculadora2 c3=operaciones(c2);
		System.out.println(c3.operacion(9, 9));
		operaciones(c1);
		
//		operaciones((int x,int y) -> x+y);
//		operaciones((x,y) -> x*y);
//		operaciones((x,y) -> x/y);
//		operaciones((x,y) -> x%y);
//		Engine engine=(n1,n2)->System.out.println();
//		operaciones(engine);
		
	}
	
	public static void operaciones(Calculadora cal)
	{int x=2, y=9;
	 
	System.out.println(cal.operacion(x,y));
	
		
	}
	
	
	public static Calculadora2 operaciones(Calculadora2 cal)
	{long x=2, y=9;
	 
	System.out.println(cal.operacion(x,y));
	

	return (xx,yy) -> xx+yy;
		
	}

}

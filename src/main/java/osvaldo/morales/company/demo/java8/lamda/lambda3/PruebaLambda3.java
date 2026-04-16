package osvaldo.morales.company.demo.java8.lamda.lambda3;

public class PruebaLambda3 {

	public static void main(String[] args) {
		
		PruebaLambda3 pl3 = new PruebaLambda3();
		Calculadora suma= (a,b)-> a+b;
//		{
//			System.out.println("la suma es:"); 
//			return a+b; 
//		};
		Calculadora mult= (a,b)-> {
			System.out.println("la mult es:");
			return a*b;
		};
		System.out.println(pl3.opera(suma, 1, 9));
		System.out.println(pl3.opera(mult, 1, 2));
		
		
		Calculadora sumaN = new Calculadora() {

			@Override
			public int operacion(int num1, int num2) {
				System.out.println("A expresion lamda implements tethod of a functional interface");
				return num1*num2;
			}
			
			
		};
		
		sumaN.operacion(10, 5);
		
		
		

	}
	
	
	public  int opera(Calculadora c,int a,int b)
	{
		return c.operacion(a, b);
	}

}

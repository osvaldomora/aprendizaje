package osvaldo.morales.company.demo.java8.lamda.calculadora2;

public class LambdaTest {

	public static void main(String[] args) {

		FunctionTest ft = () -> System.out.println("Hola Mundo");
		ft.saludar();
		
		LambdaTest obj = new LambdaTest();
		obj.miMetodo(ft);
		
		Calculadora cal = (int n1, int n2)->{
			System.out.println("the multiplication is :"+ n1*n2);
		    return n1*n2;
		};
		
		int res=cal.operacion(7, 8);
		System.out.println("res:" +res);
		

		
	}
	
	public  void miMetodo(FunctionTest functionTest) {
		
		functionTest.saludar();
		
	}

}

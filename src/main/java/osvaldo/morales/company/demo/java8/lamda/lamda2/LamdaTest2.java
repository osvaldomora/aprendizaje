package osvaldo.morales.company.demo.java8.lamda.lamda2;

public class LamdaTest2 {
	
	public static void main(String[] args) {
		
		Operationes op =(num1qqq,qqqnum2) ->System.out.println(num1qqq+qqqnum2);
		op.imprimesuma(1, 2);
		LamdaTest2 lambda = new LamdaTest2();
		lambda.metodo((n1,n2)->System.out.println("This is a multiplication:"+ n1*n2),5,5);
		lambda.metodo(op,10,10);
		
	}
	
	public void metodo(Operationes op,int a, int b) {
		op.imprimesuma(a, b);
	}

}

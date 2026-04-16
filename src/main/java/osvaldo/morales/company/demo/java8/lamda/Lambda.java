package osvaldo.morales.company.demo.java8.lamda;

public class Lambda {

	public static void main(String[] args) {
		Ficticia fic = (x,y)->{
		 return x+y;
		};
		
		
		/*operacion((x,y)->x+y,4,5);
		operacion((x,y)->x*y,4,5);*/
		Lambda la = new Lambda();
		la.operacion((x,y)->x*y,1,2);
		operacion(fic,1,2);
		System.out.println(fic.calculadora(2,3));
		
	}

	private static   void operacion(Ficticia fic,int x, int y) {
		
		System.out.println(fic.calculadora(x, y));

		
	}


}

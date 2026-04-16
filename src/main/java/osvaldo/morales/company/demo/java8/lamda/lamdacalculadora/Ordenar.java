package osvaldo.morales.company.demo.java8.lamda.lamdacalculadora;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenar {

	public static void main(String[] args) {
		Ordenar orden = new Ordenar();
		orden.ordenar();
		orden.calculetor();

	}
	
	
	public  void ordenar(){
		List<String> lista = new ArrayList<>();
		lista.add("c");
		lista.add("a");
		lista.add("b");
		
//		Collections.sort(lista,new Comparator<String>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				return o1.compareTo(o2);
//			}
//		});
		
		Collections.sort(lista,(p1,p2)->p1.compareTo(p2));
		
		
		for(String list : lista)
		{
			System.out.println(list);
		}
	}
	
	public void calculetor(){	
//		Calculadora opera= new Calculadora() {
//			@Override
//			public int operacion(int a, int b) {
//			
//				return a+b;
//			}
//		};
		
//		Calculadora opera=(a,b)-> a+b;
		
		 int  c=10;//si se ocupa una variable dentro de una expresion lambda esta por defecto es una constante
		Calculadora opera=(a,b)->{
			
			return a+b+c;
		};
	
		
		System.out.println(opera.operacion(4, 5));
		
	}

}

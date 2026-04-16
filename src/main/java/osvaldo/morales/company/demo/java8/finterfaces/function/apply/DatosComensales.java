package osvaldo.morales.company.demo.java8.finterfaces.function.apply;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DatosComensales {
	
	public static void main(String args[])	
	{
		List<Comensal> coms= Arrays.asList(
				new Comensal("osva",234.5,6),
				new Comensal("osva1",235.5,9),
				new Comensal("osva2",237.5,9));
		
		
		
		List<Object> list1=	getDataComensales(coms, x->x.getNombre());
		list1.forEach(x->System.out.println(x));
		
		List<Object> list2=	getDataComensales(coms, x->x.getMesa());
		list2.forEach(x->System.out.println(x));
		


	}

	
	public static List<Object> getDataComensales(List<Comensal> coms, Function<Comensal, Object> f) {
		
		 List<Object> lista =  new ArrayList<>();
		 for(Comensal comensal: coms) {
			 lista.add(f.apply(comensal));
		 }
		return lista;
	}
}

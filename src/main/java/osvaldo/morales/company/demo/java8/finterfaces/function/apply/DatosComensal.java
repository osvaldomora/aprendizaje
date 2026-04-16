package osvaldo.morales.company.demo.java8.finterfaces.function.apply;

import java.util.function.Function;

public class DatosComensal {
	
	public static void main(String args[])	
	{
		
		Comensal com1 = new Comensal("osva",234.5,6);
		String nombreCom =  (String) getDataComensal(com1, x->x.getNombre());
		
		System.out.println("the name is:"+nombreCom);
		
		int mesa =  (Integer) getDataComensal(com1, x->x.getMesa());
		System.out.println("the mesa is:"+mesa);

	}
	
	public static Object getDataComensal(Comensal com1, Function<Comensal, Object> f)
	{
		return f.apply(com1);
	}

}

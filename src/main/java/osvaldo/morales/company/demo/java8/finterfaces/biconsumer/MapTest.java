package osvaldo.morales.company.demo.java8.finterfaces.biconsumer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {

		Map<String,String> map = new HashMap<String,String>();
		String arreglo[][]= {{"lupis","Huajuapna"},{"kagel","india"},{"Alex","Mx"}};
		
		
		for(int i=0;i<arreglo.length;i++)
		{
			map.put(arreglo[i][0], arreglo[i][1]);
		}
		
		Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
		if(iter!=null) {
			
			while(iter.hasNext()) {
				
				Map.Entry<String, String> entry = iter.next();
				System.out.println(entry.getKey() +entry.getValue());
				
			}
		}
		
		map.forEach((k,v)->System.out.println(k +v));
		
		
		
	}

}

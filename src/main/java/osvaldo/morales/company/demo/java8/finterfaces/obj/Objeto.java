package osvaldo.morales.company.demo.java8.finterfaces.obj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Objeto {

	public static void main(String[] args) {
     Map<String, String> pr = new HashMap<String, String>(); 
     pr.put(null, "1");
//     pr.put(null, "2");
     pr.forEach((k,v)->System.out.println("clave:" + k + " " + "value:"+v));
     
     metod(pr);
     System.out.println("before call the method");
     pr.forEach((k,v)->System.out.println("clave:" + k + " " + "value:"+v));

	}

	private static void metod(Map<String, String> pr2) {
		
		pr2.put("2", "2");
	     pr2.forEach((k,v)->System.out.println("clave:" + k + " " + "value:"+v));
	}

}

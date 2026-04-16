package osvaldo.morales.company.demo.java8.finterfaces.consumer;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumern {

	public static void main(String[] args) {


//		Consumer<String> cons = x -> System.out.println(x.toUpperCase());
//		cons.accept("hola mundo");
		
		
		List<Estudiantes> studentsl=  Arrays.asList(new Estudiantes("kagel", 10), new Estudiantes("valdo", 20));
	    OperacionEstudiantes op = new OperacionEstudiantes();
	
	    Consumer<Estudiantes> es = e-> System.out.println(e.getName()+e.getAverage());
	   
	    
	    Consumer<Estudiantes> es2 = e2->System.out.println(e2.getAverage()*2);
	    op.aceptaTodos(studentsl, es);
	}

}

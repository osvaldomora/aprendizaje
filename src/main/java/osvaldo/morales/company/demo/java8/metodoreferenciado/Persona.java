package osvaldo.morales.company.demo.java8.metodoreferenciado;

public class Persona {

	private String name;
	private Double edad;

	public Persona() {

	}

	public Persona(String name, double average) {
		super();
		this.name = name;
		this.edad = average;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getEdad() {
		return edad;
	}

	public void setEdad(double average) {
		this.edad = average;
	}

	@Override
	public String toString() {
		return "Estudiantes [name=" + name + ", average=" + edad + "]";
	}

	public static int comparePorEdad(Persona a, Persona b) {

		return a.getEdad().compareTo(b.getEdad());
	}

	public int comparePorNombre(Persona a, Persona b) {

		return a.getName().compareTo(b.getName());
	}
	
	public  int comparePorEdad2( Persona b) {

		return this.getEdad().compareTo(b.getEdad());
	}

}

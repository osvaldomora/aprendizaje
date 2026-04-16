package osvaldo.morales.company.demo.java8.finterfaces.predicate;

public class Estudiante {
	
	private String name;
	private double average;
	public Estudiante(String name, double average) {
		super();
		this.name = name;
		this.average = average;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	@Override
	public String toString() {
		return "Estudiantes [name=" + name + ", average=" + average + "]";
	}

}

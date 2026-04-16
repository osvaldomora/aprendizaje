package osvaldo.morales.company.demo.java8.exercise.comparable;

import java.util.Date;

public class Persona implements Comparable<Persona> {
	
	private int persona;
	private String name;
	private Date date;
	
	
	public Persona(int persona, String name) {
		super();
		this.persona = persona;
		this.name = name;
	}
	public int getPersona() {
		return persona;
	}
	public void setPersona(int persona) {
		this.persona = persona;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int compareTo(Persona o) {
		
		int result = this.name.compareTo(o.name);
		
		return result;
	}
	@Override
	public String toString() {
		return "Persona [persona=" + persona + ", name=" + name + ", date=" + date + "]";
	}
	
	

}

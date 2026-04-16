package osvaldo.morales.company.demo.java8.exercise.streams;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		Persona p = new Persona("pedro");
		Viaje v = new Viaje("Francia");
		Viaje v2 = new Viaje("Inglaterra");
		p.addViaje(v);
		p.addViaje(v2);
		Persona p1 = new Persona("gema");
		Viaje v3 = new Viaje("Italia");
		Viaje v4 = new Viaje("Belgica");
		p1.addViaje(v3);
		p1.addViaje(v4);
		List<Persona> lista = new ArrayList<Persona>();
		lista.add(p);
		lista.add(p1);
	/*	for (Persona persona : lista) {
			System.out.println(persona.getNombre());
			for (Viaje viaje : persona.getLista()) {
				System.out.println(viaje.getPais());
			}
		}*/
	/*	
		lista.stream().forEach(x->{
			x.getLista().stream().forEach(pa->System.out.println(pa.getPais()));
		});*/
		
	/*	
		lista.stream().map(persona -> persona.getLista())
		  .flatMap(viajes -> viajes.stream())
		  .forEach(new Consumer < Viaje > () {
		    @Override
		    public void accept(Viaje t) {
		      System.out.println(t.getPais());
		    }
		  });}*/
		
		lista.stream().map(persona -> persona.getLista())
		  .flatMap(viajes -> viajes.stream())
		  .forEach(x->System.out.println(x.getPais()));
	}
}
package comparatorYcomparable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import daw.com.Pantalla;

public class AppOrdenarPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Comparator<Persona> comparador, comparadorPorEdad, comparadorPorNombre;
		
		List<Persona> originalPersonas = new ArrayList<>();
		List<Persona> personas  = new ArrayList<>();
		
		originalPersonas.add(new Persona ("miguel", 25, LocalDate.of(1990, 5, 23)));
		originalPersonas.add(new Persona ("juan", 40, LocalDate.of(1980, 2, 14)));
		originalPersonas.add(new Persona ("luis", 65, LocalDate.of(2006, 4, 14)));
		originalPersonas.add(new Persona ("andres", 65, LocalDate.of(2016, 4, 14)));
		
		// Mostrar lista
		Pantalla.escribirString("\nLista sin ordenar");
		for (Persona p :originalPersonas)
			Pantalla.escribirString("\n"+ p);
		
		
		// hacer copia del original antes de ordenar
		personas.addAll(originalPersonas);
		// Ordenar alfabéticamente
		Collections.sort(personas);
		// Mostrar lista
		Pantalla.escribirString("\n\nLista ordenada alfabéticamente");
		for (Persona p :personas)
			Pantalla.escribirString("\n"+ p);
		
		
		// hacer copia del original antes de ordenar
		personas.clear();
		personas.addAll(originalPersonas);
		// Ordenar por edad (de menor a mayor)
		comparadorPorEdad = new ComparadorPorEdad();
		Collections.sort(personas, comparadorPorEdad);
		Pantalla.escribirString("\n\nLista ordenada por edad");
		for (Persona p :personas)
			Pantalla.escribirString("\n"+ p);
		
		
		// hacer copia del original antes de ordenar
		personas.clear();
		personas.addAll(originalPersonas);
		// Ordenar por edad de mayor a menor (al revés)
		comparador = comparadorPorEdad.reversed();
		Collections.sort(personas, comparador);
		Pantalla.escribirString("\n\nLista ordenada por edad al revés");
		for (Persona p :personas)
			Pantalla.escribirString("\n"+ p);
		
		
		// hacer copia del original antes de ordenar
		personas.clear();
		personas.addAll(originalPersonas);
		// Ordenar por edad y nombre
		comparadorPorNombre = new ComparadorPorNombre();
		comparador = comparadorPorEdad.thenComparing(comparadorPorNombre);
		Collections.sort(personas, comparador);
		Pantalla.escribirString("\n\nLista ordenada por edad y nombre");
		for (Persona p :personas)
			Pantalla.escribirString("\n"+ p);
		
		
	}

}

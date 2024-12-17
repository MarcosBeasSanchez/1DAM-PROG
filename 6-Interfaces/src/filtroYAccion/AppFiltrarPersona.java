package filtroYAccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import daw.com.Pantalla;

public class AppFiltrarPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Predicate<Persona> filtroPorNombre, filtroPorEdad, filtro;
		Consumer<Persona> accion;
		List<Persona> originalPersonas = new ArrayList<>();
		List<Persona> personas  = new ArrayList<>();
		
		
		originalPersonas.add(new Persona ("miguel", 25, LocalDate.of(1990, 5, 23)));
		originalPersonas.add(new Persona ("juan", 40, LocalDate.of(1980, 2, 14)));
		originalPersonas.add(new Persona ("luis", 65, LocalDate.of(2006, 4, 14)));
		originalPersonas.add(new Persona ("andres", 65, LocalDate.of(2016, 4, 14)));
		
		
		accion = new AccionMostrarPersona();
		
		// Mostrar lista usando accion
		Pantalla.escribirString("\nLista sin filtrar");
		originalPersonas.forEach(accion);
		
		
		// hacer copia del original antes de filtrar
		personas.addAll(originalPersonas);
		
		// Filtrar por nombre
		filtroPorNombre = new FiltroPorNombre ("miguel");
		personas.removeIf(filtroPorNombre);
		Pantalla.escribirString("\nLista filtrada por nombre");
		// Mostrar lista usando accion
		personas.forEach(accion);
		

		// hacer copia del original antes de filtrar
		personas.clear();
		personas.addAll(originalPersonas);
		
		// Filtrado por  edad
		filtroPorEdad = new FiltroPorEdad (30);
		personas.removeIf(filtroPorEdad);
		Pantalla.escribirString("\nLista filtrada por edad >= 30");
		personas.forEach(accion);

		
		
		// hacer copia del original antes de filtrar
		personas.clear();
		personas.addAll(originalPersonas);
		
		// Filtrado por nombre y edad
		filtroPorEdad = new FiltroPorEdad (30);
		filtro = filtroPorNombre.and(filtroPorEdad);
		personas.removeIf(filtro);
		Pantalla.escribirString("\nLista filtrada por nombre miguel y edad >= 30");
		personas.forEach(accion);
		
		
	}

}

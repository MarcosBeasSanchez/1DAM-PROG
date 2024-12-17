package comparatorYcomparable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import daw.com.Pantalla;

public class AppBuscarPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparator<Persona> comparador, comparadorPorEdad, comparadorPorNombre;
		Persona pMax, pMin;
		
		List<Persona> originalPersonas = new ArrayList<>();
				
		originalPersonas.add(new Persona ("miguel", 25, LocalDate.of(1990, 5, 23)));
		originalPersonas.add(new Persona ("juan", 40, LocalDate.of(1980, 2, 14)));
		originalPersonas.add(new Persona ("luis", 65, LocalDate.of(2006, 4, 14)));
		originalPersonas.add(new Persona ("andres", 65, LocalDate.of(2016, 4, 14)));
		
		pMax = Collections.max(originalPersonas);
		Pantalla.escribirString("\nÚltimo  orden natural" +pMax);
		pMin = Collections.min(originalPersonas);
		Pantalla.escribirString("\nPrimero orden natural" +pMin);

		
		comparadorPorEdad = new ComparadorPorEdad();
		pMax = Collections.max(originalPersonas, comparadorPorEdad);
		Pantalla.escribirString("\nLa persona de mayor edad es " +pMax);
		pMin = Collections.min(originalPersonas, comparadorPorEdad);
		Pantalla.escribirString("\nLa persona de menor edad es " +pMin);
		
		// Buscar en el arraylist el primero con edad 40
		int lugar = Collections.binarySearch(originalPersonas, new Persona ("", 65, null), comparadorPorEdad);
		if (lugar >= 0)
			Pantalla.escribirString("\nLa persona buscada es " + originalPersonas.get(lugar));
		else
			Pantalla.escribirString("\nNo existe la persona buscada");
		
		
	}

}

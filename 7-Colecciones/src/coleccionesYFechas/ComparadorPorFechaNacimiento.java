package coleccionesYFechas;

import java.util.Comparator;

public class ComparadorPorFechaNacimiento implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
	}

}
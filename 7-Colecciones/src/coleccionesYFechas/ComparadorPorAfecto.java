package coleccionesYFechas;

import java.util.Comparator;

public class ComparadorPorAfecto implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		// TODO Auto-generated method stub
		return Float.compare(p2.getAfecto(), p1.getAfecto());
	}

}
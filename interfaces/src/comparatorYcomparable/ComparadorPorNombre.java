package comparatorYcomparable;

import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}

}

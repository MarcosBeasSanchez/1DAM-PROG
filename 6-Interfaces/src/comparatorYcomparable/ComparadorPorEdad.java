package comparatorYcomparable;

import java.util.Comparator;

public class ComparadorPorEdad implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		
		return o1.getEdad() - o2.getEdad();
	}



}

package examenFinal;

import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Material> {

	@Override
	public int compare(Material o1, Material o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

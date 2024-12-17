package colecciones;

import java.util.Comparator;

public class ComparadorPeliculaPorPrecio implements Comparator<Pelicula> {

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
		// TODO Auto-generated method stub
		return Float.compare(p1.getPrecio(), p2.getPrecio());
	}

}
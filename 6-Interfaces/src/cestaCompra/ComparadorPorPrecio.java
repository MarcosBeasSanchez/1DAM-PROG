package cestaCompra;

import java.util.Comparator;

public class ComparadorPorPrecio implements Comparator<Electrodomestico> {

	@Override
	public int compare(Electrodomestico o1, Electrodomestico o2) {
		// TODO Auto-generated method stub
		return Float.compare(o1.precioFinal(), o2.precioFinal());
	}

}
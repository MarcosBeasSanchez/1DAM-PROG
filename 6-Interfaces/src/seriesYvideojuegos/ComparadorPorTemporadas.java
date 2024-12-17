package seriesYvideojuegos;

import java.util.Comparator;

public class ComparadorPorTemporadas implements Comparator<Entregable> {

	@Override
	public int compare(Entregable o1, Entregable o2) {
		// TODO Auto-generated method stub
		return ((Serie)o1).getTemporadas()-((Serie)o2).getTemporadas();
	}

}
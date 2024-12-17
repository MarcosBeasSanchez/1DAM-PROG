package seriesYvideojuegos;

import java.util.function.Predicate;

public class EsSerie implements Predicate<Entregable> {

	@Override
	public boolean test(Entregable t) {
		// TODO Auto-generated method stub
		
		return t instanceof Serie;
	}


}
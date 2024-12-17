package seriesYvideojuegos;

import java.util.function.Predicate;

public class EstaEntregado implements Predicate<Entregable> {

	@Override
	public boolean test(Entregable t) {
		// TODO Auto-generated method stub
		return t.isEntregado();
	}

}
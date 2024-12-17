package coleccionesYFechas;

import java.util.function.Predicate;

public class FiltroCumpleAnios implements Predicate<Persona> {

	@Override
	public boolean test(Persona t) {
		// TODO Auto-generated method stub
		return t.esSuCumpleHoy();
	}

}
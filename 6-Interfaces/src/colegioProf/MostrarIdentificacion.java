package colegioProf;

import java.util.function.Consumer;

import daw.com.Pantalla;

public class MostrarIdentificacion implements Consumer<Persona> {

	@Override
	public void accept(Persona t) {
		// TODO Auto-generated method stub
		Pantalla.escribirSaltoLinea();
		t.identificar();
	}

}

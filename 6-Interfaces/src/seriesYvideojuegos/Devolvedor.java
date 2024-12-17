package seriesYvideojuegos;

import java.util.function.Consumer;

import daw.com.Pantalla;

public class Devolvedor implements Consumer<Entregable> {

	@Override
	public void accept(Entregable t) {
		// TODO Auto-generated method stub
		t.devolver();
		Pantalla.escribirString("\n" + t);
	}

}
package cestaCompra;

import java.util.function.Consumer;

import daw.com.Pantalla;

public class MostrarLinea implements Consumer<LineaCesta> {

	@Override
	public void accept(LineaCesta t) {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n" + t.getE().getIdentificador());
		Pantalla.escribirString("\t" + t.getCantidad() );
		Pantalla.escribirString("\t" + t.getE().precioFinal());
		Pantalla.escribirString("\t" + t.getTotal());
	}

}
package colegioProf;

import daw.com.Pantalla;

public interface LeerYMostrarDatos {

	void leerClave();

	void leerRestoDatos();

	default void mostrarDatos() {
		Pantalla.escribirString("\n" + toString());
	}

	default void leerDatos() {
		leerClave();
		leerRestoDatos();
	}

}

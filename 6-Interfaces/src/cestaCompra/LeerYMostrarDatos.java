package cestaCompra;

import daw.com.Pantalla;

public interface LeerYMostrarDatos {
	
	void leerIdentificador ();
	void leerRestoDatos (); 
	
	default void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + toString());
	}
	default void leerDatos ()
	{
		leerIdentificador ();
		leerRestoDatos ();
	}
	

}
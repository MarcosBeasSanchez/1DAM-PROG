package ismael;

public interface LeerYMostrarDatos {

	void leerId ();
	void leerRestoDatos (); 
	
	default void mostrarDatos ()
	{
		System.out.println("\n" + toString());
	}
	default void leerDatos ()
	{
		leerId ();
		leerRestoDatos ();
	}
}

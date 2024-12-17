package practicaFinal;

public interface LeerDatos {
	//defecto
	void leerRestoDatos (); 
	//herencia
	default void leerDatos()
	{
		leerRestoDatos ();
	}
}
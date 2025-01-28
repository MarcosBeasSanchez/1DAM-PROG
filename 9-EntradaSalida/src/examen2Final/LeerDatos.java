package examen2Final;

public interface LeerDatos {

	void leerID();
	void leerDatos();
	
	default void leerSoloDatos(){
		leerDatos();
	}
	default void leerTodo() {
		leerID();
		leerDatos();
	}
	


}

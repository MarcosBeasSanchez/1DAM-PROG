package ejercicio1ex;

public interface Leer {
	
	 void leerID();
	 void leerDatos();
	 
	default void leerTodo() {
		leerDatos();
	}
	

}

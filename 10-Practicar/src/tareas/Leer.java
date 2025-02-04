package tareas;

public interface Leer {
	
	public void leerID();
	public void leerDatos();
	
	default void leerSoloDatos() {
		leerDatos();
	}
	
	default void leerTodo() {
		leerID();
		leerDatos();
	}

}

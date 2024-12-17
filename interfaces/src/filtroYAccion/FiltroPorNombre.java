package filtroYAccion;

import java.util.function.Predicate;

public class FiltroPorNombre implements Predicate<Persona> {

	private String nombre;
	
	
	public FiltroPorNombre(String nombre) {
		
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public boolean test(Persona t) {
		// TODO Auto-generated method stub
		return t.getNombre().equals(nombre);
	}

}

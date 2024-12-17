package coleccionesYFechas;

import java.util.Set;
import java.util.function.Consumer;

public class InsertarAficion implements Consumer<String> {
	
	private Set<String> aficiones;
	
	

	public InsertarAficion(Set<String> aficiones) {
		this.aficiones = aficiones;
	}

	

	public Set<String> getaficiones() {
		return aficiones;
	}



	public void setaficiones(Set<String> aficiones) {
		this.aficiones = aficiones;
	}



	@Override
	public void accept(String t) {
		// TODO Auto-generated method stub
		aficiones.add(t);

	}

}
package coleccionesYFechas;

import java.util.function.Consumer;

public class ObtenerAficones implements Consumer<Persona> {

	private Consumer <String> accion;
	
	public ObtenerAficones(Consumer<String> accion) {
		this.accion = accion;
	}

	
	public Consumer<String> getAccion() {
		return accion;
	}


	public void setAccion(Consumer<String> accion) {
		this.accion = accion;
	}


	@Override
	public void accept(Persona t) {
		// TODO Auto-generated method stub
		t.getAficiones().forEachRemaining(accion);
	}

}
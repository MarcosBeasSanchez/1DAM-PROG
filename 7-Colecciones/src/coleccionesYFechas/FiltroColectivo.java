package coleccionesYFechas;

import java.util.function.Predicate;

public class FiltroColectivo implements Predicate<Persona> {
	
	private Colectivo colectivo;
	
	

	public FiltroColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}


	public Colectivo getColectivo() {
		return colectivo;
	}


	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}


	@Override
	public boolean test(Persona p) {
		// TODO Auto-generated method stub
		return p.getColectivo().equals(colectivo);
	}

}
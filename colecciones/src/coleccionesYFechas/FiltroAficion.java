package coleccionesYFechas;

import java.util.function.Predicate;

public class FiltroAficion implements Predicate<Persona> {

	private String aficion;
	
	public FiltroAficion (String aficion)
	{
		this.aficion = aficion;
	}
	
	
	public String getAficion() {
		return aficion;
	}


	public void setAficion(String aficion) {
		this.aficion = aficion;
	}


	@Override
	public boolean test(Persona t) {
		// TODO Auto-generated method stub
		/*
		boolean resultado = false;
		
		
		while (!resultado && t.getAficiones().hasNext())
			if (t.getAficiones().next().equalsIgnoreCase(aficion))
				resultado = true;
		
		
		
		return resultado;
		*/
		
		return t.tieneAficion(aficion);
	}

}

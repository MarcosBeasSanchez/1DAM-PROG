package filtroYAccion;

import java.util.function.Predicate;

public class FiltroPorEdad implements Predicate<Persona> {

	private int edad;
	
	public FiltroPorEdad(int edad) 
	{
		this.edad = edad;
	}	
	
	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public boolean test(Persona t) {
		// TODO Auto-generated method stub
		return t.getEdad() >= edad;
	}

}

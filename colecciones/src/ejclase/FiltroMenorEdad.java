package ejclase;

import java.util.function.Predicate;

public class FiltroMenorEdad implements Predicate<Alumno> {
	
	private int edad;

	public FiltroMenorEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
}

	@Override
	public boolean test(Alumno t) {
		// TODO Auto-generated method stub
		return t.getEdad() < 18;
	}

}

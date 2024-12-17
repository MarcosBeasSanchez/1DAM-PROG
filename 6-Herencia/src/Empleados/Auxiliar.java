package Empleados;

import java.time.LocalDate;

import daw.com.Teclado;

public class Auxiliar extends Empleado {

private static final float SUELDOBASE = 1200;
	
	private boolean bilingue;
	private float sueldocompleto;
	
	public Auxiliar(String nombre, String dni, LocalDate edad, float sueldobase 
			, boolean bilingue, float sueldocompleto) {
		
		super (nombre, dni,edad, sueldobase);
		
		setBilingue(bilingue);
		setSueldocompleto(sueldocompleto);
	}
	
	public Auxiliar() {
		this ("","",LocalDate.now().minusYears(16),SUELDOBASE,false,0);
	}

	public boolean isBilingue() {
		return bilingue;
	}

	public void setBilingue(boolean bilingue) {
		if (bilingue = true) {
			sueldocompleto = SUELDOBASE + 100;
		}
		this.bilingue = bilingue;
	}

	public float getSueldocompleto() {
		return sueldocompleto;
	}

	public void setSueldocompleto(float sueldocompleto) {
		if (bilingue = true) {
			sueldocompleto = getSueldobase() + 100;
		}
		this.sueldocompleto = sueldocompleto;
	}
	
	public void leerDatos ()
	{
		super.leerDatos();
		
		setBilingue(Traducion(Teclado.leerString("\nBilingue? S/N")));
	}

	private boolean Traducion(String respuesta) {
		
		if (respuesta.equalsIgnoreCase("S")) {
			 return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Auxiliar [bilingue=" + bilingue + ", sueldocompleto=" + sueldocompleto + "]";
	}


}
	

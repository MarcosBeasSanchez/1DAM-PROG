package Empleados;

import java.time.LocalDate;

import daw.com.Teclado;

public class Profesor extends Empleado {

private static final float SUELDOBASE = 1200;
	
	private String titulacion;
	private int npublicaciones;
	private float sueldocompleto;
	
	public Profesor(String nombre, String dni, LocalDate edad, float sueldobase 
			, String titulacion , int npublicaciones, float sueldocompleto) {
		
		super (nombre, dni,edad, sueldobase);
		
		this.titulacion = titulacion;
		setNpublicaciones(npublicaciones);
		setSueldocompleto(sueldocompleto);
		
	}
	
	public Profesor() {
		this ("","",LocalDate.now().minusYears(16),SUELDOBASE,"",0,0);
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getNpublicaciones() {
		return npublicaciones;
	}

	public void setNpublicaciones(int npublicaciones) {
		this.npublicaciones = npublicaciones;
	}

	public float getSueldocompleto() {
		return sueldocompleto;
	}

	public void setSueldocompleto(float sueldocompleto) {
		
		int publicaciones = getNpublicaciones();
		
		
		
		sueldocompleto = getSueldobase() + (publicaciones * 20);
		
		this.sueldocompleto = sueldocompleto;
	}

	@Override
	public String toString() {
		return "Profesor [titulacion=" + titulacion + ", npublicaciones=" + npublicaciones + ", sueldocompleto="
				+ sueldocompleto + "]";
	}

	public void leerDatos ()
	{
		super.leerDatos();
		
		setNpublicaciones(Teclado.leerInt("\nNº Publicaciones ?"));
		titulacion = Teclado.leerString("\nTitulacion?");
	}
}
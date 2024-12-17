package Empleados;

import java.time.LocalDate;

import daw.com.Teclado;

public class Administrativo extends Empleado {

	private static final float SUELDOBASE = 1200;
	
	private String categoria;
	private int destino;
	private float sueldocompleto;
	
	public Administrativo(String nombre, String dni, LocalDate edad, float sueldobase , String categoria , int destino, float sueldocompleto) {
		
		super (nombre, dni,edad, sueldobase);
		
		this.destino = destino;
		setCategoria(categoria);
		setSueldocompleto(sueldocompleto);
		
	}
	
	public Administrativo() {
		this ("","",LocalDate.now().minusYears(16),SUELDOBASE,"",0,0);
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		
		this.categoria = categoria;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public float getSueldocompleto() {
		return sueldocompleto;
	}

	public void setSueldocompleto(float sueldocompleto) {
		
		if (categoria.equalsIgnoreCase("OFICIAL")) {
			sueldocompleto = getSueldobase() + 200;
		}
		this.sueldocompleto = sueldocompleto;
	}




	@Override
	public String toString() {
		return "Administrativo [categoria=" + categoria + ", destino=" + destino + ", sueldocompleto=" + sueldocompleto
				+ super.toString() +"]";
	}

	public void leerDatos ()
	{
		super.leerDatos();
		
		destino = Teclado.leerInt("\nDestino?");
		setCategoria(Teclado.leerString("\nCategoria?"));
	}
	
	
}

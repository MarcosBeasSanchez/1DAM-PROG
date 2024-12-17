package Empleados;

import java.time.LocalDate;

import daw.com.Teclado;

public abstract class Empleado {
	
	private static final float SUELDOBASE = 1200;

	private String nombre, dni;
	private LocalDate edad;
	private float sueldobase;
	
	public Empleado  (String nombre, String dni, LocalDate edad, float sueldobase) {
		this.nombre = nombre;
		this.dni = dni;
		setEdad(edad);
		setSueldobase(sueldobase);
	}
	
	public Empleado() {
		this ("","",LocalDate.now().minusYears(16),SUELDOBASE);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getEdad() {
		return edad;
	}

	public void setEdad(LocalDate edad) {
		if (edad.plusYears(16).isAfter(LocalDate.now()))
			edad = LocalDate.now().minusYears(16);
		this.edad = edad;
	}

	public float getSueldobase() {
		return sueldobase;
	}

	public void setSueldobase(float sueldobase) {
		
		this.sueldobase = sueldobase <= 1200 ? SUELDOBASE: sueldobase;
	}


	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", sueldobase=" + sueldobase
				+ ", sueldocompleto=" + "]";
	}
	
	public void leerDatos ()
	{
		String fechaString;

		nombre = Teclado.leerString("\nNombre?");
		dni = Teclado.leerString("\nDNI?");
		fechaString = Teclado.leerString("\nFecha nacimiento (yyyy-mm-dd)");
		setEdad (LocalDate.parse(fechaString));
		setSueldobase (Teclado.leerFloat("\nSueldobase?"));
		
	}

}

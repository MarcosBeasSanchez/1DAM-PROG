package filtroYAccion;

import java.time.LocalDate;

public class Persona implements Comparable<Object> {

	private String nombre;
	private int edad;
	private LocalDate fecha;
	
	public Persona ()
	{
		this ("", 0, LocalDate.now());
	}
	
	
	public Persona(String nombre, int edad, LocalDate fecha) {
	
		this.nombre = nombre;
		this.edad = edad;
		this.fecha = fecha;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", fecha=" + fecha + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Persona other = (Persona) o;

		return nombre.compareTo(other.nombre);
	}





}

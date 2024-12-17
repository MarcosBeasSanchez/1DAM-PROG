package expresioneslambda;

import java.time.LocalDate;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Alumno implements Comparable<Alumno> // Tiene el orden natural 
{
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private int nota;
	
	public Alumno ()
	{
		this("","",LocalDate.now(),0);
	}
	
	public Alumno (String dni)
	{
		this(dni, "",LocalDate.now(), 0);
	}
	public Alumno(String dni, String nombre, LocalDate fechaNacimiento, int nota) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.nota = nota;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", nota=" + nota
				+ "]";
	}
	
	public void leerDatos ()
	{
	
		nombre = Teclado.leerString("\nnombre");
		fechaNacimiento = LocalDate.parse(Teclado.leerString("\nyyyy-MM-dd"));
		nota = Teclado.leerInt("\nnota");
	}

	@Override
	public int hashCode() {
		Pantalla.escribirString("\nEstoy ejecutando hashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Pantalla.escribirString("\nEstoy ejecutando equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	
	@Override
	public int compareTo(Alumno o) // define el orden natural 
	{
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nEstoy ejecutando compareTo");
		Pantalla.escribirString("\n" + toString() + " - " + o.toString());
		return dni.compareTo(o.dni);
	}

}
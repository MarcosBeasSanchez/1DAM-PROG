package ficheros;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Alumno implements Comparable<Alumno>  
{
	private static final String SEPARADOR = ":";
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private int nota;
	
	public Alumno ()
	{
		this("");
	}
	
	public Alumno (String dni)
	{
		this(dni, "",LocalDate.now().minusYears(18), 1);
	}
	public Alumno(String dni, String nombre, LocalDate fechaNacimiento, int nota) throws IllegalArgumentException
	{
		
		this.dni = dni;
		this.nombre = nombre;
		setFechaNacimiento (fechaNacimiento);
		setNota (nota);
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

	public void setFechaNacimiento(LocalDate fechaNacimiento) throws IllegalArgumentException {
		
		if (fechaNacimiento == null)
			throw new IllegalArgumentException("alumno sin datos de fecha de nacimiento");
		if (fechaNacimiento.plusYears(18).isAfter(LocalDate.now()))
			throw new IllegalArgumentException("alumno menor de edad");
		
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) throws IllegalArgumentException{
		if (nota < 1 || nota > 10)
			throw new IllegalArgumentException("nota no permitida");
		
			
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", nota=" + nota
				+ "]";
	}
	
	public void leerDatos ()
	{

		boolean exito;
		nombre = Teclado.leerString("\nnombre");
		
		do
		{
			exito = true;
			try {
			setFechaNacimiento (LocalDate.parse(Teclado.leerString("\nyyyy-MM-dd")));
			setNota  (Teclado.leerInt("\nnota[1-10]"));
			}
			catch (IllegalArgumentException e)
			{
				Pantalla.escribirString("\n" + e.getMessage());
				exito = false;
			}
			
			catch (DateTimeParseException e)
			{
				Pantalla.escribirString("\nError en el formato");
				exito = false;
			}	
			
		}while(!exito);
		
		
	}

	@Override
	public int hashCode() {
	
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

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
		return dni.compareTo(o.dni);
	}
	
	public String toCsv ()
	{
		String csv = "";
		
		csv += dni;
		csv += SEPARADOR;
		csv += nombre;
		csv += SEPARADOR;
		csv += fechaNacimiento;
		csv += SEPARADOR;
		csv += nota;
		
		return csv;
	}

	public void fromCsv (String csv)
	{
		String valores[] = csv.split(SEPARADOR);
		
		if (valores.length > 0)
		{
			try
			{
				dni = valores[0];
				nombre = valores[1];
				setFechaNacimiento (LocalDate.parse(valores[2]));
				setNota (Integer.valueOf(valores[3]));
			}
			catch (IndexOutOfBoundsException e)
			{
				switch (valores.length)
				{
					case 1:
						nombre = "";
					case 2:
						fechaNacimiento = LocalDate.now().minusYears(18);
					case 3:
						nota = 1;
				}
			}
			catch (DateTimeParseException e)
			{
				fechaNacimiento = LocalDate.now().minusYears(18);
			}
			catch (NumberFormatException e)
			{
				nota = 1;
			}
			catch (IllegalArgumentException e)
			{
				if (e.getMessage().equals ("nota no permitida"))
					nota = 1;
				else if (e.getLocalizedMessage().contains("alumno"))
					fechaNacimiento = LocalDate.now().minusYears(18);
					
			}
		}
	}

}

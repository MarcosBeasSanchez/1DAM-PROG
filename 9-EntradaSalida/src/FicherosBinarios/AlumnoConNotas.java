package FicherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AlumnoConNotas {
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private int[] notas;
	
	public AlumnoConNotas ()
	{
		this("","",LocalDate.now(),0);
	}
	
	public AlumnoConNotas (String dni)
	{
		this(dni, "",LocalDate.now(), 0);
	}
	public AlumnoConNotas(String dni, String nombre, LocalDate fechaNacimiento, int ... notas) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.notas = notas;
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
		if (fechaNacimiento.plusYears(18).isAfter(LocalDate.now()))
			throw new IllegalArgumentException("alumno menor de edad");
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public int[] getNotas() {
		return notas;
	}

	public void setNotas(int ... notas) {
			
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + 
				", nota=" + Arrays.toString(notas)
				+ "]";
	}
	
	public void leerDatos ()
	{

		boolean exito;
		int cuantas;
		
		nombre = Teclado.leerString("\nnombre");
		
		do
		{
			exito = true;
			try {
			setFechaNacimiento (LocalDate.parse(Teclado.leerString("\nyyyy-MM-dd")));
			}
			catch (IllegalArgumentException |DateTimeParseException e)
			{
				Pantalla.escribirString("\n" + e.getMessage());
				exito = false;
			}
			
			
		}while(!exito);
		
		cuantas = Teclado.leerInt("cuantas notas");
		notas = new int[cuantas];
		
		for (int i= 0; i < cuantas; i++ )
			notas[i] = Teclado.leerInt("nota " + i);
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
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoConNotas other = (AlumnoConNotas) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}	
	
	public void escribirFichero (DataOutputStream filtro) throws IOException
	{
		
		filtro.writeUTF(dni);
		filtro.writeUTF(nombre);
		filtro.writeUTF(fechaNacimiento.toString());
		filtro.writeInt(notas.length);
		for (int n :notas)
			filtro.writeInt(n);
		
	}
	
	public void leerFichero (DataInputStream filtro) throws IOException
	{
		int cuantas;
		
		dni = filtro.readUTF();
		nombre = filtro.readUTF();
		try {
			setFechaNacimiento (LocalDate.parse(filtro.readUTF()));
		}
		catch (IllegalArgumentException | DateTimeParseException  e)
		{
			fechaNacimiento = LocalDate.now().minusYears(18);
		}
		
		cuantas = filtro.readInt();
		if (cuantas > 0)
		{
			notas = new int[cuantas];
		
			for (int i = 0; i < cuantas; i++)
				notas[i] = filtro.readInt();
		}
		
	}

}

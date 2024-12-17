package ficheros;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import daw.com.Pantalla;
import daw.com.Teclado;

public class EscribirAlumnosCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Alumno> alumnos;
		Alumno alumno;
		String dni;
		
		alumnos = new HashSet<Alumno> ();
		
		// leer alumnos del teclado
		do
		{
			dni = Teclado.leerString("\ndni:");
			alumno = new Alumno (dni);
			if (alumnos.add(alumno))
				alumno.leerDatos();
			else
				Pantalla.escribirString("\nAlumno ya existente");
		}while (Teclado.leerString("continuar?").equalsIgnoreCase("s"));

		// escribir alumnos en el fichero csv
		try (PrintWriter fichero = new PrintWriter("alumnos.csv"))
		{
			alumnos.forEach(a -> fichero.println(a.toCsv()));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Pantalla.escribirString("\nerror escribiendo fichero");
		}
		
	}

}
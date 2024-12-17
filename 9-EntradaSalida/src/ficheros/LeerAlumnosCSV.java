package ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import daw.com.Pantalla;

public class LeerAlumnosCSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Alumno> alumnos = new HashSet<Alumno> ();
		Alumno alumno;
		String linea;
		
		
		// Leer alumnos del fichero
		try (BufferedReader buffer = new BufferedReader(new FileReader ("alumnos.csv")))
		{
			
			while (buffer.ready())
			{
				linea = buffer.readLine();
				alumno = new Alumno ();
				alumno.fromCsv(linea);
				alumnos.add(alumno);
			}
				
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			Pantalla.escribirString("\nError leyendo fichero...");
		}
		
		alumnos.forEach(System.out::println);
		
	}

}
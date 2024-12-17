package FicherosBinarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import daw.com.Pantalla;

public class AppLeerAlumnosConNotas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<AlumnoConNotas> alumnos;
		AlumnoConNotas al;
		int cuantos;
		
		alumnos = new ArrayList<>();
		
		try (DataInputStream filtro = new DataInputStream (new FileInputStream ("alumnosnotas.dat")))
		{
			cuantos = filtro.readInt();
			if (cuantos > 0)
			{
				for (int i = 0; i < cuantos; i++)
				{
					al = new AlumnoConNotas();
					al.leerFichero(filtro);
					alumnos.add(al);
				}
			}
			
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			Pantalla.escribirString("\nError leyendo fichero...");
		}
		
		Pantalla.escribirString("\nListado de alumnos\n");
		
		alumnos.forEach(System.out::println);

	}

}
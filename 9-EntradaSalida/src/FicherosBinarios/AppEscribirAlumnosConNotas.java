package FicherosBinarios;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppEscribirAlumnosConNotas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlumnoConNotas a;
		List<AlumnoConNotas> alumnos;
		
		
		alumnos = new ArrayList<>();
		
		do
		{
			a = new AlumnoConNotas();
			a.leerDatos();
			alumnos.add(a);
			
		}while (Teclado.leerString("sigo?").equalsIgnoreCase("s"));
		
		// Escribir fichero
		try (DataOutputStream filtro = new DataOutputStream (new FileOutputStream("alumnosnotas.dat")))
		{
			filtro.writeInt(alumnos.size());
			
			for (AlumnoConNotas al : alumnos)
				al.escribirFichero(filtro);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Pantalla.escribirString("\nError escribiendo...");
		}
		
	}

}
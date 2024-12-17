package LeerEscribirGaraje;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import daw.com.Pantalla;

public class AppLeerGaraje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fichero;
		BufferedReader buffer;
		Garaje garaje = new Garaje ();
		
		
		try
		{
			fichero = new FileReader("garaje.csv");
			buffer = new BufferedReader(fichero);
			
			garaje.leerFicheroTexto(buffer);
			
			buffer.close();
			fichero.close();
		}
		catch (IOException e)
		{
			Pantalla.escribirString("\nError leyendo datos");
		}
		
		
		garaje.mostrarDatos();

	}

}

package FicherosBinarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import daw.com.Pantalla;

public class AppLeerFicheroBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;int edad;float sueldo;boolean coche;
		
		try (DataInputStream filtro = new DataInputStream (new FileInputStream("borrame.dat")))
		{
			nombre = filtro.readUTF();
			filtro.readUTF();
			edad = filtro.readInt();
			sueldo = filtro.readFloat();
			coche = filtro.readBoolean();

			Pantalla.escribirString("\n" +  nombre + " " + edad + " "+ sueldo + " " + coche);

			nombre = filtro.readUTF();
			edad = filtro.readInt();
			sueldo = filtro.readFloat();
			coche = filtro.readBoolean();

			Pantalla.escribirString("\n" +  nombre + " " + edad + " "+ sueldo + " " + coche);
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			Pantalla.escribirString("\nerror leyendo");
		}
	}

}
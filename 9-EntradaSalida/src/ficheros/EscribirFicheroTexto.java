package ficheros;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import daw.com.Teclado;

public class EscribirFicheroTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		int edad;
		try(PrintWriter salida = new PrintWriter(new FileWriter("mifichero.txt",false)))
		{
			do
			{
				nombre = Teclado.leerString();
			
				if (!nombre.isEmpty())
				{
					edad = Teclado.leerInt();
					salida.println(nombre+";"+edad);
				}
			}while (!nombre.isEmpty());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("fichero no encontrado");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("fichero de escritura");
		}
	

	}

}
package ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerNombreYEdad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String linea,nombre;
		int edad;
		
		// try -catch con recursos, cierra sÃ³lo los recursos abiertos
		try (BufferedReader buffer = new BufferedReader(new FileReader ("mifichero.txt")))
		{
			while (buffer.ready())
			{
				linea = buffer.readLine();
				nombre = linea.split(";")[0];
				edad = Integer.valueOf(linea.split(";")[1]);
				
				System.out.println(nombre + "->" + edad);
			}
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error leyendo fichero");
		}

	}

}
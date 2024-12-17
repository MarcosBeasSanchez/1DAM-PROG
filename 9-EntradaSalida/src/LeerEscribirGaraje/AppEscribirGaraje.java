package LeerEscribirGaraje;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppEscribirGaraje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Garaje garaje;
		Vehiculo v;
		int tipo;
		
		PrintWriter fichero;
		
		garaje = new Garaje (Teclado.leerInt("plazas "));
		
		do
		{
			tipo = Teclado.leerInt("\n1 Moto - 2 Coche ?");
			if (tipo == 1)
				v = new Moto ();
			else 
				v = new Coche ();
			
			v.leerDatos();
			
			garaje.addVehiculo(v);
			
		}while (garaje.getNplazasLibres() > 0 && Teclado.leerString("\nSigo ?").equals("s"));
		
		// Escribir fichero
		try
		{
			// abri fichero
			fichero = new PrintWriter("garaje.csv");
			
			// escribir fichero
			garaje.escribirFicheroTexto(fichero);
			
			// cerrar fichero
			fichero.close();
			
		}catch (FileNotFoundException e)
		{
			Pantalla.escribirString("\n" + e.getMessage());
		}

	}

}

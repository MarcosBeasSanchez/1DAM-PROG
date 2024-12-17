package llaveycerradura;

import daw.com.Pantalla;

public class AppCerradura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cerradura cerradura;
		Llave llave;
	
		
		cerradura = new Cerradura ();
		Pantalla.escribirString("\n"+cerradura);
		
		
		do
		{
			llave = new Llave ();
			
			
		}while (!cerradura.abrirCerradura(llave));
		
		Pantalla.escribirString("\n"+llave);
		

	}

}
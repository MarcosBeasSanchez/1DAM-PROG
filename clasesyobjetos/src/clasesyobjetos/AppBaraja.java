package clasesyobjetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppBaraja {

	public static void main(String[] args) {
		// 7 y media -todas valen su numero, ecepto figuras que valen medio punto, gana el que se aproxima a 7.5
		// El programa pide el n de jugadores , va repartiendo cartas a cada jugador hasta que este se planta o se pasa.
		
		// Crear una nueva instancia de Baraja
        Baraja española = new Baraja();
        Carta cartas[];
        int n;
       
        
        
        //inicializar
       española.inicializarBaraja();
       
       española.barajar();
		
		do
		{
		n = Libreria.leerEnteroPositivo("cuantas quieres ?");
		
		cartas = española.darCartas(n);
		if (cartas == null)
		 Pantalla.escribirString("\nNo hay tantas cartas para dar" );
		else
			for (Carta c : cartas)
				c.mostrarDatos();
		}while(Teclado.leerString("mas?").equalsIgnoreCase("s"));
		
		/*
		if (cartas == null)
			Pantalla.escribirString("\nNo hay tantas cartas para dar" );
		else
			for (Carta c : cartas)
				c.mostrarDatos();
		*/
		Pantalla.escribirString("\nQuedan " + española.cartasDisponibles()); 
		
		española.cartasEnBaraja();
	}
}
	
      
     
      
        


import daw.com.Pantalla;
import daw.com.Teclado;

public class NombreMasLargo {

	public static void main(String[] args) {
		// leer un conjunto de nombres y mostrar en que posicion se encuentra el mas largo 
		// a continuacion mostrar cuantas veces se repite

		
		String nombres[];
		int posicionMasLargo, cuantos, veces;
		
		cuantos = Libreria.leerEnteroPositivo("cuantos nombres?");
		
		nombres = new String[cuantos];
		
		for (int i = 0; i < nombres.length; i++)
			nombres[i] = Teclado.leerString("nombres[" + i + "]=");
			
		posicionMasLargo = 0;
		
		for (int i = 1; i < nombres.length; i++)
			if (nombres[i].length() > nombres[posicionMasLargo].length())
				posicionMasLargo = i;
		
		veces = 1;
		
		for (int i = posicionMasLargo + 1; i < nombres.length; i++)
			if (nombres[i].equals(nombres[posicionMasLargo]))
				veces ++;
		
		Pantalla.escribirString("\n El nombre mas largo es "  
							+ nombres[posicionMasLargo]);
		Pantalla.escribirString("\n Nº de veces que aparece = " + veces);
		Pantalla.escribirString("\n La primera vez esta¡ en la posición: " 
							+ posicionMasLargo);
		
		
		
		
		
		
		
	}
}
			
		
			
			
			
	
package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class UsoSplit {

	public static void main(String[] args) {
		//El programa debe contar y mostrar cuántas palabras distintas hay en la frase, eliminando duplicados. 
		
		
		String linea;
		String palabras[],distintas[];
		int cuantasDistintas = 0;
		
		
		linea = Teclado.leerString("introduzca una frase");
		
		//La funcion .Split separa cadenas de strings en Substrings indicando el delimitador entre ();
		palabras = linea.split(" ");
		
		distintas = new String[palabras.length];
		
		for (int i = 0 ; i < palabras.length; i++)
			if (estaEnArray(palabras[i], distintas) == -1)
			{
				distintas[cuantasDistintas] = palabras[i];
				cuantasDistintas++;
			}
		
		Pantalla.escribirString("\nhay " + cuantasDistintas + " palabras distintas");
		
		for (int i = 0; i < cuantasDistintas; i++)
			Pantalla.escribirString("\n" + distintas[i]);
		
	}
	
	private static int estaEnArray(String elemento, String[] array) {
		// TODO Auto-generated method stub
		int pos = -1;
		
		for (int i = 0 ; i < array.length && pos == -1; i++)
			if (elemento.equals(array[i])) // importa el orden, para evitar null
				pos = i;
		
		return pos;
	}

}
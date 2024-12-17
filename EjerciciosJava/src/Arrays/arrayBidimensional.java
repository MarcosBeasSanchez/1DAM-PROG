package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class arrayBidimensional {

	public static void main(String[] args) {

		
		int array[][];
		int filas, columnas;
		
		filas = Libreria.leerEnteroPositivo("filas");
		columnas = Libreria.leerEnteroPositivo("columnas");
		
		array = new int[filas][columnas];
		
		// CREAR EL ARRAY 
		for (int i = 0; i < array.length; i++)// recorre las filas
			for (int j = 0; j < array[i].length; j++) // para cada fila recorre las columnas
				array[i][j] = Teclado.leerInt("[" + i + "][" +j +"]=");
		
		
		// PINTAR EL ARRAY 
		for (int i = 0; i < array.length; i++){// recorre las filas
			for (int j = 0; j < array[i].length; j++) // para cada fila recorre las columnas
				Pantalla.escribirString(array[i][j] + "\t");
			Pantalla.escribirSaltoLinea();
			
		}
	}
}
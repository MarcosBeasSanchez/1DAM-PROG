package Arrays;

import daw.com.Pantalla;

public class arrayEjer13 {

	public static void main(String[] args) {
		float array[][];
		int filas = 4, columnas = 4;
		
		//Creamos el tamaño del array
		array = new float[filas][columnas];
		
		// Ejecuta
		for (int x = 0; x < array.length; x++)// recorre las filas
			for (int y = 0; y < array[x].length; y++) // para cada fila recorre las columnas
			{
				if (x == y)
					array[x][y] = 1;
				else
					array[x][y] = 0;
			}
		
		// Pinta
		for (int x = 0; x < array.length; x++) {
			
			for (int y = 0; y < array[x].length; y++) {
				Pantalla.escribirString(array[x][y] + "\t");
			}
			
			Pantalla.escribirSaltoLinea();
			
			// o  cambiar todo por libreria.mostrarArray(array[x]);
				
		}
	}
}

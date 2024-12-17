package Arrays;

import daw.com.Pantalla;

public class arrayEjer12 {

	public static void main(String[] args) {
		int array[][];
		

		// Carga array
		array = new int[3][5];
		
		for (int x = 0; x < array.length; x++)// recorre las filas
			for (int y = 0; y < array[x].length; y++) // para cada fila recorre las columnas
			{
				 array[x][y] = 10*(x+1)+1 + y;			 
			}
				
				
		// Muestra
		for (int x = 0; x < array.length; x++)// recorre las filas
		{
			for (int y = 0; y < array[x].length; y++) // para cada fila recorre las columnas
				Pantalla.escribirString(array[x][y] + "\t");
			Pantalla.escribirSaltoLinea();
			
			// o  cambiar todo por libreria.mostrarArray(array[x]);
			
		}
	}
}

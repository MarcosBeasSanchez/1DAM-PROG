package Arrays;

import daw.com.Teclado;

public class arrayTridimensional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[][][];
		int filas, columnas, profundidad;


		filas = Libreria.leerEnteroPositivo("filas");
		columnas = Libreria.leerEnteroPositivo("columnas");
		profundidad = Libreria.leerEnteroPositivo("profundidas");
		
		array = new int[filas][columnas][profundidad];
		
		for (int i = 0; i < array.length; i++)// recorre las filas
			for (int j = 0; j < array[i].length; j++) // para cada fila recorre las columnas
				for (int k = 0; k < array[i][j].length; k++)
				array[i][j][k] = Teclado.leerInt("[" + i + "][" +j +"]["+ k +"]");
		
		
	}

}
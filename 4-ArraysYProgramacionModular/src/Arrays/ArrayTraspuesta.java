package Arrays;

import daw.com.Pantalla;


public class ArrayTraspuesta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int filas, columnas;
		int array[][], traspuesta[][];
		
		filas = Libreria.leerEnteroPositivo("filas");
		columnas = Libreria.leerEnteroPositivo("columnas");
		array = new int[filas][columnas];
		
		rellenarArray (array);
		
		mostrarArrayBidimensional (array);
		
		traspuesta = calcularTraspuesta (array);
		
		Pantalla.escribirString("\nLa traspuesta es :\n");
		mostrarArrayBidimensional (traspuesta);
		
		if (sonIguales (array,traspuesta))
			Pantalla.escribirString("\nEl array es igual a su traspuesta");
		else
			Pantalla.escribirString("\nEl array NO es igual a su traspuesta");

	}

	private static boolean sonIguales(int[][] array1, int[][] array2) {
		// TODO Auto-generated method stub
		boolean iguales;
		
		iguales = (array1.length == array2.length) 
					&& (array1[0].length == array2[0].length);
		
		for (int i = 0; iguales && i < array1.length; i++)
			for (int j = 0; iguales && j < array1[i].length; j++)
				iguales = (array1[i][j] == array2[i][j]);
		
		return iguales;
	}

	private static int[][] calcularTraspuesta(int[][] array) {
		// TODO Auto-generated method stub
		int traspuesta[][];
		
		traspuesta = new int[array[0].length][array.length];
		
		for (int i = 0; i< array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				traspuesta[j][i] = array[i][j];
		
		
		
		return traspuesta;
	}

	private static void mostrarArrayBidimensional(int[][] array) {
		// TODO Auto-generated method stub
		for (int i = 0; i< array.length; i++)
		{
			Pantalla.escribirSaltoLinea();
			for (int j = 0; j < array[i].length; j++)
				Pantalla.escribirString("\t" + array[i][j]);
		}
	}

	private static void rellenarArray(int[][] array) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				//array[i][j] = (int)(Math.random()*100);// 0 - 99
				array[i][j] = i==j?1:0;
		
	}

}
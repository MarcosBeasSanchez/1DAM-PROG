package Arrays;

import daw.com.Teclado;

public class sumaFilasYColumnas {

	public static void main(String[] args) {
	//Un ejercicio que pida al ususario cuantas filas y cuantas columnas.
	//Después un array que guarde la suma de las filas y OTRO para las columnas.
	//Pista : Un array bidimensional y 2 unidimensionales
	
	int array[][];
	int sumaFilas[];
	int sumaColumnas[];
	int filas, columnas;
	
	filas = Libreria.leerEnteroPositivo("FILAS?");
	columnas = Libreria.leerEnteroPositivo("COLUMNAS?");
	
	array = crearArray (filas, columnas);
	
	//Filas
	sumaFilas = new int [filas];
	sumaFilas = sumarLasFilas(array, sumaFilas);
	//Columnas
	sumaColumnas = new int [columnas];
	sumaColumnas = sumarLasColumnas(array, sumaColumnas);
	
	//Mostrar valores
	Libreria.mostrarArray(sumaFilas);
	System.out.println("\n");
	Libreria.mostrarArray(sumaColumnas);
	
	}
	
	public static int[][] crearArray(int filas, int columnas){
		int array[][];
		
		array = new int [filas][columnas];
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = Teclado.leerInt("array[" + i +"],[" + j +"]" );	
		
		return array;

	}
	
	public static int[] sumarLasFilas(int array[][], int sumaFilas[]) {
		
		for (int i = 0 ; i < array.length; i++) { // i = filas
			for (int j = 0 ; j < array[0].length; j++) { // j = columnas
				sumaFilas[i] =  sumaFilas[i] + array[i][j]; 
			}
		}
		return sumaFilas;
	}
	
	public static int[] sumarLasColumnas(int array[][], int sumaColumnas[]) {
		
		for (int i = 0 ; i < array.length; i++) { // i = filas
			for (int j = 0 ; j < array[i].length; j++) { // j = columnas
				sumaColumnas[j] =  sumaColumnas[j] + array[i][j]; 
			}
		}
		return sumaColumnas;
	}
}
	

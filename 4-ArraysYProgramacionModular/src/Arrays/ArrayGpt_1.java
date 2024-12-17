package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class ArrayGpt_1 {

	public static void main(String[] args) {
		//Escribe un programa que cree una matriz bidimensional 
		//(por ejemplo, 3x3) e imprima la suma de todos sus elementos.
		
		 int array[][]; 
		 int suma = 0;
		 
		 
		 int filas = Teclado.leerInt("FILAS?");
		 int columnas = Teclado.leerInt("COLUMNAS?");
		 
		 array = new int [filas][columnas];
		 
		 //CREAR EL ARRAY
		for(int i = 0; i < filas ;i++) {
			for(int j=0; j< columnas; j++) {
				array[i][j] = Teclado.leerInt("["+i+"]"+ "["+j+"] =");
				suma = suma + array [i][j];
			}
		}
		
		// MOSTRAR -(hecho con array.length en vez de filas y columnas)
		for (int i = 0; i < array.length; i++){// recorre las filas
			for (int j = 0; j < array[i].length; j++)   // para cada fila recorre las columnas
				Pantalla.escribirString(array[i][j] + "\t");
				Pantalla.escribirSaltoLinea();
			
		}
		System.out.println(suma);
	}
}



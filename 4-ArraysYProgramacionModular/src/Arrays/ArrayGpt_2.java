package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class ArrayGpt_2 {

	public static void main(String[] args) {
		//Crea un programa que genere una matriz (por ejemplo, 4x4) 
		//y encuentre e imprima el valor del elemento más grande.

		 int array[][]; 
		 int elementoMasGrande =0;
		 
		 int filas = Teclado.leerInt("FILAS?");
		 int columnas = Teclado.leerInt("COLUMNAS?");
		 
		 array = new int [filas][columnas];
		 
		 //CREAR EL ARRAY
		for(int i = 0; i < filas ;i++) {
			for(int j=0; j< columnas; j++) {
				array[i][j] = Teclado.leerInt("["+i+"]"+ "["+j+"] =");
				
				if (array[i][j] > elementoMasGrande)
					elementoMasGrande = array[i][j];
			}
		}
		
		
		System.out.println("EL elemento mas grande es: " + elementoMasGrande);
		
		//Mostrar ARRAY
		for(int i=0; i < filas; i++) {
			Pantalla.escribirSaltoLinea();
			for(int j=0; j < columnas;j++) {
				System.out.print(array[i][j]+ "\t");
			}
		}
		
		
		
	}

}

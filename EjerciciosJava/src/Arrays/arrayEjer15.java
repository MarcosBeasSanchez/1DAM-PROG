package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class arrayEjer15 {
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int array[][], posicionMayor[];

			array = crearArray ();
			posicionMayor = buscarPosicionMayor (array);
			
			// mostrar mayor
			Pantalla.escribirString("\nEl mayor esta en la fila " + posicionMayor[0]);
			Pantalla.escribirString("\nEl mayor esta en la columna " + posicionMayor[1]);

		}

		public static int[] buscarPosicionMayor(int[][] array) {
			int posicionMayor[] = {0,0}; // el mayor es el primero
			
			for (int i = 0; i < array.length; i++)
				for (int j = 0; j < array[i].length; j++)
					if (array[i][j] > array[posicionMayor[0]][posicionMayor[1]])
					{
						posicionMayor[0] = i;
						posicionMayor[1] = j;
					}
			
			return posicionMayor;
		}

		public static int[][] crearArray(){
			int array[][], filas, columnas;
			
			filas = Libreria.leerEnteroPositivo("filas");
			columnas = Libreria.leerEnteroPositivo("columnas");
			
			array = new int [filas][columnas];
			for (int i = 0; i < array.length; i++)
				for (int j = 0; j < array[i].length; j++)
					array[i][j] = Teclado.leerInt("array[" + i +"],[" + j +"]" );
			
			
			return array;
		
		

	}

}

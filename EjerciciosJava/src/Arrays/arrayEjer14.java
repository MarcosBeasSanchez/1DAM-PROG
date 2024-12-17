package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class arrayEjer14 {

	public static void main(String[] args) {
			
		
			int array[][], posicion[];
			int elemento;
			
			
			array = crearArray ();
			elemento = Teclado.leerInt("Elemento a buscar");
			posicion = buscarPosicion (array, elemento);
			
			// mostrar mayor
			
			if (posicion != null)
			{
				Pantalla.escribirString("\nEl elemento esta en la fila " + posicion[0]);
				Pantalla.escribirString("\nEl elemento esta en la columna " + posicion[1]);
			}
			else
				Pantalla.escribirString("\nElemento no encontrado");


		}
		public static int[] buscarPosicion(int[][] array, int elemento) {
			// busca el valor de elemento dentro del array y si lo encuentra retorna la posicion
			int posicion[] = null;
			
			for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				if (array[i][j] == elemento)
				{
					posicion = new int[2];
					posicion[0] = i; // i son las filas
					posicion[1] = j; // j son las columnas 
				}
			
			return posicion;
		}
		
		public static int[][] crearArray() {
			// TODO Auto-generated method stub
			int array[][], filas, columnas;
			
			filas = Libreria.leerEnteroPositivo("Filas");
			columnas = Libreria.leerEnteroPositivo("Columnas");
			
			array = new int [filas][columnas];
			for (int i = 0; i < array.length; i++) // fila
				for (int j = 0; j < array[i].length; j++) // columna
					array[i][j] = Teclado.leerInt("array[" + i +"],[" + j +"]" );
			
			return array;
		}

	}
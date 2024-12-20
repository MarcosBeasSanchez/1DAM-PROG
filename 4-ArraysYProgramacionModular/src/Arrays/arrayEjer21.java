package Arrays;

import daw.com.Teclado;

public class arrayEjer21 {

	public static void main(String[] args) {
		// Leer 10 números enteros, almacenarlos en un array 
		// y determinar en qué posiciones se encuentran los números terminados en 4. 
		
		// n termina en 4 si n % 10==4

		int array[];
		boolean terminaEnN[];
		
		array = crearArrayInt();
		
		leerArray(array);
		
		terminaEnN = calcularTerminadosEnN(array, 4); 
		
		// mostrar las posiciones de los que terminan en 4
		
		 boolean encontrado = false;
		 
		for (int i = 0; i < terminaEnN.length; i++) {
			if (terminaEnN[i]) {
			System.out.println( "Terminado en 4 posicion -> " + (i+1));
			encontrado = true;
			}
		}
		
		 if (!encontrado) {
		        System.out.println("NINGUN NUMERO TERMINADO EN 4");
		 }
	
	}
	
	public static boolean[] calcularTerminadosEnN (int array[], int n)
	{
		boolean termina[];
		termina = new boolean[array.length];
		
		// Decimos que todos no terminan en 4 para despues comprobar si es cierto
		for (int i = 0; i < termina.length; i++)
			termina[i] = false;
		
		// buscar los que terminan en n
		for (int i = 0; i < array.length; i++)
			if (array[i] %10 == n)
				termina[i] = true;
		
		return termina;
	}

	public static void leerArray (int array[]){
		for (int i = 0; i < array.length; i++)
			array[i] = Teclado.leerInt("Numero[" + (i + 1)+ "]=");
	}
	
	public static int[] crearArrayInt ()
	{
		int cuantos;
		int array[];
		
		cuantos = Libreria.leerEnteroPositivo("Cuantos Numeros?");
		
		array = new int[cuantos];
		
		return array;
	}
}


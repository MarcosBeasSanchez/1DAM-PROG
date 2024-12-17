package Arrays;
import daw.com.Pantalla;

public class miPrimerArray {

	public static void main(String[] args) {
		// Leer 10 numeros enteros positivos, calcular la media y mostrar se debería cada numero de la media.
		
		
		//[] 1.Definimos array
		int array[], media, suma =0;
		
		// 2.Construimos el array para almacenar los numeros [en este caso 100]
		array = new int[5];
		
		//3.Podemos utilizar el array
		for(int i=0; i < array.length; i++)
		{
			array[i]= Libreria.generarAleatorio(1,100);
			Pantalla.escribirInt("ALEATORIO ES: ", array[i]);
			suma = suma + array[i];	
		}
		
		//suma total del los valores del array
		System.out.println("La suma total es: " + suma);
		
		//definir media y mostrar
		media = suma / array.length; 
		System.out.println("La media es de: " + media);
		
		// Mostrar desviacion de la media
		for(int i=0; i< array.length; i++)
		{
			Pantalla.escribirInt("desviacion de la media", array[i] - media);
		}

	}

}

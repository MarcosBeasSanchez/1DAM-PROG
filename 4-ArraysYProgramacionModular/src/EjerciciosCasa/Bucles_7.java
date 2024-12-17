package EjerciciosCasa;

import daw.com.Teclado;

public class Bucles_7 {

	public static void main(String[] args) {
		/*Desarrollar un programa que solicite la carga de 10 números e 
		imprima la suma de los últimos 5 valores ingresados */
		
		int numeros;
		int sumaNumeros=0;
		int contador=0;
		
		for ( int i = 0; i < 10 ; i++) {
			numeros = Teclado.leerInt("dame un numero" );
			sumaNumeros++;
			
			if(sumaNumeros > 5) {
				contador += numeros;
			}
		}
		
		System.out.println("la suma de los ultimos 5 es: " + contador);

		
		
		
		
		
		
		
		
		
		
	}

}

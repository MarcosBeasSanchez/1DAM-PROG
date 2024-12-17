package EjerciciosCasa;

import daw.com.Teclado;

public class Bucles_2 {

	public static void main(String[] args) {
		/* Crear un programa calcule cuantas cifras tiene un número entero positivo 
		 * (pista: se puede hacer dividiendo varias veces entre 10
		*/
		
		 int numero;
		 int cantidadCifras;
		 
		numero=Teclado.leerInt("Dame un numero te dire cuantas cifras tiene");
		
		if(numero >= 0) {
			cantidadCifras = contarCifras(numero);
		System.out.println("El numero "+ numero + " tiene " + cantidadCifras + " cifras");
		
			
		}else {
			System.out.println("POR FAVOR INGRESE NUM ENTERO");
		}
		
		

		
		

	}
	
	private static int contarCifras( int numero ) {
		
		int cifras = 0;
		
		while (numero > 0) {
			numero = numero/10;
			cifras++;
		}
		
		return cifras;
	}

}

package EjerciciosCasa;

import daw.com.Teclado;

public class RepasoEjer1 {

	public static void main(String[] args) {
		// Escribir un programa que pida dos números y saque el mayor de ellos por pantalla.
		// Una versión mejorada informará de si los dos números son iguales

		int num1, num2; 
		
		num1 = Teclado.leerInt("Dame 1º numero");
		num2 = Teclado.leerInt("Dame 2º numero");
		
		if (num1 == num2)
			System.out.println("son iguales");
		else 
			if( num1 < num2)
				System.out.println("El segundo numero es mayor");
			else
				System.out.println("El primer numero es mayor");
		
		
		

			
	
			
			
	}

}

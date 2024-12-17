package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales6 {

	public static void main(String[] args) {
		// Que tome dos números y diga si ambos son pares o impares
		
		int num1, num2;
		
		num1 = Teclado.leerInt("dame el 1º numero");
		num2 = Teclado.leerInt("dame el 2º numero");
		
		if(num1 % 2 == 0 && num2 % 2 == 0) 
			System.out.println("ambos numeros son pares");
		
		else if(num1 % 2 != 0 && num2 % 2 != 0) { 
			System.out.println("ambos numeros son impares");
		}else{ 
			System.out.println("ERROR");
		}
	}
}

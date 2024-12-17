package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales3 {

	public static void main(String[] args) {
		//Que pida tres números y detecte si se han introducido en orden creciente

		
		int num1, num2, num3 ;
		
		num1 = Teclado.leerInt("dame 1ª numero");
		num2 = Teclado.leerInt("dame 2ª numero");
		num3 = Teclado.leerInt("dame 3ª numero");
		
		
		if(num1 < num2 && num2 < num3) {
			System.out.println("es un numero creciente");
		}else{
			System.out.println("no es un numero decreciente");
		}
			
		
		
		
		
	}

}

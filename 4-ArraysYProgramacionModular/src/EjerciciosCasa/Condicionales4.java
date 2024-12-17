package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales4 {

	public static void main(String[] args) {
		//que pida tres números e indicar si el tercero es igual a la suma del primero y el segundo.
	
		int num1, num2, num3 ;
		
		num1 = Teclado.leerInt("dame 1ª numero");
		num2 = Teclado.leerInt("dame 2ª numero");
		num3 = Teclado.leerInt("dame 3ª numero");
		
		if ( num2 + num1 == num3) {
			System.out.println("el 3º numero es = a la suma del 1º + el 2º");
		}else{
			System.out.println("el 3º numero NO es = a la suma del 1º + el 2º");
		}
		
	}

}

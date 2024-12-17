package EjerciciosCasa;

import daw.com.Teclado;

public class T2_Propuestos_2 {

	public static void main(String[] args) {
		
		int numero = Teclado.leerInt("Dame un numero");
		
		if (numero % 3 == 0 && numero % 6 == 0 && numero % 9 == 0) {
			System.out.println("el numero ES MULTIPLO de 3 6 9");
		}else {
			System.out.println("el numero NO ES MULTIPLO de 3 6 9");
		}
			
		
		
		

	}

}

package EjerciciosCasa;

import daw.com.Teclado;

public class T2_Propuestos_9 {

	public static void main(String[] args) {
		
		int numero;
		String respuesta;
		int contadorPrimos =0;
		
		do {
			numero = Teclado.leerInt("Dame un numero entero positivo");
			
			if (esPrimo(numero)) 
				contadorPrimos++;
			
			respuesta = Teclado.leerString("Desea continuar?  S/N ");
			
		}while(!respuesta.equalsIgnoreCase("N"));
		
		System.out.println("Total de numeros primos introduciodos = " + contadorPrimos);

	}
	
	public static boolean esPrimo (int numero) {
		
		 boolean esPrimo = true;
		 
		 if (numero <= 1)
			 esPrimo = false;
		 
		 for (int i = 2; i < numero; i++)
				if (numero % i == 0)
					esPrimo = false;
		
		 return esPrimo;
		
	}

}

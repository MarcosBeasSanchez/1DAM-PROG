package EjerciciosCasa;

import daw.com.Teclado;

public class T2_Propuestos_8 {

	public static void main(String[] args) {
		
		int numero=0;
		int contadorNum =0;
		int sumaCifras=0;
		
		
		do {
			numero = Teclado.leerInt("Dame un numero");
			
			if(numero>0) {
				contadorNum++;
				  sumaCifras = sumaCifras + numero;
			}	
			
		}while(numero != 0);
		
		System.out.println("Has introducido; " + contadorNum);
		System.out.println("La suma de todos los numeros es de: " + sumaCifras);
		

	}

}

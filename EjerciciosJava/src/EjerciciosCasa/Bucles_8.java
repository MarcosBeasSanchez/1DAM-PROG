package EjerciciosCasa;

import Arrays.Libreria;

public class Bucles_8 {

	public static void main(String[] args) {
		/* Realizar un programa que solicite la carga de un valor entero del 1 al 10. Mostrar después la
		tabla de multiplicar de dicho número.*/
		
		int num , multiplicacion = -1 , resultado;
		
		num = Libreria.leerEntreLimites(1, 10, "\nDame un valor entre el 1 y 10");
		
		for( int i = 0; i < 11; i++) {
			
			resultado = (num * multiplicacion) + num; 
			multiplicacion++; 
			System.out.println(num + " x " + multiplicacion + " = " + resultado );
		}

	}

}

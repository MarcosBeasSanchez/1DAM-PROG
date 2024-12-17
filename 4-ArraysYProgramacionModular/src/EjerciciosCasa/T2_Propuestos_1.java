package EjerciciosCasa;

import daw.com.Teclado;

public class T2_Propuestos_1 {

	public static void main(String[] args) {
		
		
		 int numero = Teclado.leerInt("Dame un numero");
		 int porcentaje= Teclado.leerInt("Dame un porcentaje");
		 int resultado;
		 
		 resultado =  ( numero * porcentaje) /100;
		 
		 System.out.println("El numero es: " + numero + "\nEl porcentaje es: " + porcentaje);
		 System.out.println("El " + porcentaje +" de " + numero +" es: " + resultado);
		 System.out.println("Descuento aplicado: " + (numero - resultado));

	}

}

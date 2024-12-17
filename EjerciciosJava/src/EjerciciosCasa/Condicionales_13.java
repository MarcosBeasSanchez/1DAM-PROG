package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales_13 {

	public static void main(String[] args) {
		// Realizar el ejercicio que muestre el nombre del cliente en la compra de llantas, si la cantidad
		//de llantas comprados es menor de 12 pagara 300 euros por unidad, y si es mayor de 12 pagara 280,
		//ademas se debe mostrar el total de la compra

		String nombre;
		int cantidad, total, preciollanta;
		
		nombre = Teclado.leerString("Dame tu nombre");
		
		cantidad = Teclado.leerInt("¿Cuantas llantas quieres compar?");
		
		if( cantidad <= 12) {
			preciollanta = 300;
		total = cantidad * preciollanta;
		}else { 
			preciollanta = 280;
		total = cantidad * preciollanta;
		}
		
		System.out.println("tu nombre es " + nombre + " y pagas " + total);
			
			
		
		
		
		
		
		
		
	}

}

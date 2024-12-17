package EjerciciosCasa;
import daw.com.Teclado;

public class Condicionales_12 {

	public static void main(String[] args) {
		// 2º Realizar el ejercicio que muestre el nombre del cliente y la cantidad de artículos comprados, si
		//la cantidad es menor de 5 pagara en efectivo, si es mayor de 5 y menor de 12 pagara con tarjeta, si
		//es mayor de 13 pagara con cheque
		
		
		//Definir Datos
		String nombre;
		int productosComprados;
		
		//Dame tu nombre
		 nombre = Teclado.leerString("Dame tu nombre");
		
		//Dime que cantidad de productos has comprado
		do{
			productosComprados = Teclado.leerInt("dime cuantos productos compraste");
		}while(productosComprados < 0);
		
		//Mostrar metodo de pago
		
		if (productosComprados >= 1 && productosComprados <= 5) {
		    System.out.println(nombre + " Pagas en efectivo");
		} else if (productosComprados >= 6 && productosComprados <= 11) {
		    System.out.println(nombre + " Pagas en tarjeta");
		} else if (productosComprados >= 13) {
		    System.out.println(nombre + " Pagas en cheque");
		}

	}

}

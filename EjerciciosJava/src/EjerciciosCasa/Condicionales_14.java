package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales_14 {

	public static void main(String[] args) {
		//En un supermercado se hace un 20% de descuento a los clientes cuya compra supere los 1000
		// en las áreas de frutas, verduras y abarrotes. 
		//¿ Cual sera el total que pagara una persona por sucompra ?
		//se debe mostrar el nombre del cliente , producto, precio , cantidad , descuento y total a pagar

		String nombre, seccion, producto;
		int cantidad=0;
		float precio=0, descuento;
		
		
		nombre = Teclado.leerString("Ingrese su nombre");
		seccion = Teclado.leerString("Indique el nombre de la seccion de productos\n 1.frutas\n 2.verduras\n 3.abarrotes");
		seccion = seccion.toLowerCase();
		producto = Teclado.leerString("Indica el nombre del producto");
		
		switch(seccion) {
		case "frutas":
			precio = Teclado.leerFloat("Indica el precio del producto");
			cantidad = Teclado.leerInt("Indica cuantos deseas comprar");
			descuento = (float) (precio * cantidad * 0.20);
			if (cantidad > 1000) {
				precio = (precio * cantidad - descuento);
				System.out.println("Hay descuento de un 20%");
			}else {
					precio = (precio * cantidad);
					System.out.println("No hay descuento");
					}
			break;
		case "verduras":
			precio = Teclado.leerFloat("Indica el precio del producto");
			cantidad = Teclado.leerInt("Indica cuantos deseas comprar");
			descuento = (float) (precio * cantidad * 0.20);
			if (cantidad > 1000) {
				precio = (precio * cantidad - descuento);
				System.out.println("Hay descuento de un 20%");
			}else {
					precio = (precio * cantidad);
					System.out.println("No hay descuento");
					}
			break;
		case "abarrotes":
			precio = Teclado.leerFloat("Indica el precio del producto");
			cantidad = Teclado.leerInt("Indica cuantos deseas comprar");
			descuento = (float) (precio * cantidad * 0.20);
			if (cantidad > 1000) {
				precio = (precio * cantidad - descuento);
				System.out.println("Hay descuento de un 20%");
			}else {
					precio = (precio * cantidad);
					System.out.println("No hay descuento");
					}
			break;
			default:
			System.out.println("ERROR");
			
		}
		
		System.out.println("\nTu nombre es "+ nombre + "\nCompraste "+ cantidad +" "+ producto + "\nPagas " + precio+"€");
		
	}

}

package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales_16 {

	public static void main(String[] args) {
		//Una distribuidora de motocicletas tiene una promoción de fin de año que consiste en lo
		//siguiente. Las motos marca Honda tienen un descuento del 5%, las marcas Yamaha del 8% y las
		//Suzuki del 10%, las otras marcas 2%.
		
		
String marca ;
float precio, descuento;


		do {
		marca= Teclado.leerString("Ingrese la marca de la moto");
		marca = marca.toLowerCase();
		}while( !marca.equals("yamaha") && !marca.equals("suzuki") && !marca.equals("honda"));
		
		
		switch (marca){
		case "honda":
			precio = Teclado.leerFloat("Ingrese el precio de la moto");
			descuento = precio * 0.05f;
			System.out.println("su descuento es de " + descuento);
			System.out.println("El pago total de la moto es de "+ (precio - descuento));
			break;
		case "yamaha":
			precio = Teclado.leerFloat("Ingrese el precio de la moto");
			descuento = precio * 0.08f;
			System.out.println("su descuento es de " + descuento);
			System.out.println("El pago total de la moto es de "+ (precio - descuento));
			break;
		case "suzuki":
			precio = Teclado.leerFloat("Ingrese el precio de la moto");
			descuento = precio * 0.10f;
			System.out.println("su descuento es de " + descuento);
			System.out.println("El pago total de la moto es de "+ (precio - descuento));
			break;	
		}
		
		
		
		
		
		
		
	}

}
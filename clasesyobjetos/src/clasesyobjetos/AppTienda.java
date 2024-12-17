package clasesyobjetos;

public class AppTienda {
	
	public static void main(String[] args) {
		
		//Crear  2 porductos y leerlos del teclado de tal manera que no se puedan repetir 
		//mostrar por pantalla el total de dinero que tenemos en el inventario.

		// nombre NO PEUDE SER NULO NI REPETIDO
		// precio no puede ser negativo
		
		Tienda p1, p2;
		float totalp1 = 0;
		float totalp2 = 0;
		
		//construir
		p1 = new Tienda ();
		p2 = new Tienda ();
		
		p1.leerDatos();
		p2.leerDatos();
		
		if (p1.getNombre().equalsIgnoreCase(p2.getNombre())) {
			System.out.println("ERROR NOMBRES IGUALES");
		} else {
			totalp1 = p1.getCantidad() * p1.getPrecio();
			System.out.println("El precio total de PRODUCTOS * CANTIDAD del P1 = " + totalp1);
			totalp2 = p2.getCantidad() * p2.getPrecio();
			System.out.println("El precio total de PRODUCTOS * CANTIDAD del P2 = " + totalp2);
		}
		
	}

}

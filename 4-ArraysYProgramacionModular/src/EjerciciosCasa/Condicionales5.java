package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales5 {

	public static void main(String[] args) {
		// º Que muestre un menú que contemple las opciones “Archivo”, “Buscar” y “Salir”, en caso de que
		// no se introduzca una opción correcta se notificará por pantalla.

		String opcion;
		
		opcion = Teclado.leerString("Elija:\n1.archivo\n2.buscar\n3.salir");
		opcion = opcion.toLowerCase();
		
		switch (opcion) {
		case"archivo":
			System.out.println("accediendo a archivo");
		break;
		case"buscar":
			System.out.println(" ahora puedes buscar");
		break;
		case"salir":
			System.out.println("saliendo del programa");
		break;
		default:
			System.out.println("ERROR");		
		}
		
	}	

}

package Empleados;

import daw.com.Teclado;

public class AppEmpleado {

	public static void main(String[] args) {
		int cuantos , opc;
		Empleado empleados[];
		
		cuantos = Teclado.leerInt("\nCuantos Empleados?");
		
		empleados = new Empleado[cuantos];
		
		for (int i = 0; i < empleados.length; i++) {
			
			mostrarDatos();
			opc = Teclado.leerInt("Elije una opcion");
			
			switch (opc) {
			case 1 :
				empleados[i] = new Administrativo ();
				break;
				
			case 2 :
				empleados[i] = new Profesor ();
				break;
				
			case 3 :
				empleados[i] = new Auxiliar ();
				break;

			}
			
			empleados[i].leerDatos();
			empleados[i].toString();
		}
	
	}
	
	public static void mostrarDatos() {
		System.out.println("¿Que tipo de empleado?");
		System.out.println("1. Administrativo");
		System.out.println("2. Profesor");
		System.out.println("3. Auxiliar");
	}
																																																																																																																																																																									 
}

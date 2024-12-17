package EjerciciosCasa;

import Arrays.Libreria;
import daw.com.Teclado;

public class Bucles_5 {

	public static void main(String[] args) {
		/*En una empresa trabajan n empleados cuyos sueldos oscilan entre 100€ y 1000€. Realizar un
		programa lea el sueldo de los trabajadores y que informe de cuantos empleados cobran
		menos de 500€ y cuantos más de 500€. Informar también del total que gasta la empresa en
		pagar a sus empleados.*/
		
		int sueldo;
		int nEmpleados;
		int gastosEmpresa=0 , mas500 = 0 , menos500 = 0 ;
		
	nEmpleados= Teclado.leerInt("Dime cuantos trabajadores hay en la empresa");
	
	for (int i=0; i<nEmpleados ; i++) {
		
		sueldo = Libreria.leerEntreLimites(100, 1000, "cuanto cobra el trabajador: " + i);
		
		if( sueldo > 500) {
			System.out.println("El trabajador: " + i + " cobra + de 500€");
			mas500++;
			//aqui acomula el valor de sueldo en la VAR gastosEmpresa
			gastosEmpresa +=  sueldo ;
		}else{
			System.out.println("El trabajador: " + i + " cobra - de 500€");
			menos500++;
			//aqui acomula el valor de sueldo en la VAR gastosEmpresa
			gastosEmpresa +=  sueldo ;
		}
		
	}
		
		System.out.println("\nHay " + mas500 +" trabajadores  que cobren mas de 500");
		System.out.println("\nHay " + menos500 +" trabajadores  que cobren menos de 500");
		System.out.println("\nLos gastos totales de la empresa son: " + gastosEmpresa);
		
		
		
	
		
		
		
		

	}

}

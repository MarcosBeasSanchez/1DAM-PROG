package EjerciciosCasa;

import daw.com.Teclado;

public class Bucles_3 {

	public static void main(String[] args) {
		/*Escribir un programa que solicite ingresar la nota (valor entre 1 y 10) de 10 alumnos, el
		programa debe informar de cuantos han aprobado y cuantos han suspendido.
		*/
		
		int alumnosAprobados = 0;
		int alumnosSuspendidos = 0;
		float nota;
		
		
		for(int i = 0 ; i < 3; i++) {
			
			nota = Teclado.leerFloat("Dime la nota del alumno " + i );
			
			if (nota >= 0 && nota <= 10) {
				if (nota >= 5) {
					alumnosAprobados++;	
				}else{
					alumnosSuspendidos++;
				}
					
				}else{
					System.out.println("PORFAVOR INDIQUE NOTA DE NUEVO");
					i--;
				}
			}
		System.out.println("ALUMNOS APROBADOS "+ alumnosAprobados+ "\nALUMNOS SUSPENSOS" + alumnosSuspendidos);
				
	
		
		
		
		
		
		
	}

}

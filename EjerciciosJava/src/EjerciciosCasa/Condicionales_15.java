package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales_15 {

	public static void main(String[] args) {
		// Mostrar el nombre de un alumno, su carrera y el tipo de trabajo; si estudia y trabaja como
		// primera condición y como segunda condición si solo estudia su nombre y la carrera que está
		// estudiando.
		
		String nombre, opcion, estudio, trabajo ;
		
		nombre= Teclado.leerString("Dime tu nombre");
		opcion = Teclado.leerString("\n1.Estudio \n2.Estudio y trabajo");
		opcion = opcion.toLowerCase();
		
		switch (opcion) {
        case "estudio":
        	estudio = Teclado.leerString("¿Que estudias?");
        	System.out.println("Tu nombre es "+nombre+ " estudias "+estudio);
            break;
        case "estudio y trabajo":
        	estudio = Teclado.leerString("¿Que estudias?");
        	trabajo = Teclado.leerString("¿De que trabajas?");
        	System.out.println("Tu nombre es "+nombre+ " estudias "+estudio+" trabajas "+ trabajo);
        	break;
        	}
		
		
		
	}

}
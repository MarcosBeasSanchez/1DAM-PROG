package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales2 {

	public static void main(String[] args) {
		// Que pida una letra y detecte si es una vocal
		
		String letra;
		
		letra = Teclado.leerString("dame una letra");
		

		if (letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o") ||letra.equals("u")) 
			System.out.println("es vocal");
		else 
			System.out.println(" es consonante");
		
		
		
		
		
		
		
	}

}

package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales_17 {

	public static void main(String[] args) {
		// Que sólo permita introducir los caracteres S y N.
		
		
		
		String letra;
		
		letra = Teclado.leerString("dame una letra, solo leere la S y N");
		letra = letra.toUpperCase();
		
		if (letra.equals("S") || letra.equals("N"))
			System.out.println("CORRECTO");
		else
			System.out.println("IN CORRECTO");

	}

}

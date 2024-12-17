package examenFinal;

import daw.com.Teclado;

public class prueba {

	public static void main(String[] args) {
		   String cadenaVacia = ""; // Cadena vacía
	        String cadenaNula = null; // Cadena nula

	        // Verificamos si la cadena está vacía
	        if (cadenaVacia.isEmpty()) {
	            System.out.println("La cadena es vacía.");
	        }

	        // Intentamos verificar si la cadena nula está vacía (esto dará un error si no se maneja)
	        try {
	            if (cadenaNula.isEmpty()) {
	                System.out.println("La cadena nula es vacía.");
	            }
	        } catch (NullPointerException e) {
	            System.out.println("Error: Intentaste verificar una cadena nula.");
	        }

	        // Verificamos si las cadenas son nulas
	        if (cadenaVacia == null) {
	            System.out.println("cadenaVacia es nula.");
	        } else {
	            System.out.println("cadenaVacia NO es nula.");
	        }

	        if (cadenaNula == null) {
	            System.out.println("cadenaNula es nula.");
	        } else {
	            System.out.println("cadenaNula NO es nula.");
	        }
	    }
	}
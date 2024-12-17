package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AlumnosYNotas {
	public static void main (String args[])
	{
		String nombres[];
		int notas[];
		int nAlumnos,posicionMayor, posicionMenor;
		float media, porcentajeAprobados;
		
		
		
		nAlumnos = Libreria.leerEnteroPositivo("¿Cuantos alumnos?");
		 //CREA el array int y String
		nombres = new String[nAlumnos];
		notas = new int[nAlumnos];
		
		// Pide los nombres y notas del total de alumnos
		leerAlumnos(nombres, notas);
	
		// Posicion de la nota mayor
		posicionMayor = buscarNotaMasAlta (notas);
		Pantalla.escribirString("\nEl alumno con nota mas alta es "  + nombres[posicionMayor]);
		
		//Posicion de la nota menor
		posicionMenor = buscarNotaMasBaja (notas);
		Pantalla.escribirString("\nEl alumno con nota mas baja es " + nombres[posicionMenor]);
		
		//Media
		media = calcularMedia (notas);
		Pantalla.escribirFloat("\nLa media es ", media);
		
		Pantalla.escribirString("\nListado que SUPERAN LA MEDIA");
		for (int i = 0; i < nombres.length; i++)
			if (notas[i] > media)
				Pantalla.escribirString("\n" + nombres[i]);
				Pantalla.escribirSaltoLinea();
		
		//Porcentaje de Aprobados
		porcentajeAprobados = calcularPorcentajeAprobados(notas);
		Pantalla.escribirFloat("porcentaje de aprobados", porcentajeAprobados);
		
		ordenarPorNombres (nombres,notas);
		
		ordenarPorNotas (notas);
    
	}
	
	public static void ordenarPorNombres(String[] nombres, int notas[]) {
	    String auxNombre;
	    int auxNota;

	    // Utilizamos el algoritmo de ordenación de burbuja
	    for (int i = 0; i < nombres.length - 1; i++) {
	        for (int j = 0; j < nombres.length - 1 - i; j++) {
	            if (nombres[j].compareTo(nombres[j + 1]) > 0) {
	                // Cambiar nombres
	                auxNombre = nombres[j];
	                nombres[j] = nombres[j + 1];
	                nombres[j + 1] = auxNombre;

	                // Cambiar notas
	                auxNota = notas[j];
	                notas[j] = notas[j + 1];
	                notas[j + 1] = auxNota;
	            }
	        }
	    }

	    System.out.println("\nNombres ordenados alfabéticamente:");
	    for (int i = 0; i < nombres.length; i++) {
	        System.out.println(nombres[i] + ": " + notas[i]);
	    }
	}



	public static void ordenarPorNotas (int array[])
	{
		int aux;
		
		for (int i = 0; i < array.length - 1; i++)
			for (int j = i + 1; j < array.length; j++)
				if (array[j] < array[i])
				{
					aux = array[i];
					array[i] = array[j];
					array[j] = aux;
				}
	}


	private static float calcularPorcentajeAprobados(int[] notas) {
		float porcentaje = 0;
		int aprobados = 0;
		
		for (int i = 0; i < notas.length; i++)
			if (notas[i] >= 5)
				aprobados++;
				
		porcentaje = aprobados * 100 / notas.length;
		
		return porcentaje;
	}

	private static float calcularMedia(int[] notas) {
		float media;
		int suma = 0;
		for (int i = 0; i < notas.length; i++)
			suma += notas[i];
		
		media = suma / notas.length;
		
		return media;
	}

	public static int buscarNotaMasBaja(int[] notas) {
		int posicion = 0;
		
		for (int i = 1; i < notas.length; i++)
			if (notas[i] < notas[posicion])
				posicion = i;
		
		return posicion;
	}

	public static int buscarNotaMasAlta(int[] notas) {
		int posicion = 0;
		
		for (int i = 1; i < notas.length; i++)
			if (notas[i] > notas[posicion])
				posicion = i;
		
		return posicion;
	}

	public static void leerAlumnos(String[] nombres, int[] notas) {
		
		for (int i = 0; i < nombres.length; i++)
		{
			nombres[i] = Teclado.leerString("nombre del alumno " + i);
			notas[i] = Libreria.leerEntreLimites(1, 10, "nota del alumno" + i);
		}
		
	}

}
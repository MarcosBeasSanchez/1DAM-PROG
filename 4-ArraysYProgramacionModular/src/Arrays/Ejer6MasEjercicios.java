package Arrays;

import daw.com.Teclado;
import daw.com.Pantalla;

public class Ejer6MasEjercicios {

	public static void main(String[] args) {
		/*
		Realizar un programa que gestione las notas de una clase de n alumnos 
		de los cuales tendremos que leer su nombre y sus notas al principio de su ejecución. 
		Cada alumno puede tener un máximo de 6 notas. (cada alumno puede tener un número de notas distinto)
		El programa debe mostrar a continuación un menú con las siguientes opciones:

1. Buscar un alumno y mostrar sus datos (nombre y notas).
2. Modificar una nota de un alumno. El programa debe preguntar el nombre y la nota a modificar y el valor de la nota.
3. Mostrar la media de todas las notas de todos los alumnos.
4. Mostrar la media y el nombre de los alumnos que tengan alguna nota menor que 5.
5. Mostrar nombre del alumno que mejor nota media ha sacado.
6. Listar los alumnos ordendos alfabéticamente. De cada alumno mostrar su nombre y todas sus notas.
7. Salir
		 */
		
		final int SALIR = 7, ASIGNATURAS = 3;
		String nombres[];
		int notas[][], opcion, cuantos;
		
		cuantos = Libreria.leerEnteroPositivo("cuantos alumnos?");
		
		nombres = new String[cuantos];
		notas = new int[cuantos][ASIGNATURAS];
		
		leerAlumnos (nombres, notas);
		
		// menu
		do
		{
			mostrarOpciones ();
			opcion = Libreria.leerEntreLimites(1,SALIR, "\nElija una opcion");
			evaluarOpcion (opcion, nombres, notas);
		}while (opcion != SALIR);
		
	}

	private static void leerAlumnos(String[] nombres, int[][] notas) {
		// TODO Auto-generated method stub
		String nombre;
		for (int i = 0; i < nombres.length; i++)
		{
			// leer nombre del alumno
			do
			{
				nombre = Teclado.leerString("nombre ");
			}while (estaAlumno(nombre, nombres)!= -1);
			nombres[i] = nombre;
			
			// leer notas del alumno
			for (int j = 0; j < notas[i].length; j++)
				notas[i][j] = Libreria.leerEntreLimites(1, 10, "nota ");
		}
		
	}

	private static void evaluarOpcion(int opcion, String[] nombres, int[][] notas) {
		// TODO Auto-generated method stub
		switch (opcion)
		{
			case 1:
				buscarAlumno (nombres, notas);
				break;
			case 2:
				modificarNota (nombres, notas);
				break;
			case 3:
				mostrarMediaDeTodos (notas);
				break;
			case 4:
				mostrarAlumnosConSuspensos (nombres,notas);
				break;
			case 5:
				mostrarMasSabio (nombres, notas);
				break;
			case 6:
				listarOrdenados (nombres, notas);
				break;
			case 7:
				Pantalla.escribirString("\nFIN");
		}
		
	}

	public static void listarOrdenados(String[] nombres, int[][] notas) {
		// TODO Auto-generated method stub
		String nombreAux;
		int notasAux[];
		
		for (int i = 0; i < nombres.length - 1; i++)
			for (int j = i+1; j < nombres.length; j++)
				if (nombres[i].compareTo(nombres[j])> 0)
				{
					nombreAux = nombres[i];
					nombres[i] = nombres[j];
					nombres[j] = nombreAux;
					
					notasAux = notas[i];
					notas[i] = notas[j];
					notas[j] = notasAux;
				}
		
		for (int i = 0; i < nombres.length; i++)
			mostrarAlumno (nombres[i], notas[i]);
		
	}


	private static float calcularMediaNotas(int[] notasAlumno) {
		// TODO Auto-generated method stub
		float media = 0;
		
		for (int i = 0; i < notasAlumno.length; i++)
			media += notasAlumno[i];
		
		return media/notasAlumno.length;
	}

	private static void mostrarMasSabio(String[] nombres, int[][] notas) {
		// TODO Auto-generated method stub
		int posSabio = 0;
		
		for (int i = 1 ; i < notas.length; i++)
			if (calcularMediaNotas(notas[i]) > calcularMediaNotas(notas[posSabio]))
				posSabio = i;
		
		mostrarAlumno (nombres[posSabio], notas[posSabio]);
	}

	private static void mostrarAlumnosConSuspensos(String nombres[],int[][] notas) {
		// TODO Auto-generated method stub
		float media = 0;
		int cuantos = 0;
		boolean algunSuspenso;
		
		for (int i = 0; i < notas.length; i++)
		{
			algunSuspenso = false;
			for (int j = 0; !algunSuspenso && j < notas[i].length ; j++)
			if (notas[i][j] < 5)
			{
				media = calcularMediaNotas(notas[i]);
				// Mostrar alumno y media
				mostrarAlumno(nombres[i], (int)Math.ceil(media));
				algunSuspenso = true;
				cuantos++;
			}
		}
		
		if (cuantos == 0)
			Pantalla.escribirString("\nQue bien, no hay suspensos");
		
	}

	private static void mostrarMediaDeTodos(int[][] notas) {
		// TODO Auto-generated method stub
		float media = 0;
		int cuantasNotas = 0;
		
		for (int i = 0; i < notas.length; i++)
			for(int j = 0; j < notas[i].length; j++)
			{
				media += notas[i][j];
				cuantasNotas++;
			}
		
		media /= cuantasNotas;
		
		Pantalla.escribirFloat("La media es: ", media);
	}

	private static void modificarNota(String[] nombres, int[][] notas) {
				String nombre;
				int pos, cual;
				
				nombre = Teclado.leerString("\nAlumno a buscar");
				
				pos = estaAlumno (nombre, nombres);
				
				
				if (pos == -1)
					Pantalla.escribirString("\nEl alunmo no se encuentra");
				else
				{
					mostrarAlumno (nombres[pos], notas[pos]);
					cual = Libreria.leerEntreLimites(0, notas[pos].length - 1, "cual nota");
					notas[pos][cual] = Libreria.leerEntreLimites(1, 10, "nueva nota");
				}
	}

	private static void buscarAlumno(String[] nombres, int[][] notas) {
		// TODO Auto-generated method stub
		String nombre;
		int pos;
		
		nombre = Teclado.leerString("\nAlumno a buscar");
		
		pos = estaAlumno (nombre, nombres);
		
		
		if (pos == -1)
			Pantalla.escribirString("\nEl alunmo no se encuentra");
		else
			mostrarAlumno (nombres[pos], notas[pos]);
		
	}

	private static void mostrarAlumno(String nombre, int... nota) {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n" + nombre);
		for (int i = 0; i < nota.length; i++)
			Pantalla.escribirString("\t"+ nota[i]);
	}

	private static int estaAlumno(String nombre, String[] nombres) {
		// TODO Auto-generated method stub
		int pos = -1;
		
		for (int i = 0 ; i < nombres.length && pos == -1; i++)
			if (nombre.equals(nombres[i])) // importa el orden, para evitar null
				pos = i;
		
		return pos;
	}

	private static void mostrarOpciones() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n1.Buscar un alumno");
		Pantalla.escribirString("\n2.Modificar una nota de un alumno"); 
		Pantalla.escribirString("\n3.Realizar la media de todas las notas");
		Pantalla.escribirString("\n4.Mostrar alumnos y sus medias con notas menores de 5");
		Pantalla.escribirString("\n5.Mostrar el alumno que mejores notas ha sacado");
		Pantalla.escribirString("\n6.Listar ordenados");
		Pantalla.escribirString("\n7.Salir");
	}

}
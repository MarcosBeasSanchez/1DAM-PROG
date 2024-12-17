package colecciones;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppPeliculasEjer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<Pelicula> peliculas = new ArrayList<>();
		List<Pelicula> copiaPeliculas;
		Pelicula pelicula;
		Stack<Pelicula> pilaPeliculas;
		Queue<Pelicula> colaPeliculas;
		int cuantas;

		//Utilidades.fromFile("datospeliculas");
		do {
			pelicula = new Pelicula ();
			pelicula.leerClave();

			if (!peliculas.contains(pelicula))
			{
				pelicula.leerOtrosDatos();
				peliculas.add(pelicula);
			}
			else
				Pantalla.escribirString("\nYa existe");
		}while (Teclado.leerString("sigo?").equals("s"));

		//Utilidades.fromKeyboard();

		// Hacer una copia de peliculas
		copiaPeliculas = new ArrayList<>(peliculas);

		// Cargar pila de peliculas
		pilaPeliculas = new Stack<> ();
		for (Pelicula p: peliculas)
			pilaPeliculas.push(p); // aÃ±adir elemento encima de la pila



		Pantalla.escribirString("\nMostrar pila");
		// Recorrer en orden inverso a la inserciÃ³n Stack pila
		for (int i = copiaPeliculas.size()-1; i >=0; i--)
			//Sacar el Ãºltimo
			Pantalla.escribirString("\n" +  copiaPeliculas.remove(i));

		Pantalla.escribirString("\nMostrar pila bis");
		while (!pilaPeliculas.isEmpty())
			//Sacar elemento de la cima de la pila
			Pantalla.escribirString("\n" +  pilaPeliculas.pop());


		// Hacer una copia de peliculas
		copiaPeliculas = new ArrayList<>(peliculas);

		// Cargar cola de peliculas
		colaPeliculas = new LinkedList<>(); // una implementaciÃ³n de Queue
		//peliculas.forEach(colaPeliculas::offer);
		for (Pelicula p: peliculas)
			colaPeliculas.offer(p); // insertar en la cola

		Pantalla.escribirString("\nMostrar cola");
		// Recorrer en orden de la inserciÃ³n Queue cola
		while (!copiaPeliculas.isEmpty())
		{
			// Sacar el primero
			Pantalla.escribirString("\n" +  copiaPeliculas.remove(0));
		}

		Pantalla.escribirString("\nMostrar cola bis");
		while (!colaPeliculas.isEmpty())
			// Sacar de la cola
			Pantalla.escribirString("\n" +  colaPeliculas.poll());


		Comparator<Pelicula> comparadorPorPrecio = new ComparadorPeliculaPorPrecio ();
		//Comparator<Pelicula> comparadorPorPrecio = (p1,p2) -> Float.compare(p1.getPrecio(), p2.getPrecio());
		// Cola de prioridad
		colaPeliculas = new PriorityQueue<>(comparadorPorPrecio);
		// cargar cola
		//peliculas.forEach(colaPeliculas::offer);
		for (Pelicula p: peliculas)
			colaPeliculas.offer(p); // insertar en la cola

		Pantalla.escribirString("\nMostrar cola prioridad");
		// Recorrer la cola
		while (!colaPeliculas.isEmpty())
			// Sacar de la cola
			Pantalla.escribirString("\n" +  colaPeliculas.poll());
		
	}


}
package colecciones;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppPeliculasEjer1 {
	final static Consumer<Pelicula> ESCRIBIR = System.out::println;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Pelicula> conjunto =new HashSet<>();
		Pelicula pelicula;
		List<Pelicula> lista;
		Map <Pelicula,String> alquileres = new HashMap<>();

		String cliente;
		float puntuacion;
		// Wrapper de float es Float
		Map <Pelicula, Float> puntuaciones = new HashMap<>(); 
		// Wrapper de int es Integer
		List<Integer> enteros = new ArrayList<>();
		
		do
		{
			pelicula = new Pelicula();
			pelicula.leerClave();
			
			if (conjunto.add(pelicula))
			{
				pelicula.leerOtrosDatos();
				Pantalla.escribirString("\nPelicula introducida");
			}
			else
				Pantalla.escribirString("\nPelicula existente");
		}while (Teclado.leerString("\nsigo?").equals("s"));
		
		
		
		// Mostrar ordenado
		// Convertir un Set a un List
		lista = new ArrayList<>(conjunto);
		
		Comparator<Pelicula> comparador;
		comparador = new Comparator<Pelicula> ()
		{

			@Override
			public int compare(Pelicula o1, Pelicula o2) {
				// TODO Auto-generated method stub
				return o1.getTitulo().compareTo(o2.getTitulo());
			}
	
		};
		lista.sort(comparador);
		
		Pantalla.escribirString("\n" + lista);

		lista.forEach(ESCRIBIR);
		
		// Realizar alquileres
		do
		{
			// Pedir cliente
			cliente = Teclado.leerString("\nCliente");
			
			//Pedir pelicula
			pelicula = new Pelicula ();
			pelicula.leerClave();
			
			// Comprobar que la pelicula existe
			if (lista.contains(pelicula))
			{
				//Comprobar que no estï¿½ alquilada
				if (!alquileres.containsKey(pelicula))
				{
					int posicion = lista.indexOf(pelicula);
					alquileres.put(lista.get(posicion),cliente);
					
				}
			}
			
		}while (Teclado.leerString("\nSigo?").equals("s"));
		
		// Recorrer las peliculas alquiladas
		for (Pelicula p: alquileres.keySet())
		{
			// Para cada  clave (p), obtenemos su valor (cliente)
			cliente = alquileres.get(p);
			Pantalla.escribirString("\nPeli " + p.getTitulo() + " alquilada por " + cliente);
		}
		
		
		
		for (Map.Entry<Pelicula, String> entry : 
							alquileres.entrySet())
		{
			cliente = entry.getValue();
			Pantalla.escribirString("\nPeli " 
					+ entry.getKey().getTitulo() 
					+ " alquilada por " + cliente);
			
		}

		for (Pelicula pl: alquileres.keySet())
			Pantalla.escribirString("\n" + pl.getTitulo() + alquileres.get(pl));
		// Realizar puntuaciones
		do
		{
			//Pedir pelicula
			pelicula = new Pelicula ();
			pelicula.leerClave();
			
			// Comprobar que la pelicula existe
			if (lista.contains(pelicula))
			{
				do
				{
					// Pedir puntuaciï¿½n
					puntuacion = Teclado.leerFloat("\nPuntuaciï¿½n");
				}while (puntuacion < 1 || puntuacion > 5);
				
				//Comprobar que no estï¿½ puntuada
				if (!puntuaciones.containsKey(pelicula))
				{
					int posicion = lista.indexOf(pelicula);
					puntuaciones.put(lista.get(posicion),puntuacion);
					
				}
			}
			
		}while (Teclado.leerString("\nSigo?").equals("s"));
		
		// Recorrer las peliculas puntuadas
		for (Pelicula p: puntuaciones.keySet())
		{
			// Para cada  clave (p), obtenemos su valor (cliente)
			puntuacion = puntuaciones.get(p);
			Pantalla.escribirString("\nPeli " + p.getTitulo() + " puntuada con " + puntuacion);
		}
	}

}
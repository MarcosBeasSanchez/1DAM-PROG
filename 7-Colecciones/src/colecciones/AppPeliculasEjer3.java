package colecciones;

import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppPeliculasEjer3 {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Set<Pelicula> peliculas = new HashSet<>();
		Set<Pelicula> copiaPeliculas;
		Pelicula pelicula;
		final Consumer<Pelicula> ESCRIBIDOR;
		
		ESCRIBIDOR = new Consumer<Pelicula> ()
				{

					@Override
					public void accept(Pelicula t) {
						// TODO Auto-generated method stub
						Pantalla.escribirString("\n" + t);
					}
					
				};
			
		//Utilidades.fromFile("prueba.txt");
		do {
			pelicula = new Pelicula ();
			pelicula.leerClave();
			
			if (peliculas.add(pelicula))
			{
				pelicula.leerOtrosDatos();
			}
			else
				Pantalla.escribirString("\nYa existe");
		}while (Teclado.leerString("sigo? s/n").equals("s"));
		
			
		//Utilidades.fromKeyboard();
			
		
		Pantalla.escribirString("\nPeliculas de mas de 10 euros");
		for (Pelicula p: peliculas)
			if (p.getPrecio() > 10)
				Pantalla.escribirString("\n" + p);
		
		copiaPeliculas = new HashSet<Pelicula>(peliculas);
		
		Predicate<Pelicula> precioMayorQue10;
		
		precioMayorQue10 =  new Predicate<Pelicula> ()
				{

					@Override
					public boolean test(Pelicula t) {
						// TODO Auto-generated method stub
						return t.getPrecio() > 10;
					}
			
			
				};
		
		copiaPeliculas.removeIf(precioMayorQue10.negate());
		copiaPeliculas.forEach(ESCRIBIDOR);
				
		Pantalla.escribirString("\nPeliculas de AVENTURA");
		for (Pelicula p: peliculas)
			if (p.getTipo().equals(TipoPelicula.AVENTURA))
				Pantalla.escribirString("\n" + p);
		
		Pantalla.escribirString("\nPeliculas de etiqueta divertida");
		for (Pelicula p: peliculas)
			if (p.contieneEtiqueta("divertida"))
				Pantalla.escribirString("\n" + p);
		
		Pantalla.escribirString("\nPeliculas de mas de 6 meses de creacion");
		for (Pelicula p: peliculas)
			if (ChronoUnit.MONTHS.between(p.getFechaCreacion(), p.getFechaEstreno())> 6)
				Pantalla.escribirString("\n" + p);
		
		// Mostrar la primera una peli­cula con precio superir a 50 euros
		boolean encontrado = false;
		 
		Iterator<Pelicula> iteradorPeliculas;
		iteradorPeliculas =  peliculas.iterator();
		while (iteradorPeliculas.hasNext() && !encontrado)
		{
			pelicula = iteradorPeliculas.next();
			//Pantalla.escribirString("\n" + pelicula);
			if (pelicula.getPrecio() > 50)
				encontrado = true;
		}
		
		if (encontrado)
			Pantalla.escribirString("\nLa peli que vale mas de 50 es :" + pelicula);
		else
			Pantalla.escribirString("\nNo hay peli que vale mas de 50 " );
		
		
	}
}
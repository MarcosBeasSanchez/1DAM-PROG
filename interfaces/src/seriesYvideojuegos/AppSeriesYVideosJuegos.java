package seriesYvideojuegos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppSeriesYVideosJuegos {

	private ArrayList <Entregable> entregables;
	
	
	public AppSeriesYVideosJuegos() {
		entregables = new ArrayList<>();
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppSeriesYVideosJuegos app = new AppSeriesYVideosJuegos();
		app.cargarDatos ();
		
		System.out.println("\n--------------------------------------------");
		app.entregar ();
		System.out.println("\n--------------------------------------------");
		app.contar ();
		System.out.println("\n--------------------------------------------");
		app.devolver ();
		System.out.println("\n--------------------------------------------");
		app.mostrarMaximos ();
		
	}
	
	public void cargarDatos ()
	{
		Entregable entregable;
		int tipo;
		
		for (int i = 0; i < 4; i++)
		{
			tipo = Teclado.leerInt("1. Serie 2. VideoJuego");
			
			if (tipo == 1)
			{
				/*
				entregable = new Serie ();
				((Serie)entregable).leerDatos();
				*/
				
				Serie s = new Serie ();
				s.leerDatos();
				entregable = s;
			}
			else
			{
				VideoJuego v = new VideoJuego ();
				v.leerDatos();
				entregable = v;
				
			}
			
			// No compruebo si ya estÃ¡ otro con el mismo tÃ­tulo
			if (!existeEntregable(entregable))
				entregables.add(entregable);
			else
				Pantalla.escribirString("\nYa existe");
		}
		
	}
	
	public boolean existeEntregable (Entregable e)
	{
		boolean existe = false;
		String titulo="";
		
		if (e instanceof Serie s) //pattern matching
			titulo = s.getTitulo();
		else if (e instanceof VideoJuego v)
			titulo = v.getTitulo();
		
		if (buscarPorTituloBueno(titulo) != null)
			existe = true;
		
		return existe;
	}
	
	public void entregar ()
	{
		
		String titulo;
		Entregable e;
		do
		{
			
			titulo = Teclado.leerString("titulo a entregar");
			e = buscarPorTituloBueno (titulo);
			if (e!= null)
			{
				e.entregar();
				Pantalla.escribirString("\nEntregado un " + e.getClass().getSimpleName() );
			}
			else
				Pantalla.escribirString("\nNo existe " + titulo);
		}while (Teclado.leerString("\nSeguir? (s/n)").equals("s"));
	}
	
	public Entregable buscarPorTitulo (String titulo)
	{
		// No funciona
		Entregable e = null;
		int lugar;
		lugar = entregables.indexOf (new Serie (titulo,""));
		if (lugar >= 0)
			e = entregables.get(lugar);
		
		return e;
	}
	
	public Entregable buscarPorTituloBueno (String titulo)
	{
		Predicate<Entregable> estaTitulo;
		Entregable e;
		e = null;
		ArrayList<Entregable> copia = new ArrayList<>();
		
		copia.addAll(entregables);
		estaTitulo = new TieneTitulo (titulo);
	
		copia.removeIf(estaTitulo.negate());
		
		if (!copia.isEmpty())
			e = copia.get(0);
		
		return e;
	}
	
		
	public void contar ()
	{
		int cuantos = 0;
		/*
		for (Entregable e: entregables)
		{
			if (e.isEntregado())
				cuantos++;
		}
		
		
		Pantalla.escribirString("\n\nHay entregados " + cuantos + " productos");
		Pantalla.escribirString("\nListado de productos");
		for (Entregable e : entregables)
			Pantalla.escribirString("\n"+ e);
		*/
		Predicate<Entregable> estaEntregado = new EstaEntregado();
		List<Entregable> copia = new ArrayList<>();		
		copia.addAll(entregables);
		copia.removeIf(estaEntregado.negate());
		cuantos = copia.size();
		Pantalla.escribirString("\n Articulos Entregados " + cuantos);
	}
	
	public void devolver ()
	{
		/*
		for (Entregable e: entregables)
			if (e.isEntregado())
				e.devolver();
		*/
		Predicate<Entregable> estaEntregado = new EstaEntregado();
		List<Entregable> copia = new ArrayList<>();		
		copia.addAll(entregables);
		copia.removeIf(estaEntregado.negate());//filtro
		copia.forEach(new Devolvedor()); // acciÃ³n
		
		Pantalla.escribirString("\n\nSe han devuelto todos los no entregados");
	}
	
	public void mostrarMaximos ()
	{
		List<Entregable> series, videojuegos;
		Predicate <Entregable> esSerie, esVideoJuego;
		Serie serie;
		VideoJuego videojuego;
		
		// Copiar entregables en series
		series = new ArrayList<> ();
		series.addAll(entregables);
		
		// Copiar entregables en videojuegos
		videojuegos = new ArrayList<>();
		videojuegos.addAll(entregables);
		
		// Filtro de series
		esSerie = new EsSerie ();
		
		// Filtro de Videojuegos
		esVideoJuego = new EsVideoJuego ();
		
		
		series.removeIf(esVideoJuego); // borrar todos los videojuegos
		videojuegos.removeIf(esSerie); // borrar todas las series
		
		serie = (Serie) Collections.max(series,new ComparadorPorTemporadas());
		videojuego = (VideoJuego) Collections.max(videojuegos,new ComparadorHoras());
		
		Pantalla.escribirString("\nLa serie con mas temporadas es " + serie);
		Pantalla.escribirString("\nEl videojuego con mas horas es " + videojuego);
	}
	

}
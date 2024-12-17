package llaveycerradura;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Cerradura {
	private static final int NBOMBINES = 3;
	private static final int NMAXIMOCORTES = 3;
	private static final int MAXIMOCORTE = 10;
	private static final int MINIMOCORTE = 0;
	
	
	// Lista de conjutos de enteros
	private List<Set<Integer>> bombines;
	
	public Cerradura (int cuantosBombines)
	{
		int cuantosCortes;
		TreeSet<Integer> cortes;
		int corte;
		
		cuantosBombines = Math.max(cuantosBombines, NBOMBINES);
		
		bombines = new ArrayList<>();
		
		for (int i = 0; i < cuantosBombines; i++)
		{
			cortes = new TreeSet<>();
			cuantosCortes = Libreria.generarAleatorio(1, NMAXIMOCORTES);
			
			bombines.add(cortes);
			
			for (int j = 0; j < cuantosCortes; j++)
			{
				do
				{
					corte = Libreria.generarAleatorio(MINIMOCORTE, MAXIMOCORTE);
				}while (!cortes.add(corte));
			}
		}
		
	}
	
	public Cerradura ()
	{
		this(NBOMBINES);
	}

	public List<Set<Integer>> getBombines() {
		return bombines;
	}

	public void setBombines(List<Set<Integer>> bombines) {
		this.bombines = bombines;
	}

	@Override
	public String toString() {
		return "Cerradura [bombines=" + bombines + "]";
	}
	
	public boolean abrirCerradura (Llave llave)
	{
		
		boolean abierta;
		
		abierta = llave.getPines().size() == bombines.size();
		
		for (int i = 0;abierta &&  i < bombines.size(); i++)
			abierta &= bombines.get(i).contains(MAXIMOCORTE - llave.getPines().get(i));
		
		
		return abierta;
		
		/*
		return llave.getPines().size() == bombines.size() &&
				Stream.iterate(0, n -> n+1).
					limit(bombines.size()).
					allMatch(i -> 
						bombines.get(i).contains(MAXIMOCORTE - llave.getPines().get(i)));
		*/
	}

}
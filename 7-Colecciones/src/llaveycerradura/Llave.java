package llaveycerradura;

import java.util.ArrayList;
import java.util.List;

public class Llave {
	private static final int NPINES = 3;
	private static final int ALTURAMAXIMAPIN = 10;
	private static final int ALTURAMINIMAPIN = 0;
	
	private List<Integer> pines;
	
	public Llave (int cuantosPines) {
		pines = new ArrayList<>();
		cuantosPines = Math.max(cuantosPines, NPINES);
		for (int i = 0; i < cuantosPines; i++)
			pines.add (Libreria.generarAleatorio(ALTURAMINIMAPIN, ALTURAMAXIMAPIN));
	}
	
	public Llave ()
	{
		this (NPINES);
	}

	public List<Integer> getPines() {
		return pines;
	}

	public void setPines(List<Integer> pines) {
		this.pines = pines;
	}
	

	@Override
	public String toString() {
		return "Llave [pines=" + pines + "]";
	}
	

}
package seriesYvideojuegos;

import java.util.ArrayList;
import java.util.List;

public enum Genero {
	COMEDIA, TERROR, FICCION, ACCION,SUSPENSE;
	
	public static Genero toGenero (String valor)
	{
		Genero genero;
		
		List<String> generos = new ArrayList<>();
		
		for (Genero g : Genero.values())
			generos.add(g.toString());
		
		if (generos.contains(valor.toUpperCase()))
		{
			genero = Genero.valueOf(valor.toUpperCase());
		}
		else
			genero = null;
			
		return genero;
	}

}
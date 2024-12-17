package colegio;

import java.util.ArrayList;
import java.util.List;


public enum TipoEstudios {
	// (ESO, Bachillerato, FP Grado Medio, FP Grado Superior).
	ESO,BACHILLERATO,CFGM,CFGS;
	
	public static TipoEstudios toEstudio (String valor)
	{
		TipoEstudios estudio;
		
		List<String> estudios = new ArrayList<>();
		
		//Recorres los valores de TipoEstudios añadiendolos a un array
		for (TipoEstudios g : TipoEstudios.values())
			estudios.add(g.toString());
		
		// Si el arrayt contiene el valor que le pasamos, lo guarda y despues lo devuelve
		if (estudios.contains(valor.toUpperCase()))
		{
			estudio = TipoEstudios.valueOf(valor.toUpperCase());
		}
		else
			// Sino lo de declara como Null
			estudio = null;
			
		return estudio;
	}
}

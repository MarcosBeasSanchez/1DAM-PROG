package coleccionesYFechas;

import java.util.HashSet;
import java.util.Set;

public enum Colectivo {
	PROFESOR,ALUMNO,EMPRESA,EXALUMNO;
	
	public static Set<String> valuesAsString ()
	{
		Set<String> values = new HashSet<>();
		
		for (Colectivo v: Colectivo.values())
			values.add(v.name());
		
		return values;
	}
	
}

package practicaFinal;

import java.util.ArrayList;
import java.util.List;

public enum Tipo {
	
	COMESTIBLE,LIMPIEZA,BELLEZA;
	
	public Tipo toTipo(String v) {
		Tipo tipo;
		
		List<String> tipos = new ArrayList<>();
		//añade al Array
		for (Tipo t : Tipo.values())
			tipos.add(t.toString());
		//Si contiene el valor lo devuelve
		if (tipos.contains(v.toUpperCase()))
		{
			tipo = Tipo.valueOf(v.toUpperCase());
		}
		else
			tipo = null;

		return tipo;

	}

}

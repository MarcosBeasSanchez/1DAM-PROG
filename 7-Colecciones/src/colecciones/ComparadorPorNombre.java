package colecciones;

import java.util.Comparator;

public class ComparadorPorNombre extends Alumno implements Comparator<Alumno> {

	//Se utiliza al implementar: alumnos= TreeSet<>(new ComparadorPorNombre());

	//Compara por nombre A-Z(OJO intentar ordenar siempre por claves Candidatas)
	
	@Override
	public int compare(Alumno o1, Alumno o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

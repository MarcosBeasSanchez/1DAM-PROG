package colecciones;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

import daw.com.Teclado;

public class AppColeccionAlumnos {

	public static void main(String[] args) {
		Set<Alumno> alumnos;
		Alumno alumno;
		String dni;
		Predicate <Alumno> notaMuyBaja;
		Iterator<Alumno> iterador;
		
				//HashSet or defecto no ordena
		alumnos = new HashSet<>(); // TreeSet<>();  // necesita Comparable en Alumno - Comparar por dni
								// TreeSet<>(new ComparadorPorNombre()); //Comprar por nombre
		do {
			dni =Teclado.leerString("dni");
			alumno = new Alumno(dni);
			if (alumnos.add(alumno)) { // porque los SET no hay repetidos.
				alumno.leerDatos();
				System.out.println("Alumno insertado correctamente");
			} else {
				System.out.println("\nEl alumno ya existe");
			}
			
			} while ("s".equals(Teclado.leerString("sigo? s/n")));
		
/*
		// 1º Opcion 
		notaMuyBaja = new Predicate<Alumno> ()
		{

			@Override
			public boolean test(Alumno t) {
				return t.getNota() < 2;
			}
	
		};
		
		alumnos.removeIf(notaMuyBaja);
		
		//2º opcion
		iterador =  alumnos.iterator();
		while(iterador.hasNext()) {
			alumno = iterador.next();
			if(alumno.getNota()<2) {
				iterador.remove();
			}
		}
*/
		for (Alumno a: alumnos)
			System.out.println("\n" + a);
	
		
	}
}

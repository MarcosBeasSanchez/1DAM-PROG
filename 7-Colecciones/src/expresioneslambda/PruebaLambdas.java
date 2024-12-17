package expresioneslambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;



public class PruebaLambdas {

	static final Consumer<Alumno> ESCRIBIDOR  = System.out::println;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Alumno> alumnos = new ArrayList<>();
		
		Comparator<Alumno> comparador;
		Predicate<Alumno> predicado;
		
		
		alumnos.add(new Alumno("001"));
		alumnos.add(new Alumno("002"));
		alumnos.add(new Alumno("003"));
		alumnos.add(new Alumno("004"));
		
		/*
		escribidor = (Alumno a) -> System.out.println(a);
		escribidor = a -> System.out.println(a);
		escribidor = System.out::println;
		*/

		alumnos.forEach(ESCRIBIDOR);
		
		
		comparador = (a1, a2) -> Integer.compare(a1.getNota(), a2.getNota());
		alumnos.sort(comparador);
		
		predicado = a -> a.getNota() >= 5;
		alumnos.removeIf(predicado.negate());
		
	}

}
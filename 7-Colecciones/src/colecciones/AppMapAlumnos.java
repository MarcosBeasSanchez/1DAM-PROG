package colecciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.BiConsumer;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppMapAlumnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map <String,Alumno> alumnos;
		Alumno alumno;
		String dni;
		BiConsumer<String, Alumno> biConsumidor;
		
		alumnos = new TreeMap ();
		
		do
		{
			dni = Teclado.leerString("\ndni");

			if (!alumnos.containsKey(dni))
			{
				alumno = new Alumno(dni);
				alumno.leerDatos();
				alumnos.put(dni, alumno);
				Pantalla.escribirString("\nAlumno insertado correctamente");

			}
			else
				Pantalla.escribirString("\nAlumno ya existe");

		}while ("s".equals(Teclado.leerString("sigo(s/n)")));
		
		
		alumno = alumnos.get("007");
		alumnos.remove("007");
	
		
		// mostrar las claves
		for (String d: alumnos.keySet())
			Pantalla.escribirString("\n" + d);
		
		// mostrar los valores
		for (Alumno a :alumnos.values())
			Pantalla.escribirString("\n" + a);
		
		// mostrar clave-valor
		for (Entry<String,Alumno> e: alumnos.entrySet())
		{
			Pantalla.escribirString("\n" + e.getKey());
			Pantalla.escribirString("\n" + e.getValue());
		}
		
		biConsumidor = new BiConsumer<String,Alumno> ()
				{

					@Override
					public void accept(String t, Alumno u) {
						// TODO Auto-generated method stub
						Pantalla.escribirString("\n" + t);
						Pantalla.escribirString("\n" + u);
					}
			
				};
		alumnos.forEach(biConsumidor);
	}

}

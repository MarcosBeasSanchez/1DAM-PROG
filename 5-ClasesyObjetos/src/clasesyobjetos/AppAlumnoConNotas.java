package clasesyobjetos;

import daw.com.Pantalla;

public class AppAlumnoConNotas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlumnoConNotas alumno,a1;
		int misNotas[];
		
		alumno = new AlumnoConNotas();
		
		a1 = new AlumnoConNotas("001", "yo", null,true);
		/*
		alumno.leerDatos();
		
		alumno.mostrarDatos();
		
		Pantalla.escribirFloat("nota media", alumno.getNotaMedia());
		
		for (int i = 0; i < alumno.getnNotas(); i++)
			alumno.setNotas(alumno.getNotas(i) + 1, i);
		
		alumno.mostrarDatos();
		
		*/
	
		
	}

}

/* Leer un conjunto de n alumnos (n se pide por el teclado). 
Mostrar por pantalla la media de las notas de cada alumno, junto con su nombre.
Mostrar la media de todo el grupo (la media de las medias).
Subir un punto en todas las notas a los alumnos que tenga su nota media por debajo de la media del grupo.
Mostrar todos los alumnos.
 */
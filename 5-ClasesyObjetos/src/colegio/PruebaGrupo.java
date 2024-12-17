package colegio;

public class PruebaGrupo {

	public static void main(String[] args) {

		Grupo g;
		Alumno alumno;
		
		g = new Grupo ();
		g.leerNombre();
		g.leerOtrosDatos();
		
		for (int i = 0; i < g.getNAlumnos(); i++)
		{
			 alumno = new Alumno ();
			 
			 do
			 {
				 alumno.leerDatosNia();
			 }while (g.buscarAlumno(alumno) != -1);
			 
			 alumno.leerOtrosDatos();
			 
			 g.addAlumno(alumno);
		}
		
		
		g.mostrarDatos();

	}

}
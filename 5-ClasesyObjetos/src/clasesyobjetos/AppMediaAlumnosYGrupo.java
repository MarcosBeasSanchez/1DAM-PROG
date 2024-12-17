package clasesyobjetos;
import daw.com.Pantalla;


public class AppMediaAlumnosYGrupo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlumnoConNotas alumnos[];
		int cuantos;
		float mediaGrupo=0, mediaAlumno;
		
		cuantos = Libreria.leerEnteroPositivo("Cuantos alumnos?");
		
		// crear array de objetos
		alumnos = new AlumnoConNotas[cuantos];
		
		for (int i = 0; i < alumnos.length; i++)
		{
			// crear el objeto
			alumnos[i] = new AlumnoConNotas();
			
			// leer sus datos del teclado
			alumnos[i].leerDatos();
		}
		
		for (int i = 0; i < alumnos.length; i++)
		{
			mediaAlumno = alumnos[i].getNotaMedia();
			Pantalla.escribirString("\n" + alumnos[i].getNombre() + "->"+ mediaAlumno);
			
			// acumular medias
			mediaGrupo += mediaAlumno;
		}
		
		// calcular la media del grupo
		mediaGrupo /= alumnos.length;
		Pantalla.escribirFloat("\nLa media del grupo es ", mediaGrupo);
		
		// subir un punto a los alumnos 
		// con media inferior a la media del grupo
		for (int i = 0; i < alumnos.length; i++)
		{
			if (alumnos[i].getNotaMedia() < mediaGrupo)
			{
				// Recorrer las notas del alumno i
				for (int j = 0; j < alumnos[i].getnNotas(); j++)
				{
					// alumnos[i].notas[j] = alumnos[i].notas[j] + 1
					alumnos[i].setNotas(alumnos[i].getNotas(j) + 1, j);
				}
			}
		}
			
		for (int i = 0; i < alumnos.length; i++)
			alumnos[i].mostrarDatos();
	}

}

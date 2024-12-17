package clasesyobjetos;

public class AppAlumno {

	public static void main(String[] args) {

	// creamos un array de alumnos, de la clase
	Alumno alumnos[] , alumno;
	
	int cuantosAlumnos = 3;
	alumnos = new Alumno [cuantosAlumnos];
	
			
			// inicializar array
			for (int i = 0; i < alumnos.length; i++)
				alumnos[i] = new Alumno ();

			// leer los alumnos
			alumno = new Alumno ();
			for (int i = 0; i < alumnos.length; i++)
				
			{
				do
				{
					alumno.leerNia();
				}while (buscarEnArray (alumnos, alumno) != true);
				alumnos[i].setNia(alumno.getNia());
				alumnos[i].leerOtrosDatos();

			}
			
			for ( int i = 0; i < alumnos.length ; i++) {
				
				alumnos[i].setNota(alumnos[i].getNota() + 1);	
				alumnos[i].mostrarDatos();
			}
			
			
			
	/* recorremos el arrray y si encuentra suspenso y repetidor , muestra su nombre
	for  ( int i = 0; i < alumnos.length ; i++) 
	{
		if(alumnos[i].isRepetidor() && alumnos[i].estaSupenso()) {
			Pantalla.escribirString(alumnos[i].getNombre());
			System.out.println();
		}		
	}*/

	}
	
	
	//Funcion que busca un nombre en el array si esta devuelve FALSE Si no TRUE
	public static boolean buscarEnArray(Alumno array[], Alumno a) {
	
		boolean posicion = true;
		
		for (int i = 0; i < array.length && posicion == true; i++)
			if (a.equals(array[i]))
				posicion = false;
		
		return posicion;
				
	}

}

package colegio; 


public class Escuela {
	private Grupo grupos[];

	public Escuela(Grupo[] grupos) {
		this.grupos = grupos;
	}
	
	public Escuela (int cuantos)
	{
		cuantos = cuantos <= 0 ? 1 : cuantos;
		grupos = new Grupo[cuantos];
		
		// todos los grupos a null para indicar que no hay grupo
	}
	
	public Escuela ()
	{
		this (3); // 3 grupos por defecto
	}

	public Grupo[] getGrupos() {
		return grupos;
	}

	public void setGrupos(Grupo[] grupos) {
		this.grupos = grupos;
	}
	
	public Grupo buscarGrupo (String nombre)
	{
		Grupo g = null;
		
		if (nombre != null && grupos != null)
		{
			for (int i = 0; g == null && i < grupos.length; i++)
				if (grupos[i] != null &&
							nombre.equalsIgnoreCase(grupos[i].getNombre()))
					g = grupos[i];
		}
	
		return g;
	}
	
	public int buscarGrupoAlumno (Alumno alumno)
	{
		
		int pos = - 1;
		
		for (int i = 0; pos == -1 && i < grupos.length; i++)
			if (grupos[i] != null)
				 if (grupos[i].buscarAlumno(alumno) != -1)
					 pos = i;
		return pos;
	}
	
	public boolean addAlumnoEnGrupo (Alumno a, String nombreGrupo)
	{
		boolean exito = false;
		Grupo g = buscarGrupo(nombreGrupo);
		
		if (g != null)
			if (buscarGrupoAlumno(a) == -1) // buscar grupo del alumno
				exito = g.addAlumno(a);
		
		return exito;
	}

	public boolean removeAlumno (String nia)
	{
		boolean exito = false;
		int posG, posA;
		Alumno a = new Alumno (nia);
		
		posG = buscarGrupoAlumno(a); // buscar el grupo del alumno
		
		if (posG != -1) // si existe el grupo 
		{
			posA = grupos[posG].buscarAlumno(a); // buscar posiciÃ³n del alumno en el grupo
			grupos[posG].setAlumno(posA, null); // borrar alumno
			exito = true;	
		}
		
		return exito;
	}
	
	public String[] listaTutores ()
	{
		String tutores[] = new String [grupos.length];
		int t = 0;
		for (int i = 0; i < grupos.length; i++)
			if (grupos[i] != null)
			{
				tutores[t] = grupos[i].getTutor();
				t++;
			}
		
		return tutores;
	}
	
	public int alumnosPorAsignatura (String nombre)
	{
		int cuantos = 0, cuantosAlumnos;
		
		
		// recorrer todos los grupos
		for (int i = 0 ; i < grupos.length; i++)
		{
			if (grupos[i] != null)
			{
				cuantosAlumnos = grupos[i].getNAlumnos();
				// recorrer los alumnos del grupo
				for (int j = 0; j < cuantosAlumnos; j++)

					if (grupos[i].getAlumno(j).buscarAsignatura(nombre) != -1)
						 cuantos++;
			}
		}
		
		return cuantos;
	}
	
	public Alumno[] listarAlumnosGrupo (String nombre)
	{
		Grupo g = buscarGrupo(nombre);
		Alumno alumnos[] = null;
		int cuantos;
		
		if (g != null)
		{
			cuantos = g.getNAlumnos();
			
			if (cuantos > 0)
			{
				alumnos = new Alumno[cuantos];
				
				for (int i = 0; i < cuantos; i++)
					alumnos[i] = g.getAlumno(i);
				
				ordenarAlumnos (alumnos);					
			}
		}
		
		return alumnos;
	}

	private void ordenarAlumnos(Alumno[] alumnos) {
		// TODO Auto-generated method stub
		Alumno aux;
		
		for (int i = 0; i < alumnos.length - 1; i++)
			for (int j = i+1; j < alumnos.length; j++)
				if (alumnos[i].getNombre().compareTo(alumnos[j].getNombre()) > 0)
				{
					aux = alumnos[i];
					alumnos[i] = alumnos[j];
					alumnos[j] = aux;
				}
	}
	
	
	
}
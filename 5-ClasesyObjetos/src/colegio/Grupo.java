package colegio;

import java.util.Arrays;

import clasesyobjetos.Libreria;
import daw.com.Pantalla;
import daw.com.Teclado;

public class Grupo {
private final static int NALUMNOS = 30;
	
	private String nombre;
	private String tutor;
	private Alumno alumnos[];
	
	
	public Grupo(String nombre, String tutor, Alumno[] alumnos) {
	
		this.nombre = nombre;
		this.tutor = tutor;
		setAlumnos (alumnos);
	}
	
	public Grupo (String nombre, String tutor)
	{
		this (nombre, tutor, NALUMNOS);
	}
	
	public Grupo (String nombre, String tutor, int cuantos)
	{
		this (nombre, tutor, null);
		if (cuantos < 1)
			cuantos = 1;
		else if (cuantos > NALUMNOS)
			cuantos = NALUMNOS;
		alumnos = new Alumno[cuantos];
	}
	
	
	public Grupo (String nombre)
	{
		this (nombre, "", NALUMNOS);
	}

	public Grupo ()
	{
		this ("");
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}


	public int getNAlumnos ()
	{
		return alumnos == null ? 0: alumnos.length;
	}
	
	public Alumno getAlumno (int cual)
	{
		Alumno alumno = null;
		
		if (alumnos != null)
		{
			if (cual < 0)
				cual = 0;
			else if (cual >= alumnos.length)
				cual = alumnos.length - 1;
			
			if (alumnos[cual] != null)
				alumno = new Alumno (alumnos[cual]);
		}
		
		return alumno;
	}
	
	public void setAlumnos(Alumno[] alumnos) {
		
		if (alumnos != null)
		{
			this.alumnos = new Alumno[alumnos.length];
			for (int i = 0; i < alumnos.length; i++)
			{
				if (alumnos[i] != null && 
							buscarAlumno (alumnos[i]) == -1) // no estÃ¡ aÃ±adido antes
					this.alumnos[i] = new Alumno (alumnos[i]);
			}
		}

	}
	
	public void setAlumno (int cual, Alumno alumno)
	{
		if (cual < 0)
			cual = 0;
		else if (cual >= alumnos.length)
			cual = alumnos.length - 1;
		
		if (alumno != null)
		{
			// comprobar que no existe
			if (buscarAlumno (alumno) == -1)
				alumnos[cual] = new Alumno(alumno);
		}
		else
			alumnos[cual] =  null;
		
	}

	
	public int buscarAlumno (Alumno alumno)
	{
		int pos = -1;
		
		for (int i = 0; pos == -1 && i < alumnos.length; i++ )
			if (alumnos[i] != null && 
						alumnos[i].equals(alumno))
				pos = i;
		
		return pos;
	}
	
	public boolean addAlumno (Alumno alumno)
	{
		boolean exito = false;
		
		if (alumno != null)
		{
			if (buscarAlumno (alumno) == -1) // no existe el alumno
			{
				// buscar hueco libre
				for (int i = 0; !exito && i < alumnos.length; i++)
				{
					if (alumnos[i] == null) // si hay hueco
					{
						exito = true;
						alumnos[i] = new Alumno (alumno);// insertar alumno en hueco
					}
				}
			}
		}
		
		return exito;
	}
	
	public void leerDatos ()
	{
		leerNombre ();
		leerOtrosDatos ();
	}

	public void leerOtrosDatos() {
		// TODO Auto-generated method stub
		int cuantos;
		tutor = Teclado.leerString("\nTutor");
		
		cuantos = Libreria.leerEntreLimites(1, NALUMNOS, "\nCuantos alumnos?");
		
		alumnos = new Alumno[cuantos];
	}

	public void leerNombre() {
		// TODO Auto-generated method stub
		nombre = Teclado.leerString("\nNombre Grupo");
		
	}

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + 
				", tutor=" + tutor + 
				", alumnos=" + (alumnos == null ? "sin alumnos" : Arrays.toString(alumnos)) + "]";
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\nnombre: " + nombre);
		Pantalla.escribirString("\ntutor: " + tutor);
		
		if (alumnos != null)
		{
			for (Alumno a : alumnos)
				if (a != null)
					a.mostrarDatos();
		}
		else
			Pantalla.escribirString("\nsin alumnos");
	}
	
	
	
	}
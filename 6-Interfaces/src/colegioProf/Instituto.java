package colegioProf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import daw.com.Pantalla;

public class Instituto {

	private List<Persona> personas;

	public Instituto() {
		personas = new ArrayList<>();
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public boolean addPersona(Persona persona) {
		boolean exito = false;
		List<Alumno> alumnos;
		Profesor profe;

		if (!personas.contains(persona)) {
			personas.add(persona);

			exito = true;

			if (persona instanceof Alumno)
				asignarTutor((Alumno) persona);
			else
			// buscar alumnos sin tutor y asignarlos a éste profe
			{
				alumnos = alumnosSinTutor();
				profe = (Profesor) persona;

				while (!profe.isFull() && alumnos.size() > 0) {
					profe.addTutorando(alumnos.get(0));
					alumnos.remove(0);
				}
			}

		}

		return exito;
	}

	public List<Alumno> alumnosSinTutor() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<>();
		Alumno alumno;

		for (Persona p : personas) {
			if (p instanceof Alumno) {
				alumno = (Alumno) p;
				if (buscarTutor(alumno) == null)
					alumnos.add(alumno);
			}
		}

		return alumnos;
	}

	public Persona getPersona(String nif) {
		Persona persona = null;
		int lugar;

		lugar = personas.indexOf(new Alumno(nif)); // Chapuza
		if (lugar >= 0)
			persona = personas.get(lugar);

		return persona;
	}

	public Profesor asignarTutor(Alumno alumno) {
		Profesor tutor = buscarTutor(alumno);
		List<Profesor> profesores = getProfesores();

		// comprobar si hay tutores libres y añadir tutorando
		for (int i = 0; tutor == null && i < profesores.size(); i++)
			if (!profesores.get(i).isFull()) {
				profesores.get(i).addTutorando(alumno);
				tutor = profesores.get(i);
			}

		return tutor;
	}

	public List<Profesor> getProfesores() {
		// Lista de profesores
		List<Profesor> profesores = new ArrayList<>();

		// se puede hacer con un predicado y un consumidor
		for (Persona p : personas)
			if (p instanceof Profesor)
				profesores.add((Profesor) p);

		return profesores;

	}

	public boolean eliminarPersona(String nif) {
		boolean exito = false;
		Profesor tutor;
		Persona persona = getPersona(nif);

		if (persona != null) {
			exito = true;
			personas.remove(persona);

			if (persona instanceof Profesor)
				reasignarTutor((Profesor) persona);
			else {
				tutor = buscarTutor((Alumno) persona);
				if (tutor != null)
					tutor.getTutorandos().remove(persona);
			}

		}

		return exito;

	}

	public void reasignarTutor(Profesor profesor) {
		Alumno a;
		List<Alumno> alumnos = profesor.getTutorandos();

		for (int i = 0; i < alumnos.size(); i++) {
			a = alumnos.get(i);
			asignarTutor(a);
		}
	}

	public Profesor buscarTutor(Alumno alumno) {
		Profesor tutor = null;
		List<Profesor> profesores = getProfesores();

		// Buscar tutor del alumno
		for (int i = 0; i < profesores.size() && tutor == null; i++)
			if (profesores.get(i).contieneTutorando(alumno))
				tutor = profesores.get(i);

		return tutor;
	}

}

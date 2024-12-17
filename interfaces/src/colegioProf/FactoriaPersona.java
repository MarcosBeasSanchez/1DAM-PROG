package colegioProf;

public class FactoriaPersona {
	public static Persona crearPersona(int tipo, String nif) {
		Persona persona;

		if (tipo == 1)
			persona = new Alumno(nif);
		else
			persona = new Profesor(nif);

		return persona;
	}
}

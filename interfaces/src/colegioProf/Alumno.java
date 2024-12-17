package colegioProf;

import java.util.Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Alumno extends Persona {

	private int curso;
	private String grupo;
	private TipoEstudios tipo;

	public Alumno(String nif) {
		super(nif);

		curso = 0;
		grupo = "";
		tipo = TipoEstudios.ESO;

	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		// comprobar si se puede el curso
		if (curso < 1)
			curso = 1;
		else if (curso > tipo.getCursos())
			curso = tipo.getCursos();

		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getTipo() {
		return tipo.toString();
	}

	public void setTipo(String tipo) {

		this.tipo = TipoEstudios.toTipoEstudios(tipo);
		setCurso(curso);
	}

	@Override
	public void identificar() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nEstudiante  -> " + getNombre());

	}

	public void leerDatos() {
		String tipo, tiposDeEstudio = "";

		super.leerDatos();
		curso = Teclado.leerInt("curso");
		grupo = Teclado.leerString("grupo");

		tiposDeEstudio = Arrays.toString(TipoEstudios.values());
		tipo = Teclado.leerString(tiposDeEstudio);

		this.tipo = TipoEstudios.toTipoEstudios(tipo);

	}

	@Override
	public String toString() {

		return super.toString() + "Alumno [curso=" + curso + ", grupo=" + grupo + ", tipo=" + tipo + "]";
	}

}

package colegioProf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.function.Consumer;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Profesor extends Persona {

	private String departamento;
	private String despacho;
	private ArrayList<Alumno> tutorandos;

	public Profesor(String nif) {
		super(nif);
		departamento = "";
		despacho = "";
		tutorandos = new ArrayList<>();
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	public ArrayList<Alumno> getTutorandos() {
		return tutorandos;
	}

	public void setTutorandos(ArrayList<Alumno> tutorandos) {
		this.tutorandos = tutorandos;
	}

	public boolean isFull() {
		return tutorandos.size() >= 9;
	}

	public boolean contieneTutorando(Alumno alumno) {
		return tutorandos.contains(alumno);
	}

	public boolean addTutorando(Alumno alumno) {
		boolean exito = false;

		if (!isFull() && !contieneTutorando(alumno)) {
			tutorandos.add(alumno);
			alumno.addMensaje(new Mensaje(getNif(), LocalDate.now(), "Bienvenido al instituto"));
			exito = true;
		}

		return exito;
	}

	public void convocarTutoria(LocalDate fecha) {
		String texto;

		Consumer<Alumno> mandarMensaje;

		texto = "Queda convocado a la sesión de tutoria en el despacho " + despacho + " con fecha " + fecha;

		mandarMensaje = new Consumer<Alumno>() {

			@Override
			public void accept(Alumno t) {
				// TODO Auto-generated method stub
				Mensaje m;
				m = new Mensaje(getNif(), LocalDate.now(), texto);
				t.addMensaje(m);
			}

		};

		tutorandos.forEach(mandarMensaje);

		/*
		 * for (Alumno t: tutorandos) { Mensaje m; m = new Mensaje
		 * (getNif(),LocalDate.now(), texto); t.addMensaje(m); }
		 */
	}

	@Override
	public void identificar() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nProfesor  -> " + getNombre());

	}

	public void leerDatos() {
		Pantalla.escribirString("\nLeyendo Profesor..");
		super.leerDatos();
		departamento = Teclado.leerString("departamento");
		despacho = Teclado.leerString("despacho");
	}

}

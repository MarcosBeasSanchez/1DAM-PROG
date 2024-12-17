package colegioProf;

import java.time.LocalDate;
import java.util.Date;

import daw.com.Teclado;

public class Mensaje {
	private String emisor;
	private final LocalDate fecha;
	private String contenido;

	public Mensaje() {
		this("", LocalDate.now(), "");

	}

	public Mensaje(String emisor, LocalDate fecha, String contenido) {

		this.emisor = emisor;
		this.fecha = fecha;
		this.contenido = contenido;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Mensaje [emisor=" + emisor + ", fecha=" + fecha + ", contenido=" + contenido + "]";
	}

	public void leerDatos() {
		emisor = Teclado.leerString();
		contenido = Teclado.leerString();
	}

}

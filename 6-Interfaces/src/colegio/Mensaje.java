package colegio;

import java.time.LocalDate;

import daw.com.Teclado;

public class Mensaje {
	private String emisor;
	private LocalDate fecha;
	private String contenido;
	
	//Constructores
	public Mensaje(String emisor, LocalDate fecha, String contenido) {
		this.emisor = emisor;
		this.fecha = fecha;
		this.contenido = contenido;
	}
	
	public Mensaje() {
		this("",LocalDate.now(),"");
	}
	
	public Mensaje(String nif, String mensaje) {
		this.emisor = nif;
		this.contenido =  mensaje;
		this.fecha = LocalDate.now();
	}
	
	//Getters Setters

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	//toString

	@Override
	public String toString() {
		return "Mensaje [emisor=" + emisor + ", fecha=" + fecha + ", contenido=" + contenido + "]";
	}
	
	//Datos
	
	public void leerDatos() {
		leerClave();
		leerOtrosDatos();
	}
	
	public void leerClave() {
		this.emisor = Teclado.leerString("Emisor");
	}
	
	public void leerOtrosDatos() {
		this.fecha = LocalDate.parse(Teclado.leerString("\nFecha de envio (aaaa-mm-dd)"));
		this.contenido = Teclado.leerString("Contnido del mensaje");
	}
	
	
	

	
	

}

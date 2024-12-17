package colegioProf;

import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;

public abstract class Persona {

	private String nif;
	private String nombre;
	private String poblacion;
	private int anio;
	private Buzon buzon;
	private Direccion direccion;
	private List<Telefono> agenda;

	public Persona() {

		this("");

	}

	public Persona(String nif) {

		this.nif = nif;
		this.nombre = "";
		this.poblacion = "";
		this.anio = 1999;
		this.buzon = new Buzon();
		this.direccion = new Direccion();
		this.agenda = new ArrayList<>();
	}

	public String getNif() {
		return nif;
	}

	private void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	private Buzon getBuzon() {
		return buzon;
	}

	private void setBuzon(Buzon buzon) {
		this.buzon = buzon;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Telefono> getAgenda() {

		return agenda;
	}

	public void setAgenda(List<Telefono> agenda) {
		this.agenda = agenda;

	}

	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", poblacion=" + poblacion + ", anio=" + anio + ", buzon="
				+ buzon.toString() + ", direccion=" + direccion + ", agenda=" + agenda + "]";
	}

	public void leerDatos() {
		this.nombre = Teclado.leerString("nombre");
		this.poblacion = Teclado.leerString("poblacion");
		this.anio = Teclado.leerInt("anio");

		this.direccion.leerDatos();

		do {
			Telefono t = new Telefono("", ""); // no hay constructor por defecto
			t.leerDatos();
			agenda.add(t);
		} while (Teclado.leerString("\nSigo").equals("S"));

	}

	public void leerCorreo() {
		buzon.leerBuzon();
	}

	public void addMensaje(Mensaje m) {
		buzon.addMensaje(m);
	}

	@Override
	public boolean equals(Object obj) {

		boolean iguales = true;
		Persona other = (Persona) obj;
		if (nif == null) {
			if (other.nif != null)
				iguales = false;
		} else if (!nif.equals(other.nif))
			iguales = false;

		return iguales;
	}

	public abstract void identificar();

}

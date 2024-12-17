package javapowersolutions;

import java.util.Objects;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Cliente {
	private final String cif;
	private String nombre;
	
	public Cliente(String cif, String nombre) {
		this.cif = cif;
		this.nombre = nombre;
	}

	public Cliente(String cif) {
		this (cif,"");
	}
	
	public Cliente() {
		this ("");
	}
	
	public String getCif() {
		return cif;
	}

	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cif, other.cif);
	}
	
	public void leerDatos ()
	{
		// leerClave (); es final
		leerOtrosDatos ();
	}

	public void leerOtrosDatos() {
		// TODO Auto-generated method stub
		nombre = Teclado.leerString("\nnombre cliente");
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + this);	
	}
	

}
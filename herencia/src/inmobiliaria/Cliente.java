package inmobiliaria;

import java.util.Objects;

import daw.com.Teclado;

public class Cliente {
	
	String dni, nombre;
	int presupuestoMax;
	
	public Cliente (String dni, String nombre, int presupuestoMax) {

	this.dni = dni;
	setNombre(nombre);
	setPresupuestoMax(presupuestoMax);
	}
	
	public Cliente ()
	{
		this ("","",0);
	}
	
	public Cliente(String dni) {
		this (dni, "", 0);
	}
	
	public Cliente (Cliente original)
	{
		this (original.dni, original.nombre,original.presupuestoMax);
	}
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		if (dni == null) {
			dni = "";
		}
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuestoMax() {
		return presupuestoMax;
	}

	public void setPresupuestoMax(int presupuestoMax) {
		if (presupuestoMax < 0) {
			presupuestoMax = 0;
		}
		this.presupuestoMax = presupuestoMax;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", presupuestoMax=" + presupuestoMax + "]";
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
		return Objects.equals(dni, other.dni);
	}
	
	public void leerDatos ()
	{
		leerClave();
		leerOtrosDatos();
	}
	
	public void leerClave ()
	{
		this.dni= Teclado.leerString("DNI");
	}

	public void leerOtrosDatos() {
		setNombre(Teclado.leerString("Nombre cliente"));
		setPresupuestoMax(Teclado.leerInt("Presupuesto Maximo"));
	}
	
	
	
	
}

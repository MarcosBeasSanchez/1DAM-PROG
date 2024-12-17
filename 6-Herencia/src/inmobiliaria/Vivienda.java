package inmobiliaria;

import java.util.Objects;

import daw.com.Teclado;

public abstract class Vivienda {
	private Direccion direccion;
	private int superficie;
	private String descripcion;
	private float pvp;
	
	
	public Vivienda(Direccion direccion, int superficie, String descripcion, float pvp) {

		setDireccion (direccion);
		setSuperficie (superficie);
		this.descripcion = descripcion;
		setPvp (pvp);
	}

	public Vivienda ()
	{
		this (new Direccion(), 0, "",0);
	}
	
	public Vivienda (Direccion direccion)
	{
		this (direccion, 0, "", 0);
	}
	
	public Vivienda (Vivienda original)
	{
		this (original.direccion, original.superficie,
				original.descripcion, original.pvp);
	}
	
	public Direccion getDireccion() {
		return new Direccion(direccion);
	}


	public void setDireccion(Direccion direccion) {
		if (direccion != null)
			this.direccion = new Direccion(direccion);
	}


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		if (superficie < 0)
			superficie = 0;
		
		this.superficie = superficie;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public float getPvp() {
		return pvp;
	}


	public void setPvp(float pvp) {
		if (pvp < 0)
			pvp = 0;
		this.pvp = pvp;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
	
		Vivienda other = (Vivienda) obj;
		return Objects.equals(direccion, other.direccion);
	}

	public void leerClave ()
	{
		direccion.leerDatos();
		
	}
	
	public void leerOtroDatos ()
	{
		setSuperficie (Teclado.leerInt("Superficie en m²"));
		this.descripcion = Teclado.leerString("Una breve descripcion");
		setPvp (Teclado.leerFloat("PVP "));
	}
	
	public void leerDatos ()
	{
		leerClave();
		leerOtroDatos();
	}
	
	public float getPrecioFinal ()
	{
		return pvp + getComision ();
	}
	
	abstract public float getComision ();

	@Override
	public String toString() {
		return "Vivienda [direccion=" + direccion + ", superficie=" + superficie + ", descripcion=" + descripcion
				+ ", pvp=" + pvp + ", precio final = " + getPrecioFinal() + "]";
	}

}
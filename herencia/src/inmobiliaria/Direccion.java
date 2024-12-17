package inmobiliaria;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Direccion {
	private String calle;
	private String portal;
	private String letra;
	private int piso;
	private String localidad;
	private String codigoPostal;

	public Direccion(String calle, String portal, String localidad, String codigoPostal,int piso, String letra) {
		this.calle = calle;
		this.portal = portal;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
		this.letra = letra;
		setPiso (piso);
	}
	public Direccion ()
	{
		this ("","","","",0,"");
	}
	
	public Direccion (Direccion original)
	{
		this (original.calle, original.portal,
				original.localidad, original.codigoPostal,
				original.piso, original.letra);
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		if (piso < -1)
			piso = -1;
		this.piso = piso;
	}
	
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", portal=" + portal + ", letra=" + letra + ", piso=" + piso
				+ ", localidad=" + localidad + ", codigoPostal=" + codigoPostal + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (codigoPostal == null) {
			if (other.codigoPostal != null)
				return false;
		} else if (!codigoPostal.equals(other.codigoPostal))
			return false;
		if (letra == null) {
			if (other.letra != null)
				return false;
		} else if (!letra.equals(other.letra))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (piso != other.piso)
			return false;
		if (portal == null) {
			if (other.portal != null)
				return false;
		} else if (!portal.equals(other.portal))
			return false;
		return true;
	}
	public void leerDatos ()
	{
		this.calle = Teclado.leerString("\ncalle");
		this.portal = Teclado.leerString("\nportal");
		this.localidad = Teclado.leerString("\nlocalidad");
		this.codigoPostal = Teclado.leerString("\ncodigo postal");
		setPiso (Teclado.leerInt("\npiso"));
		this.letra = Teclado.leerString("\nletra");
		
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\ncalle " + calle);
		Pantalla.escribirString("\nportal " + portal);
		Pantalla.escribirString("\nlocalidad " + localidad);
		Pantalla.escribirString("\ncodigo postal " + codigoPostal);
		Pantalla.escribirString("\npiso " + piso);
		Pantalla.escribirString("\nletra " + letra);
		
	}

	
}
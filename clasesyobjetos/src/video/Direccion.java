package video;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Direccion {
	private String calle;
	private String portal;
	private String localidad;
	private String codigoPostal;

	public Direccion(String calle, String portal, String localidad, String codigoPostal) {
		this.calle = calle;
		this.portal = portal;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}
	public Direccion ()
	{
		this ("","","","");
	}
	
	public Direccion (Direccion original)
	{
		this (original.calle, original.portal,
				original.localidad, original.codigoPostal);
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
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", portal=" + portal + ", localidad=" + localidad + ", codigoPostal="
				+ codigoPostal + "]";
	}
	
	public void leerDatos ()
	{
		this.calle = Teclado.leerString("\ncalle");
		this.portal = Teclado.leerString("\nportal");
		this.localidad = Teclado.leerString("\nlocalidad");
		this.codigoPostal = Teclado.leerString("\ncÃ³digo postal");
		
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\ncalle " + calle);
		Pantalla.escribirString("\nportal " + portal);
		Pantalla.escribirString("\nlocalidad " + localidad);
		Pantalla.escribirString("\ncÃ³digo postal " + codigoPostal);
	}

}
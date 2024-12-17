package colegio;

import java.util.Objects;

import daw.com.Teclado;

public class Direccion {
	
	private String calle, ciudad, cp, pais;
	
	//Constructores
	public Direccion(String calle,String ciudad, String cp, String pais) {
		this.calle = calle; 
		this.ciudad = ciudad;
		this.cp = cp; 
		this.pais = pais;
	}
	public Direccion() {
		this ("","","","");
	}
	
	//Getters setters
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	//tostring y equals 
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", ciudad=" + ciudad + ", cp=" + cp + ", pais=" + pais + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(calle, ciudad, cp, pais);
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
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(cp, other.cp) && Objects.equals(pais, other.pais);
	}
	
	//Datos
	public void leerDatos() {
		this.calle = Teclado.leerString("Nombre de la calle");
		this.ciudad = Teclado.leerString("Nombre de ciudad");
		this.cp = Teclado.leerString("Código postal");
		this.pais = Teclado.leerString("País");
	}
	
	
	

}

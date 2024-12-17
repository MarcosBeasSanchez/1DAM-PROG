package colegio;

import java.util.Objects;

import daw.com.Teclado;

public class Telefono {
	
	private String tipo, numero;
	
	//Constructores
	public Telefono(String tipo, String numero) {
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public Telefono() {
		this ("","");
	}
	//Getters Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	//Equals y tostring

	@Override
	public String toString() {
		return "Telefono [tipo=" + tipo + ", numero=" + numero + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		return Objects.equals(numero, other.numero) && Objects.equals(tipo, other.tipo);
	}
	
	//Datos
	
	public void  leerDatos() {
		this.numero =  Teclado.leerString("Num telefono");
		this.tipo =  Teclado.leerString("tipo ");
	}
	

}

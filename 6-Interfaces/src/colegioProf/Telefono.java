package colegioProf;

import java.util.Objects;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Telefono implements LeerYMostrarDatos {
	private String tipo;
	private String numero;

	public Telefono(String tipo, String numero) {

		this.tipo = tipo;
		this.numero = numero;
	}

	public Telefono clone() {
		return new Telefono(tipo, numero);
	}

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

	@Override
	public String toString() {
		return "Telefono [tipo=" + tipo + ", numero=" + numero + "]";
	}

	public void leerClave() {
		this.numero = Teclado.leerString("numero telef.");
	}

	public void leerRestoDatos() {
		this.tipo = Teclado.leerString("tipo telef");
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
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
		return Objects.equals(numero, other.numero);
	}

}

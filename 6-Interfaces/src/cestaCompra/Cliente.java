package cestaCompra;

import java.util.Objects;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Cliente {
	private final String cif;
	private String nombre;
	private float saldo;
	
	public Cliente(String cif, String nombre , float saldo) {
		this.cif = cif;
		this.nombre = nombre;
		setSaldo(saldo);
		
	}

	public Cliente(String cif) {
		this (cif,"",0);
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
	
	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo < 0 ? 0: saldo;
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
		saldo = Teclado.leerInt("Saldo del cliente");
	}
	

	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + this);	
	}
	

}
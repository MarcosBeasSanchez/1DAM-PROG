package javapowersolutions;

import java.util.Objects;

import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class Producto {
	private final String id;
	private String nombre;

	public Producto(String id, String nombre) {

		this.id = id;
		this.nombre = nombre;
	}
	
	public Producto(String id) {

		this(id,"");
	}
	
	public Producto() {

		this("");
	}
	
	public Producto (Producto original)
	{
		this(original.id, original.nombre);
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/* Por que hay herencia se quita
		if (getClass() != obj.getClass())
			return false;
		*/
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id);
	}
	
	public void leerDatos ()
	{
		//leerClave (); es final
		leerOtrosDatos ();
	}

	public void leerOtrosDatos() {
		// TODO Auto-generated method stub
		nombre = Teclado.leerString("\nnombre producto");
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precioFinal=" + getPrecioFinal() + "]";
	}

	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + this);	
	}
	
	public abstract float getPrecioFinal ();

	public float getPrecioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}

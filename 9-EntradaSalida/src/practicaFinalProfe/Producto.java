package practicaFinalProfe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Teclado;


public abstract class Producto implements Comparable<Producto>{
	private String referencia, nombre;
	private float precio;
	private int stock;
	
	public Producto ()
	{
		this ("");
	}
	
	public Producto (String referencia)
	{
		this (referencia,"",0,0);
	}
	
	public Producto(String referencia, String nombre, float precio, int stock) {

		this.referencia = referencia;
		this.nombre = nombre;
		setPrecio (precio);
		setStock (stock);
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) throws IllegalArgumentException
	{
		if (precio < 0)
			throw new IllegalArgumentException("precio negativo");
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) throws IllegalArgumentException
	{
		if (stock < 0)
			throw new IllegalArgumentException("stock negativo");
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}

	@Override
	public int compareTo(Producto o) {
		// TODO Auto-generated method stub
		return referencia.compareTo(o.referencia);
	}
	
	public void leerClave ()
	{
		referencia = Teclado.leerString("\nreferencia: ");
	}
	
	public void leerOtrosDatos ()
	{
		nombre = Teclado.leerString("\nnombre: ");
		
		// No sería bueno hacerlo así
		// Mejor con try-catch
		do
		{
			precio = Teclado.leerFloat("\nprecio");
		}while (precio < 0);
		
		stock = Libreria.leerEnteroPositivo("\nstock");
	}

	@Override
	public String toString() {
		return "Producto [referencia=" + referencia + 
				", nombre=" + nombre + 
				", precio=" + getPrecioVenta() + 
				", stock=" + stock	+ "]";
	}
	
	public abstract float getPrecioVenta ();
	
	public void escribirFichero (DataOutputStream filtro) throws IOException
	{
		filtro.writeUTF(referencia);
		filtro.writeUTF(nombre);
		filtro.writeFloat(precio);
		filtro.writeInt(stock);
		
	}
	
	public void leerFichero (DataInputStream filtro) throws IOException
	{
		referencia = filtro.readUTF();
		nombre = filtro.readUTF();
		
		try
		{
			setPrecio (filtro.readFloat());
		}
		catch (IllegalArgumentException e)
		{
			setPrecio (0);
		}
		
		try
		{
			setStock (filtro.readInt());
		}
		catch (IllegalArgumentException e)
		{
			setStock (0);
		}
		
	}

}

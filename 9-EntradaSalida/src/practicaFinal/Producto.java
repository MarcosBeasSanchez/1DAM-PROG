package practicaFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

import daw.com.Teclado;

public abstract class Producto implements LeerDatos{
	
	private static int CODIGOPRODUCTO=0;
	
	private int id = 0;
	private String nombre;
	private float precioCompra;
	int stock;

	public Producto(String nombre, float precioCompra, int stock) {
		Producto.CODIGOPRODUCTO++;
		this.id = Producto.CODIGOPRODUCTO;
		setNombre(nombre);
		setPrecioCompra(precioCompra);
		setStock(stock);
	}
	
	public Producto() {
		Producto.CODIGOPRODUCTO++;
		this.id = Producto.CODIGOPRODUCTO;
		this.nombre = "";
		this.precioCompra = 0;
		this.stock = 0;
	}
	
	//clave primaria
	public int getId() {
		return id;
	}

	public void setId(int id) throws IllegalArgumentException{
		if (id == 0) {
			throw new IllegalArgumentException("El ID no puede ser nulo");
		} 
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws IllegalArgumentException{
		if (nombre == null || nombre.equals("")) {
			throw new IllegalArgumentException("Error NOMBRE vacio no posible");
		}
		this.nombre = nombre;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precio) {
		if (precio < 0 ) {
			throw new  IllegalArgumentException("Precio de Compra, no puede ser < 0");
		}
		this.precioCompra = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock < 0) {
			throw new  IllegalArgumentException("Stock no puede ser < 0");
		}
		this.stock = stock;
	}
	
	public abstract float getPrecioVenta(); // almacena el precioFinal	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Producto other = (Producto) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precioCompra + ", stock=" + stock + "]";
	}

	@Override
	public void leerRestoDatos() {
		boolean valido;
		do {
			valido = false;
			try {
				setNombre(Teclado.leerString("Nombre Prodcuto"));
				setPrecioCompra(Teclado.leerFloat("Precio de Compra"));
				setStock(Teclado.leerInt("Nº de stock"));
			} catch (IllegalArgumentException e) {
				valido = true;
				System.out.println(e.getMessage());
			}
		} while (valido);
	}
	
	public void actualizarStock (int cantidad) {
		this.stock += cantidad;
		
	}
	
	public void escribirFichero (DataOutputStream filtro) throws IOException
	{
		filtro.writeInt(id);
		filtro.writeUTF(nombre);
		filtro.writeFloat(precioCompra);
		filtro.writeInt(stock);
		
	}
	
	public void leerFichero (DataInputStream filtro) throws IOException
	{
		id = filtro.readInt();
		nombre = filtro.readUTF();
		
		try
		{
			setPrecioCompra(filtro.readFloat());
		}
		catch (IllegalArgumentException e)
		{
			setPrecioCompra (0);
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

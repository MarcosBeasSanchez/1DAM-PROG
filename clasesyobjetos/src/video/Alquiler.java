package video;

import java.time.LocalDate;
import daw.com.Pantalla;

public class Alquiler {


    private Cliente cliente;
    private ProductoVC producto;
    private LocalDate fecha;
    private boolean alquilado;// es redundante ,al loro
	
    public Alquiler(Cliente cliente, ProductoVC producto, LocalDate fecha, boolean alquilado) {
	
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		setAlquilado (alquilado); 
	}

	public Alquiler(Cliente cliente, ProductoVC producto) {
		
		this (cliente, producto,LocalDate.now(),true);

	}
    
	public Alquiler ()
    {
        this (new Cliente(), new ProductoVC(), LocalDate.now(),false);
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ProductoVC getProducto() {
		return producto;
	}

	public void setProducto(ProductoVC producto) {
		this.producto = producto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		producto.setAlquilado(alquilado);
		this.alquilado = alquilado;
	}
    
	public boolean equals(Alquiler other) {
		
		
		return  other != null &&
				cliente.equals(other.cliente) && fecha.isEqual(other.fecha) && producto.equals(other.producto);
	}
	
	public String toString()
    {
        return cliente.getIdCliente() + "->" + producto.getTitulo() + "->" + fecha;
    }
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + this);
	}
	}
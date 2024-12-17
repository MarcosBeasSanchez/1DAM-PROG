package javapowersolutions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Oferta {
	private Cliente cliente;
	private LocalDate fecha;
	private List<Producto> productos;
	private boolean aceptada;
	
	public Oferta ()
	{
		this(new Cliente());
	}
	
	public Oferta (Cliente cliente)
	{
		this.cliente = cliente;
		fecha = LocalDate.now();
		productos = new ArrayList<>();
		aceptada = false;
		
	}
	
	public Oferta (Oferta original)
	{
		this.cliente = original.cliente;
		fecha = original.fecha;
		aceptada = original.aceptada;
		productos = new ArrayList<>(original.productos);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public boolean isAceptada() {
		return aceptada;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oferta other = (Oferta) obj;
		return Objects.equals(cliente, other.cliente) && 
				Objects.equals(fecha, other.fecha)&&
				compararProductos(productos, other.productos);
	}

	private boolean compararProductos(List<Producto> productos2, List<Producto> productos3) {
		// TODO Auto-generated method stub
		boolean iguales;
		
		iguales = productos2.size() == productos3.size(); 
		
		iguales = iguales && productos2.containsAll(productos3);
			
		return iguales;
	}

	@Override
	public String toString() {
		return "Oferta [cliente=" + cliente + ", fecha=" + fecha + ", productos=" + productos + ", aceptada=" + aceptada
				+ "]";
	}
	
	
	
}

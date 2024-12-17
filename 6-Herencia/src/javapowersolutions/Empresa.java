package javapowersolutions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private ArrayList<Comercial> comerciales;
	private ArrayList<Cliente> clientes;
	private ArrayList<Producto> productos;
	
	public Empresa ()
	{
		comerciales = new ArrayList<>();
		clientes = new ArrayList<>();
		productos = new ArrayList<>();
	}

	public ArrayList<Comercial> getComerciales() {
		return comerciales;
	}

	public void setComerciales(ArrayList<Comercial> comerciales) {
		this.comerciales = comerciales;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public boolean insertarProducto (Producto producto)
	{
		boolean exito = false;
		if (!productos.contains(producto))
			productos.add(producto);
		
		return exito;
	}
	
	public boolean insertarCliente (Cliente cliente)
	{
		boolean exito = false;
		if (!clientes.contains(cliente))
			clientes.add(cliente);
		
		return exito;
	}
	
	public boolean insertarComercial (Comercial comercial)
	{
		boolean exito = false;
		if (!comerciales.contains(comercial))
			comerciales.add(comercial);
		
		return exito;
	}
	
	public Comercial getComercial (String nif)
	{
		Comercial comercial = null,aBuscar;
		int cual;
		aBuscar = new Comercial (nif);
		
		if (comerciales.contains(aBuscar))
		{
			cual = comerciales.indexOf(aBuscar);
			comercial = comerciales.get(cual);
		}
		
		return comercial;
	}
	
	public Cliente getCliente (String nif)
	{
		Cliente cliente = null, aBuscar;
		int cual;
		
		aBuscar = new Cliente(nif);
		
		if (clientes.contains(aBuscar))
		{
			cual = clientes.indexOf(aBuscar);
			cliente = clientes.get(cual);
		}
			
		return cliente;
	}
	
	public Producto getProducto (String idProducto)
	{
		Producto producto = null,aBuscar;
		int cual;
		
		aBuscar = new Desarrollo (idProducto);
		
		if (productos.contains(aBuscar))
		{
			cual = productos.indexOf(aBuscar); // chapuza
			producto = productos.get(cual);
		}
	
		return producto;
	}
	
	public boolean insertarOferta (Comercial comercial, Cliente cliente, 
									ArrayList<Producto> productos, LocalDate fecha)
	{
		boolean exito = false;
		
		Oferta oferta = new Oferta(cliente);
		
		// Poner fecha a la oferta
		oferta.setFecha(fecha);
		
		// AÃ±adir productos a la oferta
		oferta.setProductos(productos);
		
		if (!comercial.getOfertas().contains(oferta))
		{
			comercial.addOferta(oferta);
			exito = true;
		}
		
		
		return exito;
	}
	
	public ArrayList<Oferta> getOfertasNoAceptadasComercialCliente (Comercial comercial, Cliente cliente)
	{
		ArrayList<Oferta> ofertasNoAceptadas = new ArrayList<>();

		
		for (Oferta f: comercial.getOfertas())
			if (!f.isAceptada()&& 
						f.getCliente().equals(cliente))
				ofertasNoAceptadas.add(f);
		
		return ofertasNoAceptadas;
	}
	
	public ArrayList<Oferta> getOfertasAceptadasCliente(Cliente cliente)
	{
		ArrayList<Oferta> ofertasAceptadas = new ArrayList<>();
		
		if (cliente != null)
			for (Comercial c: comerciales)
				for (Oferta f: c.getOfertas())
					if (f.getCliente().equals(cliente) && f.isAceptada())
						ofertasAceptadas.add(f);
					
		return ofertasAceptadas;
	}
	
	public ArrayList<Oferta> getOfertasNoAceptadas()
	{
		ArrayList<Oferta> ofertasNoAceptadas = new ArrayList<>();
		

			for (Comercial c: comerciales)
				for (Oferta f: c.getOfertas())
					if (!f.isAceptada())
						ofertasNoAceptadas.add(f);
					
		return ofertasNoAceptadas;
	}
	
	public ArrayList<Oferta> getOfertasAceptadasComercial (Comercial comercial)
	{
		ArrayList<Oferta> ofertasAceptadas = new ArrayList();
		
		if (comercial != null)
			for (Oferta f: comercial.getOfertas())
				if (f.isAceptada())
					ofertasAceptadas.add(f);
					
		return ofertasAceptadas;
	}
	
	public void aceptarOferta (Oferta oferta, Comercial comercial)
	{
		
		comercial.eliminarOferta(oferta);
		comercial.addOferta(oferta);
		
	}
}
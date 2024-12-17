package cestaCompra;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
	private List<Electrodomestico> electrodomesticos;
	private List<Cliente> clientes;

	public Tienda ()
	{
		electrodomesticos = new ArrayList<>();
		clientes = new ArrayList<>();
	}

	public List<Electrodomestico> getElectrodomesticos() {
		return electrodomesticos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public Electrodomestico getElectrodomestico (String identificador)
	{
		Electrodomestico aux, e = null;
		int lugar;
		
		aux = new Televisor (identificador); // chapuza
		
		lugar = electrodomesticos.indexOf(aux);
		
		if (lugar >= 0)
			e = electrodomesticos.get(lugar);
		
		return e;
	}
	
	public Cliente getCliente (String cif)
	{
		Cliente aux, c = null;
		int lugar;
		
		aux = new Cliente (cif);
		
		lugar = clientes.indexOf(aux);
		
		if (lugar >= 0)
			c = clientes.get(lugar);
		
		return c;	
	}
	
	public boolean insertarElectrodomestico (Electrodomestico e)
	{
		boolean exito = false;
		
		if (getElectrodomestico (e.getIdentificador()) == null) // si no esta lo añado
		{
			electrodomesticos.add(e);
			exito = true;
		}
		
		return exito;
	}
	
	public boolean insertarCliente (Cliente c)
	{
		boolean exito = false;
		
		if (getCliente (c.getCif()) == null)
		{
			clientes.add(c);
			exito = true;
		}
		
		return exito;
	}
	
	public boolean eliminarElectrodomestico (String identificador)
	{
		boolean exito = false;
		
		Electrodomestico e = getElectrodomestico(identificador);
		
		if (e != null) // Si existe el electrodomestico lo elimino
		{
			electrodomesticos.remove(e);
			exito = true;
		}
		
		return exito;
	}
	
	public boolean eliminarCliente (String cif)
	{
		boolean exito = false;
		
		Cliente c = getCliente(cif);
		
		if (c != null)
		{
			clientes.remove(c);
			exito = true;
		}
		
		return exito;
	}
	
	public float totalInventario ()
	{
		float total = 0;
		
		for (Electrodomestico e : electrodomesticos)
			total += e.precioFinal() * e.getStock();
		
		return total;
	}
	
}

package inmobiliaria;

import java.util.ArrayList;

public class Inmobiliaria {
	private ArrayList<Vivienda> viviendas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Visita> visitas;
	private String nombre;
	
	public Inmobiliaria ()
	{
		this ("");
		
	}

	public Inmobiliaria (String nombre)
	{
		this.nombre = nombre;
		viviendas = new ArrayList<>();
		clientes = new ArrayList<>();
		visitas = new ArrayList<>();
	}
	
	public Inmobiliaria (Inmobiliaria original)
	{
		this.nombre = original.nombre;
		
		viviendas = new ArrayList<>();
		
		for (Vivienda v: original.viviendas)
			viviendas.add(v);
		
		clientes = new ArrayList<>(original.clientes);
		visitas = new ArrayList<>(original.visitas);
	}
	
	public Vivienda getVivienda (int cual)
	{
		if (cual < 0)
			cual = 0;
		else if (cual > viviendas.size() - 1)
			cual = viviendas.size() - 1;
		
		return viviendas.get(cual);
	}
	
	public int getNViviendas ()
	{
		return viviendas.size();
	}
	
	public void setVivivenda (int cual, Vivienda v)
	{
		if (cual < 0)
			cual = 0;
		else if (cual > viviendas.size() - 1)
			cual = viviendas.size() - 1;
		
		if (!viviendas.contains(v))
			viviendas.set(cual, v);
	}

	public Vivienda getVivienda (Direccion direccion)
	{
		Vivienda v = null;
		int cual;
		
		cual = viviendas.indexOf(new ViviendaLibre(direccion));
		
		if (cual >= 0)
			v = viviendas.get(cual);
			
		return v;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean insertarVivienda (Vivienda v)
	{
		boolean exito = false;
		
		if (!viviendas.contains(v))
		{
			viviendas.add(v);
			exito = true;
		}
		
		return exito;
	}
	
	public boolean eliminarVivienda (Direccion direccion)
	{
		ArrayList<Visita> visitasVivienda;
		boolean exito = false;
		Vivienda v = getVivienda (direccion);
		
		if (v != null)
		{
			// eliminar las visitas de la vivienda
			visitasVivienda = getVisitasPorVivienda(v);
			visitas.removeAll(visitasVivienda);
			// eliminar la vivienda
			viviendas.remove(v);
			exito = true;
		}
		
		return exito;
	}

	@Override
	public String toString() {
		return "Inmobiliaria [viviendas=" + viviendas + ", clientes=" + clientes + ", visitas=" + visitas + ", nombre="
				+ nombre + "]";
	}


	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Visita> getVisitas() {
		return visitas;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setVisitas(ArrayList<Visita> visitas) {
		this.visitas = visitas;
	}

	public Cliente getCliente (String dni)
	{
		Cliente cliente = null;
		int cual;
		
		cual = clientes.indexOf(new Cliente (dni));
		
		if (cual >= 0)
			cliente = clientes.get(cual);
		
		return cliente;		
	}
	
	public void setCliente (int cual, Cliente cliente)
	{
		if (!clientes.contains(cliente))
		{
			if (cual < 0)
				cual = 0;
			else if (cual > clientes.size() - 1)
				cual = clientes.size() -1;

			clientes.set(cual, cliente);
		}
	}
	
	public boolean insertarCliente (Cliente cliente)
	{
		boolean exito = false;
		
		if (!clientes.contains(cliente))
		{
			clientes.add(cliente);
			exito = true;
		}
		
		
		return exito;
	}
	
	public boolean eliminarCliente (String dni)
	{
		boolean exito = false;
		Cliente cliente;
		ArrayList<Visita> visitasCliente;
		
		
		cliente = getCliente (dni);
		
		if (cliente != null)
		{
			// Borrado en cascada
			// eliminar visitas antes
			visitasCliente = getVisitasPorCliente (cliente);
			visitas.removeAll(visitasCliente);
			
			// eliminar cliente
			clientes.remove(cliente);
			
			exito = true;
		}
		
		return exito;
	}
	
	public ArrayList<Visita> getVisitasPorVivienda (Vivienda vivienda)
	{
		ArrayList<Visita> visitasVivienda = new ArrayList<>();
		
		if (vivienda != null)
		{
			for (Visita v : visitas)
				if (v.getVivienda().equals(vivienda))
					visitasVivienda.add(v);
		}
		
		return visitasVivienda;
	}
	
	public ArrayList<Visita> getVisitasPorCliente (Cliente cliente)
	{
		ArrayList<Visita> visitasCliente = new ArrayList<>();
		
		if (cliente != null)
		{
			for (Visita v : visitas)
				if (v.getCliente().equals(cliente))
					visitasCliente.add(v);
		}
		
		return visitasCliente;
	}
	

	public boolean insertarVisita (Visita visita)
	{
		boolean exito = false;
		
		if (!visitas.contains(visita))
		{
			visitas.add(visita);
			exito = true;
		}
		
		return exito;
	}
}
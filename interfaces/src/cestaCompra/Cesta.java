package cestaCompra;

import java.util.ArrayList;
import java.util.List;

public class Cesta {
	private Cliente cliente;
	private List <LineaCesta> lineas;

	public Cesta ()
	{
		this(null);
	}
	
	public Cesta (Cliente cliente)
	{
		this.cliente = cliente;
		lineas = new ArrayList<>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<LineaCesta> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaCesta> lineas) {
		this.lineas = lineas;
	}
	
	public void insertarLinea (LineaCesta linea)
	{
		int lugar = lineas.indexOf(linea);
		
		if (lugar <= 0) // insertar en la cesta no existe
			lineas.add(linea);
		else // cambiar la cantidad que ya habÃ­a
		{
			lineas.get(lugar).setCantidad(linea.getCantidad());
		}
	}
	
	public boolean eliminarLinea (LineaCesta linea)
	{
		boolean exito = false;
		
		int lugar = lineas.indexOf(linea);
		
		if (lugar >= 0)
		{
			lineas.remove(lugar);
			exito = true;
		}
		
		return exito;
	}
	
	public float getTotal ()
	{
		float total = 0;
		
		for (LineaCesta linea : lineas)
			total += linea.getTotal();
		
		return total;
	}
}
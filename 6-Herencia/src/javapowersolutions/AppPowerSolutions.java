package javapowersolutions;

import java.time.LocalDate;
import java.util.ArrayList;


import clasesyobjetos.Libreria;
import daw.com.Pantalla;
import daw.com.Teclado;


public class AppPowerSolutions extends AppConMenu {

	private Empresa empresa;
	
	public AppPowerSolutions() {
		super();
		
		addOpcion("Insertar Comercial");
		addOpcion("Insertar Cliente");
		addOpcion("Insertar Producto");
		addOpcion("Insertar Oferta");
		addOpcion("Aceptar Oferta");
		addOpcion("Listar ofertas aceptadas de un cliente");
		addOpcion("Listas ofertas realizadas no aceptadas de todos los clientes");
		addOpcion("Listar las ofertas aceptadas de un comercial");
		
		
		empresa = new Empresa ();
	}

	public static void main(String[] args) {
		AppPowerSolutions app = new AppPowerSolutions();
		
		app.run();
	}

	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub
		switch (opc)
		{
			case 1:
				addComercial();
				break;
			case 2:
				addCliente();
				break;
			case 3:
				addProducto();
				break;
			case 4:
				addOferta();
				break;
			case 5:
				aceptarOferta();
				break;
			case 6:
				listarOfertasAceptadasCliente();
				break;
			case 7:
				listarOfertasNoAceptadas();
				break;
			case 8:
				listarOfertasAceptadasComercial();
				break;
			case 9:
				salir();
				break;	
		}
		
	}

	private void addComercial() {
		// TODO Auto-generated method stub
		Comercial comercial;
		String mensaje = "Comercial ya existente";
		String nif;
		
		
		nif = Teclado.leerString("\nnif");
		comercial = new Comercial (nif);
		
		if (!empresa.getComerciales().contains(comercial))
		{
			comercial.leerOtrosDatos();
			empresa.insertarComercial(comercial);
			mensaje = "Comercial insertado correctamente";
		}
		
		Pantalla.escribirString("\n"+mensaje);
		
	}

	private void addCliente() {
		// TODO Auto-generated method stub
		Cliente cliente;
		String mensaje = "Cliente ya existente";
		String nif;
		
		nif = Teclado.leerString("\nnif");
		cliente = new Cliente (nif);
		
		if (!empresa.getClientes().contains(cliente))
		{
			cliente.leerOtrosDatos();
			empresa.insertarCliente(cliente);
			mensaje = "Cliente insertado correctamente";
		}
		
		Pantalla.escribirString("\n"+mensaje);
		
	}

	private void addProducto() {
		// TODO Auto-generated method stub
		int tipoProducto;
		Producto producto;
		String idProducto;
		String mensaje = "\nProducto ya existente";
		
		idProducto = Teclado.leerString("\nid producto");
		// chapuza
		producto = new Desarrollo (idProducto);
		
		
		if (!empresa.getProductos().contains(producto))
		{
			tipoProducto = Libreria.leerEntreLimites(1, 2, "\n1.Desarrollo - 2.FormaciÃ³n");
			if (tipoProducto == 2)
				producto = new Formacion(idProducto);
			
			producto.leerOtrosDatos();
			
			empresa.insertarProducto(producto);
			mensaje = "\nProducto aÃ±adido correctamente";
		}
		
		Pantalla.escribirString("\n" + mensaje);
	}

	private void addOferta() {
		// TODO Auto-generated method stub
		Comercial comercial;
		Cliente cliente;
		Producto producto;
		ArrayList<Producto> productos;

		
		comercial = leerComercialPorClave();
		
		if (comercial != null)
		{
			cliente = leerClientePorClave();
			
			if (cliente != null)
			{
				productos = new ArrayList<>();
				do
				{
					producto = leerProductoPorClave();
					if (producto != null)
						productos.add(producto);
					else
						Pantalla.escribirString("\nProducto no existe");
					
				}while (Teclado.leerString("\nsigo?").equalsIgnoreCase("s"));
				
				// aÃ±adir oferta al comercial
				if (empresa.insertarOferta(comercial, cliente, 
										productos, LocalDate.now()))
					Pantalla.escribirString("\nOferta aÃ±adida correctamente");
				else
					Pantalla.escribirString("\nOferta existente");
			}
			else
				Pantalla.escribirString("\nEl cliente no existe");
			
		}
		else
			Pantalla.escribirString("\nEl comercial no existe");
		
	}

	public void aceptarOferta() {
		// TODO Auto-generated method stub
		Cliente cliente;
		Oferta oferta;
		Comercial comercial;
		
		
		cliente = leerClientePorClave();
		
		if (cliente != null)
		{
			comercial = leerComercialPorClave();
			if (comercial != null)
			{
				oferta = leerOfertaNoAceptada (comercial,cliente);
				if (oferta!= null)
				{
					oferta.setAceptada(true); // aceptar la oferta
					empresa.aceptarOferta(oferta, comercial);
					Pantalla.escribirString("\nOferta aceptada " + oferta);
				}
				else
					Pantalla.escribirString("\nOferta no existente");
			}
			else
				Pantalla.escribirString("\ncomercial no existe");
		}
		else
			Pantalla.escribirString("\nCliente no existe");
		
	}

	private Oferta leerOfertaNoAceptada(Comercial comercial, Cliente cliente) {
		// TODO Auto-generated method stub
		
		Oferta oferta;
		ArrayList<Oferta> ofertasNoAceptadas; 
		int cual;
		
		ofertasNoAceptadas = empresa.getOfertasNoAceptadasComercialCliente(comercial, cliente);
		
		if (!ofertasNoAceptadas.isEmpty())
		{
			for (int i = 0 ; i < ofertasNoAceptadas.size(); i++)
				Pantalla.escribirString("\n" + i + "-" + ofertasNoAceptadas.get(i));
			
			cual = Libreria.leerEntreLimites(0,ofertasNoAceptadas.size() , "\nElija una oferta");
			oferta = ofertasNoAceptadas.get(cual); 
		}
		else
			oferta = null;
		
		return oferta;
	}

	public void listarOfertasAceptadasCliente() {
		// TODO Auto-generated method stub
		Cliente cliente = leerClientePorClave();
		ArrayList<Oferta> ofertasAceptadas;
		
		if (cliente != null)
		{
			ofertasAceptadas = empresa.getOfertasAceptadasCliente(cliente);
			if (!ofertasAceptadas.isEmpty())
				for (Oferta o: ofertasAceptadas)
					Pantalla.escribirString("\n" + o);
			else
				Pantalla.escribirString("\nNo hay ofertas");
		}
		else
			Pantalla.escribirString("\ncliente no existe");
	}

	public void listarOfertasNoAceptadas() {
		// TODO Auto-generated method stub
		ArrayList<Oferta> ofertasNoAceptadas;
		
		ofertasNoAceptadas = empresa.getOfertasNoAceptadas();
		if (!ofertasNoAceptadas.isEmpty())
			for (Oferta o: ofertasNoAceptadas)
				Pantalla.escribirString("\n" + o);
		else
			Pantalla.escribirString("\nNo hay ofertas");
	}

	public void listarOfertasAceptadasComercial() {
		// TODO Auto-generated method stub
		ArrayList<Oferta> ofertasAceptadas;
		Comercial comercial = leerComercialPorClave();
		
		
		if (comercial != null)
		{
			ofertasAceptadas = empresa.getOfertasAceptadasComercial(comercial);
			if (!ofertasAceptadas.isEmpty())
				for(Oferta o : ofertasAceptadas)
					Pantalla.escribirString("\n" + o);
			else
				Pantalla.escribirString("\nNo hay ofertas");
		}
		else
			Pantalla.escribirString("\ncomercial no existe");
	}

	public void salir() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nfin...");
	}
	
	public Comercial leerComercialPorClave ()
	{
		String nif;
	
		// mostrar todos los comerciales para elegir
		for (Comercial c : empresa.getComerciales())
			Pantalla.escribirString("\n" + c.getNif());
		
		nif = Teclado.leerString("\nnif");
			
		return empresa.getComercial(nif);
	}

	public Cliente leerClientePorClave ()
	{

		String nif;
		// Mostrar todos los clientes para elegir
		for (Cliente c: empresa.getClientes())
			Pantalla.escribirString("\n" + c.getCif());
		
		/*
		empresa.getClientes().stream().
					map(Cliente::getCif).
					forEachOrdered(System.out::println);
		*/
		
		nif = Teclado.leerString("\nif");
			
		return empresa.getCliente(nif);
	}
	public Producto leerProductoPorClave ()
	{

		String idProducto;

		// Mostrar todos los productos para elegir
		for (Producto p : empresa.getProductos())
			Pantalla.escribirString("\n" + p.getId());
		
		idProducto = Teclado.leerString("\nid producto");
		
		return empresa.getProducto(idProducto);
	}
}
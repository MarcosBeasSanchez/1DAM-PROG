package cestaCompra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import daw.com.Pantalla;
import daw.com.Teclado;


public class AppTienda extends AppConMenu {
	private Tienda tienda;
	
	public AppTienda ()
	{
		// Llamar al constructor padre
		super ();
		
		// Cargar Opciones de menÃº
		addOpcion("Hacer pedido");
		addOpcion("Mostrar inventario");
		addOpcion("Listar Clientes");
		
		
		// crear tienda
		tienda = new Tienda ();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppTienda app = new AppTienda();
		
		// cargar datos del teclado
		//RedirigirTeclado.fromFile("electrodomesticos.in");
		app.cargarDatos ();
		//RedirigirTeclado.fromKeyboard();
		
		// Ejecutar menu
		app.run();

	}

	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub
		
		switch (opc)
		{
			case 1:
				hacerPedido ();
				break;
			case 2:
				mostrarInventario ();
				break;
			case 3:
				listarClientes ();
				break;
			case 4:
				salir ();
		}
		
	}
	
		
	public void hacerPedido() {
		Cliente cliente;
		Cesta cesta;
		
		// Seleccionar cliente
		cliente = tienda.getCliente(Teclado.leerString("\nCIF cliente"));
		
		if (cliente!= null)
		{
			// Crear cesta para el cliente
			cesta = new Cesta (cliente);
			
			// hacer compra
			rellenarCesta (cesta);
			
			// comprobar saldo
			if (cliente.getSaldo() >= cesta.getTotal())
			{
				//actualizar stock productos
				actualizarStock (cesta);
				
				// actulizar saldo cliente
				cliente.setSaldo(cliente.getSaldo() - cesta.getTotal());
				
				// mostrar pedido
				mostrarPedido (cesta);
			}
			else
				Pantalla.escribirString("\nCliente sin saldo suficiente " + cliente.getSaldo() + "€" +
			"\nValor de cesta " + cesta.getTotal() + "€"); ;
				
		}
		else
			Pantalla.escribirString("\nCliente no dado de alta");
		
	}
	
	
	public void rellenarCesta(Cesta cesta) {
		String clave;
		Electrodomestico e;
		int cantidad;
		LineaCesta linea;
		
		do
		{
			clave = Teclado.leerString("identificador Electrodomestico");
			e = tienda.getElectrodomestico(clave);
			if (e != null) // comprobar que existe el producto
			{
				cantidad = Teclado.leerInt("\nCantidad de productos");
				if (cantidad <= e.getStock()) // comprobar que hay stock
				{
					linea = new LineaCesta (e, cantidad);
					cesta.insertarLinea(linea);
				}
				else
					Pantalla.escribirString("\nNo hay stock para esa cantidad");
			}
			else
				Pantalla.escribirString("\nNo existe producto");
			
		}while (Teclado.leerString("continuar?(s/n)").equals("s"));
		
	}

	public void actualizarStock(Cesta cesta) 
	{
		Electrodomestico e;
		
		for (LineaCesta linea : cesta.getLineas())
		{
			e = linea.getE();
			e.setStock(e.getStock() - linea.getCantidad());
		}
		
	}
	
	public void mostrarPedido(Cesta cesta) {
		
		Consumer<LineaCesta> accion = new MostrarLinea ();
		
		cesta.getLineas().forEach(accion);
		
		Pantalla.escribirString("\nTotal del pedido es " + cesta.getTotal());
		
	}

	
	public void mostrarInventario() {
		Comparator<Electrodomestico> comparador;
		Consumer<Electrodomestico> mostrarProducto;
		
		/*
		comparador = new Comparator<Electrodomestico>()
				{

					@Override
					public int compare(Electrodomestico o1, Electrodomestico o2) {
						// TODO Auto-generated method stub
						return Float.compare(o1.precioFinal(), o2.precioFinal());
					}
			
				};
		*/
		List<Electrodomestico> copia = new ArrayList<>();
		// Crear copia de productos para ordenar
		copia.addAll(tienda.getElectrodomesticos());
		
		// ordenar por precio 
		comparador = new ComparadorPorPrecio ();
		Collections.sort(copia,comparador);
		
		// Mostrar productos
		
		// Clase anonima
		mostrarProducto = new Consumer<Electrodomestico>()
				{

					@Override
					public void accept(Electrodomestico e) {
						// TODO Auto-generated method stub
						Pantalla.escribirString("\nIDproducto" + e.getIdentificador());
						Pantalla.escribirString("\tPrecioFinal " + e.precioFinal());
						Pantalla.escribirString("\tStock " + e.getStock());
					}
			
				};
		
		copia.forEach(mostrarProducto);
				
		// Mostrar total inventario
		Pantalla.escribirString("\nTotal inventario " + tienda.totalInventario());
	}

	public void salir() {
		Pantalla.escribirString("\nCiao bambino");
		
	}
	
	public void cargarDatos ()
	{
		cargarElectrodomesticos ();
		cargarClientes();
		
	}
	
	public void cargarElectrodomesticos ()
	{
		Electrodomestico e;
		String clave;
		int tipo;
		
		// Leer electrodomesticos
		do
		{
			clave = Teclado.leerString("\nIdentificador electrodomestico");
			
			if (tienda.getElectrodomestico(clave) == null){
				do
				{
					tipo = Teclado.leerInt("1.Lavadora - 2. Televisor");
				}while (tipo != 1 && tipo != 2);
				
				e = FactoriaElectrodomestico.crearElectrodomestico(tipo);
				
				e.setIdentificador(clave);
				
				e.leerRestoDatos();
				
				tienda.insertarElectrodomestico(e);
			}
			else
				Pantalla.escribirString("\nElectrodomestico ya dado de alta");
			
		}while (Teclado.leerString("Seguir? (s/n)").equalsIgnoreCase("s"));
		
	}
	
	public void cargarClientes ()
	{
		Cliente c;
		String clave;
		
		do
		{
			clave = Teclado.leerString("\nCIF cliente");
			
			if (tienda.getCliente(clave) == null)
			{
				c = new Cliente (clave);
				
				c.leerOtrosDatos();
				
				tienda.insertarCliente(c);
			}
			else
				Pantalla.escribirString("\nCliente ya dado de alta");
			
		}while (Teclado.leerString("Seguir? (s/n)").equalsIgnoreCase("s"));
	}
	
	public void listarClientes ()
	{
		/*
		for (Cliente c : tienda.getClientes())
			Pantalla.escribirString("\n" + c);
		*/
		Consumer<Cliente> mostrarCliente;
		
		// clase anonima
		mostrarCliente = new Consumer<Cliente>() {

			@Override
			public void accept(Cliente t) {
				// TODO Auto-generated method stub
				Pantalla.escribirString("\n" + t);
			}
			
		};
		
		tienda.getClientes().forEach(mostrarCliente);
		
	}

}

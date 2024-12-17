package video;

import daw.com.Pantalla;

public class VideoClub {
	private static final int MAXCLIENTES = 5;
	private static final int MAXPRODUCTOS = 10;
	private static final int MAXALQUILER = 20;
	
	private Cliente clientes[];// composicion
	private ProductoVC productos[]; //composicion
	private Alquiler alquileres[]; // composicion
	private String nombreVC;
	
	public VideoClub(Cliente[] clientes, ProductoVC[] productos, Alquiler[] alquileres, String nombreVC) {
	
		setClientes (clientes);
		setProductos (productos);
		setAlquileres (alquileres);
		this.nombreVC = nombreVC;
	}

	public VideoClub(String nombreVC) {

		this.nombreVC = nombreVC;
		
		clientes = new Cliente[MAXCLIENTES];
		productos = new ProductoVC[MAXPRODUCTOS];
		alquileres = new Alquiler[MAXALQUILER];
		
		// Cuidado todos estan a null 
		// cuando no se han usado
	}
	
	public VideoClub ()
	{
		this("");
	}

	public Cliente[] getClientes() {
		Cliente[] copia = null;
		
		if (clientes != null)
		{
			copia = new Cliente[clientes.length];
			for (int i = 0; i < clientes.length; i++)
				if (clientes[i]!= null)
					copia[i] = new Cliente(clientes[i]);
		}
		
		
		return copia;
	}

	public void setClientes(Cliente[] clientes) {
		if (clientes != null)
		{
			this.clientes = new Cliente[clientes.length];
		
			for (int i = 0; i < clientes.length;i++)
				if (clientes[i]!= null)
					this.clientes[i] = new Cliente(clientes[i]);
				else
					this.clientes[i] = null;
		}
		else
			this.clientes = new Cliente[MAXCLIENTES];			
		
	}

	public ProductoVC[] getProductos() {
		return productos;
	}

	public void setProductos(ProductoVC[] productos) {
		this.productos = productos;
	}

	public Alquiler[] getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(Alquiler[] alquileres) {
		this.alquileres = alquileres;
	}

	public String getNombreVC() {
		return nombreVC;
	}

	public void setNombreVC(String nombreVC) {
		this.nombreVC = nombreVC;
	}

	public void addCliente ()
	{
		Cliente cliente;
		
		if (contarClientesLibres() > 0)
		{
			cliente = new Cliente ();
			do
			{
				cliente.leerClave();
			}while (existeCliente(cliente));
			
			cliente.leerOtrosDatos();
			insertarCliente (cliente);
		}
		
	}

	public void insertarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		boolean insertado = false;
		for (int i = 0; i < clientes.length && !insertado; i++)
			if (clientes[i] == null)
			{
				clientes[i] = new Cliente(cliente);
				insertado = true;
			}
		
	}

	public boolean existeCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for (int i = 0; i < clientes.length && !existe; i++)
			if (cliente.equals(clientes[i]))
				existe = true;
		
		return existe;
	}

	public int buscarCliente (String id)
	{
		int pos = -1;
		
		for (int i = 0; i < clientes.length && pos == -1; i++)
			if (clientes[i] != null &&
					clientes[i].getIdCliente().equals(id))
				pos = i;
		
		return pos;
	}
	
	public void addProducto ()
	{
		ProductoVC producto ;
		
		if (contarProductosLibres() > 0)
		{
			producto = new ProductoVC ();
			do
			{
				producto.leerClave();
			}while (existeProducto(producto));
			
			producto.leerOtrosDatos();
			insertarProducto (producto);
		}
		
	}

	public void insertarProducto(ProductoVC producto) {
		// TODO Auto-generated method stub
		boolean insertado = false;
		for (int i = 0; i < productos.length && !insertado; i++)
			if (productos[i] == null)
			{
				productos[i] = new ProductoVC(producto);
				insertado = true;
			}
		
	}

	public boolean existeProducto(ProductoVC producto) {
		// TODO Auto-generated method stub
		boolean existe = false;
		
		for (int i = 0; i < productos.length && !existe; i++)
			if (producto.equals(productos[i]))
				existe = true;
		
		return existe;
	}

	public int buscarProducto (String id)
	{
		int pos = -1;
		
		for (int i = 0; i < productos.length && pos == -1; i++)
			if (productos[i] != null &&
					productos[i].getTitulo().equals(id))
				pos = i;
		
		return pos;
	}
	
	public boolean insertarAlquiler (Alquiler alquiler)
	{
		boolean encontrado = false;
		
		for (int i = 0; i < alquileres.length && !encontrado; i++)
			if (alquileres[i] == null)
			{
				encontrado = true;
				alquileres[i] = alquiler;
			}
		return encontrado;
	}
	
	public void alquilar ()
	{
		Cliente cliente = new Cliente ();
		ProductoVC producto = new ProductoVC ();
		Alquiler alquiler;
		// pedir clave cliente
		// comprobar si existe el cliente
		// comprobar si el cliente tiene algo alquilado
		if (alquileres[alquileres.length - 1] == null)
		{
			do
			{
				cliente.leerClave();
				
			}while(!existeCliente(cliente)
					|| clienteConAlquiler(cliente));
			
			
			/*
			int pos;
			String titulo = producto.getTitulo();
			pos = buscarProducto(titulo);
			productos[pos].isAlquilado()
			*/
			
			// pedir clave producto
			// comprobar si existe el producto
			// comprobar si el producto estÃ¡ alquilado
			
			do
			{
				producto.leerClave();
			}while (!existeProducto(producto) ||
					productos[buscarProducto(producto.getTitulo())].isAlquilado());
	
			
			// crear un alquiler nuevo
			cliente = clientes[buscarCliente(cliente.getIdCliente())];
			producto = productos[buscarProducto(producto.getTitulo())];
			alquiler = new Alquiler (cliente,producto);
			
			
			insertarAlquiler (alquiler);
			producto.setAlquilado(true);
			Pantalla.escribirString("\nProducto alquilado correctamente");
		}
		
		else
			Pantalla.escribirString("\nNo se ha podido alquilar Producto");
		
		
	}
	
	public void devolver ()
	{
		Cliente cliente = new Cliente();
		ProductoVC producto;
		cliente.leerClave();
		
		if (existeCliente(cliente) && clienteConAlquiler(cliente))
		{
			producto = devolverProductoAlquiladoPorCliente (cliente);

			Pantalla.escribirString("\nProducto devuelto");
			producto.mostrarDatos();
		}
		else
			Pantalla.escribirString("\nel cliente no existe o no tiene nada alquilado");
		
	}
	
	private ProductoVC devolverProductoAlquiladoPorCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		ProductoVC producto = null;
		int ultimo = alquileres.length -1;
				
		for (int i = ultimo ; i >= 0 && producto == null; i--)
			if (alquileres[i]!= null && 
					alquileres[i].getCliente().equals(cliente))
			{
				producto = alquileres[i].getProducto();
				alquileres[i].setAlquilado(false);
				producto.setAlquilado(false);
			}
		
				
		return producto;
	}

	public boolean clienteConAlquiler (Cliente cliente)
	{
		boolean alquilado = false;
		boolean encontrado = false;
		
		for (int i = alquileres.length -1; i >= 0 && !encontrado; i--)
			if (alquileres[i]!= null && 
					alquileres[i].getCliente().equals(cliente))
			{
				encontrado = true;
				alquilado = alquileres[i].isAlquilado();
			}
		
		
		return alquilado;
	}
	
	public int contarClientesLibres()
	{
		return contarLibres (clientes);
		/*
		int libres = 0;
		
		for (Cliente c: clientes)
			if (c == null)
				libres++;
		
		return libres;
		*/
	}
	
	public int contarProductosLibres()
	{
		return contarLibres (productos);
		/*
		int libres = 0;
		
		for (ProductoVC p: productos)
			if (p == null)
				libres++;
		
		return libres;
		*/
	}
	
	public <T> int contarLibres (T array[])
	{
		 int libres = 0;
		 
		 for (T t : array)
			 if(t == null)
				 libres++;
		 return libres;
	}
	
}
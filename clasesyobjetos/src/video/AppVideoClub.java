package video;

import clasesyobjetos.Libreria;
import daw.com.Pantalla;
import daw.com.Teclado;


public class AppVideoClub {

	private static final int SALIR = 9;
	private VideoClub vc;
	
	public AppVideoClub ()
	{
		 vc = new VideoClub ();
	}

	public static void main(String[] args) {
		int opc;
		
		AppVideoClub app = new AppVideoClub ();
		
		do
		{
			app.mostrarOpciones ();
			opc = Libreria.leerEntreLimites(1, SALIR, "\nElija su opcion..");
			app.evaluarOpcion (opc);
		}while (opc != SALIR);
	}
	
	private void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub
		
		switch (opc)
		{
			case 1:
					insertarCliente ();
					break;
			case 2:
					insertarProducto ();
					break;
			case 3:
					listarClientes ();
					break;
			case 4:
					listarProductosSinAlquilar ();
					break;
			case 5:
					alquilarProducto ();
					break;
			case 6:
					devolverProducto ();
					break;
			case 7:
					mostrarFichaCliente ();
					break;
			case 8:
					mostrarFichaProducto ();
					break;
			case 9:
					salir ();
					break;
		}
		
	}
	

	private void mostrarFichaProducto() {
		// TODO Auto-generated method stub
		String titulo;
		int pos;
		titulo = Teclado.leerString("ti­tulo producto");
		pos = vc.buscarProducto(titulo);
		
		if (pos == -1)
			Pantalla.escribirString("\nNo existe");
		else
			vc.getProductos()[pos].mostrarDatos();
		
		
	}

	private void mostrarFichaCliente() {
		// TODO Auto-generated method stub
		String id;
		int pos;
		id = Teclado.leerString("id cliente");
		pos = vc.buscarCliente(id);
		
		if (pos == -1)
			Pantalla.escribirString("\nNo existe");
		else
			vc.getClientes()[pos].mostrarDatos();
		
	}

	private  void insertarCliente() {
		// TODO Auto-generated method stub
		vc.addCliente();
	}

	private  void insertarProducto() {
		// TODO Auto-generated method stub
		vc.addProducto();
	}

	private  void listarClientes() {
		// TODO Auto-generated method stub
		for (Cliente cliente : vc.getClientes())
			if (cliente != null)
				cliente.mostrarDatos();	
	}

	private  void listarProductosSinAlquilar() {
		// TODO Auto-generated method stub
		for (ProductoVC producto : vc.getProductos())
			if (producto != null && !producto.isAlquilado())
				producto.mostrarDatos();
	}

	private  void alquilarProducto() {
		// TODO Auto-generated method stub
		vc.alquilar();
	}

	private  void devolverProducto() {
		// TODO Auto-generated method stub
		vc.devolver();
	}

	private  void salir() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nFIN...");
	}

	public  void mostrarOpciones() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n1.Insertar Cliente");
		Pantalla.escribirString("\n2.Insertar Producto");
		Pantalla.escribirString("\n3.Listar clientes");
		Pantalla.escribirString("\n4.Listar productos");
		Pantalla.escribirString("\n5.Alquilar producto");
		Pantalla.escribirString("\n6.Devolver producto");
		Pantalla.escribirString("\n7.Ficha cliente");
		Pantalla.escribirString("\n8.Ficha producto");
		Pantalla.escribirString("\n9.Salir");
	}

}
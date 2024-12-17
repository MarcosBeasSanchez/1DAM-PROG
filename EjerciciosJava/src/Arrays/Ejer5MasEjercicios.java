package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejer5MasEjercicios {
	
	final static String VACIO ="";

	public static void main(String[] args) {
		/*
		Que gestione los datos de stock de una tienda de comestibles, la información a recoger será:

		nombre del producto, precio, cantidad en stock. 

		La tienda dispone de 10 productos distintos. El programa debe ser capaz mostrar un menú con las siguientes opciones:

		1. Dar de alta un producto nuevo (no pueden repetir por nombre)
		2. Buscar un producto por su nombre. Pedimos el nombre y se muestra su precio y el stock.
		3. Modificar el stock y precio de un producto dado el nombre.
		4. Dar de baja un producto (dado el nombre).
		5. Salir. Mostrar todos los productos(nombre,precio,stock) ordenados alfabéticamente.
		*/
		
		final int CUANTOS=2, SALIR=5;
		
		String nombre[];
		int cantidad[],opcion;
		float pvp[];
		
		// Crear arrays
		nombre = new String[CUANTOS];
		cantidad = new int[CUANTOS];
		pvp = new float[CUANTOS];
		
		inicializarTienda (nombre,cantidad,pvp);
		
		do
		{
			mostrarOpciones ();
			opcion = Libreria.leerEntreLimites(0, SALIR, "\nElija una opcion: ");
			evaluarOpcion (opcion, nombre, cantidad,pvp);
		}while (opcion != SALIR);
		
	}

	public static void inicializarTienda(String[] nombre, int[] cantidad, float[] pvp) {
		for (int i = 0; i < nombre.length; i++)
		{
			nombre[i] = VACIO ;
			pvp[i] = 0;
			cantidad[i] = 0;
		}
	}
	
	public static void evaluarOpcion(int opcion, String[] nombre, int[] cantidad, float[] pvp) {
		switch (opcion)
		{
			case 0:
				mostrarTienda(nombre,cantidad, pvp);
			break;
			case 1:
				darAlta (nombre, cantidad, pvp);
				break;
			case 2:
				buscarProducto (nombre, cantidad, pvp);
				break;
			case 3:
				editarProducto (nombre, cantidad, pvp);
				break;
			case 4:
				eliminar (nombre, cantidad, pvp);
				break;
			case 5:
				listar (nombre, cantidad, pvp);
				Pantalla.escribirString("\nFIN");
				break;
		}
		
	}
	
	private static void mostrarTienda(String[]nombre, int[]cantidad,float[]precio) {
		
		System.out.println("LISTA DE PRODUCTOS");
		for(int i = 0 ; i < nombre.length; i++) {
			if (nombre[i].equals("")) {
				System.out.println("Producto " + (i + 1) + " vacio");
				
			} else {
				System.out.println("Nombre: " + nombre[i] +" | "+ "Cantidad: "+ cantidad[i]+" | " +"Precio: " +precio[i]);				
				}
		}
			
		
	}

	private static void eliminar(String[] nombre, int[] cantidad, float[] pvp) {
		String producto;
		int pos;
		
		// leer el nombre del producto a buscar
		producto = Teclado.leerString("Nombre producto: ");
		// comprobar si existe el producto
		pos = buscarPorNombre (producto, nombre);
		
		if (pos != -1)
		{
			nombre[pos] = VACIO;
			cantidad[pos] = 0;
			pvp[pos] = 0;
		}
		else
			Pantalla.escribirString("\nEl producto no existe\n");
	}

	private static void listar(String[] nombres, int[] cantidad, float[] pvp) {
		String tempNombre;
		int tempCantidad;
		float tempPvp;
		
		for (int i = 0; i < nombres.length - 1; i++)
			for (int j = i+1; j < nombres.length; j++)
				if (nombres[i].compareTo(nombres[j])> 0)
				{
					tempNombre = nombres[i];
					nombres[i] = nombres[j];
					nombres[j] = tempNombre;
					
					tempCantidad = cantidad[i];
					cantidad[i] = cantidad[j];
					cantidad[j] = tempCantidad;
					
					tempPvp = pvp[i];
					pvp[i] = pvp[j];
					pvp[j] = tempPvp;
				}
		for (int i = 0; i < nombres.length; i++)
			mostrarProducto(nombres[i], cantidad[i], pvp[i]);
		
	}

	private static void editarProducto(String[] nombre, int[] cantidad, float[] pvp) {
		String producto;
		int pos;
		
		// leer el nombre del producto a buscar
		producto = Teclado.leerString("Nombre producto: ");
		// comprobar si existe el producto
		pos = buscarPorNombre (producto, nombre);
		
		// si existe, mostrar producto y pedir nuevos datos
		if (pos != -1)
		{
			mostrarProducto (nombre[pos], cantidad[pos], pvp[pos]);
			cantidad[pos] = Teclado.leerInt("Nueva cantidad:");
			pvp[pos] = Teclado.leerFloat("Nuevo precio");
		}
		else
			Pantalla.escribirString("\nEl producto no existe:");
		
		
	}

	private static void buscarProducto(String[] nombre, int[] cantidad, float[] pvp) {
		String producto;
		int pos;
		
		// leer el nombre del producto a buscar
		producto = Teclado.leerString("Nombre producto: ");
		// comprobar si existe el producto
		pos = buscarPorNombre (producto, nombre);
		
		// si existe, mostrar producto
		if (pos != -1)
			mostrarProducto (nombre[pos], cantidad[pos], pvp[pos]);
		else
			Pantalla.escribirString("\nEl producto no existe\n");
		
	}

	private static void mostrarProducto(String nombre, int cantidad, float precio) {
		if (!nombre.equals(VACIO))
		{
			
			Pantalla.escribirString("\nNombre: " + nombre + " | ");
			Pantalla.escribirString(" Cantidad: " + cantidad + " | ");
			Pantalla.escribirString(" Pvp: " + precio + "\n" );
			
		}
		
	}

	private static void darAlta(String[] nombre, int[] cantidad, float[] pvp) {
		String producto;
		int pos;
		
		pos = buscarPorNombre (VACIO,nombre);
		// Si hay hueco libre insertar en el primer hueco libre
		if (pos != -1)
		{
			// leer el nombre del producto a insertar
			producto = Teclado.leerString("Nombre producto: ");
			
			// comprobar si existe el producto 
			if (buscarPorNombre (producto, nombre) == -1)
			{
				nombre[pos]= producto;
				pvp[pos] = Teclado.leerFloat("PVP: ");
				cantidad[pos] = Teclado.leerInt("Cantidad: ");

			}
			else
				Pantalla.escribirString("\nProducto ya existe\n");
		}
		else
			Pantalla.escribirString("\nNo se admiten mas productos\n");


	}

	private static int buscarPorNombre(String producto, String[] nombre) {
		int pos = -1;
		
		for (int i = 0; i < nombre.length && pos == -1; i++)
			if (producto.equalsIgnoreCase(nombre[i]))
				pos = i;
		return pos;
	}

	private static void mostrarOpciones() {
		System.out.println("===========================================");
		Pantalla.escribirString("0.Mostrar tienda.");
		Pantalla.escribirString("\n1.Dar de alta un producto nuevo.");
		Pantalla.escribirString("\n2.Buscar un producto por su nombre.");
		Pantalla.escribirString("\n3.Modificar el stock y precio de un producto dado.");
		Pantalla.escribirString("\n4.Eliminar un producto");
		Pantalla.escribirString("\n5.Salir\n");
		System.out.print("===========================================");
		
	}

}
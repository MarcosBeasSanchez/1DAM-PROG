package practicaFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.swing.text.html.HTMLDocument.Iterator;

import daw.com.Pantalla;
import daw.com.Teclado;
import practicaFinalProfe.AppConMenu;

public class AppAlmacen extends AppConMenu{
	
	public Map<Integer,Producto>almacen = new HashMap<>();

	
	public AppAlmacen() {
		super();
		addOpcion("Añadir producto");
		addOpcion("Modificar stock");
		addOpcion("Servir pedido");
		addOpcion("Mostrar lista precios");
		addOpcion("Eliminar caducados");
		addOpcion("importar csv");
		addOpcion("exportar csv");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppAlmacen app = new AppAlmacen();
		
		app.leerDatosEntrada();
		app.run();
		app.guardarDatos();

	}
	
	@Override
	public void evaluarOpcion(int opc) {
		switch (opc)
		{
			case 1:
				addProducto();
				break;
			case 2:
				modStock();
				break;
			case 3:
				servir();
				break;
			case 4:
				lista();
				break;
			case 5:
				caducados();
				break;
			case 6:
				importarCSV();
				break;
			case 7:
				exportarCSV();
				break;
		}

	}

	private void exportarCSV() {
		// TODO Auto-generated method stub
		
	}


	private void importarCSV() {
		// TODO Auto-generated method stub
		
	}


	public boolean existeProducto(int id) {
		//true si el producto existe
		return almacen.containsKey(id);
	}
	
	public void addProducto() throws IllegalArgumentException {
		int id,opc;
		Producto p;
		id = Teclado.leerInt("Id de producto");
		
		if (!existeProducto(id)) {
			opc= Teclado.leerInt("1.Perecedero/2.NoPerecedero");
			
			switch (opc) {
			case 1:
				p = new Perecedero();
				break;
			case 2:
				p= new NoPerecedero();
				break;

			default:
				throw new IllegalArgumentException("Respuesta no valida");
			}
			//LeerLosDatos
			p.leerDatos();
			//Añadirlo al almacen
			almacen.put(id, p);
		}else {
			System.out.println("El producto ya existe , imposible registrarlo");
		}
	}
	
	public void modStock() {
		int id,cantidad;
		id = Teclado.leerInt("Id de producto");
		
		if (existeProducto(id)) {
			do {
				cantidad = Teclado.leerInt("nº de stock a añadir a este producto");
			} while (cantidad < 0);
			//Obtener el procucto 
			Producto p = almacen.get(id);
			//cambiar Stock
			p.setStock(p.getStock() + cantidad);
				
		}else {
			System.out.println("El producto solicitado no existe");
		}
	}
	
	public void servir() {
		String opc;	
		int id,c = 0 ;
		float pedidoTotal = 0 ,s;
		Producto p = null;
		Map<Producto,Integer>pedido = new HashMap<>();;
		
		
		do {
			id = Teclado.leerInt("Id de producto");
			if (existeProducto(id)) {
				p = almacen.get(id);
				c = Teclado.leerInt("Cantidad de unidades a servir");
				
				if (c > p.getStock()) {
					System.out.println("Imposible servir , stock " + p.getStock() + " ,solicitado: " + c);
				}
				
			}else {
				System.out.println("El producto no existe el producto " + id);
			}
			
			s = c * p.getPrecioVenta(); // Cantidad * precio
			pedidoTotal += s; // Precio de todos los productos sumados
			
			pedido.put(p,c);
			p.actualizarStock(-c);
			
			opc = Teclado.leerString("Sigo s/n");
			
			
		} while (opc.equalsIgnoreCase("s"));
		
		 System.out.println("Resumen del pedido:");
	        for (Map.Entry<Producto, Integer> entry : pedido.entrySet()) {
	        	
	            Producto producto = entry.getKey();
	            int cantidad = entry.getValue();
	            double subtotal = cantidad * producto.getPrecioVenta();
	            
	            System.out.println("Producto: " + producto.getNombre() + ", Precio: " + producto.getPrecioVenta() +
	                    ", Cantidad: " + cantidad + ", Subtotal: " + subtotal);
	        }
	        System.out.println("Total del pedido: " + pedidoTotal);
	    }
	
	public void lista() {
        List<Producto> listaProductos = new ArrayList<>(almacen.values());
        
        //ordena la lista por precio de venta de mayor a menor
        listaProductos.sort(Comparator.comparingDouble(Producto::getPrecioVenta).reversed());

        System.out.println("----- Lista de precios -----");
        for (Producto producto : listaProductos) {
        	System.out.println("\n------------------------");
            System.out.println("Número de referencia: " + producto.getId());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Stock: " + producto.getStock());
            System.out.println("Precio de venta: " + producto.getPrecioVenta());
        }
    }
	
	public void caducados() {
		List<Producto>lista;
		float total = 0, subtotal;
		
		lista = new ArrayList<> (almacen.values());
		
		for (Map.Entry<Integer, Producto> e : almacen.entrySet()) {
			Integer key = e.getKey();
			Producto val = e.getValue();
			
			if (val instanceof Perecedero && ((Perecedero) val).estaCaducado() ) {
				//añade el producto caducado a la Lista
				lista.add(val);
				//subtotal
				subtotal = val.getPrecioCompra() * val.getStock();
				System.out.println("\n + " + val.getId() + ", " + val.getNombre() + " , " + subtotal);
				//total 
				total += subtotal;
				//lo elimina del almacen
				almacen.remove(key);
			}
		}
		System.out.println("\n total € productos caducados = " + total);
	}
	
	public void salida() {
		System.out.println("Adios");
	}
	
	public void guardarDatos() {
		// TODO Auto-generated method stub
		
		try (DataOutputStream filtro = new DataOutputStream (new FileOutputStream("productos.dat"))){
			//cantidad de prodcutos
			filtro.writeInt(almacen.size());
			
			
			for (Producto p : almacen.values())
			{
				//filtro.writeUTF(p.getClass().getName());
				if (p instanceof Perecedero)
					filtro.writeUTF("Perecedero");
				else
					filtro.writeUTF("NoPerecedero");
				
				p.escribirFichero(filtro);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Pantalla.escribirString("\nerror guardando datos");
		}
		
	}

	public void leerDatosEntrada() {
		// TODO Auto-generated method stub
		String tipoProducto;
		Producto p;
		try(DataInputStream filtro = new DataInputStream (new FileInputStream("productos.dat")))
		{
			int cuantos = filtro.readInt();
			
			for (int i = 0; i < cuantos; i++)
			{
				try
				{
					tipoProducto = filtro.readUTF();
					p = FactoriaProducto.build(tipoProducto);
		
					p.leerFichero(filtro);
				
					almacen.put(p.getId(), p);
				}
				catch (IllegalArgumentException e)
				{
					Pantalla.escribirString("\nTipo de producto sin identificar en lectura de fichero");
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Pantalla.escribirString("\nNo hay datos guardados");
		}
		
	}
	
	
	

	

}

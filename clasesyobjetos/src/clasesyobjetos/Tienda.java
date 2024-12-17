package clasesyobjetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Tienda {
	
	// Estado de la clase
	private String nombre ;
	private float precio;
	private  int cantidad;
	private boolean caducidad;
	
	//////////////////////////////////////////////////////////////////
	
	// Constructor por defecto
	public Tienda ()
	{
		nombre = "";
		precio = 0;
		cantidad = 0;
		caducidad = true;
	}
	
	// Constructor con todos los parametros
	public Tienda (String name, float price, int stock , boolean expiration)
	{
		setNombre(name);
		precio = price;
		cantidad = stock;
		caducidad =  expiration;
				
	}
	// Constructor con el nombre predefinido
	public Tienda (String name)
	{
		setNombre(name);
		precio = 0;
		cantidad = 0;
		caducidad = true;
	}
	
	/////////////////////////////////////////////////////////////////////
	
	// Selectores y MOD
	
	public String getNombre ()
	{
		return nombre;
	}
	public void setNombre (String name)
	{
		if (name == null)
			name = "";
		
		nombre = name;
	}
	
	public float getPrecio ()
	{
		return precio;
	}
	
	public void setPrecio (float price)
	{
		precio = price;
	}
	
	public int getCantidad() 
	{
		return cantidad;
	}
	
	public void setCantidad(int stock) 
	{
		cantidad = stock;
	}

  ///////////////////////////////////////////////////////////////////
		
	public void leerDatos ()
		{
		 String caducidadToBoolean;
		 
			setNombre (Teclado.leerString("NOMBRE? = "));
			precio = Teclado.leerFloat("PRECIO? = ");
			cantidad = Teclado.leerInt("CANTIDAD = ?");
			caducidadToBoolean = Teclado.leerString("CADUCIDAD? S/N = ");
			if (caducidadToBoolean.equalsIgnoreCase("S")) {
				caducidad = true;
			}else if (caducidadToBoolean.equalsIgnoreCase("N")) {
				caducidad = false;
			} else {
				do {
					System.out.println("DATOE ERRONEOS, INTRODUCE DE NUEVO");
					leerDatos();
				}while(caducidad == true || caducidad == false);
			}
		}
		
	public void mostrarDatos ()
		{
			Pantalla.escribirString( "Nombre = ", nombre);
			Pantalla.escribirFloat("Precio = ", precio);
			Pantalla.escribirInt("Cantidad = ", cantidad);
			System.out.println( "Caducidad = " + caducidad);
		}
	

	}


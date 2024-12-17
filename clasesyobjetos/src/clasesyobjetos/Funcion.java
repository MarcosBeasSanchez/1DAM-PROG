package clasesyobjetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Funcion {
	//Estado clase
	private static final float PRECIOMINIMO = 1;
	private String nombre;
	private float precio;
	
	//Constructores
	
	public Funcion(String nombre, float precio) {

		this.nombre = nombre; 
		setPrecio  (precio);
	}
	
	public Funcion () 
	{
		this ("",0); // pone vacio y 0 al crear funcion 
	}
	
	public Funcion (Funcion original) // copia
	{
		this (original.nombre, original.precio);
	}

	public Funcion (String nombre)
	{
		this (nombre,0);
	}
	
	// Getters y setters 
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) { //Establece un precio minimo = 1
		if (precio < PRECIOMINIMO)
			precio = PRECIOMINIMO;
		
		this.precio = precio; 
	}
	
	@Override
	public String toString() {
		return "Funcion [nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	public boolean equals (Funcion otra) //retorna true o false si la funcion esta ya escrita
	{
		return otra != null  &&  nombre.equalsIgnoreCase(otra.nombre);
	}
	
	public void leerDatos ()
	{
		leerClave (); //Lee nombre funcion
		leerRestoDatos (); // Lee precio funcion
	}

	public void leerRestoDatos() {
		do
		{
			precio = Teclado.leerFloat("\nPrecio Funcion ");
		}while (precio < PRECIOMINIMO);
	}

	public void leerClave() {
		nombre = Teclado.leerString("\nNombre Funcion");
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\nNombre funcion: "+ nombre);
		Pantalla.escribirString("\nPrecio funcion: " + precio );
	}
}
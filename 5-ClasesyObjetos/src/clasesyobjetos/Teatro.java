package clasesyobjetos;

import java.util.Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;
import video.Direccion;

// Estado de la calse 
public class Teatro {
	private static final int FUNCIONES = 4;
	private String nombre; // nombre del teatro
	private Direccion direccion; // Direccion del teatro
	private Funcion funciones[]; // Array de funciones(varias funciones en un teatro)
	
	public Teatro(String nombre, Direccion direccion, Funcion[] funciones) { 
		this.nombre = nombre;
		setDireccion(direccion); // composicion
		setFunciones(funciones); // agregacion
	}
	
	public Teatro (String nombre)
	{
		this (nombre, new Direccion(), new Funcion[FUNCIONES]);
	}
	
	public Teatro ()
	{
		this ("");
	}

	public Teatro (Teatro original)
	{
		this (original.nombre, original.direccion,
				original.funciones);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		// devolver copia dura
		return new Direccion(direccion);  // composiciÃ³n
	}

	public void setDireccion(Direccion direccion) {
		// copia dura
		this.direccion = direccion != null? new Direccion (direccion): new Direccion();
	}

	public Funcion[] getFunciones() {
		return funciones; // agregaciÃ³n 
	}

	public void setFunciones(Funcion[] funciones) {
		if (this.funciones == null) // si no esta¡ creado el array
			this.funciones = new Funcion[FUNCIONES];
		
		for (int i = 0; i < this.funciones.length; i++)
			this.funciones[i] = funciones[i]; // copia blanda
	}
	
	
	public Funcion getFuncion (int cual)
	{
		Funcion funcion = null;
		
		if (cual >= 0 && cual < funciones.length)
			funcion = funciones[cual];
		
		return funcion;
	}
	
	public void setFuncion (int cual, Funcion funcion)
	{
		if (cual >= 0 && cual < funciones.length)
			this.funciones[cual] = funcion; // copia blanda
		
	}
	
	public boolean equals (Teatro otro)
	{
		return otro!= null &&
				nombre.equals(otro.nombre);
	}

	@Override
	public String toString() {
		return "Teatro [nombre=" + nombre + ", direccion=" + direccion + 
				", funciones=" + Arrays.toString(funciones) + "]";
	}
	
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}

	public void leerOtrosDatos() {
		direccion.leerDatos();
		
		// No se pueden leer las funciones, 
		// tiene que ser una funcion que exista.
		// Hay que leer fuera de la clase
	}

	public void leerClave() {
		// TODO Auto-generated method stub
		nombre = Teclado.leerString("\nNombre Teatro");
 
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\nNombre teatro : " + nombre);
		direccion.mostrarDatos();
		
		for (int i = 0; i < funciones.length; i++)
			if (funciones[i] != null)
				funciones[i].mostrarDatos();
	}

}
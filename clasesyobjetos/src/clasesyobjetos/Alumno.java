package clasesyobjetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Alumno {
	// constantes
	private static final int NOTAMINIMA = 1;
	private static final int NOTAMAXIMA = 10;
	
	// Estado de la clase
	private String nia;
	private String nombre;
	private int nota;
	private boolean repetidor;
	
	// Constructores
	public Alumno (String nia, String nombre, int nota, boolean repetidor)
	{
		setNia (nia);
		setNombre (nombre);
		setNota (nota);
		this.repetidor = repetidor;
	}
	
	public Alumno ()
	{
		this ("");
	}
	
	public Alumno (String nia)
	{
		this (nia, "", NOTAMINIMA, false);
	}
	
	// Constructor copia
	public Alumno (Alumno original)
	{
		this (original.nia, original.nombre, 
				original.nota, original.repetidor);
	}
	
	// Selectores y modificadores
	public String getNia ()
	{
		return nia;
	}
	public void setNia (String nia)
	{
		if (nia == null)
			nia = "";
		
		this.nia = nia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null)
			nombre = "";
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		if (nota < NOTAMINIMA)
			nota = NOTAMINIMA;
		else if (nota > NOTAMAXIMA)
			nota = NOTAMAXIMA;
		
		this.nota = nota;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}
	
	public void leerDatos ()
	{
		leerNia ();
		leerOtrosDatos ();
	}
	
	public void leerNia ()
	{
		nia = Teclado.leerString("\nnia ");
	}
	
	public void leerOtrosDatos ()
	{
		nombre = Teclado.leerString("nombre ");
		nota = Libreria.leerEntreLimites(NOTAMINIMA, NOTAMAXIMA, "nota ");
		repetidor = Teclado.leerString("Es repetidor?(S/N)").
				equalsIgnoreCase("s");
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\nNIA " + nia);
		Pantalla.escribirString("\nnombre " + nombre);
		Pantalla.escribirString("\nnota " + nota);
		if (repetidor)
			Pantalla.escribirString("\nEs repetidor");
		else
			Pantalla.escribirString("\nNo es repetidor");
		
		//Pantalla.escribirString("\n" + (repetiror?"Es repetidor":"No es repetidor"));
	}
	
	public boolean estaSupenso ()
	{
		return nota < 5;
	}
	
	public boolean equals (Alumno otro)
	{
		return this.nia.equalsIgnoreCase(otro.nia);
	}
	
	//media de cada alumno 
	//media global
	

}
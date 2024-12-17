package clasesyobjetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AlumnoConNotas {
	// constantes
	private static final int NOTAMINIMA = 1;
	private static final int NOTAMAXIMA = 10;
	private static final int NNOTAS = 3;

	
	// Estado de la clase
	private String nia;
	private String nombre;	
	private int notas[];
	private boolean repetidor;
	
	// Constructores
	public AlumnoConNotas (String nia, String nombre, int notas[], boolean repetidor)
	{
		setNia (nia);
		setNombre (nombre);
		setNotas (notas);
		this.repetidor = repetidor;
	}
	
	public AlumnoConNotas ()
	{
		this ("");
	}
	
	public AlumnoConNotas (String nia)
	{
		 //int array[];
		 //array = new int[NNOTAS];
		this (nia, "", new int[NNOTAS] , false);
	}
	
	// Constructor copia
	public AlumnoConNotas (AlumnoConNotas original)
	{
		this (original.nia, original.nombre, 
				original.notas, original.repetidor);
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

	private int[] getNotas() {
		return notas;
	}
	
	public int getNotas (int cual)
	{
		if (cual < 0)
			cual = 0;
		else if (cual > notas.length - 1)
			cual = notas.length - 1;
		
		return notas[cual];
	}
	
	public int getnNotas ()
	{
		return notas.length;
	}

	public void setNotas (int nota, int cual)
	{
		if (cual < 0)
			cual = 0;
		else if (cual > notas.length - 1)
			cual = notas.length - 1;
		
		if (nota < NOTAMINIMA)
			nota = NOTAMINIMA;
		else if (nota >NOTAMAXIMA)
			nota = NOTAMAXIMA;
		
		notas[cual] = nota;
	}
	
	private void setNotas(int notas[]) {
		if (notas == null) // parÃ¡metro de entrada
			notas = new int[NNOTAS];
		for (int i = 0; i < notas.length; i++)
			if (notas[i] < NOTAMINIMA)
				notas[i] = NOTAMINIMA;
			else if (notas[i] >NOTAMAXIMA)
				notas[i] = NOTAMAXIMA;
		
		//this.notas = notas;
		// hacer una copia de las notas que nos pasan
		if (this.notas == null) // variable de la clase
		{
			this.notas = new int [NNOTAS];
			
		}
		for (int i = 0; i < this.notas.length; i++)
			this.notas[i] = notas[i];
	
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
		for (int i = 0; i < notas.length; i++)
			notas[i] = Libreria.leerEntreLimites(NOTAMINIMA, NOTAMAXIMA, "nota ");
		repetidor = Teclado.leerString("Es repetidor?(S/N)").equalsIgnoreCase("s");
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\nNIA " + nia);
		Pantalla.escribirString("\nnombre " + nombre);
		
		Pantalla.escribirString("\nnotas ");
		for (int i = 0; i < notas.length; i++)
			Pantalla.escribirString("\t" + notas[i]);
		if (repetidor)
			Pantalla.escribirString("\nEs repetidor");
		else
			Pantalla.escribirString("\nNo es repetidor");
		
		//Pantalla.escribirString("\n" + (repetiror?"Es repetidor":"No es repetidor"));
	}
	
	public boolean estaSuspenso ()
	{
		return getNotaMedia() < 5;
	}
	
	public float getNotaMedia ()
	{
		float media = 0;
		
		for (int i = 0; i < notas.length; i++)
			media += notas[i];
		
		media /= notas.length;
		
		return media;
	}
	
	public boolean equals (AlumnoConNotas otro)
	{
		return this.nia.equalsIgnoreCase(otro.nia);
	}
	

}
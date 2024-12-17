package colegio;

import clasesyobjetos.Libreria;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Asignatura {
	private static final int MINIMANOTA = 1;
	private static final int MAXIMANOTA = 10;
	private static final int MINIMACONVOCATORIA = 1;
	private static final int MAXIMACONVOCATORIA = 4;
	private String nombre;
	private int nota;
	private int convocatoria;
	
	public Asignatura(String nombre, int nota, int convocatoria) 
	{
		this.nombre = nombre;
		setNota (nota);
		setConvocatoria (convocatoria);
	}

	public Asignatura() {
		this ("");
	}
	public Asignatura(String nombre) {
		this (nombre, MINIMANOTA,MINIMACONVOCATORIA);
	}
	
	public Asignatura (Asignatura original)
	{
		this (original.nombre, original.nota, original.convocatoria);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota){
		if (nota < MINIMANOTA)
			nota = MINIMANOTA;
		else if (nota > MAXIMANOTA)
			nota = MAXIMANOTA;
		
		this.nota = nota;
	}
	
	
	public int getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(int convocatoria) {
		if (convocatoria < MINIMACONVOCATORIA)
			convocatoria = MINIMACONVOCATORIA;
		else if (convocatoria > MAXIMACONVOCATORIA)
			convocatoria = MAXIMACONVOCATORIA;
		this.convocatoria = convocatoria;
	}

	public void leerDatos ()
	{
		leerNombre ();
		leerOtrosDatos ();
	}
	
	public void leerNombre ()
	{
		nombre = Teclado.leerString("nombre asignatura ");
	}
	
	public void leerOtrosDatos ()
	{
		nota = Libreria.leerEntreLimites(MINIMANOTA, MAXIMANOTA, "\nnota");
		
		convocatoria = Libreria.leerEntreLimites(MINIMACONVOCATORIA, MAXIMACONVOCATORIA, "\nconvocatoria");
	}

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + 
				", nota=" + nota + 
				", convocatoria=" + convocatoria + "]";
	}

	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + toString());
	}
	
	public boolean estaAprobada ()
	{
		return nota > 4;
	}
	
	boolean equals (Asignatura otra)
	{
		return otra != null &&
				otra.nombre != null &&
				otra.nombre.equalsIgnoreCase(nombre);
	}

}

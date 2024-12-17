package coleccionesYFechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Persona implements Comparable<Persona>{

	private static final LocalDate FECHAINICIAL = LocalDate.of(2000, 1, 1);
	private static final String FORMATOSTRING = "dd-MM-yyyy";
	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern(FORMATOSTRING);
	
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private float afecto;
	private Set<String> aficiones;
	private Colectivo colectivo;
	

	public Persona ()
	{
		this ("");
	}
	
	public Persona (String dni)
	{
		this ("", dni, FECHAINICIAL, 0f, new HashSet<>(),Colectivo.ALUMNO);
	}
	
	public Persona(String nombre, String dni, 
			LocalDate fechaNacimiento, 
			float afecto, 
			Set<String> aficiones,
			Colectivo colectivo) {
		this.nombre = nombre;
		this.dni = dni;
		setFechaNacimiento (fechaNacimiento);
		setAfecto (afecto);
		this.aficiones = aficiones;
		this.colectivo = colectivo;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre.equals("") || nombre == null) {
			throw new IllegalArgumentException("Nombre vacio no permitido");
		}
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if (dni.equals("") || dni == null) {
			throw new IllegalArgumentException(" vacio no permitido");
		}
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("La fecha de nacimiento no puede ser posterior a la fecha actual");
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getAfecto() {
		return afecto;
	}

	public void setAfecto(float afecto) {
		if (afecto < 0) {
			throw new IllegalArgumentException("El valor del afecto no puede ser negativo");
		}
		this.afecto = Math.max(0,afecto);
	}

	public Iterator<String> getAficiones() {
		return aficiones.iterator();
	}

	public void setAficiones(Set<String> aficiones) {
		if (aficiones == null) {
	        throw new IllegalArgumentException("El conjunto de aficiones no puede ser nulo");
	    }
		this.aficiones = aficiones;
	}

	public Colectivo getColectivo() {
		return colectivo;
	}

	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return dni.compareTo(o.dni);
	}
	
	public int getEdad ()
	{
		return fechaNacimiento.until(LocalDate.now()).getYears();
	}
	
	public boolean esMayorDeEdad ()
	{
		return getEdad() >= 18;
	}
	
	public boolean esSuCumpleHoy ()
	{
		return fechaNacimiento.getMonth().equals(LocalDate.now().getMonth()) 
				&&
				fechaNacimiento.getDayOfMonth()== LocalDate.now().getDayOfMonth();
	}
	
	public void aumentarAfecto (float afecto)
	{
		if (afecto > 0)
			this.afecto += afecto;
		else {
			throw new IllegalArgumentException("\nValor negativo no permitido");
		}
	}
	
	public void descontarAfecto (float afecto)
	{
		if (afecto > 0 && afecto < this.afecto)
			this.afecto -= afecto;
		else {
			throw new IllegalArgumentException("\nValor no valido");
		}
	}
	
	public boolean insertarAficion (String aficion)
	{
		return aficiones.add(aficion);
	}
	
	public boolean tieneAficion (String aficion)
	{
		return aficiones.contains(aficion);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + 
				", dni=" + dni + 
				", fechaNacimiento=" + fechaNacimiento.format(FORMATO) + 
				", afecto="	+ afecto + 
				", aficiones=" + aficiones + 
				", colectivo=" + colectivo + "]";
	}
	
	public void leerClave ()
	{
		dni = Teclado.leerString("\nDNI ");
	}
	
	public void leerRestoDatos ()
	{
		setNombre(Teclado.leerString("\nNombre"));
		setFechaNacimiento (LocalDate.parse(Teclado.leerString("\nFecha Nacimiento " + FORMATOSTRING),FORMATO));
		setAfecto (Teclado.leerFloat("\nAfecto "));
		
		do
		{
			aficiones.add(Teclado.leerString("\nNueva aficion: "));
		}while (Teclado.leerString("\nSigo?").equalsIgnoreCase("s"));
		setAficiones(aficiones);
		
		leerColectivo ();
	}
	
	public void leerColectivo ()
	{
		String colectivo;
		do
		{
			Pantalla.escribirString("\n" + Colectivo.valuesAsString());
			
			colectivo = Teclado.leerString("\nColectivo").toUpperCase();
			
		}while (!Colectivo.valuesAsString().contains(colectivo));
		
		this.colectivo = Colectivo.valueOf(colectivo);
	}

}
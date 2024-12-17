package ejclase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import coleccionesYFechas.Persona;

import daw.com.Teclado;

public class Alumno implements Comparable<Alumno>{

	private static final LocalDate FECHAINICIAL = LocalDate.of(2000, 1, 1);
	private static final String FORMATOSTRING = "dd-MM-yyyy";
	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern(FORMATOSTRING);
	
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private float afecto;
	private Set<String> aficiones;
	

	public Alumno ()
	{
		this ("");
	}
	
	public Alumno (String dni)
	{
		this ("", dni, FECHAINICIAL, 0f, new HashSet<>());
	}
	
	public Alumno(String nombre, String dni, LocalDate fechaNacimiento, float afecto, Set<String> aficiones) {
		this.nombre = nombre;
		this.dni = dni;
		setFechaNacimiento (fechaNacimiento);
		setAfecto (afecto);
		this.aficiones = aficiones;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento.isAfter(LocalDate.now()))
			fechaNacimiento = LocalDate.now();
		
		this.fechaNacimiento = fechaNacimiento;
	}

	public float getAfecto() {
		return afecto;
	}

	public void setAfecto(float afecto) {
		
		this.afecto = Math.max(0,afecto);
	}

	public Iterator<String> getAficiones() {
		return aficiones.iterator();
	}

	public void setAficiones(Set<String> aficiones) {
		this.aficiones = aficiones;
	}
	
	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		return nombre.compareTo(o.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
	
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
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
	}
	
	public void descontarAfecto (float afecto)
	{
		if (afecto > 0 && afecto < this.afecto)
			this.afecto -= afecto;
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
				", aficiones=" + aficiones +  "]";
	}
	
	
	public void leerDatos(){
		leerClave();
		leerRestoDatos();
	}
	
	public void leerClave ()
	{
		dni = Teclado.leerString("\nDNI ");
	}
	
	public void leerRestoDatos ()
	{
		nombre = Teclado.leerString("\nNombre ");
		setFechaNacimiento (LocalDate.parse(Teclado.leerString("\nFecha Nacimiento " + FORMATOSTRING),FORMATO));
		setAfecto (Teclado.leerFloat("\nAfecto "));
		
		do
		{
			aficiones.add(Teclado.leerString("\nNueva aficion "));
		}while (Teclado.leerString("\nMas Aficiones(s/n)?").equalsIgnoreCase("s"));
	
	}



}

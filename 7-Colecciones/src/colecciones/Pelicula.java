package colecciones;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Pelicula implements Comparable<Pelicula> {

	//clave
	private String codigo;

	private String titulo;
	private float precio;
	private TipoPelicula tipo;
	private Set<String> etiquetas;
	private LocalDate fechaCreacion;
	private LocalDate fechaEstreno;

	public Pelicula ()
	{
		this ("");
	}

	public Pelicula(String codigo) {
		this(codigo, "",0,TipoPelicula.AVENTURA,new HashSet<>(),LocalDate.now(),LocalDate.now());
	}


	public Pelicula(String codigo, String titulo, float precio, TipoPelicula tipo, Set<String> etiquetas,
			LocalDate fechaCreacion, LocalDate fechaEstreno) {
		this.codigo = codigo;
		this.titulo = titulo;
		setPrecio (precio);
		this.tipo = tipo;
		this.etiquetas = etiquetas;
		this.fechaCreacion  = fechaCreacion;
		setFechaEstreno (fechaEstreno);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		if (precio < 0)
			precio = 0;
		this.precio = precio;
	}

	public TipoPelicula getTipo() {
		return tipo;
	}

	public void setTipo(TipoPelicula tipo) {
		this.tipo = tipo;
	}

	public Set<String> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<String> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		if (fechaCreacion.isAfter(fechaEstreno)||
				fechaCreacion.isEqual(fechaEstreno))
			fechaCreacion = fechaEstreno.minusMonths(3);
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		if (fechaEstreno.isBefore(fechaCreacion)||
				fechaEstreno.isEqual(fechaCreacion))
			fechaEstreno = fechaCreacion.plusMonths(3);
		this.fechaEstreno = fechaEstreno;
	}

	public boolean addEtiqueta (String etiqueta)
	{
		return etiquetas.add(etiqueta);
	}

	public boolean tieneEtiquetas ()
	{
		return !etiquetas.isEmpty();
	}

	public boolean contieneEtiqueta (String etiqueta)
	{
		return etiquetas.contains(etiqueta);
	}

	public boolean borrarEtiqueta (String etiqueta)
	{
		return etiquetas.remove(etiqueta);
	}

	public void leerClave ()
	{
		codigo = Teclado.leerString("\nCodigo pelicula ");
	}

	public void leerOtrosDatos ()
	{
		String tipoString,etiqueta;

		titulo = Teclado.leerString("\nTitulo pelicula ");

		setPrecio (Teclado.leerFloat("\nPrecio pelicula "));

		// Leer tipo pelÃ­cula
		do
		{
			Pantalla.escribirString("\nElejir un tipo de pelicula " + TipoPelicula.toStringList());
			tipoString = Teclado.leerString("\nTipo de Pelicula");
		}while (!TipoPelicula.toStringList().contains(tipoString.toUpperCase()));

		tipo = TipoPelicula.valueOf(tipoString);

		// Leer etiquetas
		do
		{
			etiqueta = Teclado.leerString("\nEtiqueta");
			etiquetas.add(etiqueta);
		}while (Teclado.leerString("\nOtra etiqueta (s/n)").equals("s"));

		// Leer fecha creaciÃ³n
		fechaCreacion = LocalDate.parse(Teclado.leerString("\nFecha Creacion (yyyy-mm-dd)"));

		// Leer y comprobar fecha estreno
		setFechaEstreno (LocalDate.parse(Teclado.leerString("\nFecha Estreno (yyyy-mm-dd)")));

	}
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}

	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", precio=" + precio + ", tipo=" + tipo
				+ ", etiquetas=" + etiquetas + ", fechaCreacion=" + fechaCreacion + ", fechaEstreno=" + fechaEstreno
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Pelicula other = (Pelicula) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Pelicula o) {
		// TODO Auto-generated method stub
		return codigo.compareTo(o.codigo);
	}

}
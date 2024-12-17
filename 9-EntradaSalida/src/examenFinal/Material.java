package examenFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import daw.com.Teclado;

public abstract class Material implements LeerDatos{
	String id,nombre; 
	LocalDate fechaEstreno; //fecha estreno
	Categoria categoria;
	
	public Material(String id, String nombre, LocalDate fechaEstreno, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
		this.categoria = categoria;
	}
	public Material() {
		this("","",LocalDate.of(2022, 02, 03),Categoria.MILLENIALS);	
	}
	
	public Material(String id) {
		this(id,"",LocalDate.of(2022, 02, 03),Categoria.MILLENIALS);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if (id == null) {
			throw new NullPointerException("El ID no puede ser Null");
		}
		if (id.equalsIgnoreCase("")) {
			throw new IllegalArgumentException("ID vacio");
		}
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		if (fechaEstreno.isBefore(LocalDate.of(2022, 02, 03))) {
			throw new IllegalArgumentException("Fecha no valida anterior al 2022-02-03");
		}
		this.fechaEstreno = fechaEstreno;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public void leerID() {
		boolean exito;
		do {
			try {
				exito = false;
				setId(Teclado.leerString("ID Material"));
			} catch (NullPointerException | IllegalArgumentException e) {
				exito = true;
				System.out.println("\n " + e.getMessage());
			}
		} while (exito);
	}
	@Override
	public void leerDatos() {
		boolean exito;
		this.nombre = Teclado.leerString("nombre Material");
		do {
			try {
				exito = false;
				setFechaEstreno(LocalDate.parse(Teclado.leerString("fecha Estreno del Material (yyyy-mm-dd)")));
				categoria = Categoria.valueOf(Teclado.leerString("Categoria: CLASICOS90/CLASICOS80/MILLENIALS").toUpperCase());
			} catch (IllegalArgumentException | DateTimeParseException e) {
				exito = true;
				System.out.println(e.getMessage());
			}
		} while (exito);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Material other = (Material) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Material [id=" + id + ", nombre=" + nombre + ", fechaEstreno=" + fechaEstreno + ", categoria="
				+ categoria + "]";
	}
	
	public void escribirFichero(DataOutputStream salida) throws IOException{
		salida.writeUTF(id);
		salida.writeUTF(nombre);
		salida.writeUTF(fechaEstreno.toString());
		salida.writeUTF(categoria.toString());
	}
	
	public void leerFichero(DataInputStream entrada) throws IOException{
		id = entrada.readUTF();
		nombre = entrada.readUTF();
		
		try {
			setFechaEstreno(LocalDate.parse(entrada.readUTF())); //parsear la fecha
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			fechaEstreno = LocalDate.now();
		}
		
		categoria = Categoria.valueOf(entrada.readUTF()); //cambiar a un enum

	}
	public boolean estrenado() {
		
		return fechaEstreno.isBefore(LocalDate.now());
	}
	
	public abstract String getTipo();
	

}
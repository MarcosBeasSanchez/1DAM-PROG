package ejercicio1ex;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import daw.com.Teclado;

public abstract class Libro implements Leer{
	String nombre;
	String autor;
	int nautores;
	float precio;
	Tipo tipo;
	LocalDate fecha;
	
	public Libro(String nombre, String autor, int nautores, float precio, Tipo tipo, LocalDate fecha) {
		this.nombre = nombre;
		this.autor = autor;
		this.nautores = nautores;
		this.precio = precio;
		this.tipo = tipo;
		this.fecha = fecha;
	}
	public Libro(String nombre) {
		this.nombre = nombre;
		this.autor = "";
		this.nautores = 0;
		this.precio = 0;
		this.tipo = Tipo.AVENTURA;
		this.fecha = LocalDate.now();
	}
	public Libro() {
		this("","",0,0,Tipo.AVENTURA,LocalDate.now());
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if (nombre.equalsIgnoreCase("") || nombre == null) {
			throw new IllegalArgumentException("Error el nombre no puede estar vacio");
		}
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		
		this.autor = autor;
	}
	public int getNautores() {
		return nautores;
	}
	public void setNautores(int nautores) {
		if (nautores < 1) {
			throw new IllegalArgumentException("Autores no pueden ser menor que 1");
		}
		this.nautores = nautores;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		if (precio < 0) {
			throw new IllegalArgumentException("Precio no puede ser negativo");
		}
		this.precio = precio;
	}
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		boolean tipoValido = false;
		   if (tipo == null) {
		        throw new IllegalArgumentException("El valor introducido no es correcto: null");
		    }
		   
		   tipoValido = tipo.comprobar(tipo);

		   if (!tipoValido) {
		        throw new IllegalArgumentException("El valor introducido no es correcto: " + tipo);
		        }

		    this.tipo = tipo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	

	@Override
	public String toString() {
		return "Libro [nombre=" + nombre + ", autor=" + autor + ", nautores=" + nautores + ", precio=" + precio
				+ ", tipo=" + tipo + ", fecha=" + fecha + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Libro other = (Libro) obj;
		return Objects.equals(nombre, other.nombre);
		}
	
	
	public abstract float precioTotal();
	
	@Override
	public void leerID() {
		boolean exito;
		do {
			exito = false;
			try {
				setNombre(Teclado.leerString("Nombre del libro"));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				exito = true;
			}
			
		} while (exito);
		
	}
	@Override
	public void leerDatos() {
		boolean exito;
		do {
			exito = false;
			try {
				setAutor(Teclado.leerString("Autor del libro"));
				setNautores(Teclado.leerInt("Nº de autores"));
				setPrecio(Teclado.leerFloat("Precio"));
				setTipo(Tipo.valueOf(Teclado.leerString("tipo de libro-AVENTURA/TERROR/COMEDIA/NOVELA").toUpperCase()));
				setFecha(LocalDate.parse(Teclado.leerString("Año de publicacion aaaa-mm-dd")));
			
			} catch (IllegalArgumentException | DateTimeParseException e) {
				System.out.println(e.getMessage());
				exito = true;
			}
		} while (exito);
	}
	
	public void modificarDatos() {
		boolean exito;
		do {
			exito = false;
			try {
				setNombre(Teclado.leerString("Nombre a cambiar del libro"));
				setAutor(Teclado.leerString("Nombre del autor a cambiar"));
				setFecha(LocalDate.parse(Teclado.leerString("Fecha a cambiar aaaa-mm-dd")));
			} catch (IllegalArgumentException | DateTimeParseException e) {
				System.out.println(e.getMessage());
				exito = true;
			}
		} while (exito);
	}
	
	public abstract String writeCSV() ;
	
	public abstract void writeDAT(DataOutputStream salida) throws IOException;
	
	public abstract void fromCSV(String[] valores) throws IOException;
	
	public abstract void readDAT(DataInputStream entrada) throws IOException;
	
	
	
	
	
	
	
	
	
}


	
	
	


	
	
	
	


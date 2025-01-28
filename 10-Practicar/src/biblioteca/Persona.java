package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import daw.com.Teclado;


public abstract class Persona implements LeerDatos{
	
	private final static String SEPARADOR = ";";
	
	String nif;
	String nombre;
	int edad;
	float presupuesto;
	float cuota;
	Categoria categoria;
	List<Libro>libros;
	

	public Persona() {
		this.nif = "";
		this.nombre="";
		this.edad=0;
		this.cuota = 0;
		this.presupuesto = 0;
		this.categoria = Categoria.JOVEN;
		this.libros = new ArrayList<>();
	}
	
	public Persona(String nif) {
		this.nif = nif;
		this.nombre = "";
		this.edad= 0;
		this.cuota = 0;
		this.presupuesto= 0;
		this.categoria = Categoria.JOVEN;
		this.libros = new ArrayList<>();
	}
	
	public Persona(String nif,String nombre,int edad,float cuota,float presupuesto,Categoria cat,List<Libro>libros) {
		this.nif = nif;
		this.nombre = nombre;
		this.edad= edad;
		this.cuota = cuota;
		this.presupuesto= presupuesto;
		this.categoria = cat;
		this.libros = libros;
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == "") {
			throw new IllegalArgumentException("Nombre vacio no permitido");
		}
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad <= 0) {
			throw new IllegalArgumentException("edad menor de 0");
		}
		this.edad = edad;
	}

	public float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Libro> getLibros() {
		return libros;
	}
	
	public int getNlibros() {
		return libros.size();
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}
	
	public boolean existeLibro(String otro) {

		boolean res = false;
		
		for (Libro libro : this.libros) {
			if (libro.getIsbn().equalsIgnoreCase(otro)) {
				res= true;
			}
		}
		return res;
	}

	public void deleteAutor(String aut){
		for (Libro libro : libros) {
			if (libro.getAutores().contains(aut)) {
				libro.deleteAutor(aut);
			}
		}
	}
	void addLibro(Libro l) {
		libros.add(l);
	}
	
	@Override
	public void leerID() {
		do {
			try {
				setNombre(Teclado.leerString("Nombre Persona"));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (nombre != null || nombre.equalsIgnoreCase(""));
		
	}

	@Override
	public void leerDatos() {
		boolean exito;
		int cuantos;
		Libro lib;
		String id;
		do {
			try {
				exito = false;
				setNombre(Teclado.leerString("Nombre Persona:"));
				setEdad(Teclado.leerInt("Edad Persona:"));
				setCuota(Teclado.leerFloat("Cuota que paga:"));
				setPresupuesto(Teclado.leerFloat("Presupuesto Persona:"));
				setCategoria(Categoria.valueOf(Teclado.leerString("Tipo Persona: MENOR,JOVEN,INTERMEDIO,VETERANO").toUpperCase()));
				cuantos = Teclado.leerInt("Cuantos libros quieres intoducir?");
				for (int i = 0; i < cuantos; i++) {
					id = Teclado.leerString("ISBN del libro");
					if (existeLibro(id)) {
						System.out.println("El libro ISBN" + id + "ya esta registrado");
					}else {
						lib = new Libro(id);
						lib.leerDatos();
						libros.add(lib);
						System.out.println("libro añadido correctamente");
					}
				}
				
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				exito = true;
			}
		} while (exito);
	}

	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", edad=" + edad + ", presupuesto=" + presupuesto
				+ ", cuota=" + cuota + ", categoria=" + categoria + ", libros=" + libros + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
	
		Persona other = (Persona) obj;
		return Objects.equals(nif, other.nif);
	}

	public abstract float calcular();

	public abstract String toCsv();

	protected abstract void fromCsv(String[] valores);

	
	
	
	
	

}

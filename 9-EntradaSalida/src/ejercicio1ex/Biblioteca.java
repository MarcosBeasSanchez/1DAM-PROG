package ejercicio1ex;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import daw.com.Teclado;
import practicaFinalProfe.Libreria;

public class Biblioteca  {
	
	String nombre;
	List<Libro> libros;

	public Biblioteca(String nombre, List<Libro> libros) {
		this.nombre = nombre;
		this.libros = libros;
	}
	
	public Biblioteca() {
		setNombre(Teclado.leerString("Nombre de la biblioteca"));
		this.libros = new ArrayList<Libro>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == "" || nombre == null) {
			throw new IllegalArgumentException("El nombre no puede ser vacio o null");
		}
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro getLibro(String titulo) {
		Libro li = null;
		
		for (Libro libro : libros) {
			if (libro.getNombre().equalsIgnoreCase(titulo)) {
				li = libro;
				break;
			}
		}
		return li;
	}
	
	public boolean existeLibro(String nombre) {
	    for (Libro libro : libros) {
	        if (libro.getNombre().equalsIgnoreCase(nombre)) {
	            return true;
	        }
	    }
	    return false;
	}

	public void leerDatos() {
		int cuantos;
		int tipo;
		Libro li;
		String name;
		
		cuantos = Teclado.leerInt("Cuatos libros hay en la biblioteca");
		
		for (int i = 0; i < cuantos; i++) {
			tipo = Libreria.leerEntreLimites(1, 2, "1.Normal 2.Bolsillo");
			name = Teclado.leerString("Nombre del libro");
			if (!existeLibro(name)) {
				if (tipo == 1) {
					li =new Normal(name);
				} else {
					li = new Bolsillo(name);
				}
				li.leerDatos();
				libros.add(li);
			}else {
				System.out.println("el nombre del libro introducido ya existe");
			}
		}
	}

	public void addLibro(Libro li) {
		libros.add(li);
	}

	public void listarLibros() {
		for (Libro libro : libros) {
			System.out.println(libro);
		}
	}

	public void writeCSV(PrintWriter salida) {
		
		salida.println(nombre);
		salida.println(";");
		
		for (Libro libro : libros) {
			if (libro instanceof Normal) {
				salida.println("NORMAL");
			}else {
				salida.println("BOLSILLO");
			}
			salida.println(libro.writeCSV());
		}
		
	}
	
	public void readCSV(BufferedReader entrada) throws IOException {
		
		//Leer nombre
	    this.nombre = entrada.readLine();
	    //Leer separador
	    String separator = entrada.readLine();
		//Crear libros
		List<Libro> libros = new ArrayList<>();
	    String linea;
		
	    while (entrada.ready()) {
	    	linea = entrada.readLine();
	        String[] valores = linea.split(";");
	        Libro libro;
	        String tipo = entrada.readLine();
	        
	        if (tipo.equalsIgnoreCase("NORMAL")) {
				libro= new Normal();
			}else {
				libro= new Bolsillo();
			}
	        libro.fromCSV(valores);
	        libros.add(libro);
	    }
	    
	    this.libros = libros;
		
	}


	public void writeDAT(DataOutputStream salida) throws IOException {
		
		salida.writeUTF(nombre);
		salida.writeInt(libros.size());
		
		for (Libro libro : libros) {
			
			if (libro instanceof Normal ) {
				salida.writeUTF("NORMAL");
			}else {
				salida.writeUTF("BOLSILLO");
			}
			libro.writeDAT(salida);
		}
		
	}

	public void readDAT(DataInputStream entrada) throws IOException {
		Libro li;
		
		nombre = entrada.readUTF();
		int cuantos = entrada.readInt();
		
		if (cuantos > 0) {
			
			for (int i = 0;i < cuantos; i ++) {
				String tipo = entrada.readUTF();
				if (tipo.equalsIgnoreCase("NORMAL")) {
					li = new Normal();
				}else {
					li = new Normal();
				}
				li.readDAT(entrada);
				libros.add(li);
			}
			
		}else {
			System.out.println("No hay Libros en la biblioteca");
		}
	}

	
	

	
}

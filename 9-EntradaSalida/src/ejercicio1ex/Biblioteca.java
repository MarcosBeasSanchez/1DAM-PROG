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
		this("",new ArrayList<>());
	}
	
	public Biblioteca(String nombre) {
		setNombre(nombre);
		this.libros = new ArrayList<Libro>();
	}
	
	public Biblioteca(String nombre,ArrayList<Libro> libros) {
		this.nombre = nombre;
		this.libros = libros;
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
	    for (Libro libro : libros) {
	        if (libro instanceof Normal) {
	            salida.print("NORMAL;");
	        } else {
	            salida.print("BOLSILLO;");
	        }
	        salida.println(libro.writeCSV());
	    }
	}

	
	public void readCSV(BufferedReader entrada) throws IOException {
		//LeerDatos Biblioteca
		//Leer nombre
	    this.nombre = entrada.readLine();
	    List<Libro> libros = new ArrayList<>();
	    String linea;
	    Libro libro;
	    
	    while (entrada.ready()) {
	    	linea = entrada.readLine();//leo la siguiente linea (Tipo libo y resto de datos)
	        String[] valores = linea.split(";"); // lo spliteo por ;
	        //leo Tipo de libro
	        if (valores[0].equalsIgnoreCase("NORMAL")) {
				libro = new Normal();
			}else {
				libro = new Bolsillo();
			}
	        //leeo resto de datos
	        libro.fromCSV(valores);
	        //lo añado a la lista creada llamada libro;
	        libros.add(libro);
	    }
	    //almaceno los libros dentro de la app
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
					li = new Bolsillo();
				}
				li.readDAT(entrada);
				libros.add(li);
			}
			
		}else {
			System.out.println("No hay Libros en la biblioteca");
		}
	}

	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + "]";
	}

	
	

	
}

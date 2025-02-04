package biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import daw.com.Teclado;

public class App extends AppConMenu {

	private static final String personas_csv = "personas.csv";
	private static final String personas_dat = "personas.dat";

	List<Persona> personas;
	

	public App() {
		super();
		addOpcion("Insertar una Persona");
		addOpcion("Insertar un Libro a una persona");
		addOpcion("Eliminar un Autor de un Libro");
		addOpcion("Ver todo");
		addOpcion("Obtener Calculo total de una persona");

		personas = new ArrayList<Persona>();
		//libros = new ArrayList<Libro>();

	}

	public static void main(String[] args) {
		App app = new App();
		app.cargarDatos();
		app.run();
	}

	

	private void cargarDatos() {
		File archivo = new File(personas_csv);
		
		if (archivo.exists()) {
			try (BufferedReader buff = new BufferedReader(new FileReader(personas_csv))){
				cargar(buff);
				System.out.println("Personas cargadas correctamente: " + personas_csv);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.out.println("Error cargando personas...");
			}
		}
		
	}
	
	private void cargar(BufferedReader buff) throws IOException {
		String linea;
		Persona p;
		
		while (buff.ready()) {
			
			linea = buff.readLine();
			String[] valores = linea.split(";");
			if (valores[0].equalsIgnoreCase("Joven")) {
                p = new Joven();
            } else {
            	p = new Veterano();
            }
		    p.fromCsv(valores);
		    personas.add(p);
		    
		    
		}
		
	}
	
	
	
	private void guardarDatos() {

		try (PrintWriter pw = new PrintWriter(new FileWriter(personas_csv))) {
			guardar(pw);
			System.out.println("Personas guardadas correctamente: " + personas_csv);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Error guardando...");
		}
	}
		
	
	private void guardar(PrintWriter pw) {
		for (Persona persona : personas) {
			pw.print(persona instanceof Joven ? "Joven;" : "Veterano;");
			pw.println(persona.toCsv());
			//mostrar por consola lo que se guarda
			System.out.println(persona);
		}
	}

	@Override
	public void evaluarOpcion(int opc) {
		switch (opc) {
		case 1:
			insertarPersona();
			break;
		case 2:
			insertarLibro();
			break;
		case 3:
			eliminarAutorLibro();
			break;
		case 4:
			verTodo();
			break;
		case 5:
			obtenerCalculo();
			break;
		case 6:
			salir();
			break;
		}

	}

	

	private void insertarPersona() {
		boolean exito;
		int opc;
		String nif;
		Persona p = null;

		do {
			exito = false;
			nif = Teclado.leerString("NIF Persona");

			if (!existePersona(nif)) {
				do {
					opc = Teclado.leerInt("1.Joven/2.Veterano");
					switch (opc) {
					case 1:
						p = new Joven(nif);
						break;
					case 2:
						p = new Veterano(nif);
						break;

					default:
						System.out.println("Numero no valido");
						break;
					}

				} while (p == null);
				p.leerSoloDatos();
				personas.add(p);
				listarPersonas();
				System.out.println("Persona introducida correctamente");
				
			} else {
				System.out.println("La persona ya existe");
				listarPersonas();
				exito = true;
			}
		} while (exito);

	}

	private void insertarLibro() {
	    String nif, isbn;
	    boolean exito;
	    Libro lib;
	    Persona p;

	    do {
	        exito = false; 
	        nif = Teclado.leerString("NIF a la que introducir un libro: ");
	        p = obtenerPersona(nif);  

	        if (p != null) { 
	            isbn = Teclado.leerString("ISBN del libro: ");
	            
	            
	            if (existeLibroEnCualquierPersona(isbn)) {
	                System.out.println("El libro con ISBN " + isbn + " ya está registrado por otra persona.");
	            } else {
	               
	                lib = new Libro(isbn);
	                lib.leerDatos();  
	                p.addLibro(lib); 
	                System.out.println("Libro introducido correctamente");
	                exito = true;  
	            }
	        } else {
	            System.out.println("Persona no existente.");
	        }

	    } while (!exito); 
	}

	private Persona obtenerPersona(String nif) {
		Persona p=null;
		for (Persona persona : personas) {
			if (persona.getNif().equalsIgnoreCase(nif)) {
				p = persona;
			}
		}
		return p;
		
	}
	
	private void eliminarAutorLibro() {
		String nif, isbn, autor;
		boolean exito;
		Persona p;

		do {
			exito = false;
			nif = Teclado.leerString("NIF de la persona: ");
			p = obtenerPersona(nif);

			if (p != null) {
				isbn = Teclado.leerString("ISBN del libro: ");

				if (p.existeLibro(isbn)) {
					autor = Teclado.leerString("Nombre del autor que quieres eliminar");
					p.deleteAutor(autor);
					System.out.println("Autor : " + autor + " eliminado correctamente" );
					listarPersonas();
				} else {
					exito=true;
					System.out.println("Este libro no existe");
				}
			} else {
				exito = true;
				System.out.println("Persona no existente.");
			}

		} while (!exito);
	}

	private void verTodo() {
		if (personas.isEmpty()) {
			System.out.println("No hay nada que mostrar");
		}else {
			System.out.println("\nPERSONAS:");
			for (Persona persona : personas) {
				System.out.println(persona);
			}
		}
	}
	
	private void obtenerCalculo() {
		System.out.println("\ntodas las personas ");
		for (Persona persona : personas) {
			System.out.println( "Nif -> " +  persona.getNombre()+ " Persona -> " + persona.getNombre() + " Calculo -> " + persona.calcular());
		}
		
	}

	private void salir() {
		guardarDatos();
		System.out.println("Fin...");
	}
	
	

	private boolean existePersona(String id) {
		boolean res = false;

		for (Persona p : personas) {
			if (p.getNif().equalsIgnoreCase(id)) {
				res = true;
			}
		}
		return res;
	}
	
	public boolean existeLibroEnCualquierPersona(String isbn) {
	    for (Persona persona : personas) { 
	        for (Libro libro : persona.getLibros()) { 
	            if (libro.getIsbn().equals(isbn)) {
	                return true;  
	            }
	        }
	    }
	    return false;  
	}

	private void listarPersonas() {
		for (Persona p : personas) {
			System.out.println(p);
		}
	}
	
}

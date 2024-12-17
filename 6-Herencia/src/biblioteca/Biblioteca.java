package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import daw.com.Teclado;

/**
 * Una Clase Biblioteca la cual contiene bibliotecarios,socios,materiales y prestamos, sirve para simular
 * la gestión y funcionamiento de una biblioteca
 */

public class Biblioteca {
	
	/**
	 * @author Marcos Beas
	 * @version 2.0.0;
	 * <p>Una Biblioteca la cual contiene bibliotecarios,socios,materiales y prestamos.
	 *  Dispone de las funciones:</p>
	 *  
	 * @see #agregarMaterial();
	 * @see #agregarPersona();
	 * @see #realizarPrestamo();
	 * @see #buscarMaterial();
	 */
	
	private String nombre;
	private String direccion;
	
	private ArrayList<Bibliotecario> bibliotecarios;
	private ArrayList<Socio> socios;
	private ArrayList<Material> materiales;
	private ArrayList<Prestamo> prestamos;
	
	
	/**
     * Constructor de la clase Biblioteca que inicializa el nombre, dirección y las listas de bibliotecarios, socios, materiales y préstamos.
     * @param nombre El nombre de la biblioteca.
     * @param direccion La dirección de la biblioteca.
     * @see Bibliotecario
     * @see Socio
     * @see Material
     * @see Prestamo
     * 
     */
	public Biblioteca(String nombre,String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.bibliotecarios = new ArrayList<>();
		this.socios = new ArrayList<>();
		this.materiales = new ArrayList<>();
		this.prestamos = new ArrayList<>();
	}
	
    /**
     * Constructor por defecto de la clase Biblioteca que inicializa el nombre, dirección y las listas de bibliotecarios, socios, materiales y préstamos con valores predeterminados.
     * añade por defecto el nombre de la biblioteca "DAM" y direccion "Villablanca,7"
     * @see Bibliotecario
     * @see Socio
     * @see Material
     * @see Prestamo
     * */
	public Biblioteca() {
		this.nombre = "DAM";
		this.direccion = "VIllablanca,7";
		this.bibliotecarios = new ArrayList<>();
		this.socios = new ArrayList<>();
		this.materiales = new ArrayList<>();
		this.prestamos = new ArrayList<>();
	}
	 /**
     * Método para agregar un nuevo material a la biblioteca, puede ser:
     * @see Libro
     * @see Disco
     * @see Pelicula
     * @see java.util.ArrayList
     * 
     */
	public void agregarMaterial() {
	    int opc;
	    
	    Material material = null;
	    do {
	        opc = Teclado.leerInt("1.Libro 2.Disco 3.Pelicula");

	        switch (opc) {
	            case 1:
	                material = new Libro();
	                break;
	            case 2:
	                material = new Disco();
	                break;
	            case 3:
	                material = new Pelicula();
	                break;
	            default:
	                System.out.println("Opción no válida, por favor seleccione nuevamente.");
	                break;
	        }
	    } while (opc < 1 || opc > 3);
	    material.leerDatosMaterial();
	    this.materiales.add(material);
	}
	/**
     * Método para agregar una nueva persona (bibliotecario o socio) a la biblioteca.
     */
	public void agregarPersona() {
	    Persona p = null;
	    int opc;

	    do {
	        opc = Teclado.leerInt("1.Bibliotecario 2.Socio");

	        switch (opc) {
	            case 1:
	                p = new Bibliotecario();
	                this.bibliotecarios.add((Bibliotecario) p);
	                break;
	            case 2:
	                p = new Socio();
	                this.socios.add((Socio) p);
	                break;
	            default:
	                System.out.println("Opción no válida, por favor seleccione de nuevo");
	                break;
	        }
	    } while (opc != 1 && opc != 2);
	}
	/**
     * Método para realizar un préstamo a un socio.
     * @param p El préstamo que se va a realizar.
     * @param s El socio al que se le va a realizar el préstamo.
     */
	public void realizarPrestamo(Prestamo p, Socio s) {
		boolean exito;
		
		exito = verificarDisponibilidad(p);
			
		if (exito && s.getNumeroPrestamos() < 5) {
			s.addPrestamo(p);
			System.out.println("Prestamo realizado");
		}else {
			System.out.println("ERROR al realizar prestamo");
		}
		}
	
	/**
     * Método para verificar la disponibilidad de un material para préstamo.
     * @param p El préstamo que se va a verificar.
     * @return true si el material está disponible, false si está alquilado.
     */
	public boolean verificarDisponibilidad(Prestamo p) {
		
		boolean exito = false;
		
		for (int i = 0; i < prestamos.size(); i++) {
			if (p.getFin().isAfter(LocalDate.now())) {
				System.out.println("Esta alquilado");
			}else {
				System.out.println("Esta Disponible");
				exito= true;
			}
		}
		return exito;
		
	}
	/**
	 * Este método busca un material espcifico:
	 * 
	 *<li> Una lista de unos <b>Libros</b> filtrados por su autor</li>
	 *<li> Una lista de unos <b>Discos</b> filtados por su nombre del grupo</li>
	 *<li> Una lista de <b>Películas</b> filtradas por el director.</li>
	 *
	 *@see Libro
	 *@see Disco
	 *@see Pelicula
	 *
	 *@return la lista que se haya solicitado
	 */
	
	public List<Material> buscarMaterial() {
		 int opc;
		 List<Material>materialSolicitado = new ArrayList();
		 
		 materialSolicitado.clear();;
		 		 
		  do {
			  opc = Teclado.leerInt("\n1.BuscarAutor \n2.BuscarDisco \n3.BuscarPelicula");
			  
		        switch (opc) {
		        	case 1:
		        		String nombreAutor = Teclado.leerString("Libros del Autor:");
		        		
		        		 for (Material m : materiales) {
		                     if (m instanceof Libro) {
		                         Libro libro = (Libro) m;
		                         if (libro.getAutor().equalsIgnoreCase(nombreAutor)) {
		                        	 materialSolicitado.add(libro); 
		                         }
		                     }
		                 }
	                break;
	                
		            case 2:
		        		String nombreDisco = Teclado.leerString("Discos del grupo:");
		        		
		        		 for (Material m : materiales) {
		                     if (m instanceof Disco) {
		                         Disco disco = (Disco) m;
		                         if (disco.getDiscografica().equalsIgnoreCase(nombreDisco)) {
		                        	 materialSolicitado.add(disco); 
		                         }
		                     }
		                 }
		               
		                break;
		            case 3:
		            	String director = Teclado.leerString("Peliculas del director:");
		            	 for (Material m : materiales) {
		                     if (m instanceof Pelicula) {
		                    	 Pelicula peli = (Pelicula) m;
		                         if (peli.getDirector().equalsIgnoreCase(director)) {
		                        	 materialSolicitado.add(peli); 
		                         }
		                     }
		                 }
		                
		                break;
		            default:
		                System.out.println("Opción no válida, por favor seleccione nuevamente.");
		                break;
		        }
		    } while (opc < 1 || opc > 3);
		  
		return materialSolicitado;
	}
	
	}




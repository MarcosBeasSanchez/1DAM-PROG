package ejercicio1ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.time.LocalDate;

import daw.com.Teclado;
import practicaFinalProfe.Libreria;

public class App extends AppConMenu {

	Biblioteca biblioteca;
	static final String CSV = "biblioteca.csv";
	static final String DAT = "biblioteca.dat";

	public App() {
		super();
		addOpcion("Cambiar Nombre,fecha y autor del libro");
		addOpcion("Añadir Libro");
		addOpcion("Ordenar Libros");
		addOpcion("Exportar a .CSV");
		addOpcion("Exportar a .DAT");
		addOpcion("listar todo");
	
	}
	
	public static void main(String[] args) {
		App app = new App();
		app.inicio();
		app.run();

	}

	private void inicio() {
		File csv = new File(CSV); // 1 
		File dat = new File(DAT); // 2
		
		int respuesta = Libreria.leerEntreLimites(1, 3, "Cargar 1.CSV / 2.DAT / 3.Cargar Datos predefinidos");
		
		biblioteca = new Biblioteca();
		//LEER CSV
		if (respuesta == 1) {
			if (csv.exists()) {
				try (BufferedReader entrada = new BufferedReader(new FileReader(CSV))){
					biblioteca.readCSV(entrada);
				} catch (IOException e) {
					System.out.println("Error leyendo CSV");
				}
			} else {
				System.out.println("El archivo " + CSV + " no se ha podido leer");
				String n = Teclado.leerString("Nombre de la biblioteca");
				biblioteca = new Biblioteca(n);
				
			}
			//LEER DAT
		} else if (respuesta == 2){
			if (dat.exists()) {
				try (DataInputStream entrada = new DataInputStream(new FileInputStream(DAT))){
					biblioteca.readDAT(entrada);
				} catch (IOException e) {
					System.out.println("Error leyendo DAT");
				}
			} else {
				System.out.println("El archivo " + DAT + " no se ha podido leer");
				String n = Teclado.leerString("Nombre de la biblioteca");
				biblioteca = new Biblioteca(n);
			}
		}else {
			//Cargar datos predefinidos
			cargarDatos();
		}
			
	}

	private void cargarDatos() {
		biblioteca = new Biblioteca("BibliotecaPrueba",Arrays.asList(
				new Normal("libroNormal","aut1",1,20,Tipo.AVENTURA,LocalDate.EPOCH,true,50),
				new Bolsillo("libroBolsillo","aut2",2,35,Tipo.TERROR,LocalDate.EPOCH,30)
				));
		
	}

	@Override
	public void evaluarOpcion(int opc) {
		switch (opc) {
		case 1:
			cambiarDatos();
			break;
		case 2:
			insertarLibro();
			break;
		case 3:
			ordenarLibros(); // alfabeticamente y precio;
			break;
		case 4:
			exportarCsv(); // Normal
			break;
		case 5:
			exportarDat(); // Binario
			break;
		case 6:
			listarBiblioteca(); // Binario
			break;
		}
	}

	private void listarBiblioteca() {
		System.out.println(biblioteca);
		System.out.println("LIBROS: ");
		biblioteca.listarLibros();
		
	}

	private void cambiarDatos() {
		String nombreLibro;
		Libro libro;
		
		nombreLibro = Teclado.leerString("Nombre del libro el cual deseas cambiar: ");
		
		if (biblioteca.existeLibro(nombreLibro)) {
			libro = biblioteca.getLibro(nombreLibro);
			libro.modificarDatos();
			System.out.println("Datos cambiados con exito " + libro.toString());
		}else {
			System.out.println(nombreLibro + " NO existe ");
		}
		
	}


	private void insertarLibro() {
		String nombre;
		int tipo;
		Libro li;
		
		nombre = Teclado.leerString("Nombre del libro que deseas introducir");
		
		if (!biblioteca.existeLibro(nombre)) {
			tipo = Libreria.leerEntreLimites(1, 2, "Tipo de libro: 1.Normal 2.Bolsillo");
			
			if (tipo == 1) {
				li = new Normal(nombre);
			} else {
				li = new Bolsillo(nombre);
			}
			
			li.leerTodo();
			biblioteca.addLibro(li);
			System.out.println("Libro " + li.getNombre() + " introducido correctamente");
			biblioteca.listarLibros();
			
		}else {
			System.out.println("El nombre del libro intorducido: " + nombre + " ya existe");
		}
	}


	private void ordenarLibros() {
		int res;
		List<Libro> LibrosNombre = new ArrayList<>();
		List<Libro> LibrosPrecio = new ArrayList<>();
		
		res = Libreria.leerEntreLimites(1, 2, "Listar por: 1.Nombre 2.Precio Total");
		
		if (res == 1) {
			//filtrar por nombre del libro
			LibrosNombre.addAll(biblioteca.libros);
			LibrosNombre.sort((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
			for (Libro libro : LibrosNombre) {
				System.out.println(libro);
			}
		}else {
			//filtar por precio final
			LibrosPrecio.addAll(biblioteca.libros);
			LibrosPrecio.sort((o1, o2) -> Float.compare(o1.precioTotal(), o2.precioTotal()));;
			for (Libro libro : LibrosPrecio) {
				System.out.println(libro.toString());
			}
		}
	}


	private void exportarCsv() {  //Normal
		
		try (PrintWriter salida = new PrintWriter(new FileWriter(CSV))){
			biblioteca.writeCSV(salida);
		} catch (IOException e) {
			System.out.println("Error guardando .CSV");
		}
		System.out.println(CSV + " guardado correctamente");
	}


	private void exportarDat() { //Binario
		try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(DAT))){
			biblioteca.writeDAT(salida);
		} catch (IOException e) {
			System.out.println("Error guardando .DAT");
		}
		System.out.println(DAT + " guardado correctamente");
		
	}


	

}

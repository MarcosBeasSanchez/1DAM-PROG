package examenFinal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import daw.com.Teclado;

public class App extends AppConMenu{
	
	private static final String clientes_archivo = "clientes.csv";
	private static final String materiales_archivo = "materiales.dat";
	private static final String escuchas_archivo = "escuchas.csv";
	
	Plataforma plataforma;

	public App() {
		super();
		addOpcion("Insertar nuevo material");
		addOpcion("Dar de alta a un nuevo cliente");
		addOpcion("Realizar una ecucha");
		addOpcion("Añadir catalan a todos los podcast que no lo tengan");
		
		plataforma = new Plataforma();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		app.inicio();
		app.run();
		

	}

	private void inicio() {
		cargarClientes();
		cargarMateriales();
		cargarEscuchas();
		
	}


	private void cargarEscuchas() {
		File archivo = new File (escuchas_archivo);
		if (archivo.exists()) {
			try (BufferedReader buffer = new BufferedReader(new FileReader(escuchas_archivo))){
				plataforma.cargarClientes(buffer);
			} catch (IOException e) {
				System.out.println("Error leyendo Escuchas");
			}
		}
		
	}


	private void cargarMateriales() {
		File archivo = new File (materiales_archivo);
		if (archivo.exists()) {
			try (DataInputStream data = new DataInputStream(new FileInputStream(materiales_archivo))){
				plataforma.cargarMateriales(data);
				
			} catch (IOException e) {
				System.out.println("Error leyendo materiales");
			}
		}
		
	}


	private void cargarClientes() {  
		File archivo = new File (clientes_archivo);
		
		if (archivo.exists()) {
			try (BufferedReader buffer = new BufferedReader(new FileReader(clientes_archivo))){
				plataforma.cargarClientes(buffer);
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.out.println("Error leyendo datos");
			}
		}
	}


	@Override
	public void evaluarOpcion(int opc) {
		
		switch (opc) {
		case 1:
				insertarMaterial();
			break;
		case 2:
				darAltaCliente();
			break;
		case 3:
				realizarEscucha();
			break;
		case 4:
				catalan();
			break;
		case 5:
				salir();
			break;
		}	
	}

	private void salir() {
		guardarClientes();
		guardarMateriales();
		guardarEscuchas();
		System.out.println("Datos guardados con éxito");
		
	}

	private void guardarEscuchas() {
		try (PrintWriter salida = new PrintWriter(new FileWriter(escuchas_archivo))){
			plataforma.guardarEscuchas(salida);
		} catch (IOException e) {
			System.out.println("Error guardando escuchas");
		}
		
	}


	private void guardarMateriales() {
		try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(materiales_archivo))){
			plataforma.guardarMateriales(salida);
		} catch (IOException e) {
			System.out.println("ERROR guardando materiales");
		}
		
	}


	private void guardarClientes() {
		try (PrintWriter pw = new PrintWriter(new FileWriter(clientes_archivo))){
			plataforma.guardarClientes(pw);
		} catch (IOException e) {
			System.out.println("Error guardando clientes ");
		}
		
	}


	private void catalan() {
		
	Predicate<Podcast>filtroCatalan = new FiltrarCatalan();
	
	for (Material i : plataforma.materiales) {
		if (i instanceof Podcast) {
			 Podcast podcast = (Podcast) i;
	            if (filtroCatalan.test(podcast)) { //si cumple los requisitos de la clase filtroCatalan:
	                podcast.getIdiomas().add("Catalán");// añade Catalán a todos estos
	                System.out.println("Catalán añadido a " + i.getTipo() + " " + i.getId() + " " + i.getNombre());
	            }
			}
		}
	}

	private void realizarEscucha() {
		String id,seleccion;
		boolean exito ;
		Comparator <Material> comparadorPorNombre = new ComparadorPorNombre();
		List<Material>materialesDisponibles;
		
		do {
			id = Teclado.leerString("ID cliente a buscar");
			exito = false;
			
			if (plataforma.existeCliente(id)) {
				
				materialesDisponibles = new ArrayList<Material>();
				
				for (Material material : plataforma.materiales) {
					if (material.estrenado()) {
						materialesDisponibles.add(material);
					}
				}
				
				Collections.sort(materialesDisponibles,comparadorPorNombre); //ordenado
				
				if (!materialesDisponibles.isEmpty()) {
					System.out.println("Materiales estrenados: ");
					for (Material material : materialesDisponibles) {
						System.out.println("ID : " + material.getId()+
											" Tipo: " + material.getTipo() +
											" Nombre: " + material.getNombre());
					}
					
					seleccion = Teclado.leerString("Seleciona un material por su ID para escuchar");
					
					if (plataforma.existeMaterial(seleccion)) {
						Escucha escuchaSeleccion = new Escucha(id,seleccion);
						plataforma.addEscucha(escuchaSeleccion);
						System.out.println("Escucha realizada con exito");
						exito = false;
					} else {
						System.out.println("Material Solicitado no encontrado");
						exito = true;
					}
					
				}else {
					System.out.println("no hay materiales estrenados");
					exito = true;
				}
				
			}else {
				System.out.println("ID del cliente no existe");
				exito = true;
			}
			
		} while (exito);
		
	}
		
	

	private void darAltaCliente() {
		String id;
		boolean exito = false;
		Cliente cliente;
		
		do {
			id = Teclado.leerString("ID cliente");
			
			if (!plataforma.existeCliente(id)) {
				cliente = new Cliente(id);
				cliente.leerDatos();
				plataforma.addCliente(cliente);
			}else {
				System.out.println("ID del cliente ya existe");
			}
			
		} while (exito);
		
	}

	private void insertarMaterial() {
		String id;
		int opc;
		Material m = null;
		boolean exito;
		
		do {
			id = Teclado.leerString("ID del material");
		
		if (!plataforma.existeMaterial(id)) {
			
			do {
				opc=Teclado.leerInt("1.podcast/2.cancion");
				switch (opc) {
				case 1:
					m = new Podcast(id);
					break;
				case 2:
					m = new Cancion(id);
					break;
				default:
					System.out.println("numero no válido");
					break;
				}
			} while (m == null);
			
			m.leerSoloDatos();
			plataforma.addMaterial(m);
			exito = false;
			
		}else {
			
			System.out.println("material ya existente");
			plataforma.listarMaterialesExistentes();
			exito= true;
		}
		} while (exito);
	}
}


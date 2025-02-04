package tareas;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.Libreria;
import daw.com.Teclado;

public class AppTarea {
	private final static String NOMBRECSV = "tareasApp.csv";
	private final static String NOMBREDAT = "tareasApp.dat";
	
	private List<Persona>listaPersonas = new ArrayList<Persona>();
	
	public static void main(String[] args) {
		AppTarea app = new AppTarea();
		app.run();
	}

	private void run() {
		int opc;

		do {

			mostrarOpciones();
			opc = Teclado.leerInt("Selecciona una opcion: ");

			switch (opc) {

			case 0:
				crearPersona();
				break;
			case 1:
				crearTarea();
				break;
			case 2:
				listar();
				break;
			case 3:
				marcarCompletada();
				break;
			case 4:
				eliminarTarea();
				break;
			case 5:
				consultas();
				break;
			case 6:
				DatosPredefinidos();
				break;
			case 7:
				cargarDatosGuardados();
				break;
			case 8:
				guardarDatosAFichero();
				break;
			case 9:
				salirPrograma();
				break;

			default:
				System.out.println("\nOpcion no valida, intentalo de nuevo...");
				break;
			}
		} while (opc != 9);
	}

	private void guardarDatosAFichero() {
		int res;
		res = Libreria.leerEntreLimites(1, 2, "Guardar 1.CSV o 2.DAT");
		
		if (res == 1) {
			try (PrintWriter salida = new PrintWriter(new FileWriter(NOMBRECSV))) {
				//salida.println(listaPersonas.size());
				for (Persona persona : listaPersonas) {
					persona.toCSV(salida);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			
			try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(NOMBREDAT))) {
				
				salida.writeInt(listaPersonas.size());
				for (Persona persona : listaPersonas) {
					persona.toDAT(salida);
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Datos DAT guardados correctamente...");

	}

	private void cargarDatosGuardados() {
		int res;
		File csv = new File(NOMBRECSV);
		File dat = new File(NOMBREDAT);
		
		res = Libreria.leerEntreLimites(1, 2, "Cargar 1.CSV o 2.DAT");
		
		if (csv.exists() && res == 1) {
			System.out.println(".CSV Fichero encontrado...");
			
			try (BufferedReader entrada = new BufferedReader(new FileReader(NOMBRECSV))){		
				while (entrada.ready()){
					Persona persona = new Persona();
					persona.fromCSV(entrada,persona);
					listaPersonas.add(persona);
				}
				System.out.println(".CSV cargado correctamente...");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		if (dat.exists() && res == 2) {
			Persona persona;
			System.out.println(".DAT Fichero Encontrado");
			
			try (DataInputStream entrada = new DataInputStream(new FileInputStream(NOMBREDAT))) {
			
				int cuantos = entrada.readInt();
				
				for (int i = 0; i < cuantos; i++) {
					persona = new Persona();
					persona.fromDAT(entrada);
					listaPersonas.add(persona);
				
				}
				
				System.out.println(".DAT cargado correctamente...");

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}



	private void consultas() {
		String descripcionMasLarga = "";
		Tarea tareaMasLarga = null;

		System.out.println("\nConsultas: ");
		System.out.println("\n1. Tarea con la descripcion mas larga");
		for (Persona persona : listaPersonas) {
			for (Tarea tarea : persona.getListaTareas()) {
				if (tarea.getDescripcion().length() > descripcionMasLarga.length()) {
					descripcionMasLarga = tarea.getDescripcion();
					tareaMasLarga = tarea;
				}
			}
		}
		System.out.println("La tarea con la descripcion mas larga es: " + tareaMasLarga);

		System.out.println("\n2. Tareas pendientes");
		List<Tarea> tareasPendientes = new ArrayList<Tarea>();
		for (Persona persona : listaPersonas) {
			for (Tarea tarea : persona.getListaTareas()) {
				if (!tarea.isCompletada()) {
					tareasPendientes.add(tarea);
				}
			}
		}
		tareasPendientes.forEach(System.out::println);

		System.out.println("\n3. Tareas completadas");
		;
		List<Tarea> tareasCompletadas = new ArrayList<Tarea>();
		for (Persona persona : listaPersonas) {
			for (Tarea tarea : persona.getListaTareas()) {
				if (tarea.isCompletada()) {
					tareasCompletadas.add(tarea);
				}
			}
		}
		tareasCompletadas.forEach(System.out::println);

		System.out.println("\n4. Tareas con prioridad alta");
		for (Persona p : listaPersonas) {
			for (Tarea tarea : p.getListaTareas()) {
				if (tarea instanceof TareaPersonal && ((TareaPersonal) tarea).getPrioridad() == Prioridad.ALTA) {
					System.out.println(tarea);
				}
			}
		}
	}

	private void salirPrograma() {

		System.out.println("Saliendo del programa...");

	}

	private void crearPersona() {
		Persona persona = new Persona();
		do {
			persona.leerID();
		} while (existePersona(persona.getDni()));
		persona.leerSoloDatos();
		listaPersonas.add(persona);
		
		System.out.println("Persona creada con exito...");

	}

	private void eliminarTarea() {
		int id;
		do {
			listar();
			id = Teclado.leerInt("Introduce el id de la tarea a eliminar: ");
		} while (!existeTarea(id));

		final int idFinal = id;
		listaPersonas.forEach(p -> p.deleteTarea(idFinal));
		System.out.println("Tarea eliminada...");
	}

	private void marcarCompletada() {
		
		int id;
		do {
			listar();
			id = Teclado.leerInt("Introduce el id de la tarea a marcar como completada: ");
		} while (!existeTarea(id));
		
		final int idFinal = id;
		//completar la tarea
		listaPersonas.forEach(p -> p.marcarTarea(idFinal));
	}

	private boolean existeTarea(int id) {
		/*boolean existe = false;
		for (Tarea tarea : listaTareas) {
			if (tarea.getId() == id) {
				existe = true;
			}
		}
		return existe;
		*/
		return listaPersonas.stream()
				.anyMatch(p -> p.getListaTareas()
				.stream()
				.anyMatch(t -> t.getId() == id));
	}

	private void listar() {
		System.out.println("\nLista de Personas: ");
		listaPersonas.forEach(p -> System.out.println(p));
		
		System.out.println("\nLista de Tareas: ");
		listaPersonas.forEach(p -> p.listar());

		
	}

	private void crearTarea() {
		String letra,descripcion,prior,idPer;
		Prioridad prioridad;
		Tarea tarea;
		Persona persona=null;
		LocalDate fecha;
		
		do {
			listar();
			idPer = Teclado.leerString("\nIntroduce el DNI de la persona a la que asignar la tarea: ");
		} while (!existePersona(idPer));
		
		for (Persona p : listaPersonas) {
			if (p.getDni().equals(idPer)) {
				persona = p;
			}
		}
		
		do {
			letra = Teclado.leerString("Es una tarea Personal(P) o Trabajo(T)?").toUpperCase();
		} while (!letra.equals("P") && !letra.equals("T"));
		
		descripcion = Teclado.leerString("Descripcion de la tarea: ");
		
		if (letra.equals("P")) {
			do {
				prior = Teclado.leerString("Prioridad (Alta, Media, Baja): ").toUpperCase();
				try {
		            prioridad = Prioridad.valueOf(prior);
		        } catch (IllegalArgumentException e) {
		            prioridad = null;
		            System.out.println("Prioridad no válida. Inténtalo de nuevo.");
		        }
			} while (prioridad == null);
			
			tarea = new TareaPersonal(descripcion,false,prioridad);
		} else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			do {
				try {
					fecha = LocalDate.parse(Teclado.leerString("Fecha de entrega (dd-MM-yyyy): "), formatter);

				} catch (DateTimeParseException e) {
					fecha = null;
					System.out.println("Fecha no válida. Inténtalo de nuevo.");
				}
				tarea = new TareaTrabajo(descripcion,fecha);
			} while (fecha == null);
		}
		persona.addTarea(tarea);
		System.out.println("\nTarea agregada con exito...");
	}

	private boolean existePersona(String idPer) {
		
		return listaPersonas.stream().anyMatch(p -> p.getDni().equals(idPer));
	}
	
	private void DatosPredefinidos() {
		Persona p1 = new Persona("001","Marcos");
		Persona p2 = new Persona("002","Juan");
		Persona p3 = new Persona("003","Pepe");
		Tarea t1 = new TareaPersonal("Hacer compra",true,Prioridad.ALTA);
		Tarea t2 = new TareaPersonal("Quedar con amigos",false,Prioridad.MEDIA);
		Tarea t3 = new TareaPersonal("Estudiar para examen",true,Prioridad.ALTA);
		Tarea t4 = new TareaPersonal("Hacer deporte",false,Prioridad.ALTA);
		Tarea t5 = new TareaPersonal("Salir a pasear",true,Prioridad.BAJA);
		
		p1.addTarea(t1);
		p1.addTarea(t2);
		p2.addTarea(t3);
		p2.addTarea(t4);
		p3.addTarea(t5);
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		
		listar();
		System.out.println("\nPersonas con tareas cargadas correctamente...");
		
	}

	private void mostrarOpciones() {
		System.out.println("\n----- Sistema de gestion de tareas -----\n");
		System.out.println("0. Crear Persona");
		System.out.println("1. Crear tarea");
		System.out.println("2. Listar ");
		System.out.println("3. Marcar tarea como completada");
		System.out.println("4. Eliminar tarea");
		System.out.println("5. Consultas");
		System.out.println("6. Datos predefinidos");
		System.out.println("7. CARGAR datos guardados(CSV-DAT)");
		System.out.println("8. GUARDAR Datos(CSV-DAT)");
		System.out.println("9. Salir\n");
		System.out.println("----------------------------------------");
	}

	

}

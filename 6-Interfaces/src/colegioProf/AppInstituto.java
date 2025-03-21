package colegioProf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppInstituto extends AppConMenu {

	// Datos de la aplicaci�n
	private Instituto instituto;

	public AppInstituto(List<String> opciones) {
		super(); // Crear AppConMenu
		addOpcion("Alta Profe");
		addOpcion("Alta Alumno");
		addOpcion("Baja profesor");
		addOpcion("Localizar Persona");
		addOpcion("Convocar tutoría");
		addOpcion("Comunicacion Tutor");
		addOpcion("Leer Correo");
		addOpcion("Enviar Mensaje");

		instituto = new Instituto(); // Crear los datos
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AppInstituto app;

		List<String> opciones;

		// Añadir las opciones del men�
		opciones = new ArrayList<>();

		// Construir un objeto aplicaci�n
		app = new AppInstituto(opciones);

		//RedirigirTeclado.fromFile("personas.in");
		app.leerDatosPeronas();
		//RedirigirTeclado.fromKeyboard();

		// Ejecutar la aplicaci�n
		app.run();

	}

	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub
		switch (opc) {
		case 1:
			darAlta(2);
			break;
		case 2:
			darAlta(1);
			break;
		case 3:
			darBaja();
			break;
		case 4:
			localizarPersona();
			break;
		case 5:
			convocarTutoria();
			break;
		case 6:
			comunicarAlTutor();
			break;
		case 7:
			leerMensajes();
			break;
		case 8:
			enviarMensaje();
			break;
		case 9:
			salir();
			break;

		}

	}

	private void enviarMensaje() {
		// TODO Auto-generated method stub
		String nif;
		Persona emisor, receptor;
		Mensaje m;

		nif = Teclado.leerString("nif emisor");

		emisor = instituto.getPersona(nif);

		if (emisor != null) {
			nif = Teclado.leerString("nif receptor");
			receptor = instituto.getPersona(nif);
			if (receptor != null) {
				m = new Mensaje();
				m.setContenido(Teclado.leerString("\nContenido"));
				m.setEmisor(emisor.getNif());
				receptor.addMensaje(m);
			} else
				Pantalla.escribirString("\nNo existe la persona con ese nif");
		} else
			Pantalla.escribirString("\nNo existe la persona con ese nif");
	}

	private void salir() {
		// TODO Auto-generated method stub
		Consumer<Persona> mostrarPersona, mostrarIdentificacion;

		mostrarPersona = new Consumer<Persona>() {

			@Override
			public void accept(Persona t) {
				// TODO Auto-generated method stub
				Pantalla.escribirSaltoLinea();
				t.identificar();

			}

		};

		mostrarIdentificacion = new MostrarIdentificacion();
		instituto.getPersonas().forEach(mostrarPersona);

		/*
		 * for (Persona t : instituto.getPersonas()) { Pantalla.escribirSaltoLinea();
		 * t.identificar(); }
		 */

		Pantalla.escribirString("\nFIN");

	}

	private void leerMensajes() {
		// TODO Auto-generated method stub
		String nif;
		Persona persona;

		nif = Teclado.leerString("nif");

		persona = instituto.getPersona(nif);

		if (persona != null)
			persona.leerCorreo();
		else
			Pantalla.escribirString("\nNo existe la persona con ese nif");

	}

	public void leerDatosPeronas() {
		String respuesta;
		Persona persona;
		int tipo;
		String nif;

		do {
			tipo = Teclado.leerInt("1. Alumno - 2. Profesor");

			darAlta(tipo);

			respuesta = Teclado.leerString("sigo S/N?");
		} while (respuesta.equalsIgnoreCase("S"));

	}

	public void darAlta(int tipo) {

		String nif;
		Persona persona;
		String resultado;

		do {
			nif = Teclado.leerString("nif");
		} while (instituto.getPersona(nif) != null);

		persona = FactoriaPersona.crearPersona(tipo, nif);
		persona.leerDatos();

		if (instituto.addPersona(persona))
			Pantalla.escribirString("\nPersona dada de alta correctamente");
		else
			Pantalla.escribirString("\nPersona ya existente");

	}

	public String leerNif() {
		String nif;

		do {
			nif = Teclado.leerString("nif");
		} while (instituto.getPersona(nif) == null);

		return nif;
	}

	public void darBaja() {
		String nif;

		nif = leerNif();

		instituto.eliminarPersona(nif);
	}

	public void localizarPersona() {
		String nif = leerNif();

		Pantalla.escribirString("\n" + instituto.getPersona(nif).getAgenda().toString());
	}

	public void convocarTutoria() {
		LocalDate fecha;
		Persona p;
		Profesor profe;
		String nif = leerNif();
		// leer fecha

		String fechaString;

		p = instituto.getPersona(nif);

		if (p instanceof Profesor) {
			fechaString = Teclado.leerString("\naaaa-mm-dd");
			fecha = LocalDate.parse(fechaString);
			profe = (Profesor) p;

			profe.convocarTutoria(fecha);
		} else
			Pantalla.escribirString("\nNo es un profe");

	}

	public void comunicarAlTutor() {
		String nif = leerNif();
		String texto = Teclado.leerString("texto a comunicar");

		Alumno alumno = (Alumno) instituto.getPersona(nif);

		Profesor tutor = instituto.buscarTutor(alumno);

		if (tutor != null)
			tutor.addMensaje(new Mensaje(alumno.getNif(), LocalDate.now(), texto));
		else
			Pantalla.escribirString("\nNo hay tutor asignado");
	}

}

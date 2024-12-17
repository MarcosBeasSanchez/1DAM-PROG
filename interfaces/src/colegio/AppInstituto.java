package colegio;

import java.util.ArrayList;

import cestaCompra.AppConMenu;
import cestaCompra.AppTienda;
import cestaCompra.Tienda;
import daw.com.Pantalla;
import daw.com.Teclado;

public class AppInstituto extends AppConMenu {
	private Instituto instituto;

	public AppInstituto() {
		// Llamar al constructor padre
				super ();
				
				// Cargar Opciones de menÃº
				addOpcion("Añadir profesor");
				addOpcion("Añadir alumno");
				addOpcion("Eliminar profesor");
				addOpcion("Localizar persona");
				addOpcion("Convocar sesión de tutoría conjunta");
				addOpcion("Comunicación al tutor");
				addOpcion("Leer mensajes");
				addOpcion("Enviar mensaje");
				addOpcion("Salir");
				
				
				// crear instituto
				instituto = new Instituto();
	}

	public static void main(String[] args) {
		AppInstituto app = new AppInstituto();
		
		app.cargarDatos ();
		
		
		// Ejecutar menu
		app.run();

	}
	
	private void cargarDatos() {
		cargarPersonas();
	}

	private void cargarPersonas() {
		Persona p;
		int res =0;
		String clave;
		
		do {
			clave = Teclado.leerString("NIF de la Persona: " );
			
			if (instituto.getAlumno(clave) == null || instituto.getProfesor(clave) == null) {
				
				do {
					res =  Teclado.leerInt("1.Profesor / 2.Alumno");
					
				} while (res !=1 && res !=2);
				
				p = FactoriaProfeAlumno.crearPersona(res);
				p.LeerDatos();
				instituto.addPersona(p);
				
			} else 
				Pantalla.escribirString("\nPersona ya dado de alta");

		} while ((Teclado.leerString("Seguir? (s/n)").equalsIgnoreCase("s")));
	}

	@Override
	public void evaluarOpcion(int opc) {
		// TODO Auto-generated method stub
		
		switch (opc)
		{
			case 1:
				añadirProfesor();
				break;
			case 2:
				añadirAlumno ();
				break;
			case 3:
				eliminarProfesor ();
				break;
			case 4:
				localizarPersona();
				break;
			case 5:
				convocarSesion();
				break;	
			case 6:
				comunicacionTutor();
				break;
			case 7:
				leerMensajes();
				break;
			case 8:
				enviarMensajes();
				break;
			case 9:
				salir ();
				break;
	
		}
		
	}

	private void añadirProfesor() {
		instituto.addProfesor();
	}

	private void añadirAlumno() {
		instituto.addAlumno();
		
	}

	private void eliminarProfesor() {
		instituto.removeProfesor();
	}

	private void localizarPersona() {
		instituto.localizarPer();
		
	}

	private void convocarSesion() {
		instituto.convocar();
	}

	private void comunicacionTutor() {
		instituto.comunicar();
	}

	private void leerMensajes() {
		instituto.leer();
	}

	private void enviarMensajes() {
		instituto.enviar();
		
	}

	private void salir() {
		instituto.salir();
	}

}

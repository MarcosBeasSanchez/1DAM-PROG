package colegio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;

public class Instituto {
	
	private String nombreCentro ;
	private List<Persona> personas;

	//Constructores
	public Instituto(String nombreCentro, List <Persona> personas) {
		this.nombreCentro = nombreCentro;
		this.personas = new ArrayList<Persona>();
	}
	
	public Instituto() {
		this.nombreCentro = "IES VILLABLANCA";
		this.personas = new ArrayList<Persona>();
	}
	//Getters Setters

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	
	public List<Persona> getPersonas() {
		return personas;
	}
	
	public void addPersona(Persona p) {
		personas.add(p);
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Alumno getAlumno(String nif) {
		Alumno a = null , aux;
		int lugar;
		
		aux = new Alumno(nif);
		
		lugar =  personas.indexOf(aux);
		
		if (lugar >= 0 && a instanceof Alumno) {
			a = (Alumno) personas.get(lugar);
		}
		return a;
	}
	
	public Profesor getProfesor(String nif) {
		Profesor p = null , aux;
		int lugar;
		
		aux = new Profesor(nif);
		
		lugar =  personas.indexOf(aux);
		
		if (lugar >= 0 && p instanceof Profesor) {
			p = (Profesor) personas.get(lugar);
		}
		return p;
		
	}
	
	public Persona getPersona(String nif) {
		Persona p = null , aux;
		int lugar;
		
		aux = new Profesor(nif);
		
		lugar =  personas.indexOf(aux);
		
		if (lugar >= 0) {
			//retorna una Persona
			p = personas.get(lugar);
		}else {
			System.out.println("Persona con NIF " + nif + " No encontrada");
		}
		
		return p;

	}
	
	public void addProfesor() {
		
		String dni;
		dni = Teclado.leerString("Ingrese el DNI del profesor:");
		
		for (Persona p : personas) {
			if (p.getNif().equalsIgnoreCase(dni) && p instanceof Profesor) {
				 System.out.println("El profesor ya existe en la base de datos.");
	                return; // Terminar el método si el profesor ya existe
			}else {
				Profesor nuevo = new Profesor(dni);
				personas.add(nuevo);
			}
		}
		
	}
	
	public void addAlumno() {
		
		String dni;
		dni = Teclado.leerString("Ingrese el DNI del Alumno:");
		
		for (Persona a : personas) {
			if (a.getNif().equalsIgnoreCase(dni)) {
				 System.out.println("DNI ya existe en la base de datos.");
	                return; // Terminar el método si el profesor ya existe
			}else {
				//Crear nuevo alumno a partir del dni
				Alumno nuevo = new Alumno(dni);
				personas.add(nuevo);
				System.out.println("Alumno añadido : " + nuevo.getNombre() + " " + nuevo.getApellidos());
				//Asignar tutor automaticamente si tiene menos de 10 alumnos
		        Profesor tutor = buscarTutorDisponible(personas);
		        tutor.agregarAlumno(nuevo);
		        System.out.println("tutor asignado : " + tutor.getNombre());
		        //Enviar mensaje bienvenida
		        tutor.enviarMensaje(nuevo,"Bienvenido al Instituto ");
				}
			}
		}
	
	 private Profesor buscarTutorDisponible(List<Persona> personas) {
	        for (Persona p : personas) {
	            if ( p instanceof Profesor && ((Profesor) p).getNalumnos() < 10) {
	                return (Profesor) p;
	            }
	        }
	        return null; // Devuelve null si no se encuentra un tutor disponible con menos de 10 alumnos
	    }
	
	public void removeProfesor(){
		
		String dni;
		dni = Teclado.leerString("Ingrese el DNI del Profesor:");
		Profesor prof = getProfesor(dni);
		
		for (Persona p : personas) {
			if (p.getNif().equalsIgnoreCase(dni) && p != null && p instanceof Profesor) {
				//Reasignar alumnos a nuevos a un profesor nuevo 
				Profesor tutorCambio = buscarTutorDisponible(personas);
				
				tutorCambio.setAlumnos(prof.getAlumnos()); // mete los alumnos del antiguo profesor en el nuevo // ERROR puede meter mas de 10 alumnos
				
				//Eliminar profesor
				personas.remove(p);
				}else {
					System.out.println("No existe ningun PROFESOR con este DNI " + dni);
				}
			}	
		}


	public void localizarPer() {
		
		String nif;
		nif = Teclado.leerString("Nif a buscar");
		
	        // Buscar la persona en la lista 
	        for (Persona per : personas) {
	            if (per.getNif().equalsIgnoreCase(nif)) {
	                // Mostrar números de teléfono 
	                System.out.println("Números de teléfono de " + per.getNombre() + ":");
	                for (Telefono telefono : per.getAgenda()) {
	                    System.out.println(telefono.getTipo() + ": " + telefono.getNumero());
	                }
	            }else {
	            	 // Si no se encontró la persona
	    	        System.out.println("No se encontró a ninguna persona con el NIF proporcionado.");
	            }
	        }
	    }

	public void convocar() {
		String nif;
		LocalDate fechaReunion;
		nif = Teclado.leerString("Nif Profesor");
		Profesor prof = getProfesor(nif);
	
		for (Persona persona : personas) {
			if (prof.getNif().equalsIgnoreCase(persona.getNif())) {
				//enviar mensaje
				fechaReunion = LocalDate.parse(Teclado.leerString("\nFecha de Reunion (aaaa-mm-dd)"));
				for (Alumno alumno : prof.getAlumnos()) {
					prof.enviarMensaje(alumno, "Queda convocado/a a al sesión de tutoria en el despacho\r\n"
					 		+ prof.getDespacho() + "con fecha " + fechaReunion);
				}
			} else {
				System.out.println("Nif Profesor NO encontrado");			
				}
			}
		}
		
	public void leer() {
		String nif;
		nif = Teclado.leerString("Nif Persona");
		Persona per = getPersona(nif);
		
		for (Persona persona : personas) {
			if (per.getNif().equalsIgnoreCase(persona.getNif())) {
				for (Mensaje m : persona.getBuzon()) {
					System.out.println("/n" + m);
				}
				per.vaciarBuzon();
			}else {
				System.out.println("Persona No encontrada");
			}
		}
	}
	
	public void comunicar() {
		String nif , msg;
		nif = Teclado.leerString("Nif Estudiante");
		Alumno per = getAlumno(nif);
	
		for (Persona alumno : personas) {
			if (per.getNif().equalsIgnoreCase(alumno.getNif())) {
				msg = Teclado.leerString("Mensaje a enviar al tutor");
				
				per.enviarMsgTutor(msg, per.getTutor());
			}else {
				System.out.println("Estudiante No encontrado");
			}
		}
	}

	public void enviar() {
		String nifEmisor,nifReceptor;
		nifEmisor = Teclado.leerString("Nif Emisor");
		nifReceptor = Teclado.leerString("Nif Receptor");
		Persona Emisor = getPersona(nifEmisor);
		Persona Receptor = getPersona(nifReceptor);

		
	}

	public void salir() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

package colegio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;

public class Profesor extends Persona {
	
	  	private String departamento;
	    private String despacho;
	    private List<Alumno> alumnos;

	    //Cosntructores
	public Profesor(String nif, String nombre, String apellidos, String poblacion, String anioNacimiento, String departamento, String despacho) {
		super(nif, nombre, apellidos, poblacion, anioNacimiento);
		 this.departamento = departamento;
	     this.despacho = despacho;
	     this.alumnos = new ArrayList<Alumno>();
	}

	public Profesor() {
		 super();
		 this.departamento = "";
		 this.despacho = "";
		 this.alumnos = new ArrayList<>();
	}
	
	public Profesor(String nif) {
		super(nif, "", "", "", ""); // Llama al constructor de la clase base con los valores predeterminados
	    this.departamento = "";
	    this.despacho = "";
	    this.alumnos = new ArrayList<>();
	}

	//Getters Settrers

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public int getNalumnos() {
		return alumnos.size();
	}

	public void setAlumnos(List<Alumno> tutorandos) {
		this.alumnos = tutorandos;
	}
	// toString
	@Override
	public String toString() {
		return "Profesor"+ super.toString() + "[departamento=" + departamento + ", despacho=" + despacho + ", tutorandos=" + alumnos + "]";
	}
	//Datos
	public void leerOtrosDatos() {
		super.leerOtrosDatos();
		this.departamento = Teclado.leerString("Departamento");
		this.despacho = Teclado.leerString("Despacho");
	}
	
	//Metodos
	public void agregarAlumno(Alumno estudiante) {
        alumnos.add(estudiante);
        estudiante.setTutor(this);
    }
	
	 public void enviarMensaje(Alumno alumno, String mensaje) {
	        // Crear una instancia de Mensaje con el emisor (profesor), el receptor (alumno), el contenido del mensaje y la fecha actual
	        Mensaje mensajeEnviado = new Mensaje(this.getNombre(), LocalDate.now(), mensaje);
	        
	        // Agregar el mensaje al buzón del alumno
	        alumno.recibirMensaje(mensajeEnviado);
	        
	        System.out.println(mensaje + " " + LocalDate.now());
	        System.out.println("Mensaje enviado desde " + this.getNombre() + " a " + alumno.getNombre() + ": " + mensaje);
	    }
	public void reasignarAlumnos() {
		
	}
	
	

}

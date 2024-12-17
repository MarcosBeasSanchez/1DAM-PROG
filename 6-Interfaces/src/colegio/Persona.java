package colegio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import daw.com.Teclado;

public abstract class Persona {
	
	private String nif,nombre,apellidos,poblacion,anioNacimiento;
	private Direccion direccion;
	private List<Telefono>agenda;
	private List<Mensaje> buzon;
	
	//Constructores
	public Persona(String nif,String nombre,String apellidos,String poblacion,String anioNacimiento) {
		   	this.nombre = nombre;
	        this.apellidos = apellidos;
	        this.nif = nif;
	        this.anioNacimiento = anioNacimiento;
	        this.poblacion = poblacion;
	        this.direccion = new Direccion();
	        this.agenda = new ArrayList<>();
	        this.buzon = new ArrayList<>();
	}
	
	public Persona() {
		this("","","","","");
	}
	
	//Getters Setters
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(String anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Telefono> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Telefono> agenda) {
		this.agenda = agenda;
	}

	public List<Mensaje> getBuzon() {
		return buzon;
	}

	public void setBuzon(List<Mensaje> buzon) {
		this.buzon = buzon;
	}
	
	//toString Equals
	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", poblacion=" + poblacion
				+ ", anioNacimiento=" + anioNacimiento + ", direccion=" + direccion + ", agenda=" + agenda + ", buzon="
				+ buzon + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*
		if (getClass() != obj.getClass())
			return false;
		*/
		Persona other = (Persona) obj;
		return Objects.equals(agenda, other.agenda) && Objects.equals(anioNacimiento, other.anioNacimiento)
				&& Objects.equals(apellidos, other.apellidos) && Objects.equals(buzon, other.buzon)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(nif, other.nif)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(poblacion, other.poblacion);
	}
	
	//Datos 
	public void LeerDatos() {
		leerClave();
		leerOtrosDatos();
	}
	
	public void leerClave() {
		nif = Teclado.leerString("NIF");
	}
	
	public void leerOtrosDatos() {
		nombre = Teclado.leerString("Nombre");
		apellidos = Teclado.leerString("Apellidos");
		anioNacimiento = Teclado.leerString("Anio de nacimiento");
		poblacion = Teclado.leerString("Poblacion");
	}
	
    

	
	//Metodos
	public void agregarTelefono(String tipo, String numero) {
	    Telefono nuevoTelefono = new Telefono(tipo, numero);
	    agenda.add(nuevoTelefono);
	}

    public void recibirMensaje(Mensaje mensaje) {
        buzon.add(mensaje);
    }

    // Método para leer y eliminar mensajes del buzón
    public List<Mensaje> leerMensajes() {
        List<Mensaje> mensajes = new ArrayList<>(buzon);
        buzon.clear();
        return mensajes;
    }
    
    public void vaciarBuzon() {
    	buzon.removeAll(this.getBuzon()); // Remueve todos los mensajes de la persona
        this.getBuzon().clear(); // Limpia la lista de mensajes de la persona
    }
    
    

}

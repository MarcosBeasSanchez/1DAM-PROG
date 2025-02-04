package tareas;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import daw.com.Teclado;

public class Persona implements Leer , Serializable{
	
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	List<Tarea>listaTareas;
	
	
	public Persona() {
		this.dni = "";
		this.nombre = "";
		listaTareas = new ArrayList<Tarea>();
	}
	
	public Persona(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		listaTareas = new ArrayList<Tarea>();
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) throws IllegalArgumentException{
		if (dni == "" || dni == null) {
			throw new IllegalArgumentException("DNI vacio no valido");
		}
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Tarea> getListaTareas() {
		return listaTareas;
	}
	public void setListaTareas(List<Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}
	
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + " Tareas: " + listaTareas + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
	
	public void addTarea(Tarea t) {
		listaTareas.add(t);
	}
	
	public void deleteTarea(Tarea t) {
		listaTareas.remove(t);
	}
	
	public void listar() {
		for (Tarea tarea : listaTareas) {
			System.out.println(tarea);
		}
	}
	
	public boolean existeTarea(int id) {
		boolean existe = false;
		for (Tarea tarea : listaTareas) {
			if (tarea.getId() == id) {
				existe = true;
			}
		}
		if (!existe) {
			System.out.println("Tarea no encontrada");
		}
		return existe;
	}
	
	public void marcarTarea(int id) {
		for (Tarea tarea : listaTareas) {
			if (existeTarea(id)) {
				tarea.setCompletada(true);
				System.out.println("Tarea marcada como completada...");
			}else {
				System.out.println("Tarea no encontrada...");
			}
		}
	}
	
	public void deleteTarea(int id) {
		for (Tarea tarea : listaTareas) {
			if (existeTarea(id)) {
				listaTareas.remove(tarea);
				System.out.println("Tarea elliminada correctamente...");
			}else {
				System.out.println("Tarea no encontrada...");
			}
		}
		
	}
	
	
	@Override
	public void leerID() {
		do {
			try {
				setDni(Teclado.leerString("DNI de la persona: "));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				dni = null;
			}
		} while (dni == null);
		
		
	}
	@Override
	public void leerDatos() {
		do {
			try {
				setNombre(Teclado.leerString("Nombre de la persona: "));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				nombre = null;
			}
		} while (nombre == null);
	}

	public void toCSV(PrintWriter salida) {
		salida.print(dni);
		salida.print(";");
		salida.print(nombre);
		salida.print(";");
		salida.print(listaTareas.size());
		salida.print(";");
		for (Tarea tarea : listaTareas) {
			tarea.toCSV(salida);
		}		
		salida.println("");
	}
	
	public void fromCSV(BufferedReader salida,Persona persona) throws IOException {
		Tarea tarea;
		int cuantos;
		
		String linea = salida.readLine();
		String val[] = linea.split(";");
		
		persona.setDni(val[0]);
		persona.setNombre(val[1]);
		cuantos = Integer.parseInt(val[2]);
		
		for (int i = 0; i < cuantos; i++) {
			if (val[3].equalsIgnoreCase("PERSONAL")) {
				tarea= new TareaPersonal();
			} else {
				tarea = new TareaTrabajo();
			}
			tarea.fromCSV(val);
			listaTareas.add(tarea);

		}	
	}

	public void toDAT(DataOutputStream salida) throws IOException {
		salida.writeUTF(dni);
		salida.writeUTF(nombre);
		salida.writeInt(listaTareas.size());
		
		for (Tarea tarea : listaTareas) {
			if (tarea instanceof TareaPersonal) {
				salida.writeUTF("PERSONAL");
			}else {
				salida.writeUTF("TRABAJO");
			}
			tarea.toDAT(salida);
		}
		
	}

	public void fromDAT(DataInputStream entrada) throws IOException {
		Tarea tarea;
		dni = entrada.readUTF();
		nombre = entrada.readUTF();
		int cuantos = entrada.readInt();
		
		for (int i = 0; i < cuantos; i++) {
			String tipo = entrada.readUTF();
			
			if (tipo.equalsIgnoreCase("PERSONAL")) {
				tarea = new TareaPersonal();
			} else {
				tarea = new TareaTrabajo();
			}
			tarea.fromDAT(entrada);
			listaTareas.add(tarea);
		}
		
		
		
	}
	
	
	
	
	

}

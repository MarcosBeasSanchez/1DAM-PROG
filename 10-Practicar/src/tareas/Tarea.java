package tareas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import daw.com.Teclado;

public abstract class Tarea implements Leer,Serializable{
	
	private static final long serialVersionUID = 1L;

	private static int generadorID = 0;
	
	private int id;
	private String descripcion;
	private boolean completada;

	public Tarea(String desciption) {
		this.id = generarId();
		this.descripcion = desciption;
		this.completada = false;
	}
	public Tarea(String desciption,boolean completada) {
		this.id = generarId();
		this.descripcion = desciption;
		this.completada = completada;
	}
	
	private int generarId() {
		return ++generadorID;
	}

	public void marcarComoCompletada() {
		completada = true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("El id no puede ser negativo");
		}
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", descripcion=" + descripcion + ", completada=" + completada + "]";
	}
	
	public abstract void mostrar();
	
	@Override
	public void leerID() {
		do {
			try {
				id = Teclado.leerInt("Introduce el id de la tarea: ");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (id != 0 && id < 0 );
		
	}

	@Override
	public void leerDatos() {
		do {
            try {
                descripcion = Teclado.leerString("Introduce la descripcion de la tarea: ");
                completada = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (descripcion != null && descripcion.equalsIgnoreCase(""));
        
    }
	public abstract void toCSV(PrintWriter salida);
	public abstract void toDAT(DataOutputStream salida) throws IOException;
	public abstract void fromCSV(String[] val);
	public abstract void fromDAT(DataInputStream entrada) throws IOException;
		
	}
	

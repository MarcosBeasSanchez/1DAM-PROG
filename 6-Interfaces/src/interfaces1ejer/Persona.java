package interfaces1ejer;

public class Persona {
	
	private String nombre;
	private int edad;
	
	public Persona ( String nombre, int edad) {
		setNombre(nombre);
		setEdad(edad);
	}
	public Persona() {
		this("",0);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if (nombre == null) {
			nombre = "";
		}
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad < 0? 0 : edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
}

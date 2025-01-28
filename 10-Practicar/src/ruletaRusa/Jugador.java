package ruletaRusa;

public class Jugador {

	private String nombre;
	private boolean estado;

	public Jugador() {
		this.nombre= "Sin nombre";
		this.estado= true;
	}

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.estado = true;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + " estado=" + (estado ? "vivo" : "muerto")+ "]";
	}

	
}

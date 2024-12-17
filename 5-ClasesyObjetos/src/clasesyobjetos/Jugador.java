package clasesyobjetos;

import daw.com.Teclado;

public class Jugador {
	
	// Estado
	
	private String nombre;
	private int puntos;
	private boolean estado; // planta o pasa
	
	
	public Jugador() { // Defecto
		nombre ="";
		puntos = 0;
		estado = true;
	}
	public Jugador(String nombre , int puntos , boolean estado) { // pedido
		setNombre(nombre);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		if (nombre.equalsIgnoreCase(""))
			nombre = Teclado.leerString(" Nombre de Jugador : ");
		this.nombre = nombre;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}

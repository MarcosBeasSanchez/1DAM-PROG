package seriesYvideojuegos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Serie implements Entregable{
	private String titulo;
	private int temporadas;
	private Genero genero;
	private String creador;
	private boolean entregado;
	
	public Serie(String titulo, int temporadas, Genero genero, String creador) {
		
		this.titulo = titulo;
		setTemporadas (temporadas);
		this.genero = genero;
		this.creador = creador;
		entregado = false;
	}

	public Serie(String titulo, String creador) {
		this (titulo, 3, Genero.ACCION, creador);
	}
	
	public Serie ()
	{
		this ("", 3, Genero.ACCION, "");
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		if (temporadas < 0)
			temporadas = 0;
		this.temporadas = temporadas;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", temporadas=" + temporadas + ", genero=" + genero + ", creador=" + creador
				+ ", entregado=" + (entregado?"Sï¿½":"No")+ "]";
	}
	

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Serie other = (Serie) obj;
		if (titulo == null) {
			if (other.titulo != null) {
				return false;
			}
		} else if (!titulo.equals(other.titulo)) {
			return false;
		}
		return true;
	}

	public void leerDatos ()
	{
		titulo = Teclado.leerString("Titulo Serie");
		setTemporadas (Teclado.leerInt("Temporadas"));
		do
		{
			genero = Genero.toGenero(Teclado.leerString("Genero"));
		}while (genero == null);
		this.creador = Teclado.leerString("Creador");
	}

	@Override
	public void entregar() {
		// TODO Auto-generated method stub
		entregado = true;
	}

	@Override
	public void devolver() {
		// TODO Auto-generated method stub
		entregado = false;
	}

	@Override
	public boolean isEntregado() {
		// TODO Auto-generated method stub
		return entregado;
	}

	@Override
	public int compareTo(Entregable o) {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nEstoy en compareTo de Serie");
		Serie otro = (Serie) o;
		return titulo.compareTo(otro.titulo); 
	}
	
}
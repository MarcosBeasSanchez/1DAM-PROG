package ismael;

import java.util.Objects;

import daw.com.Teclado;

public class Pelicula extends Material implements LeerYMostrarDatos {
	
	String director,resumen;
	
	public Pelicula(int id, String titulo, String director, String resumen) {
		super(id, titulo);
		this.director=director;
		this.resumen = resumen;
	}

	public Pelicula() {
		super();
		this.director="";
		this.resumen = "";
	}

	public Pelicula(int id) {
		super(id);
		this.director="";
		this.resumen = "";
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		this.director= Teclado.leerString("director");
		this.resumen = Teclado.leerString("resumen");
	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(director);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
	
		Pelicula other = (Pelicula) obj;
		return Objects.equals(director, other.director);
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", resumen=" + resumen + "]" + super.toString();
	}
	

}

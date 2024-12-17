package ismael;

import java.util.Objects;

import daw.com.Teclado;

public class Material implements LeerYMostrarDatos {
	
	
	String titulo;
	int id;

	public Material(int id, String titulo) {
		setId(id);
		this.titulo = titulo;
	}
	
	public Material() {
		this.id = 0;
		this.titulo = "";
	}
	
	public Material(int id) {
		this.id = id;
		this.titulo = "";
	}
	
	//Getters setters 
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id > 0 ? id : 0;
	}

	// metodos
	@Override
	public String toString() {
		return "Material [titulo=" + titulo + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		Material other = (Material) obj;
		return id == other.id && Objects.equals(titulo, other.titulo);
	}

	@Override
	public void leerId() {
		this.id =Teclado.leerInt("ID");
	}

	@Override
	public void leerRestoDatos() {
	this.titulo = Teclado.leerString("Titulo");
		
	}
	

}

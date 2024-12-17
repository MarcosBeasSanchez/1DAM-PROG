package ismael;

import java.util.Objects;

import daw.com.Teclado;

public class Libro extends Material implements LeerYMostrarDatos {
	
	int pag;
	String autor,genero;

	
	public Libro(int id, String titulo, int pag, String autor, String genero) {
		super(id, titulo);
		setPag(pag);
		this.autor = autor;
		this.genero = genero;
	}

	public Libro() {
		super();
		setPag(0);
		this.autor = "";
		this.genero = "";
	}

	public Libro(int id) {
		super(id);
		setPag(0);
		this.autor = "";
		this.genero = "";
	}

	public int getPag() {
		return pag;
	}

	public void setPag(int pag) {
		this.pag = pag > 0 ? pag : 0;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		this.autor= Teclado.leerString("autor");
		this.genero = Teclado.leerString("genero");
		this.pag = Teclado.leerInt("Num pag");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(autor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor);
	}

	@Override
	public String toString() {
		return "Libro [pag=" + pag + ", autor=" + autor + ", genero=" + genero + "]" + super.toString();
	}
	
	
	
	
	
	
	

}

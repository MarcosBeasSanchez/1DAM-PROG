package ismael;

import java.util.Objects;

import daw.com.Teclado;

public class Disco extends Material implements LeerYMostrarDatos {
	String discografia;

	public Disco(int id, String titulo,String discografia) {
		super(id, titulo);
		this.discografia = discografia;
	}

	public Disco() {
		super();
		this.discografia = "";
	}

	public Disco(int id,String titulo) {
		super(id);
		this.titulo =titulo;
		this.discografia = "";
	}

	public String getDiscografia() {
		return discografia;
	}

	public void setDiscografia(String discografia) {
		this.discografia = discografia;
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		this.discografia= Teclado.leerString("Dicografia");
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(discografia);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		
		Disco other = (Disco) obj;
		return Objects.equals(discografia, other.discografia);
	}

	@Override
	public String toString() {
		return "Disco [discografia=" + discografia + "]" + super.toString();
	}
	
	
	
	
	

}

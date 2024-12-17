package interfacesProbando;



public class Animal {
	private String tipo;
	private String continente;
	
	
	
	
	public Animal() {
		this("","");
	}


	public Animal(String tipo, String continente) {
		this.tipo = tipo;
		this.continente = continente;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getContinente() {
		return continente;
	}


	public void setContinente(String continente) {
		this.continente = continente;
	}


	@Override
	public String toString() {
		return "[tipo=" + tipo + ", continente=" + continente + "]";
	}
	
	

	
}

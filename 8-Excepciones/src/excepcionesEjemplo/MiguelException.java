package excepcionesEjemplo;

public class MiguelException extends Exception {
	
	private String texto;

	public MiguelException() {
		// TODO Auto-generated constructor stub
		super();
		texto ="No tengo nada que decir";
	}

	public MiguelException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
		texto = arg0;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	



}

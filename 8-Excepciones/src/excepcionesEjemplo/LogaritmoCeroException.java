package excepcionesEjemplo;

public class LogaritmoCeroException extends Exception {
	private String texto;

	public  LogaritmoCeroException ()
	{
		super ();
		texto = "No se puede calcular el logaritmo";
	}
	
	public LogaritmoCeroException (Double arg)
	{
		super ();
		if (arg == 0)
			texto = "No se puede calcular el logaritmo de cero";
		else 
			texto = "No se puede calcular el logaritmo de un valor menor de cero";
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	

}

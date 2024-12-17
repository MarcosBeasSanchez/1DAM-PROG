package LeerEscribirGaraje;
import daw.com.Pantalla;
import daw.com.Teclado;

public class Moto extends Vehiculo {

	private boolean antirrobo;
	
	
	public Moto() {
		super();
		// TODO Auto-generated constructor stub
		antirrobo = false;
	}

	public Moto (String matricula)
	{
		super (matricula);
		antirrobo = false;
	}

	public Moto( String matricula,int potencia,String propietario, boolean antirrobo) {
		super(potencia, matricula, propietario);
		// TODO Auto-generated constructor stub
		this.antirrobo = antirrobo;
	}


	public boolean isAntirrobo() {
		return antirrobo;
	}


	public void setAntirrobo(boolean antirrobo) {
		this.antirrobo = antirrobo;
	}
	
	public void leerOtrosDatos()
	{
		super.leerOtrosDatos();
		antirrobo = Boolean.parseBoolean(Teclado.leerString("Antirrobo (true/false)"));
		
	}
	
	public void mostrarDatos()
	{
		super.mostrarDatos();
		if (antirrobo)
			Pantalla.escribirString("Tiene antirrobo");
		else
			Pantalla.escribirString("No tiene antirrobo");
		Pantalla.escribirSaltoLinea();
	}
	
	@Override
	public float getCouta() {
		// TODO Auto-generated method stub
		return 2 * super.getPotencia() - ((antirrobo)?30:0);
	}

	
	public String toCSV ()
	{
		return super.toCSV() + antirrobo;
	}
	
	public void fromCSV (String linea)
	{
		int nAtributosPadre =  super.getClass().getSuperclass().getDeclaredFields().length;
		
		super.fromCSV(linea);
	
		
		//antirrobo = Boolean.parseBoolean(linea.split(",")[3]);
		
		antirrobo = Boolean.parseBoolean(linea.split(",")[nAtributosPadre]);
		
	}

}

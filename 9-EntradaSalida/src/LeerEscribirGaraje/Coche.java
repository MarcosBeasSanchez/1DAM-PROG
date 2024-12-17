package LeerEscribirGaraje;


import daw.com.Pantalla;
import daw.com.Teclado;


public class Coche extends Vehiculo {

	private int nplazas;
	
	public Coche() {
		// TODO Auto-generated constructor stub
		super();
		nplazas = 0;
	}

	public Coche (String matricula)
	{
		super (matricula);
		nplazas = 0;
	}
	
	public Coche(String matricula, int potencia,String propietario, int nplazas) {
		super(potencia, matricula, propietario);
		// TODO Auto-generated constructor stub
		this.nplazas = nplazas;
	}

	
	
	public int getNplazas() {
		return nplazas;
	}

	public void setNplazas(int nplazas) {
		if (nplazas < 1)
			throw new IllegalArgumentException("plazas no permitidas");
		this.nplazas = nplazas;
	}

	
	
	public void leerOtrosDatos()
	{
		boolean exito;
		super.leerOtrosDatos();
		do
		{
			try {
				exito = true;
				setNplazas (Teclado.leerInt("n plazas"));
			}catch (IllegalArgumentException e)
			{
				Pantalla.escribirString("\n" + e.getMessage());
				exito = false;
			}
		}while (!exito);
			
		
	}
	
	public void mostrarDatos()
	{
		super.mostrarDatos();
		Pantalla.escribirInt(nplazas);
		Pantalla.escribirSaltoLinea();
	}
	

	@Override
	public float getCouta() {
		// TODO Auto-generated method stub
		return nplazas * getPotencia();
	}

	public String toCSV ()
	{
		return super.toCSV() + nplazas;
	}
	
	public void fromCSV (String linea)
	{
		super.fromCSV(linea);
	
		try {
			nplazas = Integer.parseInt(linea.split(",")[3]);
		}catch (IllegalArgumentException e)
		{
			nplazas = 1;
		}
		
	}
}

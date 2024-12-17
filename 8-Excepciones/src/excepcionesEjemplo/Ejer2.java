package excepcionesEjemplo;

import daw.com.Pantalla;


public class Ejer2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String unString = null;
		double n;
		
		n = Math.sqrt(-4.);
		try
		{
		
		throw new MiguelException ("despertar cabro...es");
		//unString.concat("hola");
		}
		catch (NullPointerException e)
		{
			Pantalla.escribirString("Objeto no inicializado");
		}
		
		catch (MiguelException e)
		{
			Pantalla.escribirString(e.getTexto());
		}
		

	}

}

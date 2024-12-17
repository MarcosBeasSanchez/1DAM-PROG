package excepcionesEjemplo;

import daw.com.Pantalla;


public class Ejer3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = new int[3];
		String unString = null;
		boolean salir = false;
		int i = 3;
		
		while (!salir)
		{
			try
			{
			Pantalla.escribirString("\nantes de provocar el error");
			array[i]= 0;
			Pantalla.escribirString("\ndespues de provocar el error");
			unString.charAt(3);
			salir = true;
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				Pantalla.escribirString("\nindice rebosado");
				i=2;
			}
			catch (NullPointerException e)
			{
				Pantalla.escribirString("\nObjeto no inicializado");
				unString = "hola";
			}
			
			Pantalla.escribirString("\ndespues del try-catch");
		}
	}

}

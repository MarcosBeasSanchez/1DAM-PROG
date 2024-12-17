package Arrays;
import daw.com.Pantalla;
import daw.com.Teclado;

public class CrearIniciales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombres[], iniciales;
		int cuantos;
		
		iniciales = "";
		cuantos = Libreria.leerEnteroPositivo("cuantos nombres?");
		
		nombres = new String[cuantos];
		
		leerArray(nombres);

		mostrarArray(nombres);
		iniciales = sacarIniciales (nombres);
		mostrarArray(nombres);
		
		Pantalla.escribirString("\n" +iniciales);
	}
	
	//cuando pasamos un array inicializado y tiene una direccion 
	//de memoria asignada es esquivalente a un paso por referencia
	
	public static String sacarIniciales (String nombres[])
	{
		String iniciales ="";
		
		for (int i = 0; i < nombres.length; i++)
		{
			nombres[i] = nombres[i].substring(0, 1);
			iniciales += nombres[i].toUpperCase();

		}
		return iniciales;
	}
	
	public static void mostrarArray (String array[])
	{
		for (int i = 0; i < array.length; i++)
			Pantalla.escribirString("\n" + array[i]);
	}
// leerArray tiene el mismo nombre segun el dato recibido hara una u otra cosa
	public static void leerArray (String array[])
	{
		for (int i = 0; i < array.length; i++)
			array[i] = Teclado.leerString("nombres[" + i + "]=");
	}
	
	public static void leerArray (int array[])
	{
		for (int i = 0; i < array.length; i++)
			array[i] = Teclado.leerInt("nombres[" + i + "]=");
	}
	
	

}
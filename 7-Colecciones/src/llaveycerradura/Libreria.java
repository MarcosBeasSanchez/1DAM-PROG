package llaveycerradura;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Libreria {
	public static int leerEnteroPositivo (String mensaje)
	{
		int numero;
		
		do
		{
			numero = Teclado.leerInt("\n" + mensaje);
		}while (numero < 1);
		
		return numero;
	}
	
	public static boolean esPrimo(int n) {
		// TODO Auto-generated method stub
		boolean loEs = true;
		
		if (n == 1)
			loEs = false;
		
		for (int i = 2; i < n && loEs; i++)
			if (n % i == 0)
				loEs = false;
		
		
		return loEs;
	}
	
	public static int leerEntreLimites (int minimo, int maximo, String mensaje)
	{
		int valorLeido, temp;
		
		if (minimo > maximo)
		{
			temp = minimo;
			minimo = maximo;
			maximo = temp;
		}
		
		do
		{
			valorLeido = Teclado.leerInt("\n" + mensaje);
		}while (valorLeido < minimo || valorLeido > maximo);
		
		return valorLeido;
	}
	
	public static boolean esBisiesto (int anio)
	{
		boolean loEs = false;
		
		if (anio % 4 == 0 && // todos los mÃºltiplos de 4 
				!(anio % 100 == 0 // excepto los mÃºltiplos de 100  
					&& !(anio % 400 == 0))) // y no de 400
			loEs = true;
		
		return loEs;
	}
	
	public static int generarAleatorio (int inicio, int fin)
	{
		int valor;
		valor = (int) (Math.random()*(fin + 1 - inicio)) + inicio;
		return valor;
	}
	
	public static void mostrarArray (String array[])
	{
		Pantalla.escribirSaltoLinea();
		for (int i = 0; i < array.length; i++)
			Pantalla.escribirString(array[i]+"\t");
	}
	
	public static void mostrarArray (int array[])
	{
		Pantalla.escribirSaltoLinea();
		for (int i = 0; i < array.length; i++)
			Pantalla.escribirString(array[i] + "\t" );
	}
	
	public static void leerArray (String array[])
	{
		for (int i = 0; i < array.length; i++)
			array[i] = Teclado.leerString("nombres[" + i + "]=");
	}
	
	public static void leerArray (int array[])
	{
		for (int i = 0; i < array.length; i++)
			array[i] = Teclado.leerInt("array[" + i + "]=");
	}
	
	public static String[] crearArrayString ()
	{
		int cuantos;
		String array[];
		
		cuantos = Libreria.leerEnteroPositivo("cuÃ¡ntos elementos?");
		
		array = new String[cuantos];
		
		return array;
	}

	public static int[] crearArrayInt ()
	{
		int cuantos;
		int array[];
		
		cuantos = Libreria.leerEnteroPositivo("cuÃ¡ntos elementos?");
		
		array = new int[cuantos];
		
		return array;
	}
	
}

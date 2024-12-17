package Arrays;

import daw.com.Teclado;

public class arrayOrdenarPrecios {

	public static void main(String[] args) {
		// Dado un array de tamaño N de precios (float), ordenarlo de forma creciente 
		// 1.Mostrar el mayor
		// 2.Mostrar el numero de veces que aparece el mayor

		
		int nPrecios  ;
		float precios[] ;
		
		nPrecios = Libreria.leerEnteroPositivo("cuantos precios quieres leer?");
		precios = new float [nPrecios];
		
		for(int i = 0 ; i < nPrecios ; i++)
		{
			precios[i] = Teclado.leerFloat( "precio?");	
		}
		
		ordenarPrecios (precios);
		Libreria.mostrarArray(precios);
	
	}
	
	public static void ordenarPrecios (float array[])
	{
		float aux;
		
		for (int i = 0; i < array.length; i++)
			for (int j = i; j < array.length; j++)
				
				if (array[j] < array[i]) // Si es menor intercambia  intercambia valor de i y j
				{
					aux = (int) array[i];
					array[i] = array[j];
					array[j] = aux;
				}
	}

}

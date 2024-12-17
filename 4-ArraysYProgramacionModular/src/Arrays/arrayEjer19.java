package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class arrayEjer19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// averigurar la posciÃ³n del mayor primo introducido
		int array[], cuantos, posicionMayor,temp;
		
		cuantos = Libreria.leerEnteroPositivo("cuÃ¡ntos elementos?");
		
		array = new int [cuantos];
		
		for (int i = 0; i < array.length; i++)
			array[i] = Teclado.leerInt("a[" + i + "]=");

		posicionMayor = -1;  // imposible -> no hay primos
		
		for (int i = 0; i < array.length; i++)
		{
			temp = array[i];
			
			if (Libreria.esPrimo(temp))
			{
				if (posicionMayor < 0)
					posicionMayor = i;
				else 
				{
					if (array[i] > array[posicionMayor])
						posicionMayor = i;
				}
			}
		}
		
		// mostrar resultados
		if (posicionMayor >= 0)
			Pantalla.escribirString("\nel mayor primo estÃ¡ en la posiciÃ³n " + posicionMayor);
		else
			Pantalla.escribirString("\nNo se han leÃ­do primos");
	}

}
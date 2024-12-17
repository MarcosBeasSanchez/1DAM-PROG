import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejer27Repaso {

	public static void main(String[] args) {
		// valor minimo y maximo y que te de los numeros primos dentro del valor minimo y maximo
		int minimo, maximo;
		int cuantosPrimos = 0;
		boolean esPrimo;
		
		do
		{
			minimo = Teclado.leerInt("valor mÃ­mimo ");
		}while (minimo < 1);
		
		do
		{
			maximo = Teclado.leerInt("valor mÃ¡ximo ");
		}while (maximo <= minimo);
		
		for (int i = minimo; i <= maximo; i++)
		{
			esPrimo = true;
			
			for (int j = 2; j < i  && esPrimo ; j++)
				if (i % j == 0)
					esPrimo = false;
			
			if (esPrimo)
			{
				Pantalla.escribirInt(i);
				cuantosPrimos++;
			}
		}
		
		if (cuantosPrimos == 0)
			Pantalla.escribirString("no habÃ­a primos");

	}

}
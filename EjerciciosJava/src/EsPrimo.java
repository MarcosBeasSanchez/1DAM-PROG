import daw.com.Pantalla;
import daw.com.Teclado;

public class EsPrimo {

	public static void main(String[] args) {
		// Leer un numero entero positivo mayor que 1 y mostrar por pantalla si es primo.
		boolean esPrimo = true;
		int numero;
		
		do
		{
			numero = Teclado.leerInt("introduzca un numero mayor que 1");
		}while (numero <= 1);
		
		for (int i = 2; i < numero  && esPrimo ; i++)
			if (numero % i == 0)
				esPrimo = false;
			// esPrimo = !(numero % i == 0)

		
		if (esPrimo) {
			Pantalla.escribirString("\n El numero "+ numero + " es primo");
		}else {
			Pantalla.escribirString("\n El numero "+ numero+ " NO es primo");
		}
		
		
	}

}

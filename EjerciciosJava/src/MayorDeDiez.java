import daw.com.Pantalla;
import daw.com.Teclado;

public class MayorDeDiez {

	public static void main(String[] args) {
		//Leer 10 numeros enteros y mostrar el mayor.
		
		int numero, mayor=0;
		
		//opcion 1
		
		for (int i = 1; i <= 10; i++)
		{
			numero = Teclado.leerInt("número " + i);
			if (i == 1) // singularidad en el primero
				mayor = numero;
			else if (mayor < numero) // solo entrará¡ si i != 1
				mayor = numero;
		}

		// opcion 2
		//mayor = Teclado.leerInt("número 1 ");
		//for (int i = 2; i <= 10; i++)
		//{
		//	numero = Teclado.leerInt("número " + i);
		//
		//	if (mayor < numero) 
		//		mayor = numero;
		//}
		
		Pantalla.escribirInt("el mayor es: ", mayor);
	}

}

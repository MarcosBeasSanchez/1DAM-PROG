
import daw.com.Pantalla;
import daw.com.Teclado;

public class CuantosNegativosYMedia {

	public static void main(String[] args) {
		// Leer de forma indefinida un conjunto de numeros enteros hasta que el usuario introduzca cero.
		// A continuacion mostrar la cantidad de numero negativos introducidos y la media los numeros tanto positivos comop negativosa.

		float media;
		int suma=0, cuantosNegativos=0, cuantosPositivos=0;
		int numero;
		
		// uso de while
		numero = -1; // inicializar antes de preguntar
		
		while (numero != 0)
		{
			numero = Teclado.leerInt("introduzca un numero, cero para parar");
			if (numero < 0)
				cuantosNegativos++;
			else if (numero > 0)
				cuantosPositivos++;
			
			suma += numero;
		}
		
		
		media = (suma /(cuantosNegativos + cuantosPositivos));
		
		Pantalla.escribirInt("numeros negativos lei­dos", cuantosNegativos);

		Pantalla.escribirFloat("La media es ", media);
		
	}

}




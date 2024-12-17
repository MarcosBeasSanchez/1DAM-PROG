import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejer22Repaso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero, cuantosImpares = 0, suma = 0;
		final int TOTAL = 10;
		
		for (int i = 1; i <= TOTAL; i++)
		{
			do
			{
				numero = Teclado.leerInt("nÃºmero " + i);
			}while (numero == 0);
			
			if (numero %2 != 0) // si el nÃºmero es impar
			{
				cuantosImpares++; // lo cuento
				suma += numero; // lo acumulo
			}
			
		}
		
		Pantalla.escribirInt("cantidad de nÂº paras", TOTAL - cuantosImpares);
		
		Pantalla.escribirFloat("la media de los impares es ", suma / cuantosImpares);

	}

}
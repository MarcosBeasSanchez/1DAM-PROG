import daw.com.Pantalla;

public class Sumatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int suma = 0;
		
		
		for (int i = 7; i < 27; i++)
		{
			// Chivato de la i
			Pantalla.escribirInt("i = ", i);
			suma = suma + i; // suma += i;
		}
		
		Pantalla.escribirInt("suma = ", suma);

	}

}
//calcular la suma de los 20 primeros numeros enteros a partir del 7

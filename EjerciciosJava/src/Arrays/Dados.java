package Arrays;

import daw.com.Pantalla;

public class Dados {

	public static void main(String[] args) {
		
		
		int valores[],valor,posMayor;
		
		valores = new int[11];
		
		
		
		for (int i = 0; i < valores.length; i++)
			valores[i] = 0;
		
		for (int i = 0; i < 100; i++)
		{
			valor = Libreria.generarAleatorio(2, 12);
			valores[valor-2]++;
		}
		
		posMayor = 0;
		
		for (int i = 1; i < valores.length; i++)
			if (valores[i] > valores[posMayor])
				posMayor = i;
		
		Pantalla.escribirInt("\nEl valor mas repetido es " , posMayor + 2);
		Pantalla.escribirString("\nSe repite " + valores[posMayor] + " veces");
		
	}

}
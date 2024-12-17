import daw.com.Pantalla;

public class CuantosPrimos {

	public static void main(String[] args) {
		// hacer un programa que lea del teclado 3 numeros y diga cuantos son primos.Para ello hacer una funcion llamada esPrimo que reciba un numero y devuelva sie es primo.
		
		
		int n, cuantos=0;
		boolean loEs;
		
		for (int i = 0; i < 3; i++)
		{
			n = Libreria.leerEnteroPositivo("introduce nÃºmero");
			loEs = Libreria.esPrimo (n);
			if (loEs)
				cuantos++;
		}
		
		Pantalla.escribirString("\nhay " + cuantos + " primos");
	}


	
	

}
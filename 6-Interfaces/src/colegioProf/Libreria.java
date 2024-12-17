package colegioProf;

import daw.com.Teclado;

public class Libreria {
	public static int leerEnteroPositivo(String mensaje) {
		int numero;

		do {
			numero = Teclado.leerInt("\n" + mensaje);
		} while (numero < 1);

		return numero;
	}

	public static boolean esPrimo(int n) {
		// TODO Auto-generated method stub
		boolean loEs = true;

		if (n == 1)
			loEs = false;

		for (int i = 2; i < n && loEs; i++)
			if (n % i == 0)
				loEs = false;

		return loEs;
	}

	public static int leerEntreLimites(int minimo, int maximo, String mensaje) {
		int valorLeido, temp;

		if (minimo > maximo) {
			temp = minimo;
			minimo = maximo;
			maximo = temp;
		}

		do {
			valorLeido = Teclado.leerInt("\n" + mensaje);
		} while (valorLeido < minimo || valorLeido > maximo);

		return valorLeido;
	}

	public static boolean esBisiesto(int anio) {
		boolean loEs = false;

		if (anio % 4 == 0 && // todos los múltiplos de 4
				!(anio % 100 == 0 // excepto los múltiplos de 100
						&& !(anio % 400 == 0))) // y no de 400
			loEs = true;

		return loEs;
	}

	public static int generarAleatorio(int inicio, int fin) {
		int valor;
		valor = (int) (Math.random() * (fin + 1 - inicio)) + inicio;
		return valor;
	}

}

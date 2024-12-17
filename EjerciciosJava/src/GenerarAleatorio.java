import daw.com.Pantalla;

public class GenerarAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		
		for (int i = 0; i < 10; i++)
		{
			n = generarAleatorio (1,12);
			Pantalla.escribirSaltoLinea();
			Pantalla.escribirInt(n);
		}

	}
	
	public static int generarAleatorio (int inicio, int fin)
	{
		int valor;
		valor = (int) (Math.random()*(fin + 1 - inicio)) + inicio;
		return valor;
	}

}
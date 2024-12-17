import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejer7MasEjercicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String reyes, rey;
		int cuantosReyes, actual;
		
		cuantosReyes = Libreria.leerEnteroPositivo("cuantos reyes?");
		
		reyes = leerReyes (cuantosReyes);
		
		rey = Teclado.leerString("rey actual?");
		
		actual = calcularReyActual (reyes, rey);
		
		Pantalla.escribirString("i­ndice rey actual " + actual);
		

	}

	public static int calcularReyActual(String listaReyes, String rey) {
		// TODO Auto-generated method stub
		int actual = 1;
		String letra, reyTemp="";
		
		for (int i = 0; i< listaReyes.length(); i++)
		{
			letra = listaReyes.substring(i, i+1);
			
			if (letra.equals(" "))
			{
				if (rey.equalsIgnoreCase(reyTemp))
					actual++;
				reyTemp = "";
			}
			else
			{
				reyTemp += letra;
				if (i == listaReyes.length() - 1 &&
						rey.equalsIgnoreCase(reyTemp))
					actual++;
			}
		}
				
		return actual;
	}

	public static String leerReyes(int cuantosReyes) {
		// TODO Auto-generated method stub
		String listaReyes;
		int cuantosLeidos;
		
		do
		{
			listaReyes = Teclado.leerString("lista de reyes");
			cuantosLeidos = calcularCuantasPalabras (listaReyes);
		}while (cuantosLeidos != cuantosReyes);
		
		return listaReyes;
	}

	public static int calcularCuantasPalabras(String listaReyes) {
		// TODO Auto-generated method stub
		int cuantos = 1;
		
		for (int i = 0; i< listaReyes.length(); i++)
			if (listaReyes.substring(i, i+1).equals(" "))
				cuantos ++;

		
		return cuantos;
	}

}
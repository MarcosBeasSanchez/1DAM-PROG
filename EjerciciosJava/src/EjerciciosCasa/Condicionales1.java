package EjerciciosCasa;


import daw.com.Pantalla;
import daw.com.Teclado;

public class Condicionales1 {

	public static void main(String[] args) {
		// Que pida un número y diga si es mayor de 100
		
		int numero;
		String mensaje;
		
		mensaje = "El numero es menor que 100";
		
		numero = Teclado.leerInt("dame un numero");
		
		if(numero <= 100)
		{
			Pantalla.escribirString(mensaje);
		}
		else
		{
			mensaje = "El numero es mayor";
			Pantalla.escribirString(mensaje);
		}
		
		
	}

}

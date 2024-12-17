	package EjerciciosCasa;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Condicionales_18 {
	public static void main(String[] args) {
	// Que pida un número del 1 al 7 y diga el día de la semana correspondiente.
		
	int numero;
	numero = Teclado.leerInt("dame un numero entre 1 y 7");
	
	semana(numero);
		
		
	}
	
	private static void semana (int numero) {
		String diaSemana ;
		switch(numero){
		
		case 1:
			diaSemana ="LUNES";
			Pantalla.escribirString("Este dia corresponde a " + diaSemana);
			break;
		case 2:
			diaSemana ="MARTES";
			Pantalla.escribirString("Este dia corresponde a " + diaSemana);
			break;
		case 3:
			diaSemana ="MIERCOLES";
			Pantalla.escribirString("Este dia corresponde a " + diaSemana);
			break;

		case 4:
			diaSemana ="JUEVES";
			Pantalla.escribirString("Este dia corresponde a " + diaSemana);
			break;

		case 5:
			diaSemana =" VIERNES";
			Pantalla.escribirString("Este dia corresponde a " + diaSemana);
			break;

		case 6:
			diaSemana ="SABADO";
			Pantalla.escribirString("Este dia corresponde a " + diaSemana);
			break;

		case 7:
			diaSemana ="DOMINGO";
			Pantalla.escribirString("Este dia corresponde a " + diaSemana);
			break;

		default: 
			Pantalla.escribirString("ERROR" );
		}
	}

}

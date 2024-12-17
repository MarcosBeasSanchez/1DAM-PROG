package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales9 {

	public static void main(String[] args) {
		//Que lea una hora en hora:minutos:segundos y diga la hora que es un segundo después.

		int hh, mm , ss;
		// Pedir datos
		hh = Teclado.leerInt("Dime HORA");
		mm = Teclado.leerInt("Dime MIN");
		ss = Teclado.leerInt("Dime SEG");
		//aumenta un segundo
		ss++;
		// sistema de reloj
		if (ss == 60){
			ss= 00;
			mm++;
		
			if (mm == 60) {
				mm= 00;
				hh++;
		
				if (hh == 24) {
					hh= 0;
				}
			}
		}
		
		System.out.println(hh +":"+ mm +":"+ ss);
			
		
	

	}

}

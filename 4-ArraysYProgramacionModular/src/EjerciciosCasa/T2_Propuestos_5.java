package EjerciciosCasa;

import Arrays.Libreria;

public class T2_Propuestos_5 {

	public static void main(String[] args) {
		//Un programa que dado la fecha de nacimiento de un votante y fecha del dia de votacion, 
		//diga si puede votar(mayor de 18 años) o no puede votar(menor de dieciocho años)

		int dia = Libreria.leerEntreLimites(1, 30, "Dia de Nacimiento?");
		int mes = Libreria.leerEntreLimites(1, 12, "Mes de Naciemiento?");
		int año = Libreria.leerEntreLimites(1, 2023, "Año de Nacimiento?");
		
		int diaVotacion = Libreria.leerEntreLimites(1, 30, "Dia que vas a votar?");
		int mesVotacion = Libreria.leerEntreLimites(1, 12, "Mes que vas a votar?");
		int añoVotacion = Libreria.leerEntreLimites(1, 2023, "Año que vas a votar??");
		
		
		int resultadoDia = diaVotacion - dia;
		int resultadoMes = mesVotacion - mes;
		int resultadoAño = añoVotacion - año;
		
		if (resultadoAño > 18) {
		    System.out.println("ERES MAYOR DE EDAD, puedes votar...");
		} else if (resultadoAño == 18 && resultadoMes > 0) {
		    System.out.println("ERES MAYOR DE EDAD, puedes votar..");
		} else if (resultadoAño == 18 && resultadoMes == 0 && resultadoDia >= 0) {
		    System.out.println("ERES MAYOR DE EDAD, puedes votar.");
		} else {
		    System.out.println("ERES MENOR DE EDAD, NO puedes votar");
		}
		
	}

}

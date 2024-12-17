package EjerciciosCasa;

import daw.com.Teclado;

public class T2_Propuestos_4 {

	public static void main(String[] args) {
		// HOROSCOPO
		
		int dia = Teclado.leerInt("DIA?");
		int mes = Teclado.leerInt("MES?");
		String signo;
		
        switch (mes) {
        case 1:
            signo = (dia >= 20) ? "Acuario" : "Capricornio";
            break;
        case 2:
            signo = (dia >= 19) ? "Piscis" : "Acuario";
            break;
        case 3:
            signo = (dia >= 21) ? "Aries" : "Piscis";
            break;
        case 4:
            signo = (dia >= 20) ? "Tauro" : "Aries";
            break;
        case 5:
            signo = (dia >= 21) ? "Géminis" : "Tauro";
            break;
        case 6:
            signo = (dia >= 21) ? "Cáncer" : "Géminis";
            break;
        case 7:
            signo = (dia >= 23) ? "Leo" : "Cáncer";
            break;
        case 8:
            signo = (dia >= 23) ? "Virgo" : "Leo";
            break;
        case 9:
            signo = (dia >= 23) ? "Libra" : "Virgo";
            break;
        case 10:
            signo = (dia >= 23) ? "Escorpio" : "Libra";
            break;
        case 11:
            signo = (dia >= 22) ? "Sagitario" : "Escorpio";
            break;
        case 12:
            signo = (dia >= 22) ? "Capricornio" : "Sagitario";
            break;
        default:
            signo = "Mes no válido";
    }

    // Mostrar el horóscopo
    System.out.println("Tu signo zodiacal es: " + signo);

	}
}




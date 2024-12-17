package ejemploFechasYHoras;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejer1Fechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String formatoString1, formatoString2;
		DateTimeFormatter formato,formato1,formato2, formato3;
		LocalDate fechaInicial, fechaFinal,fechaAux;
		
		formatoString1 = "dd/MM/yy";
		formatoString2 = "MM/dd/yyyy";
		
		formato = DateTimeFormatter.ISO_LOCAL_DATE; // "yyyy-MM-dd"
		formato = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		formato = DateTimeFormatter.ofPattern(formatoString1);
		
		formato1 = DateTimeFormatter.ofPattern(formatoString1);
		formato2 = DateTimeFormatter.ofPattern(formatoString2);
		
		// Leer dos fechas del teclado (elije tÃº el formato) 
		fechaInicial = LocalDate.parse(Teclado.leerString(formatoString1),formato1);
		fechaFinal = LocalDate.parse(Teclado.leerString(formatoString2),formato2);
		
		// Mostrar La fecha posterior con el formato : "2 de abril de 2019"
		formato3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		
		// Comprobar fechas e intercambiar si procede
		if (fechaInicial.isAfter(fechaFinal))
		{
			fechaAux = fechaFinal;
			fechaFinal = fechaInicial;
			fechaInicial = fechaAux;		
		}
		Pantalla.escribirString("\n" + fechaFinal.format(formato3));
		
		
		
		//Si la diferencia de dÃ­as entre ambas es superior a 9 meses mostrar "ya deberÃ­a haber nacido",
		//en caso contrario mostrar "toodavÃ­a quedan x dÃ­as", donde x el nÃºmero de dÃ­as que quedan.
		Period intervalo = Period.between(fechaInicial, fechaFinal);
		Period intervalo2 = fechaInicial.until(fechaFinal);
		
		long intervalo3 = ChronoUnit.MONTHS.between(fechaInicial, fechaFinal);
		
		
		Pantalla.escribirString("\nHan pasado " + intervalo.getDays() + " dias");
		Pantalla.escribirString("\nHan pasado " + intervalo.getMonths() + " meses");
		Pantalla.escribirString("\nHan pasado " + intervalo.getYears() + " anios");
		
		Pantalla.escribirString("\nHan pasado " + intervalo3 + " meses");
		
		
		if (intervalo3 < 9)
			Pantalla.escribirString("\nTodavÃ­a quedan " + ChronoUnit.DAYS.between(fechaInicial.plusMonths(9), fechaFinal)+" dÃ­as");
		else
			Pantalla.escribirString("\nYa deberÃ­a de haber nacido");
		
		// Si hay alguna fecha cuyo aÃ±o sea bisiesto.
		if (fechaInicial.isLeapYear() || fechaFinal.isLeapYear())
			Pantalla.escribirString("\nHay fechas con aÃ±o bisiesto");

		// El nÃºmero de domingos que hay entre las dos fechas.
		/*
		fechaAux = fechaInicial;
		int contadorDomingos = 0;
		while (fechaAux.isBefore(fechaFinal) || fechaAux.isEqual(fechaFinal))
		{
			if (fechaAux.getDayOfWeek() == DayOfWeek.SUNDAY)
				contadorDomingos ++;
			
			fechaAux = fechaAux.plusDays(1); //fechaAux++;
		}
		
		*/
		
		int contadorDomingos = 0;
		
		if (fechaInicial.getDayOfWeek() != DayOfWeek.SUNDAY)
			fechaAux = fechaInicial.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		else 
			fechaAux = fechaInicial;
		
		
		while (fechaAux.isBefore(fechaFinal) || fechaAux.isEqual(fechaFinal))
		{
			contadorDomingos++;
			fechaAux = fechaAux.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		}
		
		Pantalla.escribirString("\nNÂº de domingos " + contadorDomingos);

		
		Pantalla.escribirString("\nNÂº de semanas " + ChronoUnit.WEEKS.between(fechaInicial, fechaFinal));
		Pantalla.escribirString("\nNÂº de meses " + ChronoUnit.MONTHS.between(fechaInicial, fechaFinal));
		Pantalla.escribirString("\nNÂº de dÃ­as " + ChronoUnit.DAYS.between(fechaInicial, fechaFinal));
		Pantalla.escribirString("\nNÂº de aÃ±os " + ChronoUnit.YEARS.between(fechaInicial, fechaFinal));
	}

}

package ejemploFechasYHoras;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejer2Fechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime horaActual, horaSalida, horaPrimera, horaSegunda;
		DateTimeFormatter formato,formato1;
		String formatoString = "HH:mm:ss";
		Duration quedan;
		
		formato = DateTimeFormatter.ofPattern(formatoString);
		
		horaSalida = LocalTime.of(21, 15);
		
		do
		{
			horaActual = LocalTime.parse(Teclado.leerString(formatoString),formato);
											
		}while (horaActual.isAfter(horaSalida));
		
		
		Pantalla.escribirString("\n" + horaActual);
		
		// Mostrar la hora con el formato "son las hh y mm"
		formato1 = DateTimeFormatter.ofPattern("'son las' HH 'y' mm 'minutos'");

		// Usar formato adhoc
		/*formato1 = new DateTimeFormatterBuilder().
				 appendLiteral("son las ").
				 appendText(ChronoField.CLOCK_HOUR_OF_DAY).
				 appendLiteral(" y ").
				 appendText(ChronoField.MINUTE_OF_HOUR).
				 toFormatter();
		
		*/
		
		
		Pantalla.escribirString("\n" + horaActual.format(formato1));
		
	
		quedan = Duration.between(horaActual, horaSalida);
	
		// Convertir los segundos a hh, mm, ss 
		LocalTime hora = LocalTime.ofSecondOfDay(quedan.getSeconds());
		Pantalla.escribirString("\nquedan " + hora.getHour() + " horas");
		Pantalla.escribirString("\nquedan " + hora.getMinute()+ " minutos");
		Pantalla.escribirString("\nquedan " + hora.getSecond() + " segundos");
		
		// despertador
		horaActual = LocalTime.parse(Teclado.leerString(formatoString),formato);
		
		horaPrimera = LocalTime.of(6, 30);
		horaSegunda = horaPrimera.plusHours(1);
		
		if (horaActual.isBefore(horaPrimera))
			Pantalla.escribirString("\nquedan otros " + 
						ChronoUnit.MINUTES.between(horaActual, horaPrimera) + 
						" minutos de sueÃ±o");
		else if(horaActual.isBefore(horaSegunda))
			Pantalla.escribirString("\ndespierta....");
		else if (horaActual.isAfter(horaSegunda))
			Pantalla.escribirString("\narriba vago....");
		
	}

}
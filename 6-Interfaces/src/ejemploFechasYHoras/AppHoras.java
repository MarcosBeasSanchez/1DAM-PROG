package ejemploFechasYHoras;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppHoras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime h1,h2,h3;
		DateTimeFormatter formato;
		
		h1 = LocalTime.now();
		
		h2 = LocalTime.of(17, 00, 00);
		
		/*
		h3 = LocalTime.parse(Teclado.leerString("\nIntroduce la hora en hh:mm:ss"));
		Pantalla.escribirString("\nLa introducida es " + h3);
		*/
		
		Duration duration = Duration.between(h1, h2);
		if (h1.isAfter(h2))
		{
			Pantalla.escribirString("\nYa ha comenzado la clase");
			Pantalla.escribirString("\nLlevamos " + duration.toMinutes() +  "minutos");
		}
		else
		{
			Pantalla.escribirString("\nTodavia un ratito de siesta mas");
			Pantalla.escribirString("\nFaltan " + duration.toMinutes() +  " minutos");
		}
		
		
		
		h1 = LocalTime.now(ZoneId.of("Greenwich")); // no hace falta
		formato = DateTimeFormatter.ofPattern("hh:mm:ss a");
		Pantalla.escribirString("\nSon las " + h1.format(formato));
		

		 h1 = h1.withHour(2);// h1.setHoras(2)// Los LocalTime, LocalDate y LocalDateTime son inmutables
		

	}

}

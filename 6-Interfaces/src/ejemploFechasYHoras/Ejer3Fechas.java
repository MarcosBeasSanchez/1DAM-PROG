package ejemploFechasYHoras;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejer3Fechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime fechaInicial, fechaFinal,fechaAux, fecha;
		
		String formatoString = "dd/MM/yyyy HH:mm"; // forma dia hora
		String mensaje = "Faltan ";
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoString);
		
		Period intervalo;
		Duration duracion;
		
		fechaFinal = LocalDateTime.now();
		
		fecha = LocalDateTime.parse(Teclado.leerString("\nfecha ("+ formatoString+")"),formato);

		fechaInicial = fecha; 
		
		if (fechaFinal.isAfter(fechaInicial))
			Pantalla.escribirString("\nHoy es posterior a " + fechaInicial.format(formato));
		else
			Pantalla.escribirString("\nHoy es anterior a " + fechaInicial.format(formato));

		// poner fechaFinal en 1 de enero de 2025
		fechaFinal = LocalDateTime.of(2025,1,1,0,0);
		
		// Comprobar fechaInicial y fechaFinal 
		if (fechaInicial.isAfter(fechaFinal))
		{
			fechaAux = fechaFinal;
			fechaFinal = fechaInicial;
			fechaInicial = fechaAux;
			
			mensaje = "Pasan ";
		}
		
		
		// calcular periodo entre las fechas
		intervalo = Period.between(fechaInicial.toLocalDate(), fechaFinal.toLocalDate());
		
		// Ajustar dÃ­as si las hora final es menor que la inicial
		if (fechaInicial.toLocalTime().isAfter(fechaFinal.toLocalTime()))
			intervalo = intervalo.minusDays(1);
		
		
		Pantalla.escribirString("\n" + mensaje + " al " + fechaFinal);
		
		Pantalla.escribirString("\n" + intervalo.getYears() + " aÃ±os");
		Pantalla.escribirString("\n" + intervalo.getMonths() + " meses");
		Pantalla.escribirString("\n" + intervalo.getDays() + " dÃ­as");
		
		
		
		
		// calcular diferencia total entre fechaInicial y fechaFinal
		duracion = Duration.between(fechaInicial, fechaFinal);
				
			
		// Restar los dÃ­as entre fechas
		// duracion sÃ³lo se queda con los que hay entre las horas
		duracion = duracion.minusDays(duracion.toDays());
		
		
				
		// Convertir los segundos a hh, mm, ss
		LocalTime hora = LocalTime.ofSecondOfDay(duracion.getSeconds());

		Pantalla.escribirString("\n" + hora.getHour() + " horas");
		Pantalla.escribirString("\n" + hora.getMinute()+ " minutos");
		Pantalla.escribirString("\n" + hora.getSecond() + " segundos");
		
		
		
		
		
		
		//CuÃ¡ntos dÃ­as han transcurrido o le quedan al 1 de enero del 2000.
		Duration d = Duration.between(fecha, LocalDateTime.of(2000, 1, 1,0,0));
		if (d.isNegative())
			Pantalla.escribirString("\nPasan dÃ­as " + d.abs().toDays());
		else
			Pantalla.escribirString("\nFaltan dÃ­as " + d.toDays());
		
	}

}
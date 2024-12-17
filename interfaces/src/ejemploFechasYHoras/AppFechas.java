package ejemploFechasYHoras;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppFechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate fecha,fecha2;

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		
		fecha = LocalDate.parse (Teclado.leerString("dd/MM/yyyy"),df);
		
		fecha2 = LocalDate.now();
		
		if (fecha.isAfter(fecha2)) // if (fecha.compareTo(fecha2) > 0)
			Pantalla.escribirString("\n" + fecha + " es posterior a " + fecha2);
		
		
		Period period;
		
		if (fecha.isBefore(fecha2))
			period = Period.between(fecha, fecha2);
		else
			period = Period.between(fecha2, fecha);
		
		
		
		
		Pantalla.escribirString("\nAnos transcurridos " + period.getYears());
		Pantalla.escribirString("\nMeses transcurridos " + period.getMonths());
		Pantalla.escribirString("\nDias transcurridos " + period.getDays());
		
		
		Pantalla.escribirString("\n" + fecha);
		Pantalla.escribirString("\n" + fecha.format(df));
		
		DateTimeFormatter formatoLargo = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		Pantalla.escribirString("\n" + fecha.format(formatoLargo));
		
		Period cuarentena = Period.of(0,2,15);
		
		LocalDate fechaAlMonte = fecha2.plus(cuarentena);
		Pantalla.escribirString("\n" + fecha2.format(formatoLargo));
		
		fechaAlMonte = fechaAlMonte.withMonth(5);// fechaAlMonte.setMonth(5);
	}

}

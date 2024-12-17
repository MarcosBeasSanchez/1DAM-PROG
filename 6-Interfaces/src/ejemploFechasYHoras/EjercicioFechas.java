package ejemploFechasYHoras;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import daw.com.Pantalla;
import daw.com.Teclado;

public class EjercicioFechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate antigua;
		
		List<LocalDate> fechas = new ArrayList<>();
		
		// Leer fechas
		leerFechas (fechas);
		
		// Mostrar fechas
		mostrarFechas (fechas);
		
		// Buscar fecha m�s antigua
		antigua = Collections.min(fechas);
		Pantalla.escribirString("\nLa fecha m�s antigua es " + antigua.toString());
		Pantalla.escribirString("\nD�as desde el 1 enero " + antigua.getDayOfYear());
		
		
		// Ordenar fechas
		Comparator<LocalDate> comparador = new ComparadorDeFechasPorDias();
		fechas.sort(comparador); // Usamos el orden total
		
		//fechas.sort(null); // Usamos el orden total
		
		Collections.sort(fechas);// Usamos el orden natural
		Collections.sort(fechas,comparador.reversed()); // Usamos el orden total
		
		
		
		// Mostrar ordenadas
		mostrarFechas (fechas);
		
	}
	
	public static void leerFechas (List<LocalDate> fechas)
	{
		DateTimeFormatter formatoLectura;
		LocalDate fecha;
		String fechaString;
		String patron = "dd/MM/yy";
		
		formatoLectura = DateTimeFormatter.ofPattern(patron);
		
		do
		{
			// Leer fecha como String
			fechaString = Teclado.leerString("\nIntroduce fecha en formato " + patron);
			
			// Convertir String a LocalDate
			fecha = LocalDate.parse(fechaString, formatoLectura);
			
			// Insertar fecha en la colecci�n
			fechas.add(fecha);
			
		}while (Teclado.leerString("Seguir?(s/n)").equals("s"));
	}
	
	public static void mostrarFechas (List<LocalDate> fechas)
	{
		DateTimeFormatter formatoEscritura;
		String fechaString;
		
		formatoEscritura = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		
		Pantalla.escribirString("\nListado de fechas");
		for (LocalDate fecha : fechas)
		{
			// Convertir LocalDate a String
			fechaString = fecha.format(formatoEscritura);
			Pantalla.escribirString("\n" + fechaString);
		}
	}
	
	

}

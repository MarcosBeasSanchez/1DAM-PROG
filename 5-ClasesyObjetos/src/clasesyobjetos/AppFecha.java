package clasesyobjetos;

import java.time.LocalDate;

public class AppFecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate fecha , fecha2 ; 
		
		fecha = LocalDate.now();
		fecha2 = LocalDate.of(2000, 12, 18);
		
		System.out.println(fecha);
		
		if (fecha.isAfter(fecha2)) {
			System.out.println(fecha + " es posterior a " + fecha2 );
		}
		if (fecha.isEqual(fecha2)) {
			System.out.println(fecha + " es igual" + " a " + fecha2 );
		}
		if (fecha.isBefore(fecha2)) {
			System.out.println(fecha + " es anterior" + " a " + fecha2 );
		}

	}

}

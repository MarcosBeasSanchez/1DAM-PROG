package ejemploFechasYHoras;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparadorDeFechasPorDias implements Comparator<LocalDate> {

	@Override
	public int compare(LocalDate o1, LocalDate o2) {
		// TODO Auto-generated method stub
		int resultado = 0;
		
		resultado = o1.getDayOfMonth() - o2.getDayOfMonth();
		
		return resultado;
	}

}

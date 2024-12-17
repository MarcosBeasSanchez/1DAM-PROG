package examenFinal;

import java.time.LocalDate;
import java.util.function.Predicate;

public class FiltrarCatalan implements Predicate<Podcast> {

	@Override
	public boolean test(Podcast t) {
		// TODO Auto-generated method stub
		return !t.getIdiomas().contains("Catalán") && t.getFechaEstreno().isBefore(LocalDate.now().minusYears(1));
	}

}

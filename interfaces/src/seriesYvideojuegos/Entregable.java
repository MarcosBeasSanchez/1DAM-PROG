package seriesYvideojuegos;

import java.util.function.Consumer;

public interface Entregable extends Comparable<Entregable>{
	public void entregar ();
	public void devolver ();
	public boolean isEntregado ();
}
package seriesYvideojuegos;

import java.util.function.Predicate;

public class TieneTitulo implements Predicate<Entregable> {

	private String titulo;
	
	
	public TieneTitulo(String titulo) {
		this.titulo = titulo;
	}

	

	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	@Override
	public boolean test(Entregable t) {
		// TODO Auto-generated method stub
		boolean estaTitulo = false;
		
		if (t instanceof VideoJuego v)
			estaTitulo = v.equals(new VideoJuego(titulo,0));
		else if (t instanceof Serie s)
			estaTitulo = s.equals(new Serie (titulo,""));
		
		return estaTitulo;
	}

}
package video;

import clasesyobjetos.Libreria;
import daw.com.Teclado;

public class ProductoVC {
	
	 public static final boolean PELICULA = true;
	 public static final boolean VIDEOJUEGO = false;
	 
	 private String titulo;
	 private boolean tipo;
	 private float pvp;
	 private int plazo;
	 private boolean alquilado;

	 public ProductoVC(String titulo, boolean tipo, float pvp, int plazo, boolean alquilado) {
		this.titulo = titulo;
		this.tipo = tipo;
		setPvp (pvp);
		setPlazo (plazo);
		this.alquilado = alquilado;
	}
	 
	 public ProductoVC (String titulo)
	 {
	    this (titulo, PELICULA, 0, 0, false);
	 }
	 
	 public ProductoVC ()
	 {
	    this ("", PELICULA, 0, 0, false);
	 }
	 
	 public ProductoVC (ProductoVC original)
	 {
		 this (original.titulo, original.tipo,original.pvp, original.plazo, original.alquilado);
	 }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		if (pvp <0)
			pvp = 0;
		this.pvp = pvp;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		if (plazo < 0)
			plazo = 0;
		this.plazo = plazo;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	 
	public void mostrarDatos ()
	{
		System.out.println("\n" + this);
	}
	
	public boolean equals(ProductoVC otro) {
		
		return otro != null && titulo.equals(otro.titulo); 
	}
    
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}
	
	public void leerOtrosDatos() {
		tipo = Teclado.leerString("\nEs pelicula ?").equalsIgnoreCase("S");
		pvp = Teclado.leerFloat("\npvp");
		setPvp (pvp);
		plazo = Libreria.leerEnteroPositivo("\nplazo");
		
		// alquilado no se lee
		//this.alquilado = alquilado;
	}

	public void leerClave() {
		titulo = Teclado.leerString("\nTitulo del producto: ");
	}

	@Override
	public String toString() {
		return "ProductoVC [titulo=" + titulo + ", tipo=" + (tipo==PELICULA?"Pelicula":"VideoJuego") + 
				", pvp=" + pvp + ", plazo=" + plazo + ", alquilado="+ alquilado + "]";
	}
	
}
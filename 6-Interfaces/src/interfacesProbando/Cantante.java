package interfacesProbando;

import daw.com.Pantalla;

public interface Cantante {
	String LETRA = "lalalalalala\n";
	 
	public void cantar();
	 
	 public default void afinar (String frase)
	 {
		 Pantalla.escribirSaltoLinea();
		 Pantalla.escribirString(frase);
		 Pantalla.escribirSaltoLinea();
	}
}

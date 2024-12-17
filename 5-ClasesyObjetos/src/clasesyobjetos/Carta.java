package clasesyobjetos;

import daw.com.Pantalla;

public class Carta {
	
	//Estado de la clase

	private int numCarta;
	private String palo;
	 
	//Constructores
	
	  public Carta(int numCarta, String palo) {
		  this.numCarta = numCarta;
		  this.palo = palo;
		 
	  }
	  
	@Override
	public String toString() {
		return numCarta + " de " + palo ;
	}

	public int getNumCarta() {
		return numCarta;
	}

	public void setNumCarta(int numCarta) {
	
		this.numCarta = numCarta;
	}


	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" +this);
	}
}

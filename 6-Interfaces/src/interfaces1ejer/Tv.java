package interfaces1ejer;

public class Tv extends Aparato implements Hablador {
	
	private boolean teletexto;
	private int pulgadas;

	public Tv(int consumo, int precio, boolean teletexto, int pulgadas) {
		super(consumo, precio);
		this.teletexto = teletexto;
		this.pulgadas = pulgadas;
		}
	
	public Tv() {
		this(100,30000,true,28);
	}

	public boolean isTeletexto() {
		return teletexto;
	}

	public void setTeletexto(boolean teletexto) {
		this.teletexto = teletexto;
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

	@Override
	public void hablar() {
		System.out.println("Soy un TV y se hablar.");

	}

	@Override
	public String toString() {
		return "Tv" + super.toString()+ "[teletexto=" + teletexto + ", pulgadas=" + pulgadas + "]";
	}
	

}

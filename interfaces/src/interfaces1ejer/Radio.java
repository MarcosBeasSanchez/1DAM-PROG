package interfaces1ejer;

public class Radio extends Aparato implements Hablador {
	
	private boolean casete;
	private int potencia;

	public boolean isCasete() {
		return casete;
	}

	public void setCasete(boolean casete) {
		this.casete = casete;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public Radio(int consumo, int precio, boolean casete, int potencia) {
		super(consumo, precio);
		this.casete = casete;
		this.potencia = potencia;
	}
	
	public Radio() {
		this(50,15000,false,25);
	}

	@Override
	public void hablar() {
		System.out.println("Soy una RADIO y se hablar.");

	}

	@Override
	public String toString() {
		return "Radio " + super.toString() + " [casete=" + casete + ", potencia=" + potencia + "]";
	}

}

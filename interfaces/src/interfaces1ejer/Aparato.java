package interfaces1ejer;

public class Aparato {
	
	private int consumo;
	private int precio;

	public Aparato(int consumo, int precio) {
		this.consumo = consumo;
		this.precio = precio;
	}

	public int getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Aparato [consumo=" + consumo + ", precio=" + precio + "]";
	}

}

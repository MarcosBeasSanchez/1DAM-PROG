package ruletaRusa;

import java.util.Random;

public class Moneda {
	
	private boolean caraocruz = true;

	public boolean isCaraocruz() {
		return caraocruz;
	}

	public void setCaraocruz(boolean caraocruz) {
		this.caraocruz = caraocruz;
	}
	
	public boolean tirarMoneda() {
		Random rand = new Random();
		caraocruz = rand.nextBoolean();
		return caraocruz;
		
	}
	
	@Override
    public String toString() {
        return caraocruz ? "Cara" : "Cruz";
    }
	
}

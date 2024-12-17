package cestaCompra;

public enum ConsumoElectrodomestico {
	// Posibles valores de consumo con su coste
		A(100),B(80),C(60),D(50),E(30),F(10);
	
	private int coste;
	
	private ConsumoElectrodomestico (int coste)
	{
		this.coste = coste;
	}

	public int getCoste() {
		return coste;
	}
	
	

}
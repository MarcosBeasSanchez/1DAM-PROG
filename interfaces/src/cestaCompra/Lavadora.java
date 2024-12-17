package cestaCompra;

import daw.com.Teclado;

public class Lavadora extends Electrodomestico {
	private final static int CARGA = 5;
	
	private int carga;

	public Lavadora() {
		carga = CARGA;
	}

	public Lavadora(String identificador, int stock, float preciobase, Color color, ConsumoElectrodomestico consumo, int peso, int carga) {
		
		super(identificador, stock, preciobase, color, consumo, peso);
		setCarga (carga);
	}

	public Lavadora(String identificador) {
		super (identificador);
		carga = CARGA;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		if (carga < CARGA)
			carga = CARGA;
		this.carga = carga;
	}
	
	@Override
	public void leerRestoDatos ()
	{
		super.leerRestoDatos();
		setCarga (Teclado.leerInt("\nCarga "));
	}

	@Override
	public String toString() {
		return "Lavadora [Carga=" + carga  + super.toString() + "]";
	}
	
	@Override
	public float getExtra ()
	{
		float extra = (carga > 30) ? 50 : 0 ; // si carga > 30 extra es 50 sino es 0
		
		/*
		if (carga > 30)
			extra = 50;
		else
			extra = 0;
		*/
		
		return  extra ;
	}
	

}
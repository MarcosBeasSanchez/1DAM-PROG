package cestaCompra;

import daw.com.Teclado;

public class Televisor extends Electrodomestico {
	
	private final static float RESOLUCION = 20;
	private final static boolean TDT = false;
	
	private float resolucion;
	private boolean tdt;

	public Televisor() {
		this ("");
	}

	public Televisor(String identificador) {
		super(identificador);
		resolucion = RESOLUCION;
		tdt = TDT;
	}

	public Televisor(String identificador, int stock, float preciobase, Color color, ConsumoElectrodomestico consumo, int peso, float resolucion, boolean tdt) 
	{
		super(identificador, stock, preciobase, color, consumo, peso);
		
		setResolucion(resolucion) ;
		tdt = TDT;
	}

	public float getResolucion() {
		return resolucion;
	}

	public void setResolucion(float resolucion) {
		if (resolucion < RESOLUCION)
			resolucion = RESOLUCION;
		this.resolucion = resolucion;
	}

	public boolean isTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}
	
	@Override
	public void leerRestoDatos ()
	{
		super.leerRestoDatos();
		setResolucion (Teclado.leerFloat("\nResolucion "));
		tdt = Teclado.leerString("\nTiene tdt?(s/n)").equalsIgnoreCase("s");
	}

	
	@Override
	public String toString() {
		return "Televisor [resolucion=" + resolucion + ", tdt=" + tdt + "," + super.toString() + "]";
	}

	@Override
	public float getExtra ()
	{
		float extra = 0;
		
		if (tdt)
			extra += 50;
		
		if (resolucion > 40)
			extra += (super.getPreciobase() * 0.30);
	
		return  extra;
	}

}

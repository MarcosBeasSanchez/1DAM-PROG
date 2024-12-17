package javapowersolutions;

import clasesyobjetos.Libreria;
import daw.com.Teclado;

public class Desarrollo extends Producto {
	private String lenguaje;
	private int nLineas;
	private float pvpLinea;
	
	

	public Desarrollo(String id, String nombre, String lenguaje, int nLineas, float pvpLinea) {
		super(id, nombre);
		this.lenguaje = lenguaje;
		setnLineas (nLineas);
		setPvpLinea (pvpLinea);
	}

	public Desarrollo (String id)
	{
		this (id, "", "",0, 0);
	}
	
	public Desarrollo ()
	{
		this ("");
	}
	
	public Desarrollo (Desarrollo original)
	{
		this (original.getId(), original.getNombre(), 
				original.lenguaje, original.nLineas, original.pvpLinea);
	}

	public String getLenguaje() {
		return lenguaje;
	}


	public int getnLineas() {
		return nLineas;
	}

	public float getPvpLinea() {
		return pvpLinea;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public void setnLineas(int nLineas) {
		if (nLineas < 0)
			nLineas = 0;
		this.nLineas = nLineas;
	}

	public void setPvpLinea(float pvpLinea) {
		if (pvpLinea < 0)
			pvpLinea = 0;
		this.pvpLinea = pvpLinea;
	}

	@Override
	public void leerOtrosDatos ()
	{
		super.leerOtrosDatos();
		lenguaje = Teclado.leerString("\nLenguaje");
		nLineas = Libreria.leerEnteroPositivo("\nnÂº lÃ­neas");
		do
		{
			pvpLinea = Teclado.leerFloat("\nPrecio lÃ­nea");
		}while (pvpLinea <= 0);
	}
	

	@Override
	public float getPrecioFinal() {
		// TODO Auto-generated method stub
		return nLineas*pvpLinea;
	}

	@Override
	public String toString() {
		return "Desarrollo [lenguaje=" + lenguaje + ", nLineas=" + nLineas + ", pvpLinea=" + pvpLinea + ", toString()="
				+ super.toString() + "]";
	}
	
}
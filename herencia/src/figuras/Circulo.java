package figuras;

import daw.com.Teclado;

public class Circulo extends Figura {

	private int radio;

	
	public Circulo(String nombre, int x, int y, int color,float grosor, int radio) {
		
		super (nombre, x, y, color, grosor);
		
		setRadio (radio);

	}

	public Circulo() {
		this ("", 0,0,0,0);
	}
	public Circulo(String nombre) {
		this (nombre, 0,0,0,0);
	}

	public Circulo(String nombre, int x, int y, int color, float grosor) {
		
		this (nombre, x,y,color,grosor, 0);
	}

	
	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio <= 0 ? 1: radio;
	}

	
	public void leerDatos ()
	{
		
		super.leerDatos();

		setRadio (Teclado.leerInt("\nradio"));
		
	}
	
	
	
	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", toString()=" + super.toString() + "]";
	}

	public float getPerimetro ()
	{
		return (float) (2 *Math.PI * radio);
	}

}
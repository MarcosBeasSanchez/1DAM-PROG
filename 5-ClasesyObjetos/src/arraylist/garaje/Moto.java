package arraylist.garaje;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Moto extends Vehiculo {
	
	private boolean antirrobo;

	public Moto() {
		this("");
	}
	
	public Moto (String matricula)
	{
		this (1,matricula, false);
	}

	public Moto (Moto original)
	{
		super(original);
		this.antirrobo = original.antirrobo;
	}
	
	public Moto(int potencia, String matricula, boolean antirrobo) {
		super(potencia, matricula);
		// TODO Auto-generated constructor stub
		this.antirrobo = antirrobo;
	}

	public boolean isAntirrobo() {
		return antirrobo;
	}

	public void setAntirrobo(boolean antirrobo) {
		this.antirrobo = antirrobo;
	}

	@Override
	public void leerOtrosDatos()
	{
		super.leerOtrosDatos();
		antirrobo = Teclado.leerString("\nTiene antirrobo (S/N)").equalsIgnoreCase("s");
		
	}
	
	@Override
	public void mostrarDatos()
	{
		super.mostrarDatos();
		Pantalla.escribirString ("\nAntirrobo :" + antirrobo);
	}

	@Override
	public float getCouta() {
		// TODO Auto-generated method stub
		return getPotencia() * 2;
	}

}
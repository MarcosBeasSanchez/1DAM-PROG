package arraylist.garaje;

import daw.com.Pantalla;
import daw.com.Teclado;


public class Coche extends Vehiculo {
	
	private int numplazas;
	

	public Coche() {
		this("");
		// TODO Auto-generated constructor stub
	}


	public Coche (String matricula)
	{
		this (1,matricula,1);
	
	}
	public Coche(int potencia, String matricula, int numplazas) {
		super(potencia, matricula);
		// TODO Auto-generated constructor stub
		setNumplazas(numplazas);
	}
	
	public Coche (Coche original)
	{
		super (original);
		this.numplazas = original.numplazas;
	}

	public int getNumplazas() {
		return numplazas;
	}


	public void setNumplazas(int numplazas) {
		if (numplazas < 1)
			numplazas = 1;
		else if (numplazas > 8)
			numplazas = 8;
		
		this.numplazas = numplazas;
	}

	@Override
	public void mostrarDatos()
	{
		super.mostrarDatos();
		Pantalla.escribirInt("\nNÂº plazas", numplazas);
	}

	@Override
	public void leerOtrosDatos()
	{
		super.leerOtrosDatos();
		setNumplazas (Teclado.leerInt("Numero de plazas"));
	}
	@Override
	public float getCouta() {
		// TODO Auto-generated method stub
		return getPotencia()* numplazas;
	}

}
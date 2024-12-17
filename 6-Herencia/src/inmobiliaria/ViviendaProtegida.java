package inmobiliaria;

import daw.com.Teclado;

public class ViviendaProtegida extends Vivienda {

	private int anios;
	
	public ViviendaProtegida() {
		super();
		// TODO Auto-generated constructor stub
		anios = 0;
	}


	public ViviendaProtegida(Direccion direccion, int superficie, String descripcion, 
			float pvp, int anios) {
		super(direccion, superficie, descripcion, pvp);
		// TODO Auto-generated constructor stub
		setAnios (anios);
	}



	public ViviendaProtegida(Direccion direccion) {
		super(direccion);
		// TODO Auto-generated constructor stub
		anios = 0;
	}

	public ViviendaProtegida(ViviendaProtegida original) {
		super(original);
		// TODO Auto-generated constructor stub
		anios = original.anios;
	}


	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		if (anios < 0)
			anios = 0;
		this.anios = anios;
	}


	public void leerOtroDatos ()
	{
		super.leerOtroDatos();
		setAnios (Teclado.leerInt("Anios"));
	}

	@Override
	public String toString() {
		return "ViviendaProtegida [anios=" + anios + ", toString()=" + super.toString() + "]";
	}

	@Override
	public float getComision() {
		// TODO Auto-generated method stub
		return 0.01f * anios * getPvp();
	}

}
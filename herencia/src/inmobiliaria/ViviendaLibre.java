package inmobiliaria;

import daw.com.Teclado;

public class ViviendaLibre extends Vivienda {
	private float porcentaje;
	
	public ViviendaLibre() {
		super();
		porcentaje = 0;
		
	}

	public ViviendaLibre(Direccion direccion, int superficie, String descripcion, float pvp, float porcentaje) {
		super(direccion, superficie, descripcion, pvp);
		setPorcentaje (porcentaje);
	}

	public ViviendaLibre(Direccion direccion) {
		super(direccion);
		porcentaje = 0;
	}

	public ViviendaLibre(ViviendaLibre original) {
		super(original);
		// TODO Auto-generated constructor stub
		porcentaje = original.porcentaje;
	}

	
	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		if (porcentaje < 0)
			porcentaje = 0;
		
		this.porcentaje = porcentaje;
	}

	@Override
	public float getComision() {
		// TODO Auto-generated method stub
		return getPvp()*porcentaje / 100;
	}
	
	public void leerOtroDatos ()
	{
		super.leerOtroDatos();
		setPorcentaje (Teclado.leerFloat("Porcentaje comision de la inmobiliaria "));
	}

	@Override
	public String toString() {
		return "ViviendaLibre [porcentaje=" + porcentaje + ", toString()=" + super.toString() + "]";
	}
	
	


}
package javapowersolutions;

import clasesyobjetos.Libreria;
import daw.com.Teclado;

public class Formacion extends Producto {
	private int horas;
	private int profes;
	private String titulacion;
	
	
	public Formacion(String id, String nombre, int horas, int profes, String titulacion) {
		super(id, nombre);
		this.horas = horas;
		this.profes = profes;
		this.titulacion = titulacion;
	}

	public Formacion (String id)
	{
		this (id, "", 0, 0,"");
	}
	
	public Formacion ()
	{
		this ("");
	}
	
	public Formacion (Formacion original)
	{
		this (original.getId(), original.getNombre(), 
				original.horas, original.profes, original.titulacion);
	}
	
	
	
	public int getHoras() {
		return horas;
	}

	public int getProfes() {
		return profes;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setHoras(int horas) {
		if (horas < 0)
			horas = 0;
		this.horas = horas;
	}

	public void setProfes(int profes) {
		if (profes < 0)
			profes = 0;
		this.profes = profes;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	@Override
	public void leerOtrosDatos ()
	{
		super.leerOtrosDatos();
		
		horas = Libreria.leerEnteroPositivo("\nnÂº horas");
		profes = Libreria.leerEnteroPositivo("\nnÂº profes");
		titulacion = Teclado.leerString("\ntitulaciÃ³n");
	}
	
	
	@Override
	public float getPrecioFinal() {
		// TODO Auto-generated method stub
		return profes * horas * 300;
	}

	@Override
	public String toString() {
		return "Formacion [horas=" + horas + ", profes=" + profes + ", titulacion=" + titulacion + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public float getPrecioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
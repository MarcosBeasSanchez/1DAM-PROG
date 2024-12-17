package inmobiliaria;

import daw.com.Pantalla;

import java.util.ArrayList;

import clasesyobjetos.Libreria;



public abstract class AppConMenu {
	
	private ArrayList<String> opciones;
	
	public AppConMenu ()
	{
		opciones = new ArrayList();
	}
	
	public AppConMenu (ArrayList<String> opciones)
	{
		this.opciones = new ArrayList(opciones);
	}
	

	public ArrayList<String> getOpciones() {
		return new ArrayList(opciones);
	}

	public void setOpciones(ArrayList<String> opciones) {
		this.opciones = new ArrayList(opciones);
	}

	public boolean addOpcion (String opcion)
	{
		boolean exito = false;
		
		if (!opciones.contains(opcion))
		{
			opciones.add(opcion);
			exito = true;
		}
		return exito;
	}
	public void mostrarOpciones()
	{
		for (int i = 0; i < opciones.size(); i++)
			Pantalla.escribirString("\n" + (i+1) + ".-" +opciones.get(i));
		
		Pantalla.escribirString("\n" + (opciones.size() + 1) +".Salir" );
	}
	
	public void run ()
	{
		int opc;
		final int SALIR = opciones.size() + 1; 
		
		do
		{
			mostrarOpciones ();
			opc = Libreria.leerEntreLimites(1, SALIR, "\nElija una opcion");
			evaluarOpcion(opc);
		}while (opc != SALIR);
		
	}
	
	public abstract  void evaluarOpcion (int opc);

}

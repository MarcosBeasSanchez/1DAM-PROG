package arraylist.garaje;

import java.util.ArrayList;

import clasesyobjetos.Libreria;
import daw.com.Pantalla;
import daw.com.Teclado;

public class AppGaraje {

	private Garaje garaje;
	
	public AppGaraje (int nPlazas)
	{
		garaje = new Garaje (nPlazas);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nPlazas;
		AppGaraje app;
		
		nPlazas = Libreria.leerEnteroPositivo("\nnºplazas");
		
		app = new AppGaraje (nPlazas);
		
		app.menu ();
	}
	
	public void menu ()
	{
		int opcion;
		final int SALIR = 4;
		
		do
		{
			mostrarOpciones ();
			opcion = Libreria.leerEntreLimites(1, SALIR, "\nElija una opciÃ³n");
			evaluarOpcion (opcion);
		}while (opcion != SALIR);
	}

	private void evaluarOpcion(int opcion) {
		// TODO Auto-generated method stub
		switch (opcion)
		{
			case 1:
				insertar ();
				break;
			case 2:
				eliminar ();
				break;
			case 3:
				listar ();
				break;
		}
		
	}

	private void listar() {
		// TODO Auto-generated method stub
		garaje.mostrarDatosOrdenadosPorCuota();
		
	}

	private void eliminar() {
		// TODO Auto-generated method stub
		String matricula;
		Vehiculo v;
		
		matricula = Teclado.leerString("\nmatricula del vehÃ­culo a sacar");
		
		v = garaje.getVehiculo(matricula);
		
		if (v != null)
		{
			Pantalla.escribirString("\nA pagar "+ v.getCouta());
			garaje.removeVehiculo(matricula);
		}
		else
			Pantalla.escribirString("\nvehÃ­culo no existe");
			
	}

	private void insertar() {
		// TODO Auto-generated method stub
		String matricula;
		int tipo;
		Vehiculo v;
		
		if (garaje.getNplazasLibres() > 0)
		{
			do
			{
				matricula = Teclado.leerString("\nMatrÃ­cula");
			}while (garaje.getVehiculo(matricula)!= null);

			tipo = Libreria.leerEntreLimites(1, 2, "\ncoche Ã³ moto (1-2)");

			if (tipo == 1)
				v = new Coche (matricula);
			else
				v = new Moto (matricula);

			v.leerOtrosDatos();

			Pantalla.escribirString("\nVehiculo insertado en la plaza " + 
					(garaje.addVehiculo(v)+1));
		}
		else
			Pantalla.escribirString("\nCompleto");
	}

	private void mostrarOpciones() {
		// TODO Auto-generated method stub
		ArrayList<String> opciones ;
		opciones = new ArrayList();
		
		opciones.add("Insertar VehÃ­culo");
		opciones.add("Sacar VehÃ­culo");
		opciones.add("Listar plazas ocupadas");
		
		for (int i = 0; i < opciones.size(); i++)
			Pantalla.escribirString("\n" + (i+1) +"." + opciones.get(i));
		
		Pantalla.escribirString("\n" + (opciones.size() + 1) +".Salir" );
	}

}
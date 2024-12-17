package LeerEscribirGaraje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import daw.com.Pantalla;


public class Garaje {
	public static final int NOHAYPLAZASLIBRES = -1;
	public static final int VEHICULOEXISTENTE = -2;
	
	
	private int nplazas; // cantidad de plazas del garaje
	private Map <String,Vehiculo> plazas;
	
	
	public Garaje() {
		this(0);
	}
	
	public Garaje(int nplazas) {
		this.nplazas = nplazas;	
		plazas = new HashMap<> ();
	}

	public int getNplazas() {
		return nplazas;
	}

	public void setNplazas(int nplazas) {
		if (nplazas < plazas.size())
			nplazas = plazas.size();
		this.nplazas = nplazas;
	}
	
	
	public Map<String,Vehiculo> getPlazas() {
		return plazas;
	}

	public void setPlazas(Map<String,Vehiculo> plazas) {
		this.plazas = plazas;
	}

	public int getNplazasLibres() {
	
		return nplazas - plazas.size();
	}

	public int addVehiculo (Vehiculo v)
	{
		int exito = 0; 
		
		
		
		if (plazas.size() < nplazas) 
			if (!plazas.containsKey(v.getMatricula()))
				plazas.put(v.getMatricula(), v);
			else
				exito = VEHICULOEXISTENTE;
		else
			exito = NOHAYPLAZASLIBRES;
				
		return exito;
	}
	
	public boolean removeVehiculo (String matricula)
	{

		return plazas.remove(matricula)!= null;
		
	}
	
		
	public Vehiculo getVehiculo (String matricula)
	{
		
		return plazas.get(matricula);
	}
	
	public void mostrarDatos()
	{
		
		plazas.values().forEach(Vehiculo::mostrarDatos);
		
	}
	
	public float calcularTotalCoutas ()
	{
		float total = 0;
		Iterator<Vehiculo> vehiculos = plazas.values().iterator();
		
		while (vehiculos.hasNext())
			total += vehiculos.next().getCouta();
		
		return total;
	}
	
	public void escribirFicheroTexto (PrintWriter fichero)
	{
		fichero.println(nplazas);
		
		for (Vehiculo v: plazas.values())
		{
			if (v instanceof Coche)
				fichero.print("Coche,");
			else
				fichero.print("Moto,");
			fichero.println(v.toCSV());
		}
	}
	
	public void leerFicheroTexto (BufferedReader buffer) throws IOException
	{
		Vehiculo v;
		
		String tipo, valores[], linea ="";
		
		// leer nplazas
		try { // tratar la excepci�n por errores en nplazas, propagar por error de fichero
			setNplazas (Integer.parseInt(buffer.readLine()));
		}catch (IllegalArgumentException e)
		{
			nplazas = 0;
		}
		
		// dejar sin vehiculos plazas
		plazas.clear();

		// Leer los veh�culos
		while (plazas.size() < nplazas && buffer.ready())
		{
			valores = buffer.readLine().split(",", 2);
			tipo = valores[0];
			
			
			
			if (tipo.equals("Coche"))
				v = new Coche ();
			else
				v = new Moto ();
			
			
			v.fromCSV(valores[1]);
				
				
			addVehiculo(v);
			
		}
		
	}
	
}

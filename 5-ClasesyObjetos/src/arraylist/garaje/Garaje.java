package arraylist.garaje;

import java.util.ArrayList;



public class Garaje {
	private int nplazas;
	private ArrayList <Vehiculo> plazas;

	
	public Garaje() {
		plazas = new ArrayList<>();
		this.nplazas = 1;
	}
	
	public Garaje(int nplazas) {	
		plazas = new ArrayList<>();
		setNplazas (nplazas);
	}

	public int getNplazas() {
		return nplazas;
	}

	public void setNplazas(int nplazas) {
		if (nplazas < plazas.size())
			nplazas = plazas.size();
		this.nplazas = nplazas;
	}
	
	public int getNplazasLibres() {
		return nplazas - plazas.size();
	}

	public Vehiculo getVehiculo (String matricula)
	{
		Vehiculo aux, v;
		int plaza;
		
		aux = new Coche (matricula);
		v = null;
				
		plaza = plazas.indexOf(aux);
		
		if (plaza != -1)
			v = plazas.get(plaza); // plazas[plaza]
		
		return v;
	}
	
	
	public void setVehiculo (Vehiculo v, int cual)
	{
		if (cual >= 0 && cual < plazas.size()&& !plazas.contains(v))
			plazas.set(cual, v);
		
	}
	
	public int addVehiculo (Vehiculo v)
	{
		if (getNplazasLibres() > 0 && !plazas.contains(v))
			plazas.add(v);
		
		return plazas.lastIndexOf(v);
	}
	
	public boolean removeVehiculo (String matricula)
	{
		Vehiculo v;
		
		// chapuza
		v = new Coche (matricula);
		
		return plazas.remove(v);
	}
	
	public void mostrarDatos()
	{
		for (Vehiculo v : plazas)
			v.mostrarDatos();
		
	}
	
	public boolean existeVehiculo (Vehiculo v)
	{
		return plazas.contains(v);
	}
	
	public void mostrarDatosOrdenadosPorCuota()
	{
		ArrayList<Vehiculo> copia = new ArrayList(plazas);
		Vehiculo aux; 
		
		for (int i = 0; i < copia.size() - 1; i++)
			for (int j = i +1; j < copia.size(); j++)
				if (copia.get(i).getCouta() < copia.get(j).getCouta())
				{
					aux = copia.get(i); // aux = copia[i]
					copia.set(i, copia.get(j)); // copia[i] = copia[j]
					copia.set(j, aux);// copia[j] = aux
				}
			
		//copia.sort(Comparator.comparing(Vehiculo::getCouta));
		
		for (Vehiculo v : copia)
			v.mostrarDatos();
		
	}
	
}
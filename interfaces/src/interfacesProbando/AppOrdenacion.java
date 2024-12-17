package interfacesProbando;

import java.util.ArrayList;

import daw.com.Pantalla;

public class AppOrdenacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Ordenable> sabios = new ArrayList<Ordenable>();
		
		
		Sabio s1 = new Sabio ("blanca",30,true,5);
		Sabio s2 = new Sabio ("amarilla",20,false,15);
		
		
		sabios.add (s1);
		sabios.add (s2);
		
		// Ordenar de mayor a menor
		Ordenar.ordenarDeMayorAMenor(sabios);
		// mostarar
		Pantalla.escribirString("\nOrdenados de mayor a menor \n");
		for (int i = 0; i < sabios.size(); i++)
		{
			Sabio s = (Sabio) sabios.get(i);
			Pantalla.escribirString(s.toString()+"\n");
		}
				
		
		
		// ordenar de menor a mayor
		Ordenar.ordenarDeMenorAMayor(sabios);
		
		//Mostrar
		Pantalla.escribirString("\nOrdenados de menor a mayor \n");
		for (Ordenable s : sabios)
			System.out.println(s);
	}

}

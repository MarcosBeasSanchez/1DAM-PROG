package interfacesProbando;

import java.util.ArrayList;

public class Ordenar {
	
	public static void ordenarDeMayorAMenor (ArrayList <Ordenable> lista)
	{
		Ordenable temp;
		
		for (int i = 0; i < lista.size() - 1; i++)
			for (int j = i + 1; j < lista.size(); j++)
				if (lista.get(i).esMayor(lista.get(j)))
				{
					temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
	}

	
	public static void ordenarDeMenorAMayor (ArrayList <Ordenable> lista)
	{
		Ordenable temp;
		
		for (int i = 0; i < lista.size() - 1; i++)
			for (int j = i + 1; j < lista.size(); j++)
				if (lista.get(i).esMenor(lista.get(j)))
				{
					temp = lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
	}
}

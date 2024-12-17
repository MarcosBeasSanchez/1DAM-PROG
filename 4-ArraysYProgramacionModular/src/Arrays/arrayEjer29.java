package Arrays;

import daw.com.Pantalla;


public class arrayEjer29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean universidad[][][];
		int opcion;
		
		universidad = new boolean[5][20][2];
		
		// inicializar array
		for (int i = 0; i < universidad.length; i++) // SALAS
			for (int j = 0; j < universidad[i].length; j++) //ORDENADORES  DE CADA SALA
				for (int k = 0; k < universidad[i][j].length;k++) // TURNOS DE CADA ORDENADOR DE CADA SALA
					universidad[i][j][k] = false; // No ocupado = libre
		
		// menu
		do
		{
			mostrarOpciones ();
			opcion = Libreria.leerEntreLimites(1, 5, "\nElija una opcion");
			evaluarOpcion (opcion, universidad);
		}while (opcion != 5);
			
	}

	private static void evaluarOpcion(int opcion, boolean[][][] universidad) {
		// TODO Auto-generated method stub
		switch (opcion)
		{
			case 1:
				asignarTurno (universidad);
				break;
			case 2:
				cancelarTurno (universidad);
				break;
			case 3:
				equiposDisponiblesEnSala (universidad);
				break;
			case 4:
				turnosAsignadosTotal (universidad);
				break;
			case 5:
				Pantalla.escribirString("\nFIN...");
			
		}
		
	}

	private static void turnosAsignadosTotal(boolean[][][] universidad) {
		// TODO Auto-generated method stub
		int turnos = 0;
		
		for (int i = 0; i < universidad.length; i++)
			for (int j = 0; j < universidad[i].length; j++)
				for (int k = 0; k < universidad[i][j].length;k++)
					if (universidad[i][j][k] == true)
						turnos++;
		Pantalla.escribirString("\nturnos asignados " + turnos);
		
	}

	private static void equiposDisponiblesEnSala(boolean[][][] universidad) {
		// TODO Auto-generated method stub
		int libres = 0, sala;
		boolean turnoLibre;
		
		sala = Libreria.leerEntreLimites(0, universidad.length - 1, "\nsala?");
		
		// Recorrer los ordenadores de la sala
		for (int j = 0; j < universidad[sala].length; j++)
		{
			turnoLibre = false;
			// Recorrer los turnos de cada ordenador
			for (int k = 0; k < universidad[sala][j].length && !turnoLibre; k++)
			{
				if (universidad[sala][j][k] == false)
				{
					libres++;
					turnoLibre = true;
				}
			}
				
		}
		
		Pantalla.escribirString("\nOrdenadores disponibles en la sala " + sala + " -- " + libres);
		
		
		
	}

	private static void cancelarTurno(boolean[][][] universidad) {
		// TODO Auto-generated method stub
		int sala, ordenador,turno;
		
		sala = Libreria.leerEntreLimites(0, universidad.length - 1, "\nsala?");
		ordenador = Libreria.leerEntreLimites(0, universidad[sala].length - 1, "\nordenador?");
		turno = Libreria.leerEntreLimites(0, universidad[sala][ordenador].length - 1, "\nturno?");
		
		if (universidad[sala][ordenador][turno] == false)
			Pantalla.escribirString("\nEl turno ya estaba libre, imposible cancelar\n");
		else
		{
			universidad[sala][ordenador][turno] = false;
			Pantalla.escribirString("\nTurno liberado");
		}
		
	}

	private static void asignarTurno(boolean[][][] universidad) {
		// TODO Auto-generated method stub
		boolean encontrado = false;
		int libre[] = null;
		
		for (int i = 0; i < universidad.length && !encontrado; i++)
			for (int j = 0; j < universidad[i].length && !encontrado; j++)
				for (int k = 0; k < universidad[i][j].length && !encontrado;k++)
					if (universidad[i][j][k] == false)
					{
						encontrado = true;
						universidad[i][j][k] = true;
						libre = new int[3];
						libre[0] = i; // sala
						libre[1] = j; // ordenador
						libre[2] = k; // turno
					}
		
		if (libre != null)
		{
			Pantalla.escribirString("\nturno asignado\n");
			Pantalla.escribirString("\nSala" + libre[0]);
			Pantalla.escribirString("\nOrdenador " + libre[1]);
			Pantalla.escribirString("\nTurno " + libre[2]);
		}
		else
			Pantalla.escribirString("\nturnos completos");
		
	}

	private static void mostrarOpciones() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n1.Asignar Turno");
		Pantalla.escribirString("\n2.Cancelar Turno");
		Pantalla.escribirString("\n3.Cantidad de equipos disponibles en una sala");
		Pantalla.escribirString("\n4.Cantidad de turnos asignados en toda la uni");
		Pantalla.escribirString("\n5.Salir");
		
	}

}

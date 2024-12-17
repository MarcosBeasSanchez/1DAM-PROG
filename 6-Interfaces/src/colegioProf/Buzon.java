package colegioProf;

import java.util.ArrayList;
import java.util.Comparator;

import daw.com.Pantalla;

public class Buzon {

	private ArrayList<Mensaje> buzon;

	public Buzon() {

		buzon = new ArrayList<>();
	}

	public void addMensaje(Mensaje mensaje) {
		buzon.add(mensaje);
	}

	public void leerBuzon() {
		Comparator<Mensaje> porFecha;

		if (buzon.isEmpty())
			Pantalla.escribirString("\nNo hay mensajes en el buzón");
		else {

			// clase anónima
			porFecha = new Comparator<Mensaje>() {

				@Override
				public int compare(Mensaje o1, Mensaje o2) {
					// TODO Auto-generated method stub
					return o1.getFecha().compareTo(o2.getFecha());
				}

			};

			// Clase que implementa el interface
			// Comparator<Mensaje> porFecha = new PorFecha ();
			buzon.sort(porFecha.reversed());// Collections.sort(buzon,porFecha);

			while (!buzon.isEmpty()) {
				Mensaje m = buzon.remove(buzon.size() - 1);

				Pantalla.escribirString("\n" + m.toString());
			}

		}

	}

}

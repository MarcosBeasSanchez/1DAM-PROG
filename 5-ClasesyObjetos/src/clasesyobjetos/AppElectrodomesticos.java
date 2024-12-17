package clasesyobjetos;

import daw.com.Pantalla;

public class AppElectrodomesticos {

	public static void main(String[] args) {
		
		Electrodomestico maquinas[];
		
		//Crear arrays
		maquinas = new Electrodomestico [1];
		
		// Crear objetos
		for(int i = 0; i< maquinas.length; i++) {
			maquinas[i] = new Electrodomestico();
		}
		
		//Leer
		for(int i = 0; i< maquinas.length; i++) {
			maquinas[i].leerDatos();;
		}
		
		maquinas[0].mostrarDatos();	
		 Pantalla.escribirString(maquinas[0].toString());

	}

}

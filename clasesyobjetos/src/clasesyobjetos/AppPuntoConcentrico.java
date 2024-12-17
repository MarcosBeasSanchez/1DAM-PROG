package clasesyobjetos;

import daw.com.Teclado;

public class AppPuntoConcentrico {

	public static void main(String[] args) {
		
		/*Crear un conjunto de puntos, averiguar si hay puntos concéntricos (dos puntos
		 son concentricos si tienen la misma posicion de X e Y*/
		
		Punto array[] ;
		int cuantosPuntos;
		boolean hayConcentricos;
		
		
		// Cuantos Puntos queremos crear+
		cuantosPuntos= Teclado.leerInt("¿Cuantos Puntos quieres crear? ");
		array = new Punto[cuantosPuntos];
		
		// Inicializamos el array de clases
		for(int i = 0; i< array.length; i++) {
			array[i] = new Punto();
		}
		//Leemos cada Punto 
		for (int i =0; i<array.length;i++) {
			array[i].leerDatos();
		}
		
		hayConcentricos = xeySonIguales(array);
		 
		 if(hayConcentricos == true) {
			 System.out.println("HAY CONCENTRICOS");
		 }else {
			 System.out.println(" NO HAY CONCENTRICOS");
		 }
	
	}
	
	public static boolean xeySonIguales(Punto array[]) {
		boolean iguales = false;
											// !iguales loq ue hace es que si encuetra 1 sale del bucle
		for(int i = 0; i< array.length -1 && !iguales;i++) {
			for(int j = i + 1 ; j < array.length && !iguales; j++) {
				
				if (array[i].getX() == array[j].getX() && array[i].getY() == array[j].getY()) {
					iguales = true;
				}
			}
		}
		return iguales;
	}
}

			
		
		
	


	

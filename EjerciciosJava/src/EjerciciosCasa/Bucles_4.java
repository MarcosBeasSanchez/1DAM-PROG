package EjerciciosCasa;

import daw.com.Teclado;

public class Bucles_4 {

	public static void main(String[] args) {
		/* Se ingresan un conjunto de N alturas de personas por teclado. 
		El valor de la altura debe seren metros. Mostrar el promedio de todas las alturas.*/
		
        int nAlturas;
        float altura, sumaAlturas = 0, promedio;

        nAlturas = Teclado.leerInt("¿Cuantas alturas quieres leer?");

        for (int i = 0; i < nAlturas; i++) {
            altura = Teclado.leerFloat("Introduce tu altura " + (i + 1));
            sumaAlturas += altura; 
        }

        promedio = sumaAlturas / nAlturas;

        System.out.println("La altura promedio es de: " + promedio);

 
      
    }
}

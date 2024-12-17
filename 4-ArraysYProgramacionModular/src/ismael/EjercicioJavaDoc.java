package ismael;

import daw.com.Teclado;
	
	/**@author Marcos Beas
	 * 
	 */


public class EjercicioJavaDoc {
	
	/**
	 * @author Marcos Beas
	 * @param args Argumentos de invocacion del programa
	 * <p>Un metodo que filtra los num indicados por el ususario y devuelve los pares con el metodo<code>esPar</code>
	 * </p>
	 * @see <a href="http://www.oracle.com"> Java documentation</a>
	 * @version 1.0.0
	 * 
	 */

	public static void main(String[] args) {
		
		//inicializar 
		int[] array = new int [5];
		
		//introducir datos con daw.com
		for (int i = 0; i < 5; i++) {
			array[i] = Teclado.leerInt("introduce un numero");
		}
		//filtrar impares	
		filtrarImpares(array);
		
	}
	/**
	 * <p>
	 * </p>
	 * 
	 * 
	 * @param entero Numero a comprobar
	 * @since 1.0.0
	 * @return true si es par , false si es impar
	 */
	
	public static boolean esPar(int entero) {
		return entero % 2 == 0;
	}
	/**
	 * 
	 * @param elementos Array que recibe con los elementos para indicar posicion y si <code> esPar </code>
	 * @since 1.0.2
	 */
	
	public static void filtrarImpares(int [] elementos) {
		
		for (int i = 0; i < 5; i++) {
			
			if(esPar(elementos[i])){
				System.out.println("la posicion " + (i+1) + " del array es par ("+elementos[i]+")");
			}
		}
	}

}

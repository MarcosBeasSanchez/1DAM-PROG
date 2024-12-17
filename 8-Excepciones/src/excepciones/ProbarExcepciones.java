package excepciones;

import java.util.Arrays;

public class ProbarExcepciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre = null;
		int array[]= new int[3];
		Arrays.fill(array,3);
		
		try {
			nombre.concat("MARCOS"); //en cuanto enuentra un error pasa del try a los catch, se olvida del resto;
			array[4]++;
		}
		catch (NullPointerException e) {
			nombre= ".";
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("te has pasado de tamaño");
		}
		catch(Exception e) {
			System.out.println("Error INDEFINIDO");
		}
		
		System.out.println(nombre);

	}

}

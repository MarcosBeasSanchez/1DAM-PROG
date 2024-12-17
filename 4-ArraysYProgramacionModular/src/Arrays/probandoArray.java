package Arrays;

import daw.com.Teclado;

public class probandoArray {

	public static void main(String[] args) {
		
		int array[];
		array = new int [10];
		
		for (int i = 0 ; i < array.length; i++) {
			array[i] = Teclado.leerInt();
			System.out.println(array[i]);
		}
		

	}

}

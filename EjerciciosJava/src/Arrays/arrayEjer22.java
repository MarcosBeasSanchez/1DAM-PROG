package Arrays;

import daw.com.Teclado;

public class arrayEjer22 {

	public static void main(String[] args) {
		/*Leer 10 números enteros, almacenarlos en un vector 
		y determinar cuántas veces está repetido el mayor. */
		
		 int arrayNum[];
		 arrayNum = new int[10];
		  int mayor =0;
		 
		  leerArray(arrayNum); 
		  mayor=determinarMayor(arrayNum);
		  compararMayor(arrayNum, mayor);
		 
	}
	
	private static void compararMayor( int arrayNum[] , int mayor) {
		
		int veces = 0;
		for (int i = 0; i < arrayNum.length; i++) {
			if (mayor == arrayNum[i])
				veces++;
		}
		
		System.out.println("El numero " + mayor + " se ha repetido " + veces + " veces");
	}
	
	private static int determinarMayor(int[] arrayNum) {
		
		int numMayor = arrayNum[0];
		
		for (int i = 0; i < arrayNum.length;i++) {
			if(numMayor < arrayNum[i]) 
				numMayor = arrayNum[i];		
			}
		
		return numMayor;
	}
	
	private static void leerArray(int arrayNum[]){
		
		for(int i = 0; i < arrayNum.length; i++) 
			arrayNum[i] = Teclado.leerInt("Num" + "[" + i + "] = ");
		}	
	}

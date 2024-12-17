package Arrays;
import daw.com.Pantalla;
import daw.com.Teclado;

public class arrayEjer18 {

	public static void main(String[] args) {
		//Leer  var,enteros, almacenarlos en un array
		//y determinar en qué posición del array  está el mayor número leído. 
		
		int cuantosNumeros, coleccionNumeros[], numMayor;
		
		cuantosNumeros = Teclado.leerInt("dime cuantos numeros quieres leer");	
		
		coleccionNumeros = new int[cuantosNumeros];
		
		for(int x=0 ; x < cuantosNumeros ; x++)
		{
			coleccionNumeros[x]=Teclado.leerInt("dime que numeros quieres leer");
		}
		
		numMayor = coleccionNumeros[0];
		
		for(int i = 0; i < cuantosNumeros; i++)
		{
			if (coleccionNumeros[i] > numMayor)
				numMayor = i ;
			
		}
			Pantalla.escribirInt("posición del número mayor = ", numMayor);		
	}
}

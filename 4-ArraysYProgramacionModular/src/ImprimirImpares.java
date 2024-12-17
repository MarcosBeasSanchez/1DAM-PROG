import daw.com.Teclado;

public class ImprimirImpares {

	public static void main(String[] args) {
		// imprimir los numeros impares positivos menores que x.

		//Definir
		int n=0, contadorImpares = 0;
		
		
		
		//Introducir un numero mayor a 0
		do {
			n = Teclado.leerInt("dame un numero");
		}while(n <= 0);
		
		
		// imprime numeros impares 
		for (int i = 1; i < n; i += 2) {
			System.out.println(i );
			contadorImpares++ ;
		}
		
		System.out.println("tu numero de impares es " + contadorImpares);
		
	}

}

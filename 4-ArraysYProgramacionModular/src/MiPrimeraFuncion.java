import daw.com.Teclado;

public class MiPrimeraFuncion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int resultado, n1 , n2 ;
		
		resultado = sumar10Primeros();
		
		System.out.println(resultado);
		
		n1 = Teclado.leerInt("primer numero");
		n2 = Teclado.leerInt("segundo numero");
		
		resultado = sumarEntreIntervalos(n1,n2);
		
		System.out.println(resultado);
	}


public static int sumar10Primeros (){
	int suma = 0;
	
	for (int i = 1; i < 11 ; i++)
		suma +=i; 
	return suma;
}

public static int sumarEntreIntervalos (int min, int max) {
	int suma =0;
	
	for (int i = min; i<= max;i++)
		suma += i;
	return suma;
	}
}


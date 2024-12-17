package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales_10 {

	public static void main(String[] args) {
	//º Que calcule el sueldo que le corresponde al trabajador de una empresa que cobra 40.000 euros anuales
	// el programa debe realizar los cálculos en función de los siguientes criterios:
		//a. Si lleva más de 10 años en la empresa se le aplica un aumento del 10%.
		//b. Si lleva menos de 10 años pero más que 5 se le aplica un aumento del 7%.
		//c. Si lleva menos de 5 años pero más que 3 se le aplica un aumento del 5%.
		//d. Si lleva menos de 3 años se le aplica un aumento del 3%

		double TOTAL = 40000, neto=0;
		int años ;
		
		años = Teclado.leerInt("Dime cuantos años llevas en la empresa");
		
		if (años >= 10)
			neto = TOTAL * 1.1;
		if (años < 10 && años >= 5)
			neto = TOTAL * 1.07;
		if (años < 5 && años >= 3)
			neto = TOTAL * 1.05;
		if (años < 3)
			neto = TOTAL * 1.03;
		
		System.out.println("tu sueldo es de " + neto);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

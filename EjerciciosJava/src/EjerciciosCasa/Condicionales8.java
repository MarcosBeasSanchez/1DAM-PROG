package EjerciciosCasa;

import daw.com.Teclado;

public class Condicionales8 {

	public static void main(String[] args) {
		//Que lea un importe bruto y calcule su importe neto, si es mayor de 15.000 se le aplicará un 16%
		//de impuestos, en caso contrario se le aplicará un 10%.
		
		float bruto, neto;
		
		bruto = Teclado.leerFloat("dame tu sueldo");
		
		// ponner una f al final del *0.10d y *0.16d nos transforma la VAR bruto a double para poder operar con decimales.
		if (bruto < 15000) {
			neto = bruto * 0.10f;
		}else {
			neto = bruto * 0.16f;
		}
		
		System.out.println("tu impuestos retenidos son " + neto);
	
	}

}

import daw.com.Pantalla;

public class NumeroTarot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dia, mes, anio, tarot;
		
		anio = Libreria.leerEnteroPositivo("aÃ±o de nacimiento:");
		mes = Libreria.leerEntreLimites(1, 12, "mes de nacimiento:");
		dia = leerDia (anio,mes);
		
		tarot = calcularTarot (dia, mes, anio);
		
		Pantalla.escribirString("\ntu nÃºmero del tarot es " + tarot);
	}

	private static int leerDia(int anio, int mes) {
		// TODO Auto-generated method stub
		int diasMes, dia;
		
		switch (mes)
		{
			case 1,3,5,7,8,10,12:
				diasMes = 31;
				break;
			case 2:
				diasMes = Libreria.esBisiesto(anio)?29:28;
				break;
			default:
				diasMes = 30;
		}
		
		dia = Libreria.leerEntreLimites(1, diasMes, "dÃ­a de nacimiento: ");
		return dia;
	}

	private static int calcularTarot(int dia, int mes, int anio) {
		// TODO Auto-generated method stub
		int tarot;
		
		tarot = anio + mes + dia;
		
		while (tarot > 9)
			tarot = sumarDigitos (tarot);
		
		return tarot;
	}

	private static int sumarDigitos(int numero) {
		// TODO Auto-generated method stub
		int digito, suma = 0;
		
		while (numero > 0)
		{
			digito = numero % 10;
			suma += digito;
			numero /= 10;
		}
		
		return suma;
	}
	
	

}

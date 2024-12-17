package EjerciciosCasa;

import daw.com.Teclado;

public class T2_Propuestos_7 {

	  public static void main(String[] args) {
		  
	        int cantidadNumeros = 0;
	        int sumaCifras = 0;
	        String respuesta ;

	        
	        do {
		        int numero = Teclado.leerInt("Dame un número");
	        	cantidadNumeros = calcularNumero(numero);
	        	sumaCifras=sumaNumeros(numero);
	        	System.out.println("Ha in introducido "+ cantidadNumeros + " cifras\nLa suma es: " + sumaCifras);
	        	respuesta = Teclado.leerString("DESEA INTODUCIR OTRO? S/N");
	        	
	        }while(!respuesta.equalsIgnoreCase("N"));
	        System.out.println("FIN");
	        
	    }
	  
	  private static int calcularNumero(int numero) {
		 int cantidadNumeros = 0;
		   do {
	            numero = numero / 10;
	            cantidadNumeros++;
	        } while (numero != 0);
		  return cantidadNumeros;
	  }
	  
	  private static int sumaNumeros(int numero) {
		 int sumaCifras = 0;
		
		  while ( numero > 0) {
			sumaCifras = sumaCifras + numero % 10;
			numero = numero /10;
		  }
		  return sumaCifras;	  
	  }
	  
	  
	  
	  }

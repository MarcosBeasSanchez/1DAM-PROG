import daw.com.Teclado;

public class FrasePalindroma {

	public static void main(String[] args) {
		// Hacer una funcion que reciba una frase y devuelva si la frase es capicua sin tener en cuenta los espacios
		String frase;
		
		do
		{
			frase = Teclado.leerString("Introduzca una frase");
		}while (frase.length() <= 1);
		
		
		if (esPalindroma(frase))
			System.out.println("ES palindroma");
		else
			System.out.println("NO es palindroma");
		
		
	}

	
	 public static boolean esPalindroma(String frase) {
	       
		 // Eliminar espacios y convertir a minúsculas
	        frase = frase.replace(" ", "").toLowerCase();

	       
	     // Verificar palíndromo
	       for (int i = 0; i < frase.length() / 2; i++) 
	            if (frase.charAt(i) != frase.charAt(frase.length()- 1 - i)) 
	                return false;
	        
	        return true;
	 }
}


	
		

	


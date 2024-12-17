	import daw.com.Pantalla;
	import daw.com.Teclado;
public class FrasePalindromaClase {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			String frase;
			boolean loEs;
			
			frase = Teclado.leerString("dime una frase");
			
			loEs = esPalindroma (frase);
			/*
			if (loEs)
				Pantalla.escribirString("\nla frase es palÃ­ndroma");
			else
				Pantalla.escribirString("\nla frase NO es palÃ­ndroma");
			*/
			Pantalla.escribirString("\nla frase " 
						+(loEs?"":"NO ")  
						+"es palÃ­ndroma");
		}

		public static boolean esPalindroma(String frase) {
			// TODO Auto-generated method stub
			
			String fraseAlReves="", letra;
		
			// quitar los espacios
			frase = frase.replace (" ", "");
			
			for (int i = frase.length() - 1; i >= 0; i--)
			{
				letra = frase.substring(i, i+1);
				fraseAlReves += letra;
			}
			
					
			return frase.equalsIgnoreCase(fraseAlReves);
		}
		

	}
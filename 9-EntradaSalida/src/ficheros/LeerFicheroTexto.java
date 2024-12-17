package ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LeerFicheroTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String linea;
		int nPalabras = 0;
		Set<String> palabras;
		
		// try -catch con recursos, cierra sÃ³lo los recursos abiertos
		try (BufferedReader buffer = new BufferedReader(new FileReader ("quijote.txt")))
		{
			palabras = new TreeSet<>();
			while (buffer.ready())
			{
				linea = buffer.readLine();
				nPalabras += linea.split(" ").length; 
				System.out.println(linea);
				// AÃ±adir palabras
				Arrays.
						asList(linea.split(" ")).
						forEach(p-> palabras.add(p));
			}
				 
			System.out.println("total palabras " + nPalabras);
			System.out.println(palabras);
			
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("El fichero no existe");
		}
		catch (IOException e)
		{
			System.out.println("Error de lectura");
		}


	}

}
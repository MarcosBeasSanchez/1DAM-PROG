package cestaCompra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RedirigirTeclado {
	private static final InputStream entrada = System.in;
	
	public static void fromFile (String fileName)
	{
		InputStream in;
		try {
			in = new FileInputStream (fileName);
			System.setIn(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void fromKeyboard ()
	{
	
		System.setIn(entrada);
	}
}
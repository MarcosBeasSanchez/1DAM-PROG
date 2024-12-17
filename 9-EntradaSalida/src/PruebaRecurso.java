import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import daw.com.Pantalla;

public class PruebaRecurso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 FileInputStream bentrada = null;
		 DataInputStream fentrada = null;
		 File file = new File("figuras.dat");
		 
		 try (Recurso recurso = new Recurso(file))
		 {
			 while (recurso.getFentrada().available() != 0)
				 recurso.getFentrada().read();

		 }
		 catch (Exception e)
		 {
			 Pantalla.escribirString(e.getMessage());
		 }
		 

		 
	}

}

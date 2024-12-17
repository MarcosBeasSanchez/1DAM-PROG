import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import daw.com.Pantalla;

public class Recurso implements AutoCloseable {
	
	private FileInputStream bentrada;
	private DataInputStream fentrada;
	
	public Recurso (File file) throws FileNotFoundException
	{
		bentrada = new FileInputStream (file);
		fentrada = new DataInputStream (bentrada);
		
	}
	
	

	public FileInputStream getBentrada() {
		return bentrada;
	}



	public DataInputStream getFentrada() {
		return fentrada;
	}



	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		fentrada.close();
		bentrada.close();
		Pantalla.escribirString("cerrando ficheros");

	}

}

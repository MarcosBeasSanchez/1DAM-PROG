package FicherosBinarios;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import daw.com.Pantalla;

public class AppEscribirFicheroBinario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (DataOutputStream filtro = new DataOutputStream(new FileOutputStream("borrame.dat")))
		{
			filtro.writeUTF("miguel");
			filtro.writeInt(34);
			filtro.writeFloat(5000);
			filtro.writeBoolean(true);
			

			filtro.writeUTF("ana");
			filtro.writeInt(24);
			filtro.writeFloat(500);
			filtro.writeBoolean(false);

			
		}  
		catch (IOException e) {
			// TODO Auto-generated catch block
			Pantalla.escribirString("\nError escribiendo..");
		}

	}

}
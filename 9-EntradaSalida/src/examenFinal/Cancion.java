package examenFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import daw.com.Teclado;

public class Cancion extends Material implements LeerDatos {

	String autor, datos;
	
	public Cancion(String id, String nombre, LocalDate fechaEstreno, Categoria categoria, String autor, String datos) {
		super(id, nombre, fechaEstreno, categoria);
		this.autor = autor;
		this.datos = datos;
	}

	public Cancion() {
		super();
		this.autor="";
		this.datos="";
	}
	public Cancion(String id) {
		super(id);
		this.autor="";
		this.datos="";
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	@Override
	public void leerSoloDatos() {
		super.leerSoloDatos();
		this.autor = Teclado.leerString("Autor Cancion");
		this.datos = Teclado.leerString("Datos extra");
	}
	
	public void leerFichero(DataInputStream entrada) throws IOException {
		super.leerFichero(entrada);
		autor = entrada.readUTF();
		datos = entrada.readUTF();
	}
	
	public void escribirFicheros(DataOutputStream salida) throws IOException {
		super.escribirFichero(salida);
		salida.writeUTF(autor);
		salida.writeUTF(datos);
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Cancion";
	}

	
}

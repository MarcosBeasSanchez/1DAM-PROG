package ejercicio1ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import daw.com.Teclado;

public class Bolsillo extends Libro {

	int nPag;

	public Bolsillo(String nombre) {
		super(nombre);
		this.nPag = 0;
	}

	public Bolsillo(String nombre, String autor, int nautores, float precio, Tipo tipo, LocalDate fecha) {
		super(nombre, autor, nautores, precio, tipo, fecha);
		this.nPag = 0;
	}
	
	public Bolsillo(String nombre, String autor, int nautores, float precio, Tipo tipo, LocalDate fecha,int npag) {
		super(nombre, autor, nautores, precio, tipo, fecha);
		this.nPag = npag;
	}
	
	public Bolsillo() {
		super();
		this.nPag = 0;
	}

	public int getnPag() {
		return nPag;
	}

	public void setnPag(int nPag) {
		if (nPag < 0) {
			throw new IllegalArgumentException("Npag no puede ser menor que 0");
		}
		this.nPag = nPag;
	}

	@Override
	public float precioTotal() {
		float precioTotal = (nPag * super.getPrecio()) / super.getTipo().getPrecioTipo();
		return precioTotal;
	}

	@Override
	public void leerTodo() {
		super.leerTodo();
		setnPag(Teclado.leerInt("Numero de páginas"));
	}

	@Override
	public String toString() {
		return  super.toString() +"Bolsillo [nPag=" + nPag + ", precioTotal()=" + precioTotal() + "]";
	}


	@Override
	public String writeCSV() {
		String linea = "";
		
		linea += nombre;
		linea += ";";
		linea += autor;
		linea += ";";
		linea += nautores;
		linea += ";";
		linea += precio;
		linea += ";";
		linea += tipo;
		linea += ";";
		linea += fecha;
		linea += ";";
		linea += nPag;
		linea += ";";
		
		return linea;
	}

	@Override
	public void fromCSV(String[] valores) throws IOException {
		
		nombre = valores[1];
		autor = valores[2];
		nautores = Integer.parseInt(valores[3]);
		precio = Float.parseFloat(valores[4]);
		tipo = Tipo.valueOf(valores[5]);
		fecha = LocalDate.parse(valores[6]);
		nPag = Integer.parseInt(valores[7]);
		
	}

	@Override
	public void writeDAT(DataOutputStream salida) throws IOException {
		salida.writeUTF(nombre);
		salida.writeUTF(autor);
		salida.writeInt(nautores);
		salida.writeFloat(precio);
		salida.writeUTF(tipo.toString());
		salida.writeUTF(fecha.toString());
		salida.writeInt(nPag);
		
	}

	@Override
	public void readDAT(DataInputStream entrada) throws IOException {
		nombre = entrada.readUTF();
		autor = entrada.readUTF();
		nautores = entrada.readInt();
		precio = entrada.readFloat();
		tipo = Tipo.valueOf(entrada.readUTF());
		fecha = LocalDate.parse(entrada.readUTF());
		nPag = entrada.readInt();
	}
	
	

	
	
	
	
	
	
	
	
}




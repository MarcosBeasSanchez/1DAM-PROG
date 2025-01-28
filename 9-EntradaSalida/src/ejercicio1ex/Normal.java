package ejercicio1ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import daw.com.Teclado;

public class Normal extends Libro implements Leer {
	
	boolean conTapaDura;
	int nPag;
	
	public Normal(String nombre, String autor, int nautores, float precio, Tipo tipo, LocalDate fecha,
		boolean conTapaDura, int nPag) {
		super(nombre, autor, nautores, precio, tipo, fecha);
		this.conTapaDura = conTapaDura;
		this.nPag = nPag;
	}
	
	public Normal(String nombre) {
		super(nombre);
		this.conTapaDura = true;
		this.nPag = 0;
	}
	
	public Normal() {
		super();
		this.conTapaDura = true;
		this.nPag = 0;
	}

	public boolean isConTapaDura() {
		return conTapaDura;
	}

	public void setConTapaDura(boolean conTapaDura) {
		this.conTapaDura = conTapaDura;
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
	public void leerTodo() {
		super.leerTodo();
		boolean exito;
		
		do {
			exito=false;
			try {
				String res = Teclado.leerString("Con tapa dura: Si/No");
				boolean respuesta = aboolean(res);
				setConTapaDura(respuesta);
				setnPag(Teclado.leerInt("Numero de paginas"));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				exito=true;
			}
		} while (exito);

	}

	private boolean aboolean(String res) {
		boolean r;
		if (res.equalsIgnoreCase("SI")) {
			r = true;
		}else if (res.equalsIgnoreCase("NO")) {
			r = false;
		}else {
			throw new IllegalArgumentException("Dato introducido erroneo");
		}
		return r;
	}

	@Override
	public float precioTotal() {
		float precioTotal = (nPag * super.getPrecio()) / super.getTipo().getPrecioTipo();
		return precioTotal;
	}

	@Override
	public String toString() {
		return super.toString() + "Normal [conTapaDura=" + conTapaDura + ", nPag=" + nPag + ", precioTotal()=" + precioTotal() + "]";
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
		linea += conTapaDura;
		linea += ";";
		linea += nPag;
		linea += ";";
		
		return linea;
	}
	
	@Override
	public void fromCSV(String[] valores) throws IOException {
		// el valor [0] ha sido consumido como Tipo de Libro(Normal o Bolsillo)
		nombre = valores[1];
		autor = valores[2];
		nautores = Integer.parseInt(valores[3]);
		precio = Float.parseFloat(valores[4]);
		tipo = Tipo.valueOf(valores[5]);
		fecha = LocalDate.parse(valores[6]);
		conTapaDura = Boolean.parseBoolean(valores[7]);
		nPag = Integer.parseInt(valores[8]);
	}

	@Override
	public void writeDAT(DataOutputStream salida) throws IOException {
		salida.writeUTF(nombre);
		salida.writeUTF(autor);
		salida.writeInt(nautores);
		salida.writeFloat(precio);
		salida.writeUTF(tipo.toString());
		salida.writeUTF(fecha.toString());
		salida.writeBoolean(conTapaDura);
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
		conTapaDura = entrada.readBoolean();
		nPag = entrada.readInt();
		
	}

	

	
	
	

	

}

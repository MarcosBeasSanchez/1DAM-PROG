package practicaFinalProfe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import daw.com.Pantalla;
import daw.com.Teclado;

public class NoPerecedero extends Producto {
	private String pais;
	private Tipo tipo;
	
	
	
	public NoPerecedero() {
		this("");
	}

	public NoPerecedero(String referencia) {
		super(referencia);
		this.pais = "España";
		this.tipo = Tipo.COMESTIBLE;
	}

	


	public NoPerecedero(String referencia, String nombre, float precio, int stock,String pais, Tipo tipo) {
		super(referencia, nombre, precio, stock);
		// TODO Auto-generated constructor stub
		this.pais = pais;
		this.tipo = tipo;
	}

	
	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	
	
	@Override
	public String toString() {
		return "NoPerecedero [pais=" + pais + ", tipo=" + tipo + ", toString()=" + super.toString() + "]";
	}

	public void leerOtrosDatos ()
	{
		boolean valido;
		super.leerOtrosDatos();
		pais = Teclado.leerString("\npais: ");
		
		do
		{
			valido = true;
			try
			{
				tipo = Tipo.valueOf(Teclado.leerString("\nTipo").toUpperCase());
			}
			catch (IllegalArgumentException e)
			{
				valido = false;
				Pantalla.escribirString("\nTipo no permitido");
			}
		}while (!valido);
		
	}

	@Override
	public float getPrecioVenta() {
		// TODO Auto-generated method stub
		float precioVenta = getPrecio ();
		
		if (!pais.equals("España") && (tipo.equals(Tipo.BELLEZA) || tipo.equals(Tipo.LIMPIEZA)))
			precioVenta *= 2; 
		else
			precioVenta *= 1.4f;
		
		return precioVenta;
	}

	public void escribirFichero (DataOutputStream filtro) throws IOException
	{
		super.escribirFichero(filtro);
		filtro.writeUTF(pais);
		filtro.writeUTF(tipo.toString());
	}
	
	public void leerFichero (DataInputStream filtro) throws IOException
	{
		super.leerFichero(filtro);
		pais = filtro.readUTF();
		try
		{
			tipo = Tipo.valueOf(filtro.readUTF());
		}
		catch (IllegalArgumentException e)
		{
			tipo = Tipo.COMESTIBLE;
		}
		
	}
}

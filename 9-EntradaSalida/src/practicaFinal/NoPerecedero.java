package practicaFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

import daw.com.Pantalla;
import daw.com.Teclado;
import practicaFinalProfe.Tipo;

public class NoPerecedero extends Producto {
	
	Tipo tipo;
	String procedencia;

	public NoPerecedero(String nombre, float precio, int stock, Tipo tipo, String procedencia) {
		super(nombre, precio, stock);
		setTipo(tipo);
		setProcedencia(procedencia);
	}

	public NoPerecedero() {
		super();
		this.tipo = Tipo.COMESTIBLE;
		this.procedencia = "";
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo)  {
		    this.tipo = tipo;
	}

	public String getProdecencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) throws IllegalArgumentException{
		if (procedencia == null) {
			throw new IllegalArgumentException("Procedencia no puede estar vacio");
		}
		this.procedencia = procedencia;
	}

	@Override
	public String toString() {
		return super.toString() + "NoPerecedero [tipo=" + tipo + ", procedencia=" + procedencia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(procedencia, tipo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		
		NoPerecedero other = (NoPerecedero) obj;
		return Objects.equals(procedencia, other.procedencia) && tipo == other.tipo;
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		boolean valido;
			
			do{
				valido = true; 
				try{
					tipo = Tipo.valueOf(Teclado.leerString("\nTipo de producto:belleza/comestible/limpieza").toUpperCase());
				}
				catch (IllegalArgumentException e){
					valido = false;
					Pantalla.escribirString("\nTipo no permitido");
				}
				
			}while (!valido);	
			
			
			setProcedencia(Teclado.leerString("\nPais de procedencia").toUpperCase());
			
		
	}

	@Override
	public float getPrecioVenta() {
		float precioFinal = getPrecioCompra();
		
		 if ((tipo.equals(Tipo.LIMPIEZA) || tipo.equals(Tipo.BELLEZA)) && !procedencia.equals("ESPAÑA")) {
			 precioFinal *= 2;
	        } else {
	        	precioFinal *= 1.4f;
	        }
		return precioFinal;
	    }
	
	
	public void escribirFichero (DataOutputStream filtro) throws IOException
	{
		super.escribirFichero(filtro);
		filtro.writeUTF(procedencia);
		filtro.writeUTF(tipo.toString());
	}
	
	public void leerFichero (DataInputStream filtro) throws IOException
	{
		super.leerFichero(filtro);
		procedencia = filtro.readUTF();
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


package practicaFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import daw.com.Teclado;

public class Perecedero extends Producto {

	private LocalDate caducidad;
	
	public Perecedero(String nombre, float precio, int stock,LocalDate caducidad) {
		super(nombre, precio, stock);
		setCaducidad(caducidad);
	}
	
	public Perecedero() {
	super();
	this.caducidad=LocalDate.now();
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) throws IllegalArgumentException{
		if (caducidad.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Error fecha no valida,no puede ser anterior al dia de hoy");
		}
		this.caducidad = caducidad;
	}
	
	public boolean estaCaducado() {
		
		return getCaducidad().isBefore(LocalDate.now());
		
	}

	@Override
	public float getPrecioVenta() {
	    long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), caducidad);
	    
	    float precioFinal = 0;
	    
	    if (diasRestantes > 5) {
	    	precioFinal = getPrecioCompra() * 2;
	        
	    } else if (diasRestantes >= 3) {
	    	precioFinal = getPrecioCompra() * 1.5f; 
	        
	    } else if (diasRestantes > 0) {
	    	precioFinal =  getPrecioCompra();
	        
	    }
		return precioFinal; 
	}

	@Override
	public void leerDatos() {
		super.leerDatos();
		boolean exito;
		
		do {
			exito = false;
			try {
				setCaducidad(LocalDate.parse(Teclado.leerString("Fecha de caducidad:(yyyy-mm-dd)")));
			} catch (IllegalArgumentException e) {
				exito = true;
				System.out.println(e.getMessage());
			} catch (DateTimeParseException e) {
				exito = true;
				System.out.println("ERROR en formato (yyyy-mm-dd)");
			}
		} while (exito);
	}

	@Override
	public String toString() {
		return  super.toString() + "Perecedero [caducidad=" + caducidad + "]";
	}
	
	public void escribirFichero(DataOutputStream filtro) throws IOException {
		String fecha;
		super.escribirFichero(filtro);
		fecha = caducidad.toString();
		filtro.writeUTF(fecha);
	}

	public void leerFichero(DataInputStream filtro) throws IOException {
		String fecha;
		super.leerFichero(filtro);
		try {
			fecha = filtro.readUTF();
			setCaducidad(LocalDate.parse(fecha));
		} catch (IllegalArgumentException | DateTimeParseException e) {
			caducidad = LocalDate.now().plusDays(1);
		}
	}
	
	
	



	
	
	
	

}

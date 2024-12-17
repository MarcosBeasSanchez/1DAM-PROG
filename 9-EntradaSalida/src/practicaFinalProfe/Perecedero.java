package practicaFinalProfe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Perecedero extends Producto {
	private LocalDate fechaCaducidad;

	public Perecedero() {
		this("");
	}

	public Perecedero(String referencia, String nombre, float precio, int stock, LocalDate fechaCaducidad) {
		super(referencia, nombre, precio, stock);
		// TODO Auto-generated constructor stub
		setFechaCaducidad(fechaCaducidad);  
	}

	public Perecedero(String referencia) {
		this(referencia,"", 0, 0, LocalDate.now().plusDays(1));
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) throws IllegalArgumentException {
		if (fechaCaducidad == null || fechaCaducidad.isBefore(LocalDate.now()))
			throw new IllegalArgumentException("fecha no permitida");
		this.fechaCaducidad = fechaCaducidad;
	}

	public void leerOtrosDatos() {
		boolean valido;
		super.leerOtrosDatos();
		do {
			try {
				valido = true;
				setFechaCaducidad(LocalDate.parse(Teclado.leerString("\nfecha caducidad")));
			} catch (IllegalArgumentException | DateTimeParseException e) {
				valido = false;
				Pantalla.escribirString("\n" + e.getMessage());
			}
		} while (!valido);

	}

	@Override
	public float getPrecioVenta() {
		// TODO Auto-generated method stub
		int dias;
		float precioVenta = 0;

		dias = Period.between(fechaCaducidad, LocalDate.now()).getDays();

		if (dias > 5)
			precioVenta = getPrecio() * 2;
		else if (dias >= 3)
			precioVenta = getPrecio() * 1.5f;
		else if (dias > 0)
			precioVenta = getPrecio();

		return precioVenta;
	}

	@Override
	public String toString() {
		return "Perecedero [fechaCaducidad=" + fechaCaducidad + ", toString()=" + super.toString() + "]";
	}

	public void escribirFichero(DataOutputStream filtro) throws IOException {
		String fecha;
		super.escribirFichero(filtro);
		fecha = fechaCaducidad.toString();
		filtro.writeUTF(fecha);
	}

	public void leerFichero(DataInputStream filtro) throws IOException {
		String fecha;
		super.leerFichero(filtro);
		try {
			fecha = filtro.readUTF();
			setFechaCaducidad(LocalDate.parse(fecha));
		} catch (IllegalArgumentException | DateTimeParseException e) {
			fechaCaducidad = LocalDate.now().plusDays(1);
		}
	}
	
	public boolean estaCaducado ()
	{
		return getFechaCaducidad().isBefore(LocalDate.now());
	}

}

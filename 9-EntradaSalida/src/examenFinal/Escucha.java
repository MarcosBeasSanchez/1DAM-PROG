package examenFinal;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import daw.com.Teclado;

public class Escucha implements LeerDatos{
	
	private final static String SEPARADOR = ";";
	
	private String nifcliente,idMaterial;
	private LocalDateTime fechaHora;

	
	
	public Escucha(String nifcliente, String idMaterial, LocalDateTime fechaHora) {
		this.nifcliente = nifcliente;
		this.idMaterial = idMaterial;
		this.fechaHora = fechaHora;
	}

	public Escucha() {
		this("" ,"", LocalDateTime.now());
	}
	
	public Escucha(String nif,String id) {
		this.nifcliente = nif;
		this.idMaterial = id;
		this.fechaHora = LocalDateTime.now();
	}

	public String getNifcliente() {
		return nifcliente;
	}

	public void setNifcliente(String nifcliente) {
		if (nifcliente.equals("") || nifcliente == null) {
			throw new IllegalArgumentException("NIF no valido/null o vacio");
		}
		this.nifcliente = nifcliente;
	}

	public String getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(String idMaterial) {
		if (idMaterial.equals("") || idMaterial == null) {
			throw new IllegalArgumentException("ID no valido/null o vacio");
		}
		this.idMaterial = idMaterial;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(idMaterial, nifcliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Escucha other = (Escucha) obj;
		return Objects.equals(idMaterial, other.idMaterial) && Objects.equals(nifcliente, other.nifcliente);
	}

	@Override
	public void leerID() {
		boolean exito;
		do {
			try {
				exito = false;
				setNifcliente(Teclado.leerString("NIF del cliente"));
				setIdMaterial(Teclado.leerString("ID del material"));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				exito = true;
			}
		} while (exito);
		
	}

	@Override
	public void leerDatos() {
		this.fechaHora = LocalDateTime.now();
		
	}

	public void fromCsv(String csv) {
		
		String valores[] = csv.split(SEPARADOR);
		
		if (valores.length > 0) {
			try {
				nifcliente = valores[0];
				idMaterial = valores[1];
				setFechaHora(LocalDateTime.parse(valores[2]));
			} catch (DateTimeParseException e) {
				fechaHora = LocalDateTime.now();
			}
		}
	}
	
	public String toCsv () {
		
		String linea = "";
		
		linea += nifcliente;
		linea += SEPARADOR;
		linea += idMaterial;
		linea += SEPARADOR;
		linea += fechaHora;
		
		return linea;
	}
	
	

}

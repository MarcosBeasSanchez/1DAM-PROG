package examenFinal;

import java.util.Objects;

import daw.com.Teclado;

public class Cliente implements LeerDatos{
	
	private final static String SEPARADOR = ";";

	String nif,nombre;
	float cuota;
	
	public Cliente(String nif, String nombre, float cuota) {
		this.nif = nif;
		this.nombre = nombre;
		this.cuota = cuota;
	}
	
	public Cliente() {
		this("","",0);
	}
	
	public Cliente(String nif) {
		this.nif = nif;
		this.nombre = "";
		this.cuota= 0;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		if (nif == null) {
			throw new NullPointerException("El NIF no puede ser Null");
		}
		if (nif.equalsIgnoreCase("")) {
			throw new IllegalArgumentException("NIF vacio");
		}
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	@Override
	public String toString() {
		return "Cliente [nif=" + nif + ", nombre=" + nombre + ", cuota=" + cuota + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nif, other.nif);
	}

	@Override
	public void leerID() {
		boolean exito;
		do {
			try {
				exito = false;
				setNif(Teclado.leerString("Nif cliente"));
			} catch (NullPointerException | IllegalArgumentException e) {
				exito = true;
				System.out.println("\n " + e.getMessage());
			}
		} while (exito);
	}

	@Override
	public void leerDatos() {
		this.nombre = Teclado.leerString("Nombre Cliente");
		
	}

	public void fromCsv(String csv) {
		String valores[] = csv.split(SEPARADOR);
		
		if (valores.length > 0) {
			try {
				nif= valores[0];
				nombre = valores[1];
				cuota = Float.parseFloat(valores[2]);
			} catch (NullPointerException | NumberFormatException e) {
				System.out.println("Error null/formato erroneo, cambiando cuota a 0");
				cuota = 0;
			}
		}
	}
	
	public String toCsv() {
		String linea = "";
		
		linea += nif;
		linea += SEPARADOR;
		linea += nombre;
		linea += SEPARADOR;
		linea += cuota;
		
		System.out.println(linea);
		
		return linea;
		
	}

	

}

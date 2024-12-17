package excepciones;

import daw.com.Teclado;

public class BonoTransporte {
	// valores: Saldo y nombre
	private String nombre;
	private int saldo;

	public BonoTransporte(String nombre, int saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
	public BonoTransporte() {
		this.nombre = "";
		this.saldo = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws IllegalArgumentException{
		
		if (nombre.equals("") || nombre == null) {
			throw new IllegalArgumentException("Nombre vacio no permitido");
		}
		this.nombre = nombre;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) throws IllegalArgumentException {
		if (saldo < 0) {
			throw new IllegalArgumentException("Valor negativo no permitido");
		}
		this.saldo = saldo;
	}
	
	public void leerDatos() {
			setNombre(Teclado.leerString("Nombre del usuario"));
			setSaldo(Teclado.leerInt("Saldo del bono"));
	}

	@Override
	public String toString() {
		return "BonoTransporte [nombre=" + nombre + ", saldo=" + saldo + "]";
	}
	
	public void picarBono() throws RuntimeException {
	    if (saldo <= 0) {
	        throw new RuntimeException("\nEl bono no tiene saldo suficiente para ser picado");
	    } else {
	        this.saldo--;
	        System.out.println("Bono picado. Saldo restante: " + saldo);
	    }
	}

	
	public void recargarBono() {
		
		System.out.println("\nRecargando bono...");
		this.saldo++;
		System.out.println("Saldo: " + saldo + " viajes ");
	}
	
	
	
	
	
	
	

}

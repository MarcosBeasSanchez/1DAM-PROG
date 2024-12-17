package interfaces1ejer;

public class Profesor extends Persona implements Hablador {

	private String despacho;
	private String email;
	
	public Profesor(String nombre, int edad, String despacho, String email) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profesor() {
		this("Jesus", 35, "555-D", "jesus@gmail.com");
	}

	@Override
	public void hablar() {
		System.out.println("Soy un PROFESOR y se hablar.");

	}

	@Override
	public String toString() {
		return "Profesor " + super.toString()+ " [despacho=" + despacho + ", email=" + email + "]";
	}
	
	

}

package interfaces1ejer;

public class Bedel extends Persona implements Hablador {
	
	private String turno;
	private int antiguedad;

	public Bedel(String nombre, int edad, String turno, int antiguedad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	public Bedel() {
		this("Dani",40, "Tarde", 10);
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	@Override
	public void hablar() {
		// TODO Auto-generated method stub
		System.out.println("Soy un BEDEL y se hablar.");

	}

	@Override
	public String toString() {
		return "Bedel "+ super.toString()+ "[turno=" + turno + ", antiguedad=" + antiguedad + "]";
	}
	
	

}

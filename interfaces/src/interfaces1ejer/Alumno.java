package interfaces1ejer;

public class Alumno extends Persona implements Hablador {
	
	private String carrera;
	private int curso;

	public Alumno(String nombre, int edad , String carrera, int curso) {
		super(nombre, edad);
		
		this.carrera = carrera;
		this.curso = curso;
	}

	public Alumno() {
		this("Marta", 22, "Informatica" ,3);
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	@Override
	public void hablar() {
		System.out.println("Soy un ALUMNO y se hablar.");

	}

	@Override
	public String toString() {
		return "Alumno"+ super.toString() +"[carrera=" + carrera + ", curso=" + curso + "]";
	}


	
	

}

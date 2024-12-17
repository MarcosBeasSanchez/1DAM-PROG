package interfaces1ejer;

public class Ave {
	

	private boolean sexo;
	private int edad;

	public Ave(boolean sexo , int edad) {
		this.sexo=sexo;
		this.edad= edad;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Ave [sexo=" + sexo + ", edad=" + edad + "]";
	}

}

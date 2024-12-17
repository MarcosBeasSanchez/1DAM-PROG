package interfacesProbando;



public class Humano {
	private String raza;
	private int edad;
	private boolean varon;
	
	public Humano ()
	{
		this ("",0,true);
	}
	
	public Humano(String raza, int edad, boolean varon) {
		
		this.raza = raza;
		this.edad = edad;
		this.varon = varon;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isVaron() {
		return varon;
	}

	public void setVaron(boolean varon) {
		
		this.varon = varon;
	}

	@Override
	public String toString() {
		return "[raza=" + raza + ", edad=" + edad + ", varon=" + varon + "]";
	}
	
	

}

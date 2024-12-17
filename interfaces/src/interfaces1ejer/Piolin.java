package interfaces1ejer;

public class Piolin extends Ave implements Hablador {
	
	public String canta;
	public int nPeliculas;

	public Piolin(boolean sexo, int edad, String canta, int nPeliculas) {
		super(sexo, edad);
		this.canta = canta;
		this.nPeliculas = nPeliculas;
		}
	public Piolin() {
		this(true,6,"En la ducha",10);
	}
	

	public String getCanta() {
		return canta;
	}
	public void setCanta(String canta) {
		this.canta = canta;
	}
	public int getnPeliculas() {
		return nPeliculas;
	}
	public void setnPeliculas(int nPeliculas) {
		this.nPeliculas = nPeliculas;
	}
	@Override
	public void hablar() {
		System.out.println("Soy un PIOLIN y se hablar.");

	}
	@Override
	public String toString() {
		return "Piolin "+ super.toString()+"[canta=" + canta + ", nPeliculas=" + nPeliculas + "]";
	}
	

}

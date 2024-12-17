package interfaces1ejer;

public class Loro extends Ave implements Hablador{
	private String region;
	private String color;


	public Loro(boolean sexo, int edad, String region, String color) {
		super(sexo, edad);
		this.color=color;
		this.region= region;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Loro() {
		this(true,6,"Europa","Azul");
	}
	
	@Override
	public void hablar() {
		System.out.println("Soy un LORO y se hablar.");

	}

	@Override
	public String toString() {
		return "Loro "+ super.toString()+"[region=" + region + ", color=" + color + "]";
	}
	
	

}

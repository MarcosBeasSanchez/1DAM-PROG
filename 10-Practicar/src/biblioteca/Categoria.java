package biblioteca;

public enum Categoria {
	
	MENOR(0.50f),
	JOVEN(1),
	INTERMEDIO(1.50f),
	VETERANO(2);
	
	private final float value;
	
	Categoria(float d) {
		this.value = d;
	}

	public float getValue() {
		return value;
	}
	
}

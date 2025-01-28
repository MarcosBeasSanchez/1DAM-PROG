package ejercicio1ex;

public enum Tipo {
	
	COMEDIA (0f), TERROR(0.5f) , AVENTURA (0.75f), NOVELA (1f);
	
	private final float precio;

	Tipo(float precio) {
		this.precio = precio;
	}

	public float getPrecioTipo() {
		return precio;
	}
	
	public boolean comprobar(Tipo t) {
		
		boolean tipoValido= false;
		
		for (Tipo tipo : Tipo.values()) {
	        if (t == tipo) {
	            tipoValido = true;
	        }
		}
		return tipoValido;
		
	}

}

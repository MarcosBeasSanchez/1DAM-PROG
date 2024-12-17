package ejercicio1ex;

public enum Tipo {
	
	COMEDIA (0), TERROR(0.5f) , AVENTURA (0.75f), NOVELA (1);
	
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

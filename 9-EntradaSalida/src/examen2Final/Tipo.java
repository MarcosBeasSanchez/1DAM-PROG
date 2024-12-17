package examen2Final;

enum Tipo {
    LINEA(1),
    PUNTOS(0.50),
    LINEA_PUNTEADA(0.75);

	private final double value;

    Tipo(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
    
    public int cuantos(){
    	int c = 0;
    	
    	for (int i = 0; i < Tipo.values().length; i++) {
    		c++;
		}
    	
    	return c;
    	
    }
}
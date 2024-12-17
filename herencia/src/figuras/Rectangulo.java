package figuras;


import daw.com.Teclado;

public class Rectangulo extends Figura {
	
	private int base, altura;

	
	public Rectangulo(String nombre, int x, int y, 
			int color,float grosor, int base, int altura) {
		
		super (nombre, x, y, color,grosor);
		
		setBase (base);
		setAltura (altura);
	}

	public Rectangulo() {
		this ("", 0,0,0,0);
	}
	public Rectangulo(String nombre) {
		this (nombre, 0,0,0,0);
	}

	public Rectangulo(String nombre, int x, int y, int color, float grosor) {
		
		this (nombre, x,y,color,grosor, 0, 0);
	}

	public Rectangulo (Rectangulo original)
	{
		super (original);
		this.base = original.base;
		this.altura = original.altura;
	}
	
	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base <= 0 ? 1: base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura <= 0 ? 1 : altura;
	}
	
	@Override
	public String toString() {
		return "Rectangulo [base=" + base + 
				", altura=" + altura + 
				", toString()=" + super.toString() + "]";
	}

	public void leerDatos ()
	{

		super.leerDatos ();
		setBase (Teclado.leerInt("\nbase"));
		setAltura (Teclado.leerInt("\naltura"));
	}
	
	public float getPerimetro ()
	{
		return 2 *(base + altura);
	}

}
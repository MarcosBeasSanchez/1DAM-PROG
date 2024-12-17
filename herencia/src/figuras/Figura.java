package figuras;

import daw.com.Teclado;

public abstract class Figura {
	private String nombre;
	private int x, y, color;
	private float grosor;
	
	public Figura(String nombre, int x, int y, int color, float grosor) {
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		setColor (color);
		setGrosor (grosor);
	}
	
	public Figura(String nombre) {
		this (nombre, 0,0,0,0);
	}
	
	public Figura ()
	{
		this ("");
	}
	
	public Figura (Figura original)
	{
		this (original.nombre, original.x, original.y,original.color, original.grosor);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		if (color < 0)
			color = 0;
		else if (color > 255)
			color = 255;
		this.color = color;
	}
	public float getGrosor() {
		return grosor;
	}

	public void setGrosor(float grosor) {
		this.grosor = grosor < 0 ? 0 : grosor;
	}
	
	@Override
	public String toString() {
		return "Figura [nombre=" + nombre + ", x=" + x + ", y=" + y + ", color=" + color + ", grosor=" + grosor + "]";
	}
	
	public void leerDatos ()
	{
		nombre = Teclado.leerString("\nnombre");
		x = Teclado.leerInt("\nx");
		y = Teclado.leerInt("\ny");
		setColor (Teclado.leerInt("\ncolor"));
		setGrosor (Teclado.leerFloat("\ngrosor"));
		
	}

	public abstract float getPerimetro();
	

}
package figuras;

import daw.com.Teclado;

public class Triangulo extends Figura {
	private int lado1, lado2, lado3;


	public Triangulo(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
		lado1 = 0;
		lado2 = 0;
		lado3 = 0;
	}
	public Triangulo ()
	{
		this ("");
	}

	public Triangulo(String nombre, int x, int y, int color, float grosor, int lado1, int lado2, int lado3) {
		super(nombre, x, y, color, grosor);
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}

	public int getLado1() {
		return lado1;
	}

	public void setLado1(int lado1) {
		this.lado1 = lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public void setLado2(int lado2) {
		this.lado2 = lado2;
	}

	public int getLado3() {
		return lado3;
	}

	public void setLado3(int lado3) {
		this.lado3 = lado3;
	}

	@Override
	public String toString() {
		return "Triangulo [lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + ", toString()="
				+ super.toString() + "]";
	}
	
	public void leerDatos ()
	{
		super.leerDatos();
		setLado1(Teclado.leerInt("\nlado1"));
		setLado2(Teclado.leerInt("\nlado2"));
		setLado3(Teclado.leerInt("\nlado3"));
	}
	@Override
	public float getPerimetro() {
		// TODO Auto-generated method stub
		return lado1 + lado2 + lado3 ;
	}
	
}
package clasesyobjetos;

import daw.com.Pantalla;

//La peculiaridad de este ejer es que una clase que contiene dentro otra(Punto())

public class Rectangulo {
	//Estado
	private int alto;
	private int ancho;
	private Punto centro;

	//Constructores
	
	public Rectangulo() {
		alto = 1;
		ancho = 1 ;
		centro = new Punto();
	}
	public Rectangulo  ( int alto , int ancho) {
		setAlto(alto);
		setAncho(ancho);
		centro = new Punto();
	}
	
	public Rectangulo  ( int alto , int ancho , Punto centro) {
		setAlto(alto);
		setAncho(ancho);
		setCentro(centro);
	}
	public Rectangulo(Rectangulo original) { //Constructor copia
		this.alto = original.alto;
		this.ancho = original.ancho;
		this.centro = new Punto (original.centro);
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto < 1? 1:alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho < 1? 1:alto;
	}
	public Punto getCentro() {
		return new Punto(centro);
	}
	public void setCentro(Punto centro) { 
		this.centro = centro == null? new Punto() : new Punto(centro); 
		// Si centnro es null ,construye un Punto por defecto sino , hace un nuevo punto y pasa el centro
		
	}
	@Override
	public String toString() {
		return "Rectangulo [alto=" + alto + ", ancho=" + ancho + ", centro=" + centro + "]";
	}
	public void leerDatos() {
		alto = Libreria.leerEnteroPositivo("Alto = ");
		ancho = Libreria.leerEnteroPositivo("Ancho = ");
		centro.leerDatos();
	}
	public void mostrarDatos() {
		Pantalla.escribirInt("\nalto", alto);
		Pantalla.escribirInt("\nancho", ancho);
		centro.mostrarDatos();
	}
	public boolean equals (Rectangulo otro) {
		boolean iguales = false;
		
		if (otro != null) {
			if(this.alto == otro.alto && this.ancho == otro.ancho && this.centro.equals(otro.centro)) {
				iguales = true;
			}
		}
		return iguales;
	}
	public int getArea() {
		return ancho * alto;
	}
	public int getPerimetro() {
		return 2 *( ancho+alto);
	}
	public void llegarAlOrigen() {
		centro.setX(0);
		centro.setY(0);
	}
	public void moverHorizontal(int cuanto) {
		centro.setX(centro.getX() + cuanto); // mueve en horizontal lo que recibe en la VAR cuanto.
	}
	
	public void moverVertical(int cuanto) {
		centro.setY(centro.getY() + cuanto); // mueve en vertical lo que recibe en la VAR cuanto.
	}
	public void escalar (float cuanto) {
	if (cuanto > 0) {
		alto = (int)Math.ceil(alto * cuanto);
		ancho = (int)Math.ceil(ancho * cuanto);
		}
	}
	
	public boolean esCuadrado() {
		return alto == ancho;
		
	}
	public float getDistanciaAOrigen() {
		return centro.getDistancia();
	}
}

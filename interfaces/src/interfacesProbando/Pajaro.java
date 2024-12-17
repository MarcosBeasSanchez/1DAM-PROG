package interfacesProbando;

import daw.com.Pantalla;

public class Pajaro extends Animal implements Cantante {
	
	private String color;
	

	public Pajaro() {
		super();
		// TODO Auto-generated constructor stub
		color = "";
	}



	public Pajaro(String tipo, String continente, String color) {
		super(tipo, continente);
		// TODO Auto-generated constructor stub
		this.color = color;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}


	

	@Override
	public String toString() {
		return "Pajaro [color=" + color + "]" + super.toString();
	}

	@Override
	public void afinar (String frase)
	{
		Pantalla.escribirString("\nLos pajaros no afinamos\n");
	}
	
	@Override
	public void cantar() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\npiopiopiopiopio\n");

	}

}

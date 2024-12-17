package arraylist.garaje;

import daw.com.Pantalla;
import daw.com.Teclado;


public abstract class Vehiculo {
	private int potencia;
	private String matricula;
	
	
	public Vehiculo() {
		this ("");
	}
	
	public Vehiculo (String matricula)
	{
		this (1,matricula);
	}
	
	public Vehiculo(int potencia, String matricula) {
		setPotencia (potencia);
		this.matricula = matricula;
	}
	
	public Vehiculo (Vehiculo original)
	{
		this (original.potencia, original.matricula);
	}


	public int getPotencia() {
		return potencia;
	}


	public void setPotencia(int potencia) {
		if (potencia < 1)
			potencia = 1;
		this.potencia = potencia;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void leerDatos ()
	{
		leerClave();
		leerOtrosDatos ();
	}
	
	public void leerClave ()
	{
		matricula = Teclado.leerString("Matricula :");
	}
	public void leerOtrosDatos()
	{
		setPotencia (Teclado.leerInt("Potencia "));
	}
	
	public void mostrarDatos()
	{
		Pantalla.escribirString("--------------");
		Pantalla.escribirString("\nMatricula :"+ matricula);
		Pantalla.escribirInt("\nPotencia :", potencia);
		Pantalla.escribirFloat("\ncuota :", getCouta());
		
	}
	
	@Override
	public String toString() {
		return "Vehiculo [potencia=" + potencia + ", matricula=" + matricula + "]";
	}


	public abstract float getCouta();

	@Override
	public boolean equals(Object obj) {
		Pantalla.escribirString("\nestoy en el equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// lo quito para evitar problemas en la herencia
		// esto es una chapuza que tendremos que solucionar
		//if (getClass() != obj.getClass())
		//	return false;
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	
	
}
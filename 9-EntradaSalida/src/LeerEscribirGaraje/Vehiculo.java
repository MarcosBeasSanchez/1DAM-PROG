package LeerEscribirGaraje;


import daw.com.Pantalla;
import daw.com.Teclado;

public abstract class Vehiculo {
	private int potencia;
	private String matricula;
	private String propietario;
	
	
	
	public Vehiculo() {
		this(0,"","");
	}

	public Vehiculo (String matricula)
	{
		this (0,matricula,"");
	}
	
	public Vehiculo(int potencia, String matricula, String propietario) {
		
		this.potencia = potencia;
		this.matricula = matricula;
		this.propietario = propietario;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		if (potencia <= 0)
			throw new IllegalArgumentException("Potencia no permitida");
		this.potencia = potencia;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public void leerClave ()
	{
		matricula = Teclado.leerString("Matricula");
	}
	
	public void leerOtrosDatos()
	{
		boolean exito;
		
		do
		{
			try {
				exito = true;
				setPotencia(Teclado.leerInt("\nPotencia "));
			}catch (IllegalArgumentException e)
			{
				Pantalla.escribirString("\n" + e.getMessage());
				exito = false;
			}
		}while (!exito);
		
		propietario = Teclado.leerString("propietario");
	}
	
	public void leerDatos ()
	{
		leerClave();
		leerOtrosDatos();
	}
	
	public void mostrarDatos()
	{
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString(matricula);
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString(propietario);
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirInt(potencia);
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirFloat("couta", getCouta());
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	

	@Override
	public String toString() {
		return "Vehiculo [potencia=" + potencia + ", matricula=" + matricula + ", propietario=" + propietario + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	public abstract float getCouta ();
	

	public String toCSV ()
	{
		String resultado = "";
		
		resultado += matricula;
		resultado += ",";
		resultado += propietario;
		resultado += ",";
		resultado += potencia;
		resultado += ",";
		
		return resultado;
	}
	
	public void fromCSV (String linea)
	{
		String lineaSobrante = "";
		String[] valores = linea.split(",");
		
		matricula = valores[0];
		propietario = valores[1];
		try
		{
			setPotencia (Integer.parseInt(valores[2]));
		}catch (IllegalArgumentException e)
		{
			potencia = 50; // valor por defecto
		}
		
	}
}

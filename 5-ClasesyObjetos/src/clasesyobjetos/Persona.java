package clasesyobjetos;
import daw.com.Teclado;
import daw.com.Pantalla;

public class Persona {
	public final static boolean HOMBRE = false;
	public final static boolean MUJER = true;
	
	public final static int SOBREPESO = 1;
	public final static int PESOIDEAL = 0;
	public final static int BAJOPESO = -1;
	
	// Estado de la clase
	final private String dni;
	private int edad;
	private String nombre;
	private boolean sexo;
	private float peso;
	private float altura;
	
	// constructores
	public Persona () // Constructor por defecto
	{
		this (0,"","H");
		
	}

	public Persona(int edad, String nombre, String sexo) 
	{
		this (edad,nombre,sexo,0,0);	
	}
	
	
	public Persona(int edad, String nombre, String sexo, float peso, float altura) {
		
		dni  = Persona.generarDNI();
		setEdad (edad);
		this.nombre = nombre;
		setSexo (sexo);
		setPeso (peso);
		setAltura (altura);
	}
	
	// constructor copia
	public Persona (Persona original)
	{
		dni  = original.dni;
		edad = original.edad;
		nombre = original.nombre;
		sexo = original.sexo;
		peso = original.peso;
		altura = original.altura;
		
	}
	

	private static String calcularLetra(int numero) {
		// TODO Auto-generated method stub
		final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		String letra;
		
		letra = letras.substring(numero%23,(numero%23)+1);
		
		return letra;
	}

	private static String generarDNI() {
		// TODO Auto-generated method stub
		String miDni="";
		int intDNI = Libreria.generarAleatorio(0, 99999999);
		
		
		miDni = intDNI+Persona.calcularLetra(intDNI);
		// Poner ceros a la izquierda
		
		for (int i = miDni.length();  i < 9; i++)
			miDni = "0" +miDni;
		
		//miDni = "000000000".substring(miDni.length()) + miDni;
		
		return miDni;
	}
	
	// Selectores y modificadores
	public String getSexo ()
	{
		return sexo== MUJER?"M":"H";
	}
	
	public void setSexo (String sexo)
	{
		//this.sexo = !sexo.equalsIgnoreCase("H");
		
		if (sexo.equalsIgnoreCase("H"))
			this.sexo = HOMBRE;
		else
			this.sexo = MUJER;
	}
	
	public String getDni() {
		return dni;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		if (edad < 0)
			edad = 0;
		
		this.edad = edad;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}



	public float getPeso() {
		return peso;
	}



	public void setPeso(float peso) {
		if (peso < 0)
			peso = 0;
		
		this.peso = peso;
	}



	public float getAltura() {
		return altura;
	}



	public void setAltura(float altura) {
		if (altura < 0)
			altura = 0;
		
		this.altura = altura;
	}

	
	// Otras funciones
	public String toString() {
		return "Persona [dni=" + dni + 
					", edad=" + edad + 
					", nombre=" + nombre + 
					", sexo=" + getSexo() + 
					", peso=" + peso + 
					", altura=" + altura + "]";
	}
	
	public int calcularIMC ()
	{
		float imc;
		int pesoIdeal  = SOBREPESO;
		
		
		imc = peso /(altura * altura);
		
		if (imc < 20)
			pesoIdeal = BAJOPESO;
		else if (imc < 26)
			pesoIdeal = PESOIDEAL;
		
		return pesoIdeal;
	}
	
	public boolean esMayorDeEdad()
	{
		return edad >= 18;
	}
	
	public void leerDatos ()
	{
		
		setEdad  (Teclado.leerInt("edad "));
		nombre = Teclado.leerString("nombre ");
		setSexo(Teclado.leerString(" Sexo (H/M)"));
		setPeso (Teclado.leerFloat("peso en kilos "));
		setAltura (Teclado.leerFloat("altura en metros"));
	}
	
	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + toString());
	}
	
	public boolean equals (Persona otra)
	{
		return this.dni.equalsIgnoreCase(otra.dni);
	}

}



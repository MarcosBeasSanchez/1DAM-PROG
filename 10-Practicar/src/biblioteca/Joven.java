package biblioteca;

import java.util.List;

import daw.com.Teclado;

public class Joven extends Persona implements LeerDatos {
	private final static String SEPARADOR = ";";
	private final static float VALOR = 10;
	
	private boolean carnetEstudiante;

	public Joven() { // Por defecto
		super();
		this.carnetEstudiante= false;
	}

	public Joven(String nif, String nombre, int edad, float cuota,float presupuesto, Categoria cat, List<Libro> libros,boolean carnetEsudiante) {
		super(nif, nombre, edad,cuota, presupuesto, cat, libros);
		this.carnetEstudiante = carnetEsudiante;
	}
	
	public Joven(String nif) {
		super(nif);
		this.carnetEstudiante = false;
	}
	

	public boolean isCarnetEstudiante() {
		return carnetEstudiante;
	}

	public void setCarnetEstudiante(boolean carnetEstudiante) {
		this.carnetEstudiante = carnetEstudiante;
	}

	@Override
	public float calcular() {
		float total;

		if (carnetEstudiante == false) {
			total = cuota * getCategoria().getValue();
		}else {
			total = (cuota * getCategoria().getValue()) + VALOR;
		}
		return total;
	}

	@Override
	public String toString() {
		return  super.toString() + " Joven [carnetEstudiante=" + carnetEstudiante + "]";
	}

	@Override
	public void leerSoloDatos() {
		super.leerSoloDatos();
		
		String respuesta = Teclado.leerString("Carnet estudiante? T/F").toUpperCase();
		if (respuesta.equalsIgnoreCase("T")) {
			setCarnetEstudiante(true);
		}  else if (respuesta.equalsIgnoreCase("F")){
			setCarnetEstudiante(false);
		}else {
			System.out.println("Respuesta INVALIDA : por defecto No tiene");
		}
		
	}

	@Override
	public String toCsv() {
		String linea= "";
		linea += nif;
		linea += SEPARADOR;
		linea += nombre;
		linea += SEPARADOR;
		linea += edad;
		linea += SEPARADOR;
		linea += presupuesto;
		linea += SEPARADOR;
		linea += cuota;
		linea += SEPARADOR;
		linea += categoria;
		linea += SEPARADOR;
		linea += libros.size();
		linea += SEPARADOR;
		
		for (Libro libro : libros) {
			linea += libro.toCsv();
		}
		
		linea += carnetEstudiante;
		linea += SEPARADOR;
		
		System.out.println(linea);
		
		return linea;
	}

	@Override
	protected void fromCsv(String[] valores) {
		nif = valores[1];
		nombre = valores[2];
		edad = Integer.parseInt(valores[3]);
		presupuesto = Float.parseFloat(valores[4]);
		cuota = Float.parseFloat(valores[5]);
		categoria = Categoria.valueOf(valores[6]);
		int cuantos = Integer.parseInt(valores[7]);
		for (int i = 0; i < cuantos; i++) {
			Libro libro = new Libro();
			libro.fromCsv(valores);
			libros.add(libro);
		}
		carnetEstudiante = Boolean.parseBoolean(valores[8]);
		
	}
	


	

}

package biblioteca;

import java.util.List;

import daw.com.Teclado;

public class Veterano extends Persona implements LeerDatos {
	private final float descuento = 0.80f; // 20 porciento de descuento
	private final static String SEPARADOR = ";";
	
	private String gustosLectura;

	public Veterano() {
		super();
		this.gustosLectura ="Sin especificar";
		
	}
	
	public Veterano(String nif) {
		super(nif);
		this.gustosLectura ="Sin especificar";
		
	}

	@Override
	public void leerSoloDatos() {
		super.leerSoloDatos();
		setGustosLectura(Teclado.leerString("gustos de lecutra?"));
	}



	public String getGustosLectura() {
		return gustosLectura;
	}

	public void setGustosLectura(String gustosLectura) {
		this.gustosLectura = gustosLectura;
	}

	public Veterano(String nif, String nombre, int edad,float cuota, float presupuesto, Categoria cat, List<Libro> libros , boolean residencia, String gustosLectura) {
		super(nif, nombre, edad,cuota, presupuesto, cat, libros);
		this.gustosLectura = gustosLectura;
	}

	@Override
	public float calcular() {
		float categoriaValue = getCategoria().getValue();
		
		return (cuota * categoriaValue) * descuento;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Veterano [descuento=" + descuento + ", gustosLectura=" + gustosLectura + "]";
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
		
		linea += gustosLectura;
		linea += SEPARADOR;
		
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
	    
	    int nLibros = Integer.parseInt(valores[7]);
		for (int i = 0; i < nLibros; i++) {
			Libro libro = new Libro();
			libro.fromCsv(valores);
			libros.add(libro);
		}
		
		gustosLectura = valores[7];
		
	    
		
	}
	
	
	
	
	
	

}

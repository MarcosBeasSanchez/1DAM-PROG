package clasesyobjetos;

import java.util.Arrays;

import daw.com.Teclado;

public class Libro {

	//Estado de la clase
	private String ISBN ;
	private String titulo;
	private String autores[];
	private int paginas;
	
	//Constructores
	//Defecto

	
	public Libro() {
		ISBN = generarISBN(0,9999999999999L);
		titulo = "";
		autores = new String[]{"Anonimo"};
		paginas = 20;
	}

	public Libro (String title, String[]autores , int paginas) {
		ISBN = generarISBN(0,9999999999999L);
		setTitulo(title);
		nAutores(autores.length);
		setPaginas(paginas);
	}
	
	public Libro (String original) { // copia
		//this (original.ISBN , )
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if (titulo == null) {
			titulo = "";
		}
		this.titulo = titulo;
	}
	public String[] getAutores() {
		return autores;
	}
	public void setAutores() {
		
		// Eliminar autores repetidos
				for (int i = 0; i < autores.length; i++) {
		            for (int j = i + 1; j < autores.length; j++) {
		                if (autores[i].equalsIgnoreCase(autores[j])) {
		                    autores[j] = "";
		                }
		            }
		        }	
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		if (paginas < 20) {
			paginas = 20;
		}
		this.paginas = paginas;
	}
	public static String generarISBN (int inicio, long fin)
	{
		long valor;
		String isbn="";
		valor =(long) (Math.random()*(fin + 1 - inicio)) + inicio;
		
		isbn += valor;
		
		return isbn;
	}
	
	public void leerDatos() {

		setTitulo(Teclado.leerString(" Titulo libro = "));
		nAutores( Teclado.leerInt("Nº autores = "));
		setPaginas(Teclado.leerInt("Nº de paginas =  "));
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", autores=" + Arrays.toString(autores) + ", paginas="
				+ paginas + "]";
	}
	
	public void nAutores (int respuesta) {
		
		if (respuesta <= 0) {
			respuesta = 1;
		}
		
		//Crear el array de autores
		autores = new String[respuesta];
		
		//Pedir nombres de los autores
		for ( int i = 0; i < respuesta ; i++) {
			autores[i] =  Teclado.leerString("Autor " + (i + 1) + " = ");
			if (autores[i].equalsIgnoreCase("")) {
				autores[i]= "Anonimo";
			}	
		}
		setAutores();
	}
	
}

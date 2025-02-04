package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import daw.com.Teclado;

public class Libro implements LeerDatos{
	private final static String SEPARADOR = ";";

	private String isbn;
	private String nLibro;
	private List<String>autores;

	public Libro(String nLibro, String isbn, List<String> autores) {
		this.nLibro = nLibro;
		this.isbn = isbn;
		this.autores = autores;
	}
	
	public Libro(String isbn) {
		this.nLibro = "";
		this.isbn = isbn;
		this.autores = new ArrayList<>();
	}
	
	public Libro() {
		this.nLibro = "";
		this.isbn = "";
		this.autores = new ArrayList<>();
	}

	
	public String getnLibro() {
		return nLibro;
	}

	public void setnLibro(String nLibro) {
		this.nLibro = nLibro;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	
	public void deleteAutor( String aut) {
		
		autores.remove(aut);
	}
	@Override
	public void leerID() {
		do {
			 try {
				setIsbn(Teclado.leerString("ISBN del libro:"));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (isbn == null || isbn.equalsIgnoreCase(""));
		
	}

	@Override
	public void leerDatos() {
		boolean exito;
		int cuantos;
		String autor;
		do {
			exito = false;
			try {
				setnLibro(Teclado.leerString("Nombre del libro"));
				cuantos = Teclado.leerInt("Cuantos autores tiene este libro? ");
				for (int i = 0; i < cuantos; i++) {
					autor = Teclado.leerString("Autor " + (i+ 1));
					if (!autores.contains(autor)) {
						autores.add(autor);
					}else {
						System.out.println("autor " + autor + " repetido");
					}
				}				
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				exito = true;
			}
			
		} while (exito);
		
	}

	public boolean existeLibro(String id) {
		boolean res = false;
		if (isbn == id) {
			res = true;
		}
		return res;
	}
	
	@Override
	public String toString() {
		return "Libro [nLibro=" + nLibro + ", isbn=" + isbn + ", autores=" + autores + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(autores, isbn, nLibro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autores, other.autores) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(nLibro, other.nLibro);
	}

	
	public String toCsv() {
		String linea= "";
		
		linea += isbn;
		linea += SEPARADOR;
		linea += nLibro;
		linea += SEPARADOR;
		linea += autores.size();
		linea += SEPARADOR;
		
		for (String aut : autores) {
			linea += aut;
			linea += SEPARADOR;
		}
		
		return linea;
	}

	public void fromCsv(String[] valores) {
		isbn = valores[8];
		nLibro = valores[9];
		int cuantos = Integer.parseInt(valores[10]);
		for (int i = 0; i < cuantos; i++) {
			autores.add(valores[11]);
		}
		
		
	}



	

}

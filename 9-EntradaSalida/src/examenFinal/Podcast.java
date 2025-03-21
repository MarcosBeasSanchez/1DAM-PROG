package examenFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;

public class Podcast extends Material implements LeerDatos {

	int nCapitulo;
	List<String>idiomas;
	
	public Podcast(String id, String nombre, LocalDate fechaEstreno, Categoria categoria, int nCapitulo,
			List<String> idiomas) {
		super(id, nombre, fechaEstreno, categoria);
		this.nCapitulo = nCapitulo;
		this.idiomas = idiomas;
	}

	public Podcast() {
		super();
		this.nCapitulo = 0;
		this.idiomas = new ArrayList<String>();
	}
	
	public Podcast(String id) {
		super(id);
		this.nCapitulo = 0;
		this.idiomas = new ArrayList<String>();

	}

	public int getnCapitulo() {
		return nCapitulo;
	}

	public void setnCapitulo(int nCapitulo) {
		if (nCapitulo < 0) {
			throw new IllegalArgumentException("capitulo < 0 no valido");
		}
		this.nCapitulo = nCapitulo;
	}

	public List<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<String> idiomas) {
		this.idiomas = idiomas;
	}
	
	public void añadirIdioma(String idioma) {
		idiomas.add(idioma);
	}

	@Override
	public void leerSoloDatos() {
		boolean exito;
		int cuantos;
		super.leerSoloDatos();
		do {
			try {
				exito = false;
				setnCapitulo(Teclado.leerInt("Capitulo nº?"));
				cuantos = Teclado.leerInt("¿Cuantos idiomas quieres introducir? ");
				for (int i = 0; i < cuantos; i++) {
					añadirIdioma(Teclado.leerString("Idioma" + i));
				}
				
			} catch (IllegalArgumentException e) {
				exito = true;
				System.out.println(e.getMessage());
			}
		} while (exito);	
	}
	

	public void leerFichero(DataInputStream entrada) throws IOException{
		super.leerFichero(entrada);
		nCapitulo = entrada.readInt(); //numero de capitulo
		
		int nIdiomas = entrada.readInt();
		
		if (nIdiomas > 0) {
			for (int i = 0; i < nIdiomas; i++) {
				String idioma = entrada.readUTF();
				idiomas.add(idioma);
			}
		}
	}
	
	public void escribirFichero(DataOutputStream salida) throws IOException{
		super.escribirFichero(salida);
		salida.writeInt(nCapitulo); // numero de capitulo
		salida.writeInt(idiomas.size()); //numero de Idiomas
		for (String i : idiomas) { //cada idioma
			salida.writeUTF(i);
		}

	}
	
	public void addIdioma(String idioma) {
		if (!idiomas.contains(idioma)) {
			idiomas.add(idioma);
		}	
	}

	@Override
	public String getTipo() {
		return "PODCAST";
	}

	@Override
	public String toString() {
		return super.toString() + "Podcast [nCapitulo=" + nCapitulo + ", idiomas=" + idiomas + "]";
	}
	
	


	
	

}

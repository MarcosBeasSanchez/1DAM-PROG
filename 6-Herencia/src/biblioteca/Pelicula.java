package biblioteca;

import daw.com.Teclado;

/**
 * La clase Pelicula representa una película que forma parte del inventario de una biblioteca.
 * Extiende de la clase Material, heredando sus atributos y métodos.
 */
public class Pelicula extends Material {

    /** El director de la película. */
    private String director;
    
    /** El resumen de la película. */
    private String resumen;

    /**
     * Constructor que inicializa un objeto Pelicula con un código, un título, un director,
     * un resumen y un bibliotecario asignado.
     * @param codigo El código de la película.
     * @param titulo El título de la película.
     * @param director El director de la película.
     * @param resumen El resumen de la película.
     * @param bibliotecario El bibliotecario responsable de la película.
     */
    public Pelicula(String codigo, String titulo, String director, String resumen, Bibliotecario bibliotecario) {
        super(codigo, titulo, bibliotecario);
        setDirector(director);
        setResumen(resumen);
    }
    
    /**
     * Constructor que inicializa un objeto Pelicula sin especificar código ni título,
     * asignando valores predeterminados para el director y el resumen,
     * y sin asignar un bibliotecario.
     */
    public Pelicula() {
        super();
        this.director = "";
        this.resumen = "";
    }

    /**
     * Obtiene el director de la película.
     * @return El director de la película.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Establece el director de la película.
     * @param director El nuevo director de la película.
     * @throws IllegalArgumentException
     */
    public void setDirector(String director) throws IllegalArgumentException {
    	if (director == null) {
            throw new IllegalArgumentException("El director no puede ser nulo");
       }
        this.director = director;
    }

    /**
     * Obtiene el resumen de la película.
     * @return El resumen de la película.
     */
    public String getResumen() {
        return resumen;
    }

    /**
     * Establece el resumen de la película.
     * @param resumen El nuevo resumen de la película.
     * @throws IllegalArgumentException
     */
    public void setResumen(String resumen) throws IllegalArgumentException {
    	if (resumen == null) {
            throw new IllegalArgumentException("El resumen no puede ser nulo");
       }
        this.resumen = resumen;
    }
    /**
     * Lee los correspondientes datos de la clase Pelicula
     */
    @Override
	public void leerDatos() {
		super.leerDatosMaterial();
		setDirector(Teclado.leerString("Discografía"));
		setResumen(Teclado.leerString("Resumen"));
		
	}
}
	
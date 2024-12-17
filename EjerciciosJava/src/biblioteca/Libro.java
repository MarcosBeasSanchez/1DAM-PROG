package biblioteca;

import daw.com.Teclado;

/**
 * La clase Libro representa un libro que forma parte del inventario de una biblioteca.
 * Extiende de la clase Material, heredando sus atributos y métodos.
 */
public class Libro extends Material {
    
    /** El número de páginas del libro. */
    private int paginas;
    
    /** El autor del libro. */
    private String autor;
    
    /** El género del libro. */
    private Genero genero;

    /**
     * Constructor que inicializa un objeto Libro con un código, un título, un número de páginas,
     * un autor, un género y un bibliotecario asignado.
     * @param codigo El código del libro.
     * @param titulo El título del libro.
     * @param paginas El número de páginas del libro.
     * @param autor El autor del libro.
     * @param genero El género del libro.
     * @param bibliotecario El bibliotecario responsable del libro.
     */
    public Libro(String codigo, String titulo, int paginas, String autor, Genero genero, Bibliotecario bibliotecario) {
        super(codigo, titulo, bibliotecario);
        setPaginas(paginas);
        setAutor(autor);
        setGenero(genero);
    }
    
    /**
     * Constructor que inicializa un objeto Libro sin especificar código ni título,
     * asignando valores predeterminados para el autor y el género(TERROR),
     * y sin asignar un bibliotecario.
     */
    public Libro() {
        super();
        this.autor= "";
        this.genero = Genero.TERROR;
    }

    /**
     * Obtiene el número de páginas del libro.
     * @return El número de páginas.
     */
    public int getPaginas() {
        return paginas;
    }

    /**
     * Establece el número de páginas del libro.
     * @param paginas El nuevo número de páginas.
     * @throws IllegalArgumentException
     */
    public void setPaginas(int paginas)throws IllegalArgumentException {
    	if(paginas <= 0)
    		throw new IllegalArgumentException("numero de paginas tiene que ser mayor a 0");
        this.paginas = paginas;
    }

    /**
     * Obtiene el autor del libro.
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     * @param autor El nuevo autor del libro.
     * @throws IllegalArgumentException
     */
    public void setAutor(String autor) throws IllegalArgumentException {
    	if (autor == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo");
        }
        this.autor = autor;
    }

    /**
     * Obtiene el género del libro.
     * @return El género del libro.
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece el género del libro.
     * @param genero El nuevo género del libro.
     * @throws IllegalArgumentException
     */
    public void setGenero(Genero genero) throws IllegalArgumentException {    	
    	 if (genero == null) {
             throw new IllegalArgumentException("El género no puede ser nulo");
         }
         if (!genero.generoValido()) {
             throw new IllegalArgumentException("El género proporcionado no es válido");
         }
         this.genero = genero;
    }
    
    /**
     * Lee los correspondientes datos de la clase Libro
     */
    @Override
	public void leerDatos() {
		super.leerDatosMaterial();
		setPaginas(Teclado.leerInt("Nº Páginas"));
		setAutor(Teclado.leerString("Autor"));
		
		System.out.println(genero.toString());
		String opc =  Teclado.leerString("Genero").toUpperCase();
		setGenero(Genero.valueOf(opc));
		
	}
}

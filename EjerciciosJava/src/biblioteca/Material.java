package biblioteca;

import daw.com.Teclado;

/**
 * La clase Material es una clase abstracta que representa un material presente en una biblioteca.
 * Contiene información básica como código, título y bibliotecario responsable.
 * Esta clase sirve como base para otros tipos específicos de materiales.
 */
public abstract class Material {
    
    /** El código del material. */
    private String codigo;
    
    /** El título del material. */
    private String titulo;
    
    /** El bibliotecario responsable del material. */
    private Bibliotecario bibliotecario;

    /**
     * Constructor que inicializa un objeto Material con un código, un título y un bibliotecario asignado.
     * @param codigo El código del material.
     * @param titulo El título del material.
     * @param bibliotecario El bibliotecario responsable del material.
     */
    public Material(String codigo, String titulo, Bibliotecario bibliotecario) {
        super();
        setCodigo(codigo);
        setTitulo(titulo);
        this.bibliotecario = bibliotecario;
    }
    
    /**
     * Constructor que inicializa un objeto Material sin especificar código ni título,
     * asignando un bibliotecario predeterminado.
     */
    public Material() {
        super();
        this.codigo = "";
        this.titulo = "";
        this.bibliotecario = new Bibliotecario();
    }

    /**
     * Obtiene el código del material.
     * @return El código del material.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del material.
     * @param codigo El nuevo código del material.
     * @throws IllegalArgumentException
     */
    public void setCodigo(String codigo) {
        if (codigo == null) {
            throw new IllegalArgumentException("El código no puede ser nulo");
        }
        this.codigo = codigo;
    }


    /**
     * Obtiene el título del material.
     * @return El título del material.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del material.
     * @param titulo El nuevo título del material.
     */
    public void setTitulo(String titulo) {
    	 if (titulo == null) {
             throw new IllegalArgumentException("El titulo no puede ser nulo");
        }
    	 this.titulo = titulo;
    }
    

    /**
     * Obtiene el bibliotecario responsable del material.
     * @return El bibliotecario responsable del material.
     */
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    /**
     * Establece el bibliotecario responsable del material.
     * @param bibliotecario El nuevo bibliotecario responsable del material.
     */
    public void leerDatosMaterial() {
    	setCodigo(Teclado.leerString("Código"));
    	setTitulo(Teclado.leerString("Título"));
    }
    /**
     * Lee los correspondientes datos de cada Material
     */
    public abstract void leerDatos();
}


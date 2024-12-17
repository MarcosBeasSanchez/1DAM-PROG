package biblioteca;

import daw.com.Teclado;

/**
 * La clase Disco representa un disco que forma parte del inventario de una biblioteca.
 * Extiende de la clase Material, heredando sus atributos y métodos.
 */
public class Disco extends Material {
    
    /** La discográfica asociada al disco. */
    private String discografica;

    /**
     * Constructor que inicializa un objeto Disco con un código, un título, una discográfica y un bibliotecario asignado.
     * @param codigo El código del disco.
     * @param titulo El título del disco.
     * @param discografica El nombre de la discográfica asociada al disco.
     * @param bibliotecario El bibliotecario responsable del disco.
     */
    public Disco(String codigo, String titulo, String discografica, Bibliotecario bibliotecario) {
        super(codigo, titulo, bibliotecario);
        setDiscografica(discografica);
    }
    
    /**
     * Constructor que inicializa un objeto Disco sin especificar código, título ni discográfica,
     * y sin asignar un bibliotecario.
     */
    public Disco() {
        super();
        this.discografica = "";
    }

    /**
     * Obtiene el nombre de la discográfica asociada al disco.
     * @return El nombre de la discográfica.
     */
    public String getDiscografica() {
        return discografica;
    }

    /**
     * Establece el nombre de la discográfica asociada al disco.
     * @param discografica El nuevo nombre de la discográfica.
     * @throws IllegalArgumentException
     */
    public void setDiscografica(String discografica) throws IllegalArgumentException{
        this.discografica = discografica;
    }
    
    /**
     * Lee los correspondientes datos de la clase Disco
     */
	@Override
	public void leerDatos() {
		super.leerDatosMaterial();
		setDiscografica(Teclado.leerString("dicografica"));
		
	}
}

package biblioteca;

/**
 * La clase Bibliotecario representa a un bibliotecario que trabaja en una biblioteca.
 * Extiende de la clase Persona, heredando sus atributos y métodos.
 */
public class Bibliotecario extends Persona {

    /** El salario del bibliotecario. */
    private float salario;
    
    /**
     * Constructor que inicializa un objeto Bibliotecario con un nombre, un DNI y un salario predeterminado.
     * @param nombre El nombre del bibliotecario.
     * @param dni El DNI del bibliotecario.
     */
    public Bibliotecario(String nombre, String dni) {
        super(nombre, dni);
        this.salario = 20000;
    }
    
    /**
     * Constructor que inicializa un objeto Bibliotecario sin especificar nombre ni DNI,
     * asignando un salario predeterminado.
     */
    public Bibliotecario() {
        super();
        this.salario = 20000;
    }

    /**
     * Obtiene el salario del bibliotecario.
     * @return El salario del bibliotecario.
     */
    public float getSalario() {
        return salario;
    }

    /**
     * Establece el salario del bibliotecario.
     * @param salario El nuevo salario del bibliotecario.
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }
}


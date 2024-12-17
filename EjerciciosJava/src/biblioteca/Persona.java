package biblioteca;

/**
 * La clase Persona representa a una persona que puede interactuar con la biblioteca.
 * Puede ser un usuario, un bibliotecario, etc.
 */
public class Persona {

    /** El nombre de la persona. */
    private String nombre;
    
    /** El número de DNI de la persona. */
    private String dni;

    /**
     * Constructor que inicializa un objeto Persona con un nombre y un número de DNI.
     * @param nombre El nombre de la persona.
     * @param dni El número de DNI de la persona.
     */
    public Persona(String nombre, String dni) {
        super();
        setNombre(nombre);
        setDni(dni);
    }
    
    /**
     * Constructor que inicializa un objeto Persona sin especificar nombre ni DNI.
     * Se asignan valores predeterminados para ambos.
     */
    public Persona() {
        this.nombre = "";
        this.dni = "";
    }

    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el número de DNI de la persona.
     * @return El número de DNI de la persona.
     */
    public String getDni() {
        return dni;
    }

	public void setNombre(String nombre) throws IllegalArgumentException {
		if (nombre == null) {
            throw new IllegalArgumentException("El NOMBRE no puede ser nulo");
       }
		this.nombre = nombre;
	}

	public void setDni(String dni) throws IllegalArgumentException {
		if (dni == null) {
            throw new IllegalArgumentException("El DNI no puede ser nulo");
       }
		this.dni = dni;
	}
}

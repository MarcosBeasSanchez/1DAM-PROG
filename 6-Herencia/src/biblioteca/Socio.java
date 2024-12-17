package biblioteca;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa a un socio de la biblioteca.
 */
public class Socio extends Persona {

    private static int GENERADOR_NUMEROS = 0;
    private int numeroSocio = 0;
    private Set<Prestamo> prestamos;

    /**
     * Constructor que inicializa un socio con nombre, DNI y un conjunto de préstamos.
     *
     * @param nombre   Nombre del socio.
     * @param dni      DNI del socio.
     * @param prestamos Conjunto de préstamos del socio.
     */
    public Socio(String nombre, String dni, Set<Prestamo> prestamos) {
        super(nombre, dni);
        Socio.GENERADOR_NUMEROS++;
        this.numeroSocio = Socio.GENERADOR_NUMEROS;
        this.prestamos = prestamos != null ? prestamos : new HashSet<>();
    }

    /**
     * Constructor que inicializa un socio sin nombre ni DNI.
     */
    public Socio() {
        super();
        Socio.GENERADOR_NUMEROS++;
        this.numeroSocio = Socio.GENERADOR_NUMEROS;
        this.prestamos = new HashSet<>();
    }

    /**
     * Obtiene el número de socio.
     *
     * @return Número de socio.
     */
    public int getNumeroSocio() {
        return numeroSocio;
    }

    /**
     * Obtiene los préstamos del socio.
     *
     * @return Conjunto de préstamos del socio.
     */
    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Obtiene el número de préstamos del socio.
     *
     * @return Número de préstamos del socio.
     */
    public int getNumeroPrestamos() {
        return prestamos.size();
    }

    /**
     * Establece los préstamos del socio.
     *
     * @param prestamos Conjunto de préstamos del socio.
     */
    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Establece el número de socio.
     *
     * @param numeroSocio Número de socio.
     */
    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    /**
     * Añade un préstamo al socio.
     *
     * @param prestamo Préstamo a añadir.
     */
    public void addPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
}


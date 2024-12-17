package biblioteca;

import java.time.LocalDate;

/**
 * Clase que representa un préstamo de material en una biblioteca.
 */
public class Prestamo {

    /** Fecha de inicio del préstamo. */
    private LocalDate inicio;

    /** Fecha de fin del préstamo. */
    private LocalDate fin;

    /** Material prestado. */
    private Material material;

    /**
     * Constructor de la clase Prestamo.
     *
     * @param inicio   Fecha de inicio del préstamo.
     * @param fin      Fecha de fin del préstamo.
     * @param material Material prestado.
     */
    public Prestamo(LocalDate inicio, LocalDate fin, Material material) {
       setInicio(inicio);
       setFin(fin);
       this.material = material;
    }

    /**
     * Obtiene la fecha de inicio del préstamo.
     *
     * @return Fecha de inicio del préstamo.
     */
    public LocalDate getInicio() {
        return inicio;
    }

    /**
     * Obtiene la fecha de fin del préstamo.
     *
     * @return Fecha de fin del préstamo.
     */
    public LocalDate getFin() {
        return fin;
    }
    /**
     * Obtiene el material prestado
     *
     * @return El material prestado
     */
	public Material getMaterial() {
		return material;
	}
	
	/**
     * Establece la fecha de inicio del préstamo.
     * 
     * @param inicio Fecha de inicio del préstamo.
     * @throws IllegalArgumentException Si la fecha de inicio es nula.
     */
    public void setInicio(LocalDate inicio)throws IllegalArgumentException {
        if (inicio == null) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser nula");
        }
        this.inicio = inicio;
    }

    /**
     * Establece la fecha de fin del préstamo.
     * 
     * @param fin Fecha de fin del préstamo.
     * @throws IllegalArgumentException Si la fecha de inicio es posterior a la fecha de fin.
     */
    public void setFin(LocalDate fin) throws IllegalArgumentException{
        if (inicio.isAfter(fin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser después de la fecha de fin");
        }
        this.fin = fin;
    }
}

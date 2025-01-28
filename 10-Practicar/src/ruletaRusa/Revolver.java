package ruletaRusa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Revolver {

	private static final int CAP_TAMBOR = 6; // Capacidad máxima del tambor

    private List<Integer> tambor;
    private int posicionActual;

    public Revolver() {
        this(1); // Por defecto, cargamos una bala
    }

    public Revolver(int numeroBalas) {
        if (numeroBalas < 1 || numeroBalas > CAP_TAMBOR) {
            throw new IllegalArgumentException("El número de balas debe estar entre 1 y " + CAP_TAMBOR + ".");
        }

        this.tambor = new ArrayList<>(CAP_TAMBOR);
        this.posicionActual = 0;

        // Inicializa el tambor con todas las posiciones vacías (0)
        for (int i = 0; i < CAP_TAMBOR; i++) {
            tambor.add(0);
        }

        // Coloca las balas en posiciones aleatorias
        Random rand = new Random();
        int balasCargadas = 0;
        while (balasCargadas < numeroBalas) {
            int posicionBala = rand.nextInt(CAP_TAMBOR); // Genera una posición aleatoria
            if (tambor.get(posicionBala) == 0) { // Si la posición está vacía
                tambor.set(posicionBala, 1); // Coloca una bala
                balasCargadas++;
            }
        }
    }

    public boolean disparar() {
        // Comprueba si hay bala en la posición actual
        boolean balaDisparada = tambor.get(posicionActual) == 1;

        // Mueve el tambor a la siguiente posición
        posicionActual = (posicionActual + 1) % CAP_TAMBOR;

        return balaDisparada;
    }

    public void girarTambor() {
        // Coloca el tambor en una posición aleatoria
        Random rand = new Random();
        posicionActual = rand.nextInt(CAP_TAMBOR);
        
    }
    
    public List<Integer> getTambor() {
		return tambor;
	}

	public void setTambor(List<Integer> tambor) {
		this.tambor = tambor;
	}

	public int getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(int posicionActual) {
		this.posicionActual = posicionActual;
	}

	public  int getCapTambor() {
		return CAP_TAMBOR;
	}

	@Override
	public String toString() {
		return "Revolver [tambor= " + tambor + "]";
	}


}

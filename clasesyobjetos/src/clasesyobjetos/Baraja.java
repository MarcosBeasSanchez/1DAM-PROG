package clasesyobjetos;


public class Baraja {
	
	// Estado
	private Carta[] cartas;
    private Carta[] monton;
    private int cartasEnBaraja = 40;
    private int cartasEnMonton = 0;

    public Baraja() {
    	cartas = new Carta[40];
    	monton = new Carta [40];
    	inicializarBaraja();
    }
    
    public void barajar() {
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));

            // Intercambiar cartas[i] y cartas[j]
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
            }
        }
    

	public void inicializarBaraja() {
		String[] palos = {"espadas", "bastos", "oros", "copas"};
        int ncartas = 0;
        for (String palo : palos) {
            for (int numero = 1; numero <= 12; numero++) {
                if (numero != 8 && numero != 9) {
                    cartas[ncartas++] = new Carta(numero, palo);
                }
            } 
        }
	}
	
	public Carta siguienteCarta() {
        if (cartasEnBaraja == 0) {
            System.out.println("No hay más cartas en la baraja.");
            return null;
        }
        Carta carta = cartas[--cartasEnBaraja]; // Da la siguienta carta de la baraja
        monton[cartasEnMonton++] = carta; // añade una carta al monton y le pasa el valor de la carta.
        return carta; // devuelve la sieguiente carta
    }
	

	
	public Carta[] darCartas (int cuantas)
	{
		Carta aDevolver[] = null;

		if (cuantas <= cartasDisponibles())
		{
			aDevolver = new Carta[cuantas];
			for (int i = 0; i < cuantas; i++)
				aDevolver[i] = siguienteCarta();
		}

		return aDevolver;
	}
		
	public int cartasDisponibles ()
	{
		return cartas.length - cartasEnMonton;
	}
	
	public void cartasEnMonton() {
		if (cartasEnMonton <= 0) {
			System.out.println("No hay cartas que mostar");
		}
		System.out.println("Cartas en el montón: ");
		for (int i = 0; i < cartasEnMonton; i++) {
			System.out.println(monton[i]);
			
		}
	}
	
	public void cartasEnBaraja() {
		if (cartasEnBaraja == 0) {
			System.out.println("No quedan cartas en la baraja");
		}
		System.out.println("Cartas en la baraja:");
		for (Carta carta : cartas) {
            System.out.println(carta);
        }
		
	}
}



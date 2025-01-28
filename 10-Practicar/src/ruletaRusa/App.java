package ruletaRusa;

import daw.com.Teclado;

public class App {
    private final static String LINEA = "------------------------";
    Revolver revolver;
    Jugador jugador1;
    Jugador jugador2;
    Moneda moneda = new Moneda();

    public static void main(String[] args) {
        App app = new App();
        app.iniciarJugadores();
        app.cargarTambor();
        app.girarTambor();
        app.jugar();
    }

    private void jugar() {
        System.out.println("\n[Se tirará una moneda al aire para ver quién empieza...]");
        System.out.println("\n	(Jugador1: Cara |||| Jugador2: Cruz)");

        Jugador jugadorActual = jugador1;
        int opc;
        boolean exito= false;;
        do {
        	if (moneda.tirarMoneda()) {
                System.out.println("\n	El resultado es: " + moneda);
                opc = Teclado.leerInt("\nJugador 1 : " + jugador1.getNombre() + "\n1.Comienzas tu? \n2.Comienza Jugador 2?");
                if (opc == 1 || opc== 2) {
                	if (opc == 1) {
                		 System.out.println("\nComienza el Jugador 1 | Nombre: " + jugador1.getNombre());
                         jugadorActual = jugador1;
					} else {
						System.out.println("\nComienza el Jugador 2 | Nombre: " + jugador2.getNombre());
                        jugadorActual = jugador2;
					}
    			}else {
    				System.out.println("Numero no válido");
    			}
               
            } else {
            	System.out.println("\n	El resultado es: " + moneda);
                opc = Teclado.leerInt("\nJugador 2 : " + jugador2.getNombre() + "\n1.Comienzas tu? \n2.Comienza Jugador 1?");
                if (opc == 1 || opc== 2) {
                	if (opc == 1) {
                		 System.out.println("\nComienza el Jugador 2 | Nombre: " + jugador2.getNombre());
                         jugadorActual = jugador2;
					} else {
						System.out.println("\nComienza el Jugador 1 | Nombre: " + jugador1.getNombre());
                        jugadorActual = jugador1;
					}
    			}else {
    				System.out.println("Numero no válido");
    			}
            }
		} while (exito);
        
        System.out.println("\n" + LINEA);

       
        for (int i = 0; i < revolver.getCapTambor(); i++) {
            System.out.println("\nTurno de " + jugadorActual.getNombre());
            boolean disparo = revolver.disparar();

            if (disparo) {
                System.out.println("¡BANG! " + jugadorActual.getNombre() + ", te volaste los sesos jajaja");
                break;
            } else {
                System.out.println("Clic... Nada ocurrió.");
            }

            // Cambiar al siguiente jugador
            jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
        }
    }

    private void iniciarJugadores() {
        String jugador;
        jugador = Teclado.leerString("Nombre Jugador N1: ");
        jugador1 = new Jugador(jugador);
        jugador = Teclado.leerString("Nombre Jugador N2: ");
        jugador2 = new Jugador(jugador);
    }

    private void girarTambor() {
        revolver.girarTambor();
    }

	private void cargarTambor() {
		int numeroBalas = 1;
		boolean exito = false;
		do {
			try {
				numeroBalas = Teclado.leerInt("¿Cuántas balas metemos al Revolver (MAX 6)?");
				if (numeroBalas < 1 || numeroBalas > 6) {
					throw new IllegalArgumentException("El número de balas debe estar entre 1 y 6.");
				}
				exito = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (!exito);

		revolver = new Revolver(numeroBalas);
	}
}

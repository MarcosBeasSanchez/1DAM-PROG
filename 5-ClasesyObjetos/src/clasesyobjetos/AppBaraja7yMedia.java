package clasesyobjetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppBaraja7yMedia {

	public static final int MAXIMOCARTAS = 14;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cuantos;
		Carta jugada[][];
		float puntosJugada[];
		int ganador;
		Baraja baraja;
		
		// inicializar juego
		cuantos = Libreria.leerEnteroPositivo("cuantos jugadores");
		
		jugada = new Carta[cuantos][MAXIMOCARTAS];
		puntosJugada = new float[cuantos];
		
		baraja = new Baraja ();
		baraja.barajar();
		
		for (int i = 0; i < jugada.length; i++)
			for(int j = 0; j < jugada[i].length; j++)
				jugada[i][j] = null; // no hay carta
		
		for (int i = 0; i < puntosJugada.length; i++)
			puntosJugada[i] = 0; // empezamos con 0 puntos
		
		// Comienza la partida
		for (int i = 0; i < jugada.length; i++)
		{
			// Para cada jugador le pedimos sus cartas
			jugada[i] = pedirCartas (baraja);
			puntosJugada[i] = calcularPuntos(jugada[i]);
		}
		
		// Buscar ganador
		ganador = buscarGanador (puntosJugada);
		
		// Mostrar quien es el ganador
		Pantalla.escribirString("\nEl ganador es " + ganador);
		
		// Mostrar todas las cartas de todos los jugadores
		for (Carta cartas[] : jugada) // para cada final
		{
			Pantalla.escribirString("\nCartas del jugador");
			for (Carta c:cartas) // para cada columna de la fila
			{
				if (c!= null)
					c.mostrarDatos();
			}
		}
		/*
		for (int i = 0; i < jugada.length; i++)
			for(int j = 0; j < jugada[i].length; j++)
				if (jugada[i][j]!= null)
					jugada[i][j].mostrarDatos();
		*/
		
	}
	private static int buscarGanador(float[] puntosJugada) {
		// TODO Auto-generated method stub
		int ganador = 0;
		
		for (int i = 1; i < puntosJugada.length; i++)
			if (puntosJugada[i]> puntosJugada[ganador])
				ganador = i;
		
		return ganador;
	}
	private static float calcularPuntos(Carta[] cartas) {
		// TODO Auto-generated method stub
		float total = 0;
		for (int i = 0; i < cartas.length; i++)
		{
			if (cartas[i] != null)
			{
				if (cartas[i].getNumCarta() < 8)
					total += cartas[i].getNumCarta();
				else
					total += 0.5f;
			}
		}
			
		total = total > 7.5f ? -1:total;
		
		return total;
	}
	private static Carta[] pedirCartas(Baraja baraja) {
		// TODO Auto-generated method stub
		Carta cartasJugador[];
		int indice = 0;
		
		cartasJugador = new Carta[MAXIMOCARTAS];
		
		do
		{
			cartasJugador[indice] = baraja.siguienteCarta();
			cartasJugador[indice].mostrarDatos();
			indice++;
		}while (calcularPuntos(cartasJugador) != -1 &&
				Teclado.leerString("mÃ¡s cartas?(s/n)").equalsIgnoreCase("s")&&
				indice < MAXIMOCARTAS);
		
		
		return cartasJugador;
	}

}
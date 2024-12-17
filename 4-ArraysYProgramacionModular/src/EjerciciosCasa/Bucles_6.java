package EjerciciosCasa;

public class Bucles_6 {

	public static void main(String[] args) {
		//Realizar un programa que imprima 25 términos de la serie 11 – 22 – 33…

        int valorInicial = 11;

        for (int i = 0; i < 25; i++) {
            System.out.print(valorInicial+ " ");
            valorInicial += 11;
        }	
    }
}

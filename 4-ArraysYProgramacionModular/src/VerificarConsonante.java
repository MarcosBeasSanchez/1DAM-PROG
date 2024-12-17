import daw.com.Teclado;

public class VerificarConsonante {

    public static void main(String[] args) {
        String frase;
        int contadorConsonantes = 0;

        // 1. LEER UNA FRASE
        frase = Teclado.leerString("Dime una frase, y te indicaré el número de consonantes que contiene");

        // 2. PASAR FRASE A MINÚSCULAS
        frase = frase.toLowerCase();

        // 3. INDICAR QUE ES UNA CONSONANTE E IMPRIMIR RESULTADO
        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);

            // Verificar si la letra es diferente de las vocales
            if (letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
                System.out.println(letra + " es consonante.");
                contadorConsonantes++;
            } else {
                System.out.println(letra + " es vocal.");
            }
        }

        // 4. MOSTRAR EL NÚMERO DE CONSONANTES
        System.out.println("La frase tiene " + contadorConsonantes + " consonantes.");
    }
}

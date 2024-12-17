package EjerciciosCasa;
import daw.com.Teclado;

public class Condicionales_11 {

	public static void main(String[] args) {
		// Realizar un programa que iongrese 4 notas, mueste el promedioo de esas notas e indicar si esta aprobado o no.
		
		//definir datos
		float n1=0,n2=0,n3=0,n4=0, media;
		
		
		//leer datos
		n1 = Teclado.leerFloat("Dame tus notas de examen");
		n2 = Teclado.leerFloat("Dame tus notas de examen");
		n3 = Teclado.leerFloat("Dame tus notas de examen");
		n4 = Teclado.leerFloat("Dame tus notas de examen");
		
		
		//hayar formula de la media
		
		media=(n1+n2+n3+n4)/4;
		
		// indicar si aprueba o supsende, (hay un error a la hora  de poner 4,4,5,4 pone que aprueba)
		
		if(media>=5) {
			System.out.println("Has Aprobado");
		}else{
			System.out.println("Has Suspendido");
		}
			
		
		
	

	}
	

}

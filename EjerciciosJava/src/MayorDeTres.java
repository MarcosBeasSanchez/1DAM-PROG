import daw.com.Pantalla;
import daw.com.Teclado;

public class MayorDeTres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1, n2, n3, mayor;
		
		// leer nÃºmeros
		n1 = Teclado.leerInt("n1 = ");
		n2 = Teclado.leerInt("n2 = ");
		n3 = Teclado.leerInt("n3 = ");
		
		// buscar el mayor
		mayor = n1;
		if (n2 > mayor)
			mayor = n2;
		
		if (n3 > mayor)
			mayor = n3;
		
		// escribir el mayor
		Pantalla.escribirInt("el mayor es ", mayor);
		
		

	}

}
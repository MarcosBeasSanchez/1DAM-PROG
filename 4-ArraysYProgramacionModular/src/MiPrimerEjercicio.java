import daw.com.Pantalla;
import daw.com.Teclado;

public class MiPrimerEjercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int edad, sueldo;
		String nombre;
		float altura;
		
		
		// leer del teclado
		// leer sueldo
		sueldo = Teclado.leerInt("dime tu sueldo ");
		// leer edad
		edad = Teclado.leerInt("dime tu edad ");
		// leer el nombre 
		nombre = Teclado.leerString("dime tu nombre ");
		// leer altura
		altura = Teclado.leerFloat("dame tu altura ");
		
		// Mostrar por pantalla
		// Escribir nombre
		Pantalla.escribirString("tu nombre es ", nombre);
		Pantalla.escribirSaltoLinea();
		// Escribir edad
		Pantalla.escribirInt("tu edad es ", edad);
		// Escribir altura
		Pantalla.escribirFloat("tu altura es ", altura);
		// Escribir sueldo
		Pantalla.escribirInt(sueldo);
		
		
		
		

	}

}
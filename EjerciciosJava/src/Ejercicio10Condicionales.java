import daw.com.Pantalla;
import daw.com.Teclado;

public class Ejercicio10Condicionales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	final int SUELDOBASE = 40000;
	int anios;
	float sueldo;
	
	
	anios = Teclado.leerInt("cuantos años llevas en la empresa");	
	
	if (anios > 10)
		sueldo = SUELDOBASE * 1.1f;
	else if (anios > 5)
		sueldo = SUELDOBASE * 1.07f;
	else if (anios > 3)
		sueldo = SUELDOBASE * 1.05f;
	else  
		sueldo = SUELDOBASE * 1.03f;
	
	Pantalla.escribirFloat("tu sueldo es", sueldo);
	
	
	
	}
	
	
	
	
	
	}



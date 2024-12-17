import daw.com.Pantalla;
import daw.com.Teclado;

public class EjerciciosJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String opcion;
		float lado1=0 ,lado2=0 ,lado3=0 ;
		float perimetro;
		
		Pantalla.escribirString("Equilatero");
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("Isosceles");
		Pantalla.escribirSaltoLinea();
		Pantalla.escribirString("Escaleno");
		Pantalla.escribirSaltoLinea();
		
		opcion = Teclado.leerString("\nelija una opcion");
		
		switch(opcion)
		{
		case"Equilatero":
		lado1 = Teclado.leerFloat("lado triángulo");
		lado2 = lado1;
		lado3= lado1;
		break;
		case "Isosceles":
		lado1 = Teclado.leerFloat("lado igual");
		lado2 = lado1;
		lado3= Teclado.leerFloat("lado desigual");
		break;
		case "Escaleno":
		lado1 = Teclado.leerFloat("lado 1");
		lado2 = Teclado.leerFloat("lado 2");
		lado3= Teclado.leerFloat("lado 3");
		break;
		default:
			Pantalla.escribirString("error...");
		} 
		
		perimetro = lado1 + lado2+ lado3;
		
		Pantalla.escribirString("el perimetro es " + perimetro);
		
	}

}

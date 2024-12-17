package figuras;

import daw.com.Pantalla;

public class AppFiguras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r,r2;
		Circulo c;
		Figura f1,f2;
		
		
		r = new Rectangulo ();
		c = new Circulo ();
		
		r.leerDatos();
		c.leerDatos();
		
		r2 = new Rectangulo (r);
	
		// El padre representa a cualquiera de los hijos
		f1 = r;
		f2 = c;
			
		if (f1.getX() == f2.getX() &&
				f1.getY() == f2.getY())
			Pantalla.escribirString("\nson concentricos");
		else 
			Pantalla.escribirString("\nNO son concentricos");
	}

}
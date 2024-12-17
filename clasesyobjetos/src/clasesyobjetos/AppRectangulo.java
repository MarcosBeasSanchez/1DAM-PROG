package clasesyobjetos;

import daw.com.Pantalla;

public class AppRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangulo r1, r2;
		Punto p;
		
		r1= new Rectangulo();
		r2= new Rectangulo(4,6);
		
		r1.escalar(3);
		r2.moverHorizontal(-3); // hacia la izquierda por ser negativo;
		r1.moverVertical(4);
		
		r1.mostrarDatos();
		r2.mostrarDatos();
		
		if (r1.getCentro().equals(r2.getCentro())) {
			Pantalla.escribirString("\n SI son concentricos");
		}else {
			Pantalla.escribirString("\n NO son concentricos");
		}
		
		if (r1.getCentro().getY() < r2.getCentro().getY()) {
			System.out.println("R2 es tiene tiene un eje Y mas alto");	
		}else {
			System.out.println("R1 es tiene tiene un eje Y mas alto");	

		}
		// No funciona x que se cambia el nombre al constructor copia
		r2.getCentro().setNombre("Punto 2");
		
		// Si funciona se cambia nombre al original
		p = r1.getCentro();
		p.setNombre("punto 1");
		r1.setCentro(p);
		
		
		}
}

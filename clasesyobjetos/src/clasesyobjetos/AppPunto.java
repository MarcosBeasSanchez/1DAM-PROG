package clasesyobjetos;

import daw.com.Pantalla;


public class AppPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Punto p1, p2, p3;
		float mayor;
			
		
		// construir
		p1 = new Punto (3,2, "p1");
		p2 = new Punto ();
		p3 = new Punto ("p3");
		
		p2.leerDatos();
		
		
		mayor = p1.getDistancia();
		
		if (p2.getDistancia() > mayor )
			mayor = p2.getDistancia();
		
		if (p3.getDistancia() > mayor )
			mayor = p3.getDistancia();
		
		Pantalla.escribirFloat("La mayor distancia es ", mayor);
		
		p1.mostrarDatos();
	}

}

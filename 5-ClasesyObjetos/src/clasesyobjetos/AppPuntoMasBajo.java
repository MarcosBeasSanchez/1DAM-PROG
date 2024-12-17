package clasesyobjetos;

public class AppPuntoMasBajo {

	public static void main(String[] args) {

		Punto p1, p2,p3, masBajo;
		
		// creamos los puntos
		p1 = new Punto ();
		p2 = new Punto ();
		p3 = new Punto ();
		
		// leer los puntos
		p1.leerDatos();
		p2.leerDatos();
		p3.leerDatos();
		
		// buscar mas bajo
		masBajo = new Punto(p1);
		
		// miramos si alguno es mas bajo que el mas bajo
		if (p2.getY() < masBajo.getY()) 
			masBajo =  new Punto(p2);
		// miramos si alguno es mas bajo que el mas bajo
		if (p3.getY() < masBajo.getY())
			masBajo = new Punto(p3);
		
		//mostramos los datos
		masBajo.mostrarDatos();
		
		
	}

}
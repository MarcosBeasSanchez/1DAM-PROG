package clasesyobjetos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class Punto {
	// Estado de la clase
		private int x;
		private int y;
		private String nombre;
		
		// Funciones de la clase
		// Constructores
		// Constructor por defecto
		public Punto ()
		{
			x = 0;
			y = 0;
			nombre = "";
		}
		
		// Constructor con todos los parametros
		public Punto (int horizontal, int vertical, String name)
		{
			x = horizontal;
			y = vertical;
			setNombre(name);
		}
		
		public Punto (String name)
		{
			x = 0;
			y = 0;
			setNombre(name);
		}
		
		// Constructor copia
		public Punto (Punto original)
		{
			x = original.x;
			y = original.y;
			nombre = original.nombre;
		}
		
		// Selectores y modificadores
		public int getX ()
		{
			return x;
		}
		
		public void setX (int horizontal)
		{
			x = horizontal;
		}
		
		public int getY ()
		{
			return y;
		}
		public void setY (int vertical)
		{
			y = vertical;
		}
		
		public String getNombre ()
		{
			return nombre;
		}
		public void setNombre (String name)
		{
			if (name == null)
				name = "";
			
			nombre = name;
		}
		
		public boolean esOrigen ()
		{
			boolean esta = false;
			
			if ( x == 0 && y == 0)
				esta = true;
			
			return esta;
		}
		
		public float getDistancia  ()
		{
			float distancia;
			
			distancia = (float) Math.sqrt((x*x) + (y*y));
			
			return distancia;
		}
	
		public void leerDatos ()
		{
			x = Teclado.leerInt("x = ");
			y = Teclado.leerInt("y = ");
			setNombre (Teclado.leerString("nombre ="));
		}
		
		public void mostrarDatos ()
		{
			Pantalla.escribirInt("x = ", x);
			Pantalla.escribirInt("y = ", y);
			Pantalla.escribirString("nombre = ", nombre);
		}

		@Override
		public String toString() {
			return "Punto [x=" + x + ", y=" + y + ", nombre=" + nombre + "]";
		}
		

	}

package clasesyobjetos;

public class AppRectanguloArray {

	public static void main(String[] args) {
		// Pedir n rectangulo al ususario, buscar rectangulo mas bajo(centro), mostrar por pantalla 
		// los rectangulos concentricos con el punto mas bajo y moverlos al origen de coordenadas.
		
			Rectangulo r[];
			int masBajo;
			
			r = cargarRectangulos ();
			
			masBajo = 0;
			for (int i = 1; i < r.length; i++)
				if (r[i].getCentro().getY() < r[masBajo].getCentro().getY())
					masBajo = i;
			
			r[masBajo].mostrarDatos(); // muestra el mas bajo de todos segun su eje Y
			
			moverAlOrigen (r, masBajo);
			
			for (Rectangulo rec : r)  // muestra datos de tosos los rectangulos
				rec.mostrarDatos();

		}

		private static void moverAlOrigen(Rectangulo[] r, int masBajo) {
			// mueve al punto de coordenadas 0.
			
			for (int i = 0; i < r.length; i++){
				if (i != masBajo){
					if (r[i].getCentro().equals(r[masBajo].getCentro())){
						r[i].llegarAlOrigen();
					}
				}
			}
			
		}

		public static Rectangulo[] cargarRectangulos() {
			// Inicializar Rectangulos y pedir datos
			Rectangulo r[];
			int cuantos;
			
			cuantos = Libreria.leerEnteroPositivo("cuantos?");
			r = new Rectangulo[cuantos];
			
			for (int i = 0; i < r.length; i++)
			{
				r[i] = new Rectangulo ();
				r[i].leerDatos();
			}
			
			return r;
		}

	}
import daw.com.Pantalla;
import daw.com.Teclado;

public class LeerPunto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y;
		float distancia;
		
		do
		{
			x = Teclado.leerInt("x=");
			y = Teclado.leerInt("y=");
		}while (x == 0 && y == 0); 
		
		distancia =(float) Math.sqrt((x*x) + (y*y));
		
		Pantalla.escribirString("(" + x + "," + y +")->" + distancia);

	}

}
package practicaFinalProfe;

import java.lang.reflect.InvocationTargetException;

public class FactoriaProducto {
	public static Producto build (String tipo) throws IllegalArgumentException
	{
		Producto p;
		
		switch (tipo)
		{
			case "Perecedero" :
				p = new Perecedero ();
				break;
			case "NoPerecedero":
				p = new NoPerecedero ();
				break;
			default:
				throw new IllegalArgumentException("tipo de producto no permitido");
		}
				
		return p;
	}
	

	public static Producto build2 (String tipo) throws IllegalArgumentException
	{
		Producto p;
		

			try {
				p = (Producto) Class.forName(tipo).
							getDeclaredConstructor().
							newInstance();
				
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				throw new IllegalArgumentException("tipo de producto no permitido");
			}

	
				
		return p;
	}

}

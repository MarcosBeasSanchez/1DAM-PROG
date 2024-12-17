package excepcionesEjemplo;

import daw.com.Pantalla;
import daw.com.Teclado;


public class Ejer1 {
	
	public static void main (String args[])
	{
		double a,b,c,res;
		
		a = Teclado.leerFloat();
		b = Teclado.leerFloat();
		c = Teclado.leerFloat();
		try{
		res = F(a,b,c);
		
		Pantalla.escribirFloat("\nresultado : ", (float)res);
		}
		
		catch (LogaritmoCeroException e)
		{
			Pantalla.escribirString("\n"+ e.getTexto());
		}
		catch (Exception e)
		{
			Pantalla.escribirString("\n"+ e.getMessage());
		}

	}
	
	public static double F (double a, double b, double c) throws LogaritmoCeroException, Exception
	{
		double res = 0;
		

			if (c == 0)
				throw new Exception ("Division por cero");
			
			if (b <= 0)
				throw new LogaritmoCeroException (b);
			
			if ((a - Math.log(b)/c) < 0)
				throw new Exception ("Raiz negativa");
			
			res = Math.sqrt(a - Math.log(b)/c);
		
		
		
		
		return res;
	}

}

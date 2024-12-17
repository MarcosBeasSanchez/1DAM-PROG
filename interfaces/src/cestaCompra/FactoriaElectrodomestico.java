package cestaCompra;

public class FactoriaElectrodomestico {
	
	public static Electrodomestico crearElectrodomestico (int tipo)
	{
		Electrodomestico e;
		
		if (tipo == 1)
			e = new Lavadora ();
		else 
			e = new Televisor ();
		
		return e;
	}

}
import daw.com.Pantalla;

public class Ejer2Tema3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nTrabajadores, tarifa, horas;
		int sueldoNeto, sueldoBruto, impuestos;
		
		nTrabajadores = Libreria.leerEnteroPositivo("nÂº trabajadores");
		tarifa = Libreria.leerEnteroPositivo("tarifa ordinaria");
		
		for (int i = 0; i < nTrabajadores; i++)
		{
			horas = Libreria.leerEnteroPositivo("horas trabajadas");
			sueldoBruto = calcularBruto (horas, tarifa);
			impuestos = calcularImpuestos (sueldoBruto);
			sueldoNeto = sueldoBruto - impuestos;
			Pantalla.escribirString("sueldo neto " + sueldoNeto);
		}

	}

	public static int calcularImpuestos(int sueldoBruto) {
		// TODO Auto-generated method stub
		int impuestos;
		
		if (sueldoBruto > 90000)
			impuestos = (int) (10000 + ((sueldoBruto - 90000)*.45));
		else if (sueldoBruto > 50000)
			impuestos = (int) ((sueldoBruto-50000) * .25 );
		else
			impuestos = 0;
		
		return impuestos;
	}

	public static int calcularBruto(int horas, int tarifa) {
		// TODO Auto-generated method stub
		int sueldo;
		
		sueldo = horas * tarifa;
		
		if (horas > 38)
			sueldo += (horas - 38) * tarifa * .5;
		
		return sueldo;
	}

}
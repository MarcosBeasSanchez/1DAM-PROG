package practicaFinal;

public class Prueba {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto p = new NoPerecedero();
		
		p.leerDatos();
		
		System.out.println(p.getPrecioVenta());
	}

}

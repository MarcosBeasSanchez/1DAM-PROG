package excepciones;

public class LanzarExcepciones {

	public static void main(String[] args) {

		int a,b;
		float c;
		
		a = teclado
		b= teclado.
		
		try {
			c = dividir(a,b);
			System.out.println("\n resultado" + c);
		}catch(IllegalArgumentException e){
			System.out.println();
		}
		
		
		
	}
	private static float dividir(int a , int b) throws IllegalArgumentException{
		float resultado;
		
		if (b== 0) {
			throw new IllegalArgumentException("No se permite divisores cero");
		}
		
		resultado = a/b;
		return resultado;
	}

}

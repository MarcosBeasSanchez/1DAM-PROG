package javapowersolutions;

import daw.com.Teclado;

public class LeerDigitosComoString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String m;
		
		m = Teclado.leerString();
		
		// leer solo di­gitos
		System.out.println(m.matches("[0-9]*")); //Del 0 al 9
	}

}
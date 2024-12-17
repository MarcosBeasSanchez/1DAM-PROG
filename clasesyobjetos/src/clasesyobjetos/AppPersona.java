package clasesyobjetos;

import daw.com.Pantalla;

public class AppPersona {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona[] personas;
		String mensaje;
		
		// Crear el array
		personas = new Persona[3];
		
		// Crear los objetos
		personas[0] = new Persona();
		personas[1] = new Persona(12, "Ana",  "M");
		personas[2] = new Persona (34, "Miguel", "H", 56, 1.67f);

		personas[0].setNombre("Antonio");
		personas[0].setEdad(23);
		personas[0].setSexo("H");
		personas[0].setPeso(75);
		personas[0].setAltura(1.70f);
		
		//personas[0].mostrarDatos();
		
		
		// Comprobar que estan en su peso ideal
		for (Persona p : personas) // for each
		{
			if (p.calcularIMC() == Persona.BAJOPESO)
				mensaje = "bajo de peso";
			else if (p.calcularIMC() == Persona.PESOIDEAL)
					mensaje = "peso ideal";
				else
					mensaje = "sobrepeso";

			Pantalla.escribirString("\n" + p.getNombre() +  " " + mensaje);
		}
		
		for (Persona p : personas)
		{
			if (p.esMayorDeEdad())
				mensaje = "es mayor de edad";
			else
				mensaje = "no es mayor de edad";
			
			Pantalla.escribirString("\n" + p.getNombre() +  " " + mensaje);
		}
		
		for (Persona p: personas)
			Pantalla.escribirString("\n" + p);
		
	}

}
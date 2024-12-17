package clasesyobjetos;
import daw.com.Pantalla;
import video.Direccion;

public class AppTeatros {

	public static void main(String[] args) {
		//Crear un conjunto de funciones de teatro: max 10, (max 4 por teatro)
		//debe tenerse presente que no se puede repertir 2 funciones iguales si tienen el mismo nombre , 
		//Crear  2 teatros y asignar las funciones de teatro que se representan
		//Indicar  cual es la funcion mas cara que se esta representando en un teatro, y en que teatro se representa.
		
		Teatro teatros[]; // varios teatros
		Funcion funciones[]; // varias funciones en varios teatros
		int nTeatros, nFunciones;
		Direccion direccion; 
		Funcion masCara;
		
		nTeatros = Libreria.leerEnteroPositivo("\nNº de teatros");
		nFunciones = Libreria.leerEnteroPositivo("\nNº de funciones");

		teatros = new Teatro[nTeatros];
		funciones = new Funcion[nFunciones];
		
		leerFunciones (funciones);
		leerTeatros (teatros, funciones);
		
		for (Teatro t: teatros) // muestra todos los teatros
			t.mostrarDatos(); 
		
		// Si se cambia algo en una funcion 
		// se cambia en todos los teatros
		funciones[3].setNombre("cambiada");
		funciones[3].setPrecio(40000);
		
		Pantalla.escribirString("\nDespues de cambiar una funcion");
		for (Teatro t: teatros)
			t.mostrarDatos();
		
		
		// Si se cambia algo de direccion
		// no se cambia en el teatro
		direccion = new Direccion ();
		direccion.leerDatos();
		teatros[0].setDireccion(direccion);
		teatros[0].mostrarDatos();
		direccion.setCodigoPostal("28030");
		Pantalla.escribirString("\nDespues de cambiar direccion");
		teatros[0].mostrarDatos();
		
	}
	
	private static void leerTeatros(Teatro[] teatros, Funcion[] funciones) {
		Teatro teatro;
		
		for (int i = 0; i < teatros.length; i++)
		{
			teatro = new Teatro (); // Crea teatro
			do
			{
				teatro.leerClave();
			}while (existeTeatro (teatro, teatros)); //Lee nombre teatro hasta que no exista anteriormente
			
			teatro.leerOtrosDatos(); //Lee el resto de datos del teatro
			
			asignarFunciones (teatro, funciones); //
			
			teatros[i] = teatro;
		}
	}
	
	private static void asignarFunciones(Teatro teatro, Funcion[] funciones) {
		//Elije una funcion de las creadas y hace una copia blanda de la seleccionada  
		int cual;
		for (int i = 0; i < teatro.getFunciones().length; i++) 
		{
			for (Funcion f: funciones)
				Pantalla.escribirString("\n"+ f.getNombre());
		
			cual = Libreria.leerEntreLimites(1, funciones.length, "\nElija una funcion");
			
			teatro.setFuncion(i, funciones[cual-1]); // -1 por la enumeracion de los array 0.1.2etc 
			
		}
		
	}

	private static boolean existeTeatro(Teatro teatro, Teatro[] teatros) {
		boolean existe = false;
		
		for (int i = 0; i < teatros.length && !existe; i++)
		{
			existe = teatro.equals(teatros[i]);
		}
		
		return existe;
	}

	public static void leerFunciones(Funcion[] funciones) {
		Funcion funcion;
		
		for (int i = 0; i < funciones.length; i++)
		{
			funcion = new Funcion (); //Crea la funcion
			do
			{
				funcion.leerClave(); 
			}while (existeFuncion (funcion,funciones)); //Lee la funcion hasta que no exista anteriormente
			
			funcion.leerRestoDatos(); //lee precio de la funcion
			funciones[i] = funcion; // Guarda la funcion creada en el array funciones
		}
	}

	private static boolean existeFuncion(Funcion funcion, Funcion[] funciones) {
		boolean existe = false;
		
		for (int i = 0; i < funciones.length && !existe; i++)
		{
			existe = funcion.equals(funciones[i]);
		}
		
		return existe; //Si la funcion existe ya, devuelve True si no False
	}


}
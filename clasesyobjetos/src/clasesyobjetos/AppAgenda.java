package clasesyobjetos;

import daw.com.Pantalla;
import daw.com.Teclado;


public class AppAgenda {
	private static final int SALIR = 8;
	
	public static void main(String[] args) {
		Agenda agenda;
		int opc, cuantos;
		
		cuantos = Libreria.leerEnteroPositivo("cuantos?");
		
		agenda = new Agenda (cuantos);
		
		do
		{
			mostrarOpciones ();
			opc = Libreria.leerEntreLimites(1, SALIR, "Elija su opcion..");
			evaluarOpcion (opc,agenda);
		}while (opc != SALIR);
		
	}
	
	public static void evaluarOpcion(int opc, Agenda agenda) {
		// TODO Auto-generated method stub
		switch (opc)
		{
		case 1:
			insertar (agenda);
			break;
		case 2:
			existe (agenda);
			break;
		case 3:
			listar (agenda);
			break;
		case 4:
			buscar (agenda);
			break;
		case 5:
			eliminar (agenda);
			break;
		case 6:
			agendaLlena (agenda);
			break;
		case 7:
			huecosLibres (agenda);
			break;
		case 8:
			salir ();
			break;
		}
		
	}
	
	private static void insertar(Agenda agenda) {
		// TODO Auto-generated method stub
		Contacto contacto;
		
		contacto = new Contacto();
		
		if (!agenda.agendaLlena())
		{
			contacto.leerClave();
			if (!agenda.existeContacto(contacto))
			{
				contacto.leerOtrosDatos();
				agenda.aniadirContacto(contacto);
				Pantalla.escribirString("\ncontacto añadido correctamente");
			}
			else
				Pantalla.escribirString("\nContacto ya existe");
		}
		else
			Pantalla.escribirString("\nAgenda llena");
	}
	private static void existe(Agenda agenda) {
		// TODO Auto-generated method stub
		Contacto contacto;
		
		
		contacto = new Contacto();
		contacto.leerClave();
		
		
		if (agenda.existeContacto(contacto))
			Pantalla.escribirString("\nContacto existe");
		else
			Pantalla.escribirString("\nContacto no existe");
		
	}
	private static void listar(Agenda agenda) {
		// TODO Auto-generated method stub
		agenda.listarContactos();
	}
	private static void buscar(Agenda agenda) {
		// TODO Auto-generated method stub
		String nombre;
		
		nombre = Teclado.leerString("nombre ");
		
		agenda.buscaContacto(nombre);
		
		
	}
	private static void eliminar(Agenda agenda) {
		Contacto contacto;
		
		contacto = new Contacto ();
		contacto.leerClave();
		
		if (agenda.eliminarContacto(contacto))
			Pantalla.escribirString("\nContacto eliminado");
		else
			Pantalla.escribirString("\nContacto no existe");
		
	}
	private static void agendaLlena(Agenda agenda) {
		// TODO Auto-generated method stub
		if (agenda.agendaLlena())
			Pantalla.escribirString("\nLlena");
		else
			Pantalla.escribirString("\nNo llena");
	}
	private static void huecosLibres(Agenda agenda) {
		// TODO Auto-generated method stub
		
		Pantalla.escribirString("\nQuedan " +
				agenda.huecosLibres() + 
				" huecos libres");
	}
	private static void salir() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nfin");
	}
	public static void mostrarOpciones() {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\n1.Insertar");
		Pantalla.escribirString("\n2.Existe contacto");
		Pantalla.escribirString("\n3.Listar contactos");
		Pantalla.escribirString("\n4.Buscar contacto");
		Pantalla.escribirString("\n5.Eliminar contacto");
		Pantalla.escribirString("\n6.Agenda llena");
		Pantalla.escribirString("\n7.Huecos libres");
		Pantalla.escribirString("\n8.Salir");
	}

}
package figuras1;

import java.util.ArrayList;

import clasesyobjetos.Libreria;
import daw.com.Pantalla;
import daw.com.Teclado;

public class AppFiguras {
	
	private Lienzo lienzo;
	
	public AppFiguras() {
		lienzo = new Lienzo();	
	}

	public static void main(String[] args) {
		
		AppFiguras app;
		app = new AppFiguras();
		int opc;
		
		app.lienzo.leerDatos();
		
		System.out.println(app.lienzo.toString());
		
		do {
			app.menu();
			opc= Libreria.leerEntreLimites(1, 6, "elije una opc");
			app.evaluarOpcion(opc);
		} while (opc != 6);
		
		
	}
	
	private void evaluarOpcion(int opc) {
		
		switch (opc) {
		case 1:
			System.out.println("----------------------");
			aniadirFigura();
			System.out.println("----------------------");
			break;
		case 2:
			System.out.println("----------------------");
			eliminarFigura();
			System.out.println("----------------------");
			break;
		case 3:
			System.out.println("----------------------");
			figuraMayor();
			System.out.println("----------------------");
			break;
		case 4:
			System.out.println("----------------------");
			verticalmente();
			System.out.println("----------------------");
			break;
		case 5:
			horizontalmente();
			break;
		case 6:
			System.out.println("----------------------");
			salir();
			System.out.println("----------------------");
			break;

		default:System.out.println("ERROR");
			break;
		}
	}

	private void horizontalmente() {
		lienzo.alinearFigurasVerticalmente();
	}

	private void verticalmente() {
			lienzo.alinearFigurasVerticalmente();;
	}

	private void figuraMayor() {
		if (lienzo.getNFiguras() < 2) {
			System.out.println("No hay 2 FIGURAS MINIMAS para comparar");
		}else {
		lienzo.mostrarFiguraMayor();
		}
	}

	private void aniadirFigura() {
		// TODO Auto-generated method stub
		Figura figura = new Rectangulo();
		int forma;
		boolean exito = false;
		
		forma = Teclado.leerInt("1. Rectangulo \n2. Circulo");
		
		
		if(forma == 2) {
			figura = new Circulo();
		}
		
		figura.leerDatos();
		System.out.println(figura.toString());
		
		exito = lienzo.addFigura(figura);
		
		if(exito == true) {
			System.out.println("Añadida");
			System.out.println("Área de la figura añadida: " + figura.getArea());
		}
		else {
			System.out.println("Error");
			System.out.println("Área de la figura que se quiere añadir: " + figura.getArea());
		}
		
		System.out.println(lienzo.getArea() + " restante del lienzo");	
		}
	
	 private void eliminarFigura() {
	        String nombre = Teclado.leerString("Nombre de la figura a eliminar: ");
	        Figura figuraEliminada = null;
	        
	        // Buscar la figura por su nombre
	        for (Figura f : lienzo.getFiguras()) {
	            if (f.getNombre().equalsIgnoreCase(nombre))
	            {
	                figuraEliminada = f;
	            }
	        }
	        
	        // Si se encontró la figura, eliminarla de la lista
	        if (figuraEliminada != null) {
	        	lienzo.removeFigura(figuraEliminada);
	            System.out.println("Figura eliminada exitosamente.");
	        } else {
	            System.out.println("No se encontró una figura con el nombre proporcionado.");
	        }
	    }

	private void salir() {
		// TODO Auto-generated method stub
		lienzo.MostrarFigurasPorPerimetroMayor();
		System.out.println("FIN...");
	}

	private void menu() {
		ArrayList <String> menu;
		menu = new ArrayList();
		
		menu.add("Añadir Figura");
		menu.add("Eliminar Figura");
		menu.add("Figura Mayor");
		menu.add("Alinear Verticalmente");
		menu.add("Alinear horizontalmente");
		
		for (int i = 0; i < menu.size(); i++)
			Pantalla.escribirString("\n" + (i+1) +"." + menu.get(i));
		
		Pantalla.escribirString("\n" + (menu.size() + 1) +".Salir" );
	}
		
	
}

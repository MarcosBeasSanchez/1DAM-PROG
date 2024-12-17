package examen2Final;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

import daw.com.Teclado;

public class App extends AppConMenu{
    static final String FILE_NAME = "lienzo.dat";
    public static Lienzo lienzo;
    

    public static void main(String[] args) {
    	App app = new App();
    	app.inicio();
    	app.run(); 
        }

	private void inicio() {
    	File file = new File(FILE_NAME);
    	boolean exito;

        if (file.exists()) {
            try (DataInputStream entrada = new DataInputStream(new FileInputStream(FILE_NAME))) {
               lienzo.leerEntrada(entrada);
                System.out.println("Lienzo cargado desde el archivo.");
            } catch (IOException e) {
                System.out.println("Error al cargar el lienzo: " + e.getMessage());
            }
        } else {
        	
            do {
            	exito = false;
            	 try {
                 	lienzo = new Lienzo();
                 	lienzo.leerDatos();
         		} catch (DateTimeException e) {
         			System.out.println(e.getMessage());
         			exito = true;
         		}
    		} while (exito);
        }
		
	}



	public App() {
    	super();
    	System.out.println("Seleccione una opcion:");
    	addOpcion("Cambiar nombre y fecha del lienzo");
    	addOpcion("Añadir Figura");
    	addOpcion("Borrar Coordenadas");
    	addOpcion("Exportar a CSV");	    	
    }
    
    @Override
	public void evaluarOpcion(int opc) {
    	 switch (opc) {
         case 1:
             cambiarNombreYFechaLienzo();
             break;
         case 2:
             anadirFigura();
             break;
         case 3:
             borrarCoordenadas();
             break;
         case 4:
             exportarACSV();
             break;
         case 5:
             salir();
             
             break;
         default:
             System.out.println("Opción no válida. Intente de nuevo.");
     }
		
	}

    private void cambiarNombreYFechaLienzo() {
    	
    	String nombre,nombrecambiar = null;
    	boolean exito;
    	LocalDate fecha = null ;
    	LocalDate fecha2;
    	
    	nombre = Teclado.leerString("Nombre del lienzo a cambiar");
    	
    	if (lienzo.existeLienzo(nombre)) {
    	
    		do {
    			exito = false;
    			try {
    				nombrecambiar = Teclado.leerString("Nombre que quieres poner: ");
    				fecha = LocalDate.parse(Teclado.leerString("fecha de creacion: yyyy-mm-aa"));
        			lienzo.cambiarDatos(nombrecambiar, fecha);
    			} catch (DateTimeException e) {
    				System.out.println(e.getMessage());
    				exito = true;
    			}
			} while (exito);
    		System.out.println("Datos cambiados correctamente / " + nombrecambiar + " / " + fecha);
		}else {
			System.out.println("El nombre introducido no existe, creando un nuevo lienzo:");
			fecha2 = LocalDate.now();
			lienzo = new Lienzo(nombre,fecha2);
			System.out.println("lienzo creado correctamente / " + nombre +" / "+ fecha2);
		}
   
    }

    private static void anadirFigura() {
    	boolean exito;
    	int fig;
    	Figura figura;
    	
    	do {
    		exito = true;
    		String nombre = Teclado.leerString("Nombre de la figura que quieres introducir");
    		
			if (!lienzo.existeFigura(nombre)) {
				fig = Teclado.leerInt("1.Rombo | 2.Pentagono");
				
				switch (fig) {
				case 1:
					figura = new Rombo();
					figura.leerSoloDatos();
					lienzo.addFigura(figura);
					lienzo.listarFiguras();
					exito = false;
					break;
				case 2:
					figura = new Pentagono();
					figura.leerSoloDatos();
					lienzo.addFigura(figura);
					exito = false;
					break;

				default: System.out.println("Respuesta no valida");
				exito = true;
					break;
				}
	
			}else {
				System.out.println("El nombre de la figura introducida ya existe");
				lienzo.listarFiguras();
				exito = false;
			}
		} while (exito);
      
    }

    private static void borrarCoordenadas() {
       Figura f ;
       String nombre;
       int x, y;
       boolean correcto;
       
    	     nombre = Teclado.leerString("Nombre de la figura que desees borrar las coordenadas");
    	       if (lienzo.existeFigura(nombre)) {
    			f = lienzo.getFiguraByName(nombre);
    			do {
    				correcto= false;
    				f.listarPuntos();
        			System.out.println("Introduce las coordenadas que deseas borrar:");
        			x= Teclado.leerInt("X:");
        			y= Teclado.leerInt("Y:");
        			if (f.deleteCoordenadas(x,y)) {
        				System.out.println("La figura: " + nombre + " con coordenadas x: "+ x + " y " + y + " ha sido eliminada");
        				correcto = true;
        			} else {
        				System.out.println("Las coordenadas introducidas no existen en la figura: " + nombre);
        			}
				} while (correcto);
    			
    		} else {
    			System.out.println("La figura introducida NO EXISTE");
    		}
    	}

    private void exportarACSV() {
        try (PrintWriter salida = new PrintWriter(new File("figuras.csv"))) {
        	
            List<Figura> figurasConPerimetroMayorA2 = new ArrayList<>();
            for (Figura figura : lienzo.figuras) {
                if (figura.calcularPerimetro() > 2) {
                    figurasConPerimetroMayorA2.add(figura);
                }
            }
            figurasConPerimetroMayorA2.sort((f1, f2) -> f2.nombre.compareTo(f1.nombre));
            for (Figura figura : figurasConPerimetroMayorA2) {
                salida.println(figura.nombre + "," + figura.calcularPerimetro());
            }
            System.out.println("Figuras exportadas a figuras.csv.");
        } catch (FileNotFoundException e) {
            System.out.println("Error al exportar a CSV: " + e.getMessage());
        }
    }

    private static void salir() {
       /* try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            salida.writeObject(lienzo);
            System.out.println("Lienzo guardado " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error al guardar el lienzo: " + e.getMessage());
        }*/
    	
    	try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(FILE_NAME))){
			lienzo.guardarDatos(salida);
		} catch (IOException e) {
			System.out.println(e.getMessage() + " Error guardando Lienzo" );
		}
    }

	
}

package SerializacionObjetos;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import biblioteca.Libreria;
import tareas.Persona;
import tareas.Tarea;
import tareas.TareaPersonal;
import tareas.TareaTrabajo;

public class pruebaSerializacionObjetos {

	public static void main(String[] args) {
		//En este caso debemos implementar Serializable ent todas las clases que vayan 
		//a ser serializadas, incluyendo las clases hijas.
		//En este caso, las clases Persona, Tarea, TareaPersonal y TareaTrabajo.
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		//Comentar y descomentar para probar la serializacion
		/*Persona p1 = new Persona("12345678A", "Pepe");
		Persona p2 = new Persona("87654321B", "Juan");
		Persona p3 = new Persona("11111111C", "Maria");
		Tarea t1 = new TareaPersonal("Comprar pan");
		Tarea t2 = new TareaTrabajo("Estudiar");
		Tarea t3 = new TareaPersonal("Hacer la compra");
	
		p1.addTarea(t1);
		p2.addTarea(t2);
		p3.addTarea(t3);
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		
		listaPersonas.forEach(p -> System.out.println(p));*/
		
		int res = Libreria.leerEntreLimites(0, 1, "0-Guardar - 1-Cargar");
		
		if (res == 0) {
			// Guardar en un archivo .
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("OOS.dat"))) {
				oos.writeObject(listaPersonas); 
				System.out.println("Objetos guardados correctamente: OOS.dat" );
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		} else {
	        // Cargar desde el archivo .DAT
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OOS.dat"))) {
	            List<Persona> listaCargada = (List<Persona>) ois.readObject(); // Casteamos el objeto leido
	            System.out.println("Personas cargadas...");
	            listaPersonas = listaCargada; // Actualizamos la lista de personas
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			
			listaPersonas.forEach(p -> System.out.println(p));
			
		}


	}

}

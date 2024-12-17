package interfaces1ejer;

import java.util.ArrayList;

public class Appinterfaces1ejer {
	public static void main(String[] args) {
	//Crear el arrayliste de habladores;
    ArrayList<Hablador> listaHabladores = new ArrayList<>();
    
    //Crear los habladortes/objetos
    Loro loro = new Loro();
    Piolin piolin = new Piolin();
    Alumno alumno = new Alumno();
    Profesor profesor = new Profesor();
    Bedel bedel = new Bedel();
    Tv tv = new Tv();
    Radio radio = new Radio();
    
    //imprelmetar al arraylist los hablantes
    
    listaHabladores.add(loro);
    listaHabladores.add(piolin);
    listaHabladores.add(alumno);
    listaHabladores.add(profesor);
    listaHabladores.add(bedel);
    listaHabladores.add(tv);
    listaHabladores.add(radio);
    
    for (Hablador h : listaHabladores) {
		h.hablar();
		System.out.println(h.toString()); 
		System.out.println("");
	}

	}
}

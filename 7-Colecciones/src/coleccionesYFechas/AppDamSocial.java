package coleccionesYFechas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import daw.com.Pantalla;
import daw.com.Teclado;



public class AppDamSocial extends AppConMenu {

	private DamSocial damSocial;
	
	public AppDamSocial ()
	{
		super ();
		damSocial = new DamSocial("villablanca");
		addOpcion ("Eliminar personas por aficion");
		addOpcion ("Aumentar aprecio");
		addOpcion ("Aficion de colectivo");
		addOpcion ("Personas sin aficion");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppDamSocial app = new AppDamSocial ();
		app.leerPersonas ();
		app.run();

	}
	
	@Override
	public void evaluarOpcion(int arg0) {
		// TODO Auto-generated method stub
		
		switch (arg0)
		{
			case 1:
				eliminarPersona();
				break;
			case 2:
				aumentarAfecto();
				break;
			case 3:
				aficionColectivo();
				break;
			case 4:
				sinAficion();
				break;
			case 5:
				salir();
				break;
		}

	}
	
	public void sinAficion() {
		// TODO Auto-generated method stub
		String aficion;
		List <Persona> personasconAficion;
		List <Persona> personas;
		
		aficion = Teclado.leerString("\nAficiï¿½n a buscar ");
		personasconAficion = damSocial.obtenerPersonasPorAficion(aficion);
		personas = damSocial.obtenerTodasPersonas();
		
		personas.removeAll(personasconAficion);
		
		Pantalla.escribirString("\nPersonas sin la aficion " + 
										aficion  + " : " + 
										personas);
		
	}

	public void aficionColectivo() {
		// TODO Auto-generated method stub
		String aficion;
		List <Persona> personasAficion;
		Set <Colectivo> colectivos = new HashSet<> ();
		
		aficion = Teclado.leerString("\nAficiï¿½n a buscar ");
		personasAficion = damSocial.obtenerPersonasPorAficion(aficion);
		
		for (Persona p: personasAficion)
			colectivos.add(p.getColectivo());
		
		//personasAficion.forEach(p-> colectivos.add(p.getColectivo()));
		
		Pantalla.escribirString("\nColectivos para la aficion " + 
									aficion  + " : " + 
									colectivos);
		
	}

	public void aumentarAfecto() {
		// TODO Auto-generated method stub
		float mediaAfecto ;
		
		mediaAfecto = calcularMediaAfecto ();
		
		Pantalla.escribirString("\nMedia de afecto actual " + mediaAfecto);
		
		for (Persona p : damSocial.getPersonas().values())
			p.aumentarAfecto(mediaAfecto);
		
		mediaAfecto = calcularMediaAfecto ();
		Pantalla.escribirString("\nMedia de afecto despuï¿½s de aumetar afecto " + mediaAfecto); 
		
	}

	private float calcularMediaAfecto ()
	{
		float media = 0;
		Collection <Persona> todas = damSocial.getPersonas().values();
		
		for (Persona p : todas)
			media += p.getAfecto();
		
		if (todas.size() > 0)
			media /= todas.size();
	
		
		/*
		return (float ) damSocial.getPersonas().values().stream().
						mapToDouble(Persona::getAfecto).
						average().
						orElse(0);
		*/
		
		return media;
	}
	
	public void eliminarPersona() {
		// TODO Auto-generated method stub
		String aficion;
		List <Persona> personasAficion;
		
		
		aficion = Teclado.leerString("\nAficiï¿½n de las personas a eliminar ");
		
		personasAficion = damSocial.obtenerPersonasPorAficion(aficion);
		
		for (Persona p : personasAficion)
			damSocial.elimiarPersona(p.getDni());
		
		//personasAficion.forEach(p -> damSocial.elimiarPersona(p.getDni()));
		
		Pantalla.escribirString("\nPersonas eliminadas " + personasAficion.size());
	}

	public void leerPersonas ()
	{
		Persona persona;
		do
		{
			persona = leerPersona ();
			damSocial.insertarPersona(persona);
			Pantalla.escribirString("\nPesona insertada correctamente");
		}while (Teclado.leerString("\nsigo?").equalsIgnoreCase("s"));
	}
	
	public Persona leerPersona ()
	{
		Persona persona = new Persona ();
		
		do
		{
			persona.leerClave();
		}while(damSocial.tienePersona(persona.getDni()));
		
		persona.leerRestoDatos();
		
		return persona;
	}
	
	public void salir ()
	{
		Comparator<Persona> comparador;
		Consumer <Persona> consumidor;
		
		comparador = new ComparadorPorNombre();
		consumidor = new MostrarNombreYEdad();
		
		List<Persona> lista = new ArrayList<>(damSocial.getPersonas().values()); 
		lista.sort(comparador);
		lista.forEach(consumidor);
	}

}	

package clasesyobjetos;


import daw.com.Pantalla;


public class Agenda {
	
	private final static int TAMANIO = 10;
	private static final Contacto VACIO = new Contacto();
	
	private Contacto[] contactos; // por composiciÃ³n
	
	public Agenda (int n)
	{
		n = n > 0?n:TAMANIO;
		
		contactos = new Contacto[n];
		for (int i = 0; i < n; i++)
			contactos[i] = new Contacto();
	}
	
	public Agenda ()
	{
		this(TAMANIO);
	}
	
	public Agenda (Agenda original)
	{
		// copia dura porque es composiciÃ³n
		this.contactos = new Contacto[original.contactos.length];
		
		for (int i = 0; i < this.contactos.length; i++)
			this.contactos[i] = new Contacto(original.contactos[i]);
	}
	
	public boolean existeContacto (Contacto contacto)
	{

		return buscarContacto(contacto) != null ;
	}
	
	public void buscaContacto (String nombre)
	{
		Contacto c = buscarContacto (new Contacto(nombre));
		
		if (c != null)
			Pantalla.escribirString("\nTelÃ©fono : " + c.getTelefono());
	}
	
	public Contacto buscarContacto (Contacto contacto)
	{
		Contacto c;
		int pos;
		
		pos = buscarPosicionContacto (contacto);
		
		c = pos != -1? new Contacto(contactos[pos]): null;
		
		return c;
	}
	
	private int buscarPosicionContacto (Contacto contacto)
	{
		int pos = -1;

		for (int i = 0; i < contactos.length && pos == -1; i++)
		{
	
			if (contactos[i].equals(contacto))
				pos = i;
		}
		return pos;
	}
	public boolean agendaLlena ()
	{
		return !existeContacto(VACIO);
	}
	
	public int huecosLibres ()
	{
		int huecos = 0;
		
		for (Contacto c: contactos)
			if (c.equals(VACIO))
				huecos++;
		return huecos;
	}
	
	public boolean eliminarContacto (Contacto contacto)
	{
		boolean exito = false;
		int pos;
		
		pos = buscarPosicionContacto(contacto);
		if (pos != -1)
		{
			contactos[pos] = new Contacto(); // VACIO
			exito = true;
		}
		
		return exito;
	}
	
	public boolean aniadirContacto (Contacto contacto)
	{
		boolean exito = false;
		int pos;
		
		if (contacto != null &&
				!agendaLlena() && 
				!existeContacto(contacto))
		{
			exito = true;
			pos = buscarPosicionContacto(VACIO);
			contactos[pos].setNombre(contacto.getNombre());
			contactos[pos].setTelefono(contacto.getTelefono());
		}
		
		return exito;
	}
	
	public void listarContactos ()
	{
		for (Contacto c: contactos)
			if (!c.equals(VACIO))
				c.mostrarDatos();
	}
	
	public boolean sincronizarAgenda (Agenda otra)
	{
		boolean exito = true;
		
		Agenda copia;
		return exito;
	}
}
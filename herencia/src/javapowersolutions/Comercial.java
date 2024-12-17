package javapowersolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import daw.com.Teclado;

public class Comercial {
	private String nombre;
	private final String nif;
	private List<Oferta> ofertas;

	public Comercial(String nombre, String nif) {

		this.nombre = nombre;
		this.nif = nif;
		ofertas = new ArrayList<>();
	}
	
	public Comercial (String nif)
	{
		this ("", nif);
	}
	
	public Comercial ()
	{
		this ("");
	}

	public String getNombre() {
		return nombre;
	}

	public String getNif() {
		return nif;
	}

	public List<Oferta> getOfertas() {
		return crearCopiaOfertas(ofertas);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = crearCopiaOfertas(ofertas);
	}
	
	private List<Oferta> crearCopiaOfertas (List<Oferta> original)
	{
		List<Oferta> copia = new ArrayList<>();
				
		for (Oferta o: original)
			copia.add(new Oferta(o));
		
		return copia;
	}
	public boolean addOferta (Oferta oferta)
	{
		boolean exito = false;
		
		if (!ofertas.contains(oferta))
		{
			ofertas.add(oferta);
			exito = true;
		}
		return exito;
	}
	
	public boolean eliminarOferta (Oferta oferta)
	{
	
		return ofertas.remove(oferta);
	}
	
	public boolean modificarOferta (Oferta oferta)
	{
		boolean exito = false;
		int cual = ofertas.indexOf(oferta);
		if (cual != -1)
		{
			exito = true;
			ofertas.set(cual, new Oferta(oferta)); // cambiar la oferta
		}
		return exito;
	}

	@Override
	public String toString() {
		return "Comercial [nombre=" + nombre + ", nif=" + nif + ", ofertas=" + ofertas + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comercial other = (Comercial) obj;
		return Objects.equals(nif, other.nif);
	}
	
	public void leerDatos ()
	{
		// leerClave (); es final
		leerOtrosDatos ();
	}


	public void leerOtrosDatos() {
		// TODO Auto-generated method stub
		nombre = Teclado.leerString("\nnombre comercial");
	}

}
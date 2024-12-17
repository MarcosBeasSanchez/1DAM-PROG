package inmobiliaria;

import java.time.LocalDate;
import java.util.Objects;

import daw.com.Teclado;

public class Visita {
	
	LocalDate visita;
	Vivienda vivienda;
	String impresion;
	Cliente cliente;
	
	public Visita(LocalDate visita ,Vivienda vivienda ,String impresion ,Cliente cliente) {
		setVisita(visita);
		this.vivienda =  vivienda;
		setImpresion(impresion);
		this.cliente = cliente;
	}
	
	public Visita() {
		this (LocalDate.now(),new ViviendaLibre(),"",new Cliente());
	}
	
	public Visita (Vivienda vivienda, Cliente cliente)
	{
		this (LocalDate.now(),vivienda, "", cliente);
		
	}
	
	public Visita (Visita original)
	{
		this (original.visita, original.vivienda,original.impresion, original.cliente);
	}

	public LocalDate getVisita() {
		return visita;
	}

	public void setVisita(LocalDate visita) {
		if (visita == null) {
			visita = LocalDate.now();
		}
		
		this.visita = visita;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public String getImpresion() {
		return impresion;
	}

	public void setImpresion(String impresion) {
		if (impresion == ""||impresion == null )
		{
			impresion = "No hay descrpicion";
		}
		this.impresion = impresion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setFecha(LocalDate fecha) {
		if (fecha.isAfter(LocalDate.now()))
			fecha = LocalDate.now();
	}
	
	public void leerDatos ()
	{
		
		visita = LocalDate.parse(Teclado.leerString("\nFecha de visita (aaaa-mm-dd)"));

		setImpresion(Teclado.leerString("Breve descripcion"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, visita, vivienda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visita other = (Visita) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(visita, other.visita)
				&& Objects.equals(vivienda, other.vivienda);
	}
	
	


	

}

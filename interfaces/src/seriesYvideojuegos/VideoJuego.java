package seriesYvideojuegos;

import daw.com.Pantalla;
import daw.com.Teclado;

public class VideoJuego implements Entregable {
	
	private String titulo;
	private float horas;
	private String empresa;
	private boolean entregado;
	

	public VideoJuego(String titulo, float horas, String empresa) {
		
		this.titulo = titulo;
		setHoras (horas);
		this.empresa = empresa;
		entregado = false;
	}

		
	public VideoJuego(String titulo, float horas) {

		this (titulo, horas, "");
	}

	public VideoJuego ()
	{
		this ("", 0f, "");
	}
	
	

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public float getHoras() {
		return horas;
	}


	public void setHoras(float horas) {
		if (horas < 0)
			horas = 0f;
		this.horas = horas;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	
	
	@Override
	public String toString() {
		return "VideoJuego [titulo=" + titulo + ", horas=" + horas + 
					", empresa=" + empresa + ", entregado=" 
					+ (entregado?"Sï¿½":"No") + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		VideoJuego other = (VideoJuego) obj;
		if (titulo == null) {
			if (other.titulo != null) {
				return false;
			}
		} else if (!titulo.equals(other.titulo)) {
			return false;
		}
		return true;
	}


	public void leerDatos ()
	{
		titulo = Teclado.leerString("Titulo");
		setHoras (Teclado.leerFloat("horas"));
		empresa = Teclado.leerString("Empresa");
	}

	@Override
	public void entregar() {
		// TODO Auto-generated method stub
		entregado = true;
	}

	@Override
	public void devolver() {
		// TODO Auto-generated method stub
		entregado = false;
	}

	@Override
	public boolean isEntregado() {
		// TODO Auto-generated method stub
		return entregado;
	}


	@Override
	public int compareTo(Entregable o) {
		// TODO Auto-generated method stub
		Pantalla.escribirString("\nEstoy en compareTo de VideoJuego");

		
		VideoJuego otro  = (VideoJuego) o;
		//return horas - otro.horas;
		return titulo.compareTo(otro.titulo);
	}

}
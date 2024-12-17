package cestaCompra;

public class LineaCesta 
{
	private int cantidad;
	private Electrodomestico e;
	
	public LineaCesta ()
	{
		this (null,0);
	}
	
	public LineaCesta (Electrodomestico e)
	{
		this (e,1);
	}
	
	public LineaCesta(Electrodomestico e, int cantidad) {
		this.cantidad = cantidad;
		this.e = e;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		if (cantidad < 1)
			cantidad = 1;
		this.cantidad = cantidad;
	}

	public Electrodomestico getE() {
		return e;
	}

	public void setE(Electrodomestico e) {
		this.e = e;
	}
	
	public float getTotal ()
	{
		return e.precioFinal() * cantidad;
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
		LineaCesta other = (LineaCesta) obj;
		if (e == null) {
			if (other.e != null) {
				return false;
			}
		} else if (!e.equals(other.e)) {
			return false;
		}
		return true;
	}
	
	
}

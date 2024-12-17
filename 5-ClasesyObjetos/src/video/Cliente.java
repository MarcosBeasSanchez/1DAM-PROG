package video;
import daw.com.Pantalla;
import daw.com.Teclado;

public class Cliente {

	private String idCliente;
    private String nombre;
    private Direccion direccion; // composicion
    private String telefono;
    
	public Cliente(String idCliente, String nombre, Direccion direccion, String telefono) {

		setIdCliente (idCliente);
		this.nombre = nombre;
		setDireccion (direccion);
		this.telefono = telefono;
	}
	public Cliente (Cliente original)
	{
		this (original.idCliente, original.nombre,original.direccion, original.telefono);
	}
	
	public Cliente ()
	{
		this("");
	}
	
	public Cliente(String idCliente) {
		
		this (idCliente, "", new Direccion(),"");
	}

	public String getIdCliente() {
		return idCliente;
	}

	private void setIdCliente(String idCliente) {
		if (idCliente == null)
			idCliente = "";
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return new Direccion (direccion);
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = new Direccion (direccion);
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre +
				", direccion=" + direccion + ", telefono="+ telefono + "]";
	}

	public void mostrarDatos ()
	{
		Pantalla.escribirString("\n" + this);
	}

	public boolean equals(Cliente otro) {
		
		return otro != null &&
				idCliente.equals(otro.idCliente);
	}
    
	public void leerDatos ()
	{
		leerClave ();
		leerOtrosDatos ();
	}
	
	public void leerOtrosDatos() {
		nombre = Teclado.leerString("\nnombre");
		direccion.leerDatos();
		do
		{
			telefono = Teclado.leerString("\ntelefono");
		}while (!telefono.matches("[0-9]*")); // solo digitos del 0 - 9  
	}

	public void leerClave() {
		idCliente = Teclado.leerString("\nidentificador de cliente ");
	}
	
}
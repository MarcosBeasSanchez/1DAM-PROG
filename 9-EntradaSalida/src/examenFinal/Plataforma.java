package examenFinal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Plataforma {
	
	private List<Cliente>clientes;
	public List<Material>materiales;
	private List<Escucha>escuchas;

	public  Plataforma() { //cuando se llama inicializa las cargas de los archivos
		clientes= new ArrayList<Cliente>();
		materiales= new ArrayList<Material>();
		escuchas= new ArrayList<Escucha>();
	}
	
	public void cargarClientes(BufferedReader br) throws IOException {
		
			String linea;
			Cliente cliente;
			while (br.ready()) {
				linea = br.readLine();
				cliente = new Cliente();
				cliente.fromCsv(linea);
				clientes.add(cliente);
			}
		}
			
	public void cargarEscuchas(BufferedReader br) throws IOException {
		
			String linea;
			Escucha escucha;

			
			while(br.ready()) {
				linea = br.readLine();
				escucha = new Escucha();
				escucha.fromCsv(linea);
				escuchas.add(escucha);
			}
	}
	
	public void cargarMateriales(DataInputStream di) throws IOException {
		
			int cuantos;
			String tipo;
			Material material;
			
			cuantos = di.readInt(); //lee cuantos materiales hay en el arraylist(podcast y canciones)
			
			if (cuantos > 0) {
				for (int i = 0; i < cuantos; i++) {
					tipo = di.readUTF(); // lee el tipo de material
					
					switch (tipo) {
					
					case "PODCAST":
						material = new Podcast();
						material.leerFichero(di);
						materiales.add(material);
						break;

					case "CANCION":
						material = new Cancion();
						material.leerFichero(di);;
						materiales.add(material);
						break;
						
					}
				}
			}
	}
	
	public void guardarClientes(PrintWriter pw)  {
		
			for (Cliente c : clientes) {
				pw.println(c.toCsv()); 
			}
	}
	
	public void guardarMateriales(DataOutputStream salida) throws IOException {
		
			salida.writeInt(materiales.size());  // Guardamos el tamaño de la lista de materiales
			
			for (Material m : materiales) {
				if (m instanceof Podcast) {
					salida.writeUTF("PODCAST");
				}else {
					salida.writeUTF("CANCION");
				}
				m.escribirFichero(salida); // Escribimos los datos del material original
			}		
	}

	public void guardarEscuchas(PrintWriter salida) {
		
			for (Escucha e : escuchas) {
				salida.println(e.toCsv());
			}
	}
	
	public boolean existeCliente(String id) {
		boolean existe = false;
		
		for (Cliente c : clientes) {
			if (c.getNif().equalsIgnoreCase(id)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public boolean existeMaterial(String id) {
		boolean existe = false;
		
		for (Material m : materiales) {
		 if (m.getId().equalsIgnoreCase(id)) {
			existe = true;
		}
		}
		return existe;
	}
	
	public boolean existeEscucha(String idCancion,String idCliente) {
		boolean existe = false;
		
		for (Escucha e : escuchas) {
		if (e.getIdMaterial().equalsIgnoreCase(idCancion) && e.getNifcliente().equalsIgnoreCase(idCliente)) {
			existe = true;
		}
		}
		return existe;
	}
	
	public void addMaterial(Material m) {
		materiales.add(m);
	}

	public void addCliente(Cliente cliente) {
		clientes.add(cliente);	
	}

	public void addEscucha(Escucha escuchaSeleccion) {
		escuchas.add(escuchaSeleccion);
		
	}

	public void listarClientes() {
		clientes.forEach(System.out::println);
	}
	
	public void listarMaterialesExistentes() {
		for (Material m : materiales) {
		System.out.println(m);
		}
		
	}

	public void listarEscuchas() {

		escuchas.forEach(System.out::println);

	}
	
	public boolean existenDatos() {
		boolean existe = true;
		
		if (clientes.isEmpty() && materiales.isEmpty() && escuchas.isEmpty()) {
			existe = false;
		}
		return existe;
		
	}
	
	
	

}

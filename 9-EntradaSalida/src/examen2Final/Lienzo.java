package examen2Final;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;

class Lienzo  {
    String nombre;
    LocalDate fechaCreacion;
    List<Figura> figuras;

    public Lienzo(String nombre, LocalDate fechaCreacion) {
        if (fechaCreacion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de creación no puede ser posterior a hoy.");
        }
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.figuras = new ArrayList<>();
    }
    

    public Lienzo() {
		this.nombre= "";
		this.fechaCreacion = LocalDate.now();
		this.figuras = new ArrayList<>();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		if (fechaCreacion.isAfter(LocalDate.now())) {
			throw new DateTimeException("La fecha introducida es posterior a la actual");
		}
		
		this.fechaCreacion = fechaCreacion;
	}


	public List<Figura> getFiguras() {
		return figuras;
	}


	public void setFiguras(List<Figura> figuras) {
		this.figuras = figuras;
	}


	public void addFigura(Figura figura) {
        figuras.add(figura);
    }

    public void removeFigura(Figura figura) {
        figuras.remove(figura);
    }

    public Figura getFiguraByName(String nombre) {
        for (Figura figura : figuras) {
            if (figura.getNombre().equalsIgnoreCase(nombre)) {
                return figura;
            }
        }
        return null;
    }
    
    
    public void cambiarDatos(String nombre , LocalDate fecha) {
    	this.nombre = nombre;
    	setFechaCreacion(fecha);
    }

    @Override
    public String toString() {
        return "Lienzo: " + nombre + " creado en " + fechaCreacion + " con figuras: " + figuras;
    }
    
    public boolean existeLienzo(String nombreopc) {
    	
    	return nombre.equalsIgnoreCase(nombreopc);
    }
    
    public boolean existeFigura(String fig) {
    	boolean existe=false;
    	for (Figura figura : figuras) {
			if (figura.getNombre().equalsIgnoreCase(fig)) {
				existe = true;
			}
		}
		return existe;
    	
    }
	


	public void listarFiguras() {
		for (Figura figura : figuras) {
			System.out.println(figura);
		}
		
	}
	
	public void leerDatos() {
		this.nombre = Teclado.leerString("Nombre del lienzo");
		setFechaCreacion(LocalDate.parse(Teclado.leerString("Fecha de creacion aaaa-mm-dd")));
	}


	public void guardarDatos(DataOutputStream salida) throws IOException {
		salida.writeUTF(nombre);
		salida.writeUTF(fechaCreacion.toString());
		
		salida.writeInt(figuras.size());
		for (Figura figura : figuras) {
			if (figura instanceof Rombo) {
				salida.writeUTF("ROMBO");
			}else {
				salida.writeUTF("PENTAGONO");
			}
			figura.guardarDatos(salida);
		}
		
	}


	public void leerEntrada(DataInputStream entrada) throws IOException {
		int cuantos;
		String tipoFigura;
		Figura figura;
		nombre = entrada.readUTF();
		fechaCreacion = LocalDate.parse(entrada.readUTF());
		
		cuantos = entrada.readInt();
		
		for (int i = 0; i < cuantos; i++) {
			tipoFigura = entrada.readUTF();
			switch (tipoFigura) {
			case "ROMBO":
				figura = new Rombo();
				figura.leerEntrada(entrada);
				figuras.add(figura);
				
				break;
				
			case "PENTAGONO":
				figura = new Pentagono();
				figura.leerEntrada(entrada);
				figuras.add(figura);
				break;

			default:
				System.out.println("imposible leer");
				break;
			}
		}
	}



	


	
}
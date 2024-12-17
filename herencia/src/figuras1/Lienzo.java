package figuras1;

import java.util.ArrayList;
import java.util.Objects;

import daw.com.Teclado;

public class Lienzo {
	
	private String nombre;
	private int ancho,alto;
	private int area;
	private ArrayList <Figura> figuras;
	
	public Lienzo(String nombre, int ancho, int alto, int area, ArrayList<Figura> figuras) {
	 this.nombre = nombre;
	 setAncho(ancho);
	 setAlto(alto);
	 this.area = alto * ancho ;
	 this.figuras = figuras;
	}
	
	public Lienzo () {
		this("",0,0,50, new ArrayList<Figura>());
	}
	
	
	
	public Lienzo (Lienzo original)
	{
		this (original.nombre, original.ancho, original.alto, original.area, original.figuras);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null)
			nombre = "";
		this.nombre = nombre;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho < 0) {
			ancho  = 0;
			}
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto < 0) {
			alto  = 0;
			}
		this.alto = alto;
	}
	
	public float getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
	
	public int getNFiguras() {
		return figuras.size();
	}
	
	public ArrayList<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}

	public void leerDatos() {
		int al, an, area;
		setNombre(Teclado.leerString("Nombre del lienzo"));
		
		al = Teclado.leerInt("Alto del lienzo");
		setAlto(al);
		an = Teclado.leerInt("Ancho del lienzo");
		setAncho(an);
		area = al*an;
		setArea(area);
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		/*
		if (getClass() != obj.getClass())
			return false;
		*/
		Lienzo other = (Lienzo) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public boolean existeFigura (Figura buscada){
		return figuras.contains(buscada);
	}
	
	public boolean addFigura (Figura anadida) // si cabe y no continene la figura , se añade
	{  
		boolean exito = false;
	    int total = 0;
	    
	    for (Figura f : figuras) {
	    	if(f != null ) {
	       total += f.getArea();
	    	}
	    }
	    
	   total+=anadida.getArea();

	   if(area >= total && !figuras.contains(anadida));{
		   
               figuras.add(anadida);
               area -= anadida.getArea(); 
               exito = true;
     
	   }
	
	   return exito;
	}
	
	public void removeFigura (Figura eliminada)
	{
		if (figuras.contains(eliminada)) {
			 figuras.remove(eliminada);

		}
	
	}
	
	public void mostrarFiguraMayor() {
		
		  if (figuras == null) {
	            System.out.println("No hay figuras en el sistema.");
	            return;
	        }
		  
	        Figura mayor = figuras.get(0);
	        
	        for (Figura f : figuras) {
	            if (f.getArea() > mayor.getArea()) {
	                mayor = f;
	            }
	        }

	        if (mayor instanceof Circulo) {
	            System.out.println("La figura mayor es un círculo con área: " + mayor.getArea());
	        } else if (mayor instanceof Rectangulo) {
	            System.out.println("La figura mayor es un rectángulo con área: " + mayor.getArea());
	        }     
	}
	
	public void alinearFigurasVerticalmente() {
		
		if (figuras.size() == 0) {
			System.out.println("No hay figuras creadas");
			return ;
		}
		
		//Asigna la figura mayor
		  Figura mayor = figuras.get(0);
		  
		  //compara con las otras figuras
	        for (Figura figura : figuras) {
	            if (figura.getY() > mayor.getY()) {
	                mayor = figura;
	            } 
	        }
	        //iguala las coordenadas  Y
	        for (Figura figura : figuras) {
				figura.setY(mayor.getY());
			}
	        //muestra
	        for (Figura f : figuras) {
	        	System.out.println(f.toString());
			}
	}
	
	public void alinearFigurasHorizontalmente() {
		
		if (figuras.size() == 0) {
			System.out.println("No hay figuras creadas");
			return;
		}
		
		//Asigna la figura mayor
		  Figura mayor = figuras.get(0);
		  
		  //compara con las otras figuras
	        for (Figura figura : figuras) {
	            if (figura.getX() > mayor.getX()) {
	                mayor = figura;
	            } 
	        }
	        //iguala las coordenadas X
	        for (Figura figura : figuras) {
				figura.setX(mayor.getX());
			}
	        //muestra
	        for (Figura f : figuras) {
	        System.out.println(f.toString());
			}
	}
	
	public void MostrarFigurasPorPerimetroMayor() {
		
	 if (figuras == null ) {
		System.out.println("No hay figuras creadas");
		return;
	}
		
		Figura aux; 
		for (int i = 0; i < figuras.size() - 1; i++)
			for (int j = i + 1; j < figuras.size(); j++)
				if (figuras.get(i).getPerimetro() < figuras.get(j).getPerimetro())
				{
					aux = figuras.get(i); 				// aux = copia[i]
					figuras.set(i, figuras.get(j)); 	// copia[i] = copia[j]
					figuras.set(j, aux);				// copia[j] = aux
				}
		
		for (Figura figura : figuras) {
			figura.toString();
		}
	}
	
	 public void blanco(Figura fa) {
		 int total=0;
		 
		 for(Figura f: figuras) {
			 if(f != null) {
				 total+=f.getArea();
			 }
			 
			 total+=fa.getArea();
			 
			 if(alto * ancho > total) {
				 
			 }
		 }
		 
	 }

	@Override
	public String toString() {
		return "Lienzo [nombre=" + nombre + ", ancho=" + ancho + ", alto=" + alto + ", area=" + area + ", figuras="
				+ figuras + "]";
	}
}
	
	
	



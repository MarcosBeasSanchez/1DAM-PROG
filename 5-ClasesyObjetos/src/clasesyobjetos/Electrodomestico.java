package clasesyobjetos;


import daw.com.Teclado;


public class Electrodomestico {
	

	
	//Estado de la clase
	
	final public String CONSUMO[] = {"A","B","C","D","E","F"};
	final public String COLOR[] ={"blanco", "negro", "rojo", "azul", "gris"};
	
	private float precio;
	private String color;
	private String consumo ;
	private float peso;
	
	//Constructores
	
	//por defecto 
	
	public Electrodomestico() {
		precio = 100;
		color = COLOR[0];
		consumo = CONSUMO[5];
		peso = 5;
	}
	
	public Electrodomestico(float price,String colour , String consumption, float weight) {
		precio = price;
		setColor(colour) ;
		setConsumo(consumption);
		setPeso(weight);
	}
	
	/*public Electrodomestico(float price, float weight) {
	price = precio;
	weight = peso;
	this color;
}*/

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		color =comprobarColor(color);
		
		this.color = color;
	}

	public String getConsumo() {
		return consumo;
	}

	public void setConsumo(String consumo) {
		
		consumo = comprobarConsumoEnergetico(consumo);
		this.consumo = consumo;
	}

	public float getPeso() {

		return peso;
	}

	public void setPeso(float peso) {
		if (peso < 0) {
			peso = 0;
		}
		this.peso = peso;
	}
	
	public void leerDatos ()
	{
		
		setPrecio (Teclado.leerFloat("Precio =  "));
		setColor(Teclado.leerString("Color = "));
		setPeso (Teclado.leerFloat("Peso = "));
		setConsumo (Teclado.leerString("Letra de consumo = "));
	}
	
	public void mostrarDatos() {
		System.out.println("PRECIO = " + precioFinal());
		System.out.println("COLOR = " + color);
		System.out.println("PESO = " + peso);
		System.out.println("CONSUMO = " + consumo);
	}
	

	@Override
	public String toString() {
		return "Electrodomestico [precio=" + precio + ", PrecioFinal = " + precioFinal() + 
				", color=" + color + ", consumo=" + consumo + ", peso=" + peso+ "]";
	}

	public String comprobarConsumoEnergetico(String consumption){
		String letra = consumption.toUpperCase();
		
		if (letra == null) {
			letra = "F";
		}
		
		  for (int i = 0; i < CONSUMO.length; i++) {
		        if (letra.equalsIgnoreCase(CONSUMO[i])) {
		            return CONSUMO[i];
		        }
		    }
		  System.out.println("Letra imposible, se pondrá por defecto F");
      	return CONSUMO[5];
		}
	
	public String comprobarColor(String colour){
		String decisionColor = colour;
		
		if (decisionColor == null) {
			decisionColor = "blanco";
		}
		
		  for (int i = 0; i < COLOR.length; i++) {
		        if (decisionColor.equalsIgnoreCase(COLOR[i])) {
		            return COLOR[i];
		        }
		    }
		    System.out.println("Color imposible, se pondrá por defecto blanco");
		    return COLOR[0];
		}
	
	public float precioFinal() {
		float precioBase = precio;
		float precioAñadido = 0;
		float precioFinal = 0;
		
		switch (getConsumo().toUpperCase()) {
		
		case "A":
			precioAñadido = 100;
			break;
		case "B":
			precioAñadido= 80;
			break;
		case "C":
			precioAñadido = 60;
			break;
		case "D":
			precioAñadido = 50;
			break;
		case "E":
			precioAñadido = 30;
			break;
		case "F":
			precioAñadido = 10;
			break;
		default : 
			System.out.println("LETRA ERRONEA");
			
		}
		if (getPeso() >= 0 && getPeso() <= 19) {
		    precioAñadido += 10;
		} else if (getPeso() >= 20 && getPeso() <= 49) {
		    precioAñadido += 50;
		} else if (getPeso() >= 50 && getPeso() <= 79) {
		    precioAñadido += 80;
		} else {
		    precioAñadido += 100;
		}
			
			precioFinal = precioBase + precioAñadido;
			
			return precioFinal;
			
			}
	} 

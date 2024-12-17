package examen2Final;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import daw.com.Teclado;

class Pentagono extends Figura implements LeerDatos{
    int numeroDeLados;

    public Pentagono(String nombre, Tipo tipo, int grosor, int color,List<Punto>puntos, int numeroDeLados) {
        super(nombre, tipo, grosor, color, puntos);
        this.numeroDeLados = numeroDeLados;
    }
    
    public Pentagono() {
    	super();
    	this.numeroDeLados = 0;
    }
    

    public int getNumeroDeLados() {
		return numeroDeLados;
	}

	public void setNumeroDeLados(int numeroDeLados) {
		if (numeroDeLados < 5) {
			throw new IllegalArgumentException("el numero de lados no puede ser inferior a 5");
		}
		this.numeroDeLados = numeroDeLados;
	}
	
	

	@Override
	public void leerSoloDatos() {
		super.leerSoloDatos();
		try {
			setNumeroDeLados(Teclado.leerInt("Numero de lados del pentagono"));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());		}
	}

	@Override
    public double calcularPerimetro() {
        return numeroDeLados * grosor;
    }

    @Override
    public String toString() {
        return "Pentagono: " + nombre + " con " + numeroDeLados + " lados";
    }
    
    public void guardarDatos(DataOutputStream salida) throws IOException {
    	super.guardarDatos(salida);
    	salida.writeInt(numeroDeLados);
    }
    
    public void leerEntrada(DataInputStream entrada) throws IOException {
    	super.leerEntrada(entrada);
    	numeroDeLados = entrada.readInt();
    }

}
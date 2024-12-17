package examen2Final;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

import daw.com.Teclado;

class Punto {
    int x, y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Punto() {
    	this.x = 0;
    	this.y = 0;
    }
    
    
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void leerPuntos() {
    	x = Teclado.leerInt("Punto X");
    	y = Teclado.leerInt("Punto Y");
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Punto other = (Punto) obj;
		return x == other.x && y == other.y;
	}

	public void guardarDatos(DataOutputStream salida) throws IOException{
		salida.writeInt(x);
		salida.writeInt(y);
	}

	public void leerEntrada(DataInputStream entrada) throws IOException {
		x = entrada.readInt();
		y = entrada.readInt();
		
	}
}
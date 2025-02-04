package tareas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import daw.com.Teclado;

public class TareaPersonal extends Tarea implements Leer{

	private static final long serialVersionUID = 1L;
	private Prioridad prioridad;
	
	public TareaPersonal() {
		this("");
		
	}
	
	public TareaPersonal(String desciption) {
		super(desciption);
		this.prioridad = Prioridad.BAJA;
	}
	
	public TareaPersonal(String desciption,boolean b,Prioridad prioridad) {
		super(desciption,b);
		this.prioridad = prioridad;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}
	
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return super.toString() + "TareaPersonal [prioridad=" + prioridad + "]";
	}

	@Override
	public void mostrar() {
	System.out.println("Soy una tarea personal");
		
	}

	@Override
	//lee solo datos sin ID
	public void leerSoloDatos() {
		super.leerSoloDatos();
		do {
			try {
				setPrioridad(Prioridad.valueOf(Teclado.leerString("Prioridad (ALTA/MEDIA/BAJA)").toUpperCase()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				prioridad = null;
			}
		} while (prioridad == null);
	}

	@Override
	//lee todo con ID
	public void leerTodo() {
		super.leerTodo();
		do {
			try {
				setPrioridad(Prioridad.valueOf(Teclado.leerString("Prioridad (ALTA/MEDIA/BAJA)").toUpperCase()));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				prioridad = null;
			}
		} while (prioridad == null);
	}

	@Override
	public void toCSV(PrintWriter salida) {
		salida.print("PERSONAL");
		salida.print(";");
		salida.print(super.getId());
		salida.print(";");
		salida.print(super.getDescripcion());
		salida.print(";");
		salida.print(super.isCompletada());
		salida.print(";");
		salida.print(prioridad);
		salida.print(";");
	}
	
	@Override
	public void fromCSV(String[] val) {
		super.setId(Integer.parseInt(val[4]));
		super.setDescripcion(val[5]);
		super.setCompletada(Boolean.parseBoolean(val[6]));
		prioridad = Prioridad.valueOf(val[7]);
	}

	@Override
	public void toDAT(DataOutputStream salida) throws IOException {
		salida.writeInt(super.getId());
		salida.writeUTF(super.getDescripcion());
		salida.writeBoolean(super.isCompletada());
		salida.writeUTF(prioridad.toString());	
	}

	@Override
	public void fromDAT(DataInputStream entrada) throws IOException {
		super.setId(entrada.readInt());
		super.setDescripcion(entrada.readUTF());
		super.setCompletada(entrada.readBoolean());
		prioridad = Prioridad.valueOf(entrada.readUTF());
		
	}
	
	


	
	
	
	
	
}

package tareas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import daw.com.Teclado;

public class TareaTrabajo extends Tarea implements Leer{
	
	private static final long serialVersionUID = 1L;
	LocalDate fechaEntrega;
	
	public TareaTrabajo () {
		this("");
	}

	public TareaTrabajo(String desciption) {
		super(desciption);
        this.fechaEntrega = LocalDate.now().plusWeeks(1); // 7 dias	
	}
	
	public TareaTrabajo(String desciption,LocalDate prior) {
		super(desciption);
        setFechaEntrega(prior);
	}

	public LocalDate getFechaEtnrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		if(fechaEntrega.isBefore(LocalDate.now())) {
			fechaEntrega = LocalDate.now();
			System.out.println("fecha entrega no puede ser anterior a la actual, cambiada a hoy: " + LocalDate.now());
		}
		this.fechaEntrega = fechaEntrega;
	}
	
	@Override
	public String toString() {
		return super.toString() + "TareaTrabajo [fechaEtnrega=" + fechaEntrega + "]";
	}

	@Override
	public void mostrar() {
		System.out.println("Soy una tarea de trabajo");
		
	}
	
	@Override
	//leer solo datos sin ID
	public void leerSoloDatos() {
		super.leerSoloDatos();
		do {
			try {
				setFechaEntrega(LocalDate.parse(Teclado.leerString("Introduce la fecha de entrega (yyyy-MM-dd)")));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				fechaEntrega = null;
			}
		} while (fechaEntrega == null);
		
	}

	@Override
	//leer todo con ID
	public void leerTodo() {
		super.leerTodo();
		
		do {
			try {
				setFechaEntrega(LocalDate.parse(Teclado.leerString("Introduce la fecha de entrega (yyyy-MM-dd)")));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				fechaEntrega = null;
			}
		} while (fechaEntrega == null);
	}

	@Override
	public void toCSV(PrintWriter salida) {
		salida.print("TRABAJO");
		salida.print(";");
		salida.print(super.getId());
		salida.print(";");
		salida.print(super.getDescripcion());
		salida.print(";");
		salida.print(super.isCompletada());
		salida.print(";");
		salida.print(fechaEntrega);
		salida.print(";");
		
	}
	@Override
	public void fromCSV(String[] val) {
		super.setId(Integer.parseInt(val[4]));
		super.setDescripcion(val[5]);
		super.setCompletada(Boolean.parseBoolean(val[6]));
		fechaEntrega = LocalDate.parse(val[7]);
	}

	@Override
	public void toDAT(DataOutputStream salida) throws IOException {
		salida.writeInt(super.getId());
		salida.writeUTF(super.getDescripcion());
		salida.writeBoolean(super.isCompletada());
		salida.writeUTF(fechaEntrega.toString());
		
	}

	@Override
	public void fromDAT(DataInputStream entrada) throws IOException {
		super.setId(entrada.readInt());
		super.setDescripcion(entrada.readUTF());
		super.setCompletada(entrada.readBoolean());
		fechaEntrega = LocalDate.parse(entrada.readUTF());
		
	}


	
	

}

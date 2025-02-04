package tutorialProyecto;


public class App {
	
	//Como montar un proyecto en Java que lea datos de entrada y escriba de salid por ejemplo .csv y .dat
	
	//1.CargarDatos de entrada (.dat o .csv) si existen 
	//.dat (DataInputStream(FileInputStrema) split(";") y ir poco a poco leyendo los datos y parseando los datos de entrada a sus tipos)
	//.csv (BufferedReader(FileReader)) escribir valor cuantos en las listas y luego leer los valores de cada objeto
	
	//2. Menu de opciones
	
	//3. GuardarDatos de salida (.dat o .csv)
    //.dat (DataOutputStream(FileOutputStream) y escribir los datos de salida)
	//.csv (BufferedWriter(FileWriter) y escribir los datos de salida)
	
	//EJEMPLO DE UNA CLASE QUE GUARDA DATOS DE ENTRADA Y SALIDA
	
//	@Override
//	public String writeCSV() {
//		String linea = "";
//		
//		linea += nombre;
//		linea += ";";
//		linea += nautores;
//		linea += ";";
//		linea += precio;
//		linea += ";";
//		linea += tipo;
//		linea += ";";
//		linea += fecha;
//		linea += ";";
	
//		return linea;
//	}
//
//	@Override
//	public void fromCSV(String[] valores) throws IOException {
//		
//		nombre = valores[1];
//		nautores = Integer.parseInt(valores[2]);
//		precio = Float.parseFloat(valores[3]);
//		tipo = Tipo.valueOf(valores[4]);
//		fecha = LocalDate.parse(valores[5]);
//		
//	}
//
//	@Override
//	public void writeDAT(DataOutputStream salida) throws IOException {
//		salida.writeUTF(nombre);
//		salida.writeInt(nautores);
//		salida.writeFloat(precio);
//		salida.writeUTF(tipo.toString());
//		salida.writeUTF(fecha.toString());
//		
//	}
//
//	@Override
//	public void readDAT(DataInputStream entrada) throws IOException {
//		nombre = entrada.readUTF();
//		nautores = entrada.readInt();
//		precio = entrada.readFloat();
//		tipo = Tipo.valueOf(entrada.readUTF());
//		fecha = LocalDate.parse(entrada.readUTF());
//	}
//	
	
	

}

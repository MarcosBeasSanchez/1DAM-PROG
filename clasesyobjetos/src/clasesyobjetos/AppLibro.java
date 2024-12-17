package clasesyobjetos;


import daw.com.Teclado;

public class AppLibro {

	public static void main(String[] args) {
		
		// Indicar libro con mas pag, ordenar alfabeticamente, un autor anonimo y no pueden repretirse los autores
		
		Libro libros[];
		int nlibros;
		
		//Crear array libros
		
		nlibros = Teclado.leerInt("Cuantos libros quieres Ingresar? : ");
		
		libros = new Libro[nlibros];
		
		for(int i = 0; i< nlibros; i++) {
			libros[i] = new Libro();
		}
		
		// Leer datos de los libros
		
		for (int i = 0 ; i < nlibros ; i++) {
			libros[i].leerDatos();
		}
		
		// Mostrar datos
		for (Libro libro: libros) {
			 System.out.println(libro.toString());	
			 }
		
		encontrarLibroConMasPaginas(libros); 
		ordenarAlfabeticamente(libros);	
	}
	
	public static void encontrarLibroConMasPaginas(Libro[] libros) {
        if (libros == null || libros.length == 0) {
           System.out.println("No hay libros a evaluar"); 
        }

        Libro libroConMasPaginas = libros[0]; // Inicializar con el primer libro

        for (int i = 1; i < libros.length; i++) {
            if (libros[i].getPaginas() > libroConMasPaginas.getPaginas()) {
                libroConMasPaginas = libros[i];
            }
        }
      System.out.println("El libro con mas paginas es: "  + libroConMasPaginas);
    }
	public static void ordenarAlfabeticamente(Libro[] libros) {

		
		Libro aux;
		
		for  ( int i = 0 ; i < libros.length -1 ; i++) {
			for (int j = i + 1; j< libros.length; j++) {
				if(libros[j].getTitulo().compareToIgnoreCase(libros[i].getTitulo()) < 0){
					aux = libros[i];
					libros[i] = libros[j];
					libros[j] = aux;
				
			}
		}
	}
		// Mostrar datos
		 for (Libro libro : libros) {
				System.out.println(libro.toString());
				 }
}
	private static int buscarLibro(Libro[] libros, Libro temp) {

		int lugar = -1;
		
		if (temp != null)
		{
			for (int i = 0; lugar == -1 && i < libros.length ; i++)
			{
				if (temp.equals(libros[i]))
					lugar = i;
			}
		}
		
		return lugar;
	}
}

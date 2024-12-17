package ejclase;

import daw.com.Teclado;

public class AppInstituto {
	
	Instituto app;

	public AppInstituto() {
	app = new Instituto("Dam");	
	app.cargarDatos(); 
	
	
	}

	public static void main(String[] args) {
		AppInstituto app = new AppInstituto();
		

	}

}

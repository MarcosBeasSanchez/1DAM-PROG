package excepciones;

public class AppBonoTransporte {
	

	public static void main(String[] args) {
		BonoTransporte bono = new BonoTransporte();
		
		bono.leerDatos();
		bono.recargarBono();
		
		/*Hay diferencia entre meter el FOR dentro de TRY(se ejecuta 5 veces)
		 *  o el TRY dentro del FOR(se ejecuta hasta el error y para)*/
		
			try {
				for (int i = 0; i < 5 ;i++) {
				bono.picarBono();
				}
				
			}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
			}
			catch(RuntimeException e){
				System.out.println(e.getMessage());
			}
		bono.recargarBono();
		
		
		
		
		
		}
	}

package Arrays;
import daw.com.Teclado;

public class arrayEjer23 {

	public static void main(String[] args) {
		// Leer 10 números enteros, almacenarlos en un array y determinar si el promedio entero 
		// de estos datos está almacenado en el array
		
		int CdN[],numeros=10 ,media;
		boolean estaMedia=false;
		
		CdN = new int [numeros];
		
		for (int i=0; i < 10 ; i++)
		{
			CdN[i]=Teclado.leerInt("dame 10 numeros");
		}
		
		media = (CdN[0] + CdN[1] + CdN[2] + CdN[3] + CdN[4] + CdN[5] + CdN[6] + CdN[7] + CdN[8] + CdN[9]) /10 ;
		
		for(int i=0; !estaMedia && i < CdN.length; i++)
			if (CdN[i] == media )
				estaMedia=true;
		
		if(estaMedia)
		System.out.println("La media esta entre los numeros escritos");
		else
			System.out.println("la media NO esta entre los elementos");
	}

}


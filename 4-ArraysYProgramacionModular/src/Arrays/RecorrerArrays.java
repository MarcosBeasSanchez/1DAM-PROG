package Arrays;

import daw.com.Pantalla;
import daw.com.Teclado;

public class RecorrerArrays {


		  public static void main(String[] args) {
			  int opcion = 0;
			  
			  do {
				  mostrarOpciones();
				  opcion = Teclado.leerInt("¿QUE OPCION TOMAS?");
				  evaluarOpcion(opcion);
			  }while(opcion != 4); 
		  }	  
		    
		 private static void recorrer1Dimension (int[] n1Dimension) {
			 for (int i = 0; i < n1Dimension.length; ++i) {
			        System.out.println(n1Dimension[i]);
			      }
		 		}
		 
		 private static void recorrer2Dimension (int [][]n2Dimension){
			 for (int i = 0; i < n2Dimension.length; ++i) {
			      for(int j = 0; j < n2Dimension[i].length; ++j) {
			        System.out.println(n2Dimension[i][j] );
			      }
			    }
		 	  }
		 
		 private static void recorrer3Dimension (int[][][]n3dimension) {
			 
			 int cont = 1;
			 
			 
			 for (int i = 0; i < n3dimension.length; i++) {
				 for(int j = 0; j<n3dimension[i].length;j++) {
					 for( int k =0 ; k < n3dimension[i][j].length; k++) {
						 n3dimension[i][j][k] = cont;
						 cont++;
					 }
				 } 
			 }
			 
			 
			 for (int i = 0; i < n3dimension.length; i++) {
		            for(int j = 0; j < n3dimension[i].length; j++) {
		                for( int k = 0; k < n3dimension[i][j].length; k++) {
		                    System.out.print(n3dimension[i][j][k] + "\t");
		                    
		                }Pantalla.escribirSaltoLinea();
		            }
		        }
		 }
		  
		 private static void mostrarOpciones() {
			 System.out.println("1.Recorrer ARRAY de 1 dimension");
			 System.out.println("2.Recorrer ARRAY de 2 dimensiones");
			 System.out.println("3.Recorrer ARRAY de 3 dimensiones");
			 System.out.println("4.SALIR");
		 }
		 
		 private static int evaluarOpcion(int opcion) { 
			 switch(opcion) {
			 
			 case 1:
				//PARA RECORRER 1 DIMESION
				  int[] n1Dimension = { 1, 2, 3, 4};
				  recorrer1Dimension(n1Dimension);
				  break;
				  
			 case 2:
				 //PARA RECORRER 2 DIMESIONES
				  int[][] n2Dimension = { {1, 2, 3, 4}, {5, 6, 7} };
				   recorrer2Dimension(n2Dimension);
				   break;
				   
			 case 3:
				 //PARA RECORRER 3 DIMENSIONES
			        int[][][] n3dimension = new int[2][2][2];;
			        recorrer3Dimension(n3dimension);
			        break;
			        
			 case 4:
				 System.out.println("FIN");
				 break;
			 }
			return opcion;
		 }
		 
		  
		}
		
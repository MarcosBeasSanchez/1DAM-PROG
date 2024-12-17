package biblioteca;

/**
 * El enum Genero define los posibles géneros de los materiales disponibles en la biblioteca.
 * Los géneros pueden ser NOVELA, TERROR, FICCION o COMEDIA.
 */
public enum Genero {
   
    NOVELA,TERROR,FICCION,COMEDIA;
	
	
/**
 * 
 * @param genero
 * @return true si el string genero es igual a alguno de los valores del enum 
 * @return false si el string genero no coincide con ninguno de los valores del enum 
 */
	  public boolean generoValido() {
	        for (Genero g : Genero.values()) {
	            if (this == g) {
	                return true;
	            }
	        }
	        return false;
	    }
	}

package ficheros;

import java.io.File;

public class InfoFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if( args.length > 0 )
		{
			for( int i=0; i < args.length; i++ )
			{
				File f = new File( args[i] );
				System.out.println( "Nombre: "+f.getName() );
				System.out.println( "Camino: "+f.getPath() );
				if( f.exists() )
				{
					System.out.print( "Fichero existente " );
					System.out.print( (f.canRead() ?
							" y se puede Leer" : "" ) );
					System.out.print( (f.canWrite() ?
							" y se puese Escribir" : "" ) );
					System.out.println( "." );
					System.out.println( "La longitud del fichero son "+
							f.length()+" bytes" );
				}
				else
					System.out.println( "El fichero no existe." );
			}
		}
		else
			System.out.println( "Debe indicar un fichero." );
	}


}
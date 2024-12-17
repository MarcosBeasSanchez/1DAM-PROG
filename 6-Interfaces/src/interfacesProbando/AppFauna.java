package interfacesProbando;



import java.util.ArrayList;

public class AppFauna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Cantante> cantantes = new ArrayList<Cantante>();
		
		Pajaro p1 = new Pajaro ("Europa","migratorio","rojo");
		Sabio s1 = new Sabio ("blanca",30,true,5);
		Sabio s2 = new Sabio ("amarilla",20,false,15);
		Pajaro p2 = new Pajaro ("Africa","nomada","verde");
		
		cantantes.add (p1);
		cantantes.add (s1);
		cantantes.add (p2);
		cantantes.add (s2);
 
		//Primero afinamos
		for (int i = 0; i < cantantes.size(); i++)
			afinarCantante(cantantes.get(i));
		
		// Hacer cantar a todos
		for (int i = 0; i < cantantes.size(); i++)
			hacerCantar(cantantes.get(i));
		
		
	}
	
	public static void afinarCantante(Cantante c)
	{
		c.afinar("1,2,3 se me oye?");
	}
	
	public static void hacerCantar(Cantante c)
	{
		c.cantar();
	}

}

import java.lang. *; 


/**
* Deze klasse is een java programma
* @author Ruben Wouters
* @version 1,5
*/

public class Oef1{

	public static void main(String args[]) 
	{
		Vermenigvuldig(1, 9);
	}

	private static void Vermenigvuldig(int basis, int max)
	{
		for(int i = 1; i <= max; i++)
		{
			int result = (basis * i);
			System.out.println( basis + " x " +  i + " = " + result);
		}
	}


}
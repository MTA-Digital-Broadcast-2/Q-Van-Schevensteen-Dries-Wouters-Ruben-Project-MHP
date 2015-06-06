import java.lang. *; // anders moet je bv bij "System.out.println("..") nog altijd java.lang. voorzetten 


/**
* Deze klasse is een java programma
* @author Ruben Wouters
* @version 1,5
*/

public class EersteProg{

		public static void main(String args[]) 
	{
		drukaf(100);
	}

	private static void drukaf(int m)
	{
		int a;

		for(a = 0; a < m; a++ )
		{
			System.out.println(a);
		}
	}


}
import java.lang. *; 


/**
* Deze klasse is een java programma
* @author Ruben Wouters
* @version 1,5
*/

public class Oef3{

	public static void main(String args[]) 
	{
		double pi = 0;
		boolean add = false;
		double deler = 1;

		for(int i = 0; i <= 10000; i++)
		{
			if(add)
			{
				pi -= (1.0f/deler);
			}
			else
			{
				pi += (1.0f/deler);
			}
			add = !add;
			deler += 2;
		}

		pi *= 4;

		System.out.println(pi);

	}


}
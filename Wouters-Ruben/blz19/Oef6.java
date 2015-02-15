import java.lang. *; 


/**
* Deze klasse is een java programma
* @author Ruben Wouters
* @version 1,5
*/

public class Oef6{

	public static void main(String args[]) 
	{
		int a[] = {12, 34, 56, 78, 123, 234, 99, 88};

		int grootste= 0;
		int vorige = 0;


		for(int i= 0; i < a.length; i++)
		{
			if(grootste < a[i])
			{
				grootste = a[i];
				vorige = a[i];
			}
		}

		System.out.println(grootste);
	}


}
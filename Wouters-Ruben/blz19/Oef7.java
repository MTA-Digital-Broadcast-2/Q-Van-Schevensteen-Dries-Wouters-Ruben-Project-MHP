import java.lang. *; 
import java.util.Arrays;

/**
* Deze klasse is een java programma
* @author Ruben Wouters
* @version 1,5
*/

public class Oef7{

	public static void main(String args[]) 
	{
		int a[] = {12, 34, 56, 78, 123, 234, 99, 88};
		int b[];
		b = new int[8];

		int grootste= 0;
		int index = 0;
		int indexGrootste = 0;

		for(int j = 0; j < a.length; j++)
		{
			for(int i= 0; i < a.length; i++)
			{
				if(grootste < a[i])
				{
					grootste = a[i];
					indexGrootste = i;
				}
			}
			b[j] = a[indexGrootste];
			a[indexGrootste] = 0;
			grootste = 0;
		}

		
		System.out.println("Array B: " + Arrays.toString(b));
		System.out.println("Array A: " + Arrays.toString(a));
	}
}
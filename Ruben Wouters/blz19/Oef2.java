import java.lang. *; 


/**
* Deze klasse is een java programma
* @author Ruben Wouters
* @version 1,5
*/

public class Oef2{

	public static void main(String args[]) 
	{
		String dagen[] = {"Zondag", "Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag", "Zaterdag"};
		String maand = "Februari";
		int aantalDagen = 27;
		int j = 0;
		
		for(int i = 1; i <= aantalDagen; i ++)
		{
			
			System.out.println(dagen[j] + " " + i + " " + maand);
			j++;
			if(j == 7)
			{
				j = 0;
			}
		}

	}


}
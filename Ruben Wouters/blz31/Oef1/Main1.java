import java.lang. *; 

public class Main1{

	public static void main(String args[]) 
	{
		Werknemer1 herman = new Werknemer1("Herman", "Hermans", 1, 1000);
		Werknemer1 jan = new Werknemer1("Jan", "Verbruggen", 2, 3500);
		Werknemer1 piet = new Werknemer1("Piet", "Schots", 3, 900);
		Werknemer1 hugo = new Werknemer1("Hugo", "Vanderwegen", 4, 2100);

		
		System.out.println(herman.voornaam);
	}
}
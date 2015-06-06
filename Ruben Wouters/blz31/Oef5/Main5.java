import java.lang. *; 

public class Main5{

	public static void main(String args[]) 
	{
		Werknemer5 herman = new Werknemer5("Herman", "Hermans", 1, 1000);
		Werknemer5 jan = new Werknemer5("Jan", "Verbruggen", 2, 3500);
		Werknemer5 piet = new Werknemer5("Piet", "Schots", 3, 900);
		Werknemer5 hugo = new Werknemer5("Hugo", "Vanderwegen", 4, 2100);

		PartTimeWerknemer5 ruben = new PartTimeWerknemer5("Ruben", "Wouters", 5, 9000, 20);
		PartTimeWerknemer5 ellen = new PartTimeWerknemer5("Ellen", "Neubourg", 6, 5000, 30);
	}
}
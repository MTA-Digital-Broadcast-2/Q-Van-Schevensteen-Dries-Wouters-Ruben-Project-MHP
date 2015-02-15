import java.lang. *; 

public class Main10{

	public static void main(String args[]) 
	{
		Werknemer10 herman = new Werknemer10("Herman", "Hermans", 1, 1000);
		Werknemer10 jan = new Werknemer10("Jan", "Verbruggen", 2, 3500);
		Werknemer10 piet = new Werknemer10("Piet", "Schots", 3, 900);
		Werknemer10 hugo = new Werknemer10("Hugo", "Vanderwegen", 4, 2100);

		PartTimeWerknemer10 ruben = new PartTimeWerknemer10("Ruben", "Wouters", 5, 9000, 20);
		PartTimeWerknemer10 ellen = new PartTimeWerknemer10("Ellen", "Neubourg", 6, 5000, 30);

		StudentWerknemer10 student = new StudentWerknemer10("Amy", "Wouters", 7, 1000, 10);

		Factuur10 factuur = new Factuur10(1, 13500);

		factuur.betaal();
	}
}
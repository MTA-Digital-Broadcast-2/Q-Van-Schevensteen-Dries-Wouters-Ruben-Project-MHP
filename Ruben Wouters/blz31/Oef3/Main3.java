import java.lang. *; 

public class Main3{

	public static void main(String args[]) 
	{
		Werknemer3 herman = new Werknemer3("Herman", "Hermans", 1, 1000);
		Werknemer3 jan = new Werknemer3("Jan", "Verbruggen", 2, 3500);
		Werknemer3 piet = new Werknemer3("Piet", "Schots", 3, 900);
		Werknemer3 hugo = new Werknemer3("Hugo", "Vanderwegen", 4, 2100);

		PartTimeWerknemer3 ruben = new PartTimeWerknemer3("Ruben", "Wouters", 5, 9000, 20);
		PartTimeWerknemer3 ellen = new PartTimeWerknemer3("Ellen", "Neubourg", 6, 5000, 30);


		herman.salarisVerhogen(10);
		System.out.println(herman.getSalaris());
		System.out.println(ruben.getSalaris());
	}
}
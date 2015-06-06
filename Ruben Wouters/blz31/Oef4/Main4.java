import java.lang. *; 

public class Main4{

	public static void main(String args[]) 
	{
		Werknemer4 herman = new Werknemer4("Herman", "Hermans", 1, 1000);
		Werknemer4 jan = new Werknemer4("Jan", "Verbruggen", 2, 3500);
		Werknemer4 piet = new Werknemer4("Piet", "Schots", 3, 900);
		Werknemer4 hugo = new Werknemer4("Hugo", "Vanderwegen", 4, 2100);

		PartTimeWerknemer4 ruben = new PartTimeWerknemer4("Ruben", "Wouters", 5, 9000, 20);
		PartTimeWerknemer4 ellen = new PartTimeWerknemer4("Ellen", "Neubourg", 6, 5000, 30);

		ellen.salarisVerhogen(10);
		System.out.println("Opslag Ellen(10% opslag): " + ellen.getSalaris());

		ruben.salarisVerhogen(5);
		System.out.println("Salaris Ruben(5% opslag): " + ruben.getSalaris());
	}
}
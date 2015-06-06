import java.lang. *; 

public class Main6{

	public static void main(String args[]) 
	{
		Werknemer6 herman = new Werknemer6("Herman", "Hermans", 1, 1000);
		Werknemer6 jan = new Werknemer6("Jan", "Verbruggen", 2, 3500);
		Werknemer6 piet = new Werknemer6("Piet", "Schots", 3, 900);
		Werknemer6 hugo = new Werknemer6("Hugo", "Vanderwegen", 4, 2100);

		PartTimeWerknemer6 ruben = new PartTimeWerknemer6("Ruben", "Wouters", 5, 9000, 20);
		PartTimeWerknemer6 ellen = new PartTimeWerknemer6("Ellen", "Neubourg", 6, 5000, 30);


		// RSZ functie test FULLTIME MEDEWERKER
		System.out.println("Get fctie fulltime: " + herman.getRSZ());
		herman.setRSZ(50);
		System.out.println("Result: Set fctie fulltime: " + herman.getRSZ() );



		// RSZ functie test PARTTIME MEDEWERKER
		System.out.println("Get fctie PartTime: " + ruben.getRSZ());
		ruben.setRSZ(95);
		System.out.println("Result: Set fctie PartTime: " + ruben.getRSZ() );



	}
}
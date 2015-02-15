import java.lang. *; 

public class Main2{

	public static void main(String args[]) 
	{
		Werknemer2 herman = new Werknemer2("Herman", "Hermans", 1, 1000);
		Werknemer2 jan = new Werknemer2("Jan", "Verbruggen", 2, 3500);
		Werknemer2 piet = new Werknemer2("Piet", "Schots", 3, 900);
		Werknemer2 hugo = new Werknemer2("Hugo", "Vanderwegen", 4, 2100);

		herman.salarisVerhogen(10);
		System.out.println(herman.getSalaris());
	}
}
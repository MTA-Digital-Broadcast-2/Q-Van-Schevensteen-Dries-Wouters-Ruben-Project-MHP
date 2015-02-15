import java.lang. *; 

public class Main9{

	public static void main(String args[]) 
	{
		Werknemer9 herman = new Werknemer9("Herman", "Hermans", 1, 1000);
		Werknemer9 jan = new Werknemer9("Jan", "Verbruggen", 2, 3500);
		Werknemer9 piet = new Werknemer9("Piet", "Schots", 3, 900);
		Werknemer9 hugo = new Werknemer9("Hugo", "Vanderwegen", 4, 2100);

		PartTimeWerknemer9 ruben = new PartTimeWerknemer9("Ruben", "Wouters", 5, 9000, 20);
		PartTimeWerknemer9 ellen = new PartTimeWerknemer9("Ellen", "Neubourg", 6, 5000, 30);

		StudentWerknemer9 student = new StudentWerknemer9("Amy", "Wouters", 7, 1000, 10);

		ruben.betaal();
		jan.betaal();
		student.betaal();
	}
}
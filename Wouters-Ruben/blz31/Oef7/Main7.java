import java.lang. *; 

public class Main7{

	public static void main(String args[]) 
	{
		Werknemer7 herman = new Werknemer7("Herman", "Hermans", 1, 1000);
		Werknemer7 jan = new Werknemer7("Jan", "Verbruggen", 2, 3500);
		Werknemer7 piet = new Werknemer7("Piet", "Schots", 3, 900);
		Werknemer7 hugo = new Werknemer7("Hugo", "Vanderwegen", 4, 2100);

		PartTimeWerknemer7 ruben = new PartTimeWerknemer7("Ruben", "Wouters", 5, 9000, 20);
		PartTimeWerknemer7 ellen = new PartTimeWerknemer7("Ellen", "Neubourg", 6, 5000, 30);

		StudentWerknemer7 student = new StudentWerknemer7("Amy", "Wouters", 7, 1000, 10);
		System.out.println("RSZ percentage STUDENT: " + student.getRSZ());
	}
}
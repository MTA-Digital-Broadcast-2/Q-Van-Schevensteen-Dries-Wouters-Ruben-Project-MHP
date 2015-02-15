import java.lang. *; 

public class Main8{

	public static void main(String args[]) 
	{
		Werknemer8 herman = new Werknemer8("Herman", "Hermans", 1, 1000);
		Werknemer8 jan = new Werknemer8("Jan", "Verbruggen", 2, 3500);
		Werknemer8 piet = new Werknemer8("Piet", "Schots", 3, 900);
		Werknemer8 hugo = new Werknemer8("Hugo", "Vanderwegen", 4, 2100);

		PartTimeWerknemer8 ruben = new PartTimeWerknemer8("Ruben", "Wouters", 5, 9000, 20);
		PartTimeWerknemer8 ellen = new PartTimeWerknemer8("Ellen", "Neubourg", 6, 5000, 30);

		StudentWerknemer8 student = new StudentWerknemer8("Amy", "Wouters", 7, 1000, 10);
		System.out.println("RSZ percentage STUDENT: " + student.getRSZ());
	}
}
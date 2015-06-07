import java.lang.*;

public class Main {

    public static void main(String[] args) {
        PartTimeWerknemer[] partTimeWerknemers = createPartTimeWerknemers();

        for (int i = 0; i < partTimeWerknemers.length; i++)
            System.out.println(partTimeWerknemers[i].voornaam);
    }
    
    private static PartTimeWerknemer[] createPartTimeWerknemers() {
    	PartTimeWerknemer[] partTimeWerknemers = {
        	new PartTimeWerknemer("Dries", "Van Schevensteen", 1, 10000, 50),
			new PartTimeWerknemer("Bart", "Janssens", 2, 9500, 50)
		};

		return partTimeWerknemers;
	}
    
}
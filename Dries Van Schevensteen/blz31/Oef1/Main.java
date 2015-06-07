import java.lang.*;

public class Main {

	public static void main(String[] args) {
		Werknemer[] werknemers = createWerknemers();

    	for (int i = 0; i < werknemers.length; i++)
        	System.out.println(werknemers[i].voornaam);
	}
	
	private static Werknemer[] createWerknemers() {
		Werknemer[] werknemers = {
			new Werknemer("Dries", "Van Schevensteen", 1, 10000),
			new Werknemer("Bart", "Janssens", 2, 9500),
			new Werknemer("Tom", "Peeters", 3, 8000),
	  		new Werknemer("Emma", "Van Hool", 4, 9000)
	  	};
	  	
		return werknemers;
	}

}
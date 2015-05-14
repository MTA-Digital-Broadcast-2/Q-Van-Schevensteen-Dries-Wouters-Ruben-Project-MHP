import java.lang.*;

public class Main {

    public static void main(String[] args) {
        Werknemer[] werknemers = createWerknemers();
        werknemers[0].setRSZ(2);

        PartTimeWerknemer[] partTimeWerknemers = createPartTimeWerknemers();
        partTimeWerknemers[0].setRSZ(10);
        
        for (int i = 0; i < werknemers.length; i++)
            System.out.println(
                String.format(
                    "Het RSZ van werknemer %s %s is: %s%%", 
                    werknemers[i].voornaam, 
                    werknemers[i].achternaam, 
                    werknemers[i].getRSZ()
                )
            );

        for (int i = 0; i < partTimeWerknemers.length; i++)
            System.out.println(
                String.format(
                    "Het RSZ van part-time werknemer %s %s is: %s%%", 
                    partTimeWerknemers[i].voornaam, 
                    partTimeWerknemers[i].achternaam, 
                    partTimeWerknemers[i].getRSZ()
                )
            );
    }
    
    private static PartTimeWerknemer[] createPartTimeWerknemers() {
        PartTimeWerknemer[] partTimeWerknemers = {
            new PartTimeWerknemer("Dries", "Van Schevensteen", 3, 10000, 50),
            new PartTimeWerknemer("Bart", "Janssens", 4, 9500, 50)
        };

        return partTimeWerknemers;
    }
    
    private static Werknemer[] createWerknemers() {
        Werknemer[] werknemers = {
            new Werknemer("Marie", "Peeters", 1, 20000),
            new Werknemer("Tom", "Van Hool", 2, 12000)
        };

        return werknemers;
    }

}
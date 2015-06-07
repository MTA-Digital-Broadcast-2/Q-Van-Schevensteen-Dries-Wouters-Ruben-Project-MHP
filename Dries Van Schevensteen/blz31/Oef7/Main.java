import java.lang.*;

public class Main {

    public static void main(String[] args) {
        StudentWerknemer[] studentWerknemers = createStudentWerknemers();
        studentWerknemers[0].setRSZ(10);
        
        for (int i = 0; i < studentWerknemers.length; i++)
            System.out.println(
                String.format(
                    "Het RSZ van student werknemer %s %s is: %s%%", 
                    studentWerknemers[i].voornaam, 
                    studentWerknemers[i].achternaam, 
                    studentWerknemers[i].getRSZ()
                )
            );
    }
    
    private static StudentWerknemer[] createStudentWerknemers() {
        StudentWerknemer[] studentWerknemer = {
            new StudentWerknemer("Dries", "Van Schevensteen", 3, 10000),
            new StudentWerknemer("Bart", "Janssens", 4, 9500)
        };

        return studentWerknemer;
    }

}
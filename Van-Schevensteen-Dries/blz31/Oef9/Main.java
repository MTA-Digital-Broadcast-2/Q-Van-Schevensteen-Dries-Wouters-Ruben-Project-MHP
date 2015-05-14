import java.lang.*;

public class Main {

    public static void main(String[] args) {
        PartTimeWerknemer[] partTimeWerknemers = createPartTimeWerknemers();
        for (int i = 0; i < partTimeWerknemers.length; i++)
            partTimeWerknemers[i].betaal();
        
        StudentWerknemer[] studentWerknemers = createStudentWerknemers();
        for (int i = 0; i < studentWerknemers.length; i++)
            studentWerknemers[i].betaal();
        
        Werknemer[] werknemers = createWerknemers();
        for (int i = 0; i < werknemers.length; i++)
            werknemers[i].betaal();
    }
    
    private static PartTimeWerknemer[] createPartTimeWerknemers() {
        PartTimeWerknemer[] partTimeWerknemers = {
            new PartTimeWerknemer("Dries", "Van Schevensteen", 3, 10000, 50),
            new PartTimeWerknemer("Bart", "Janssens", 4, 9500, 50)
        };

        return partTimeWerknemers;
    }
    
    private static StudentWerknemer[] createStudentWerknemers() {
        StudentWerknemer[] studentWerknemer = {
            new StudentWerknemer("Jens", "Bal", 5, 3000),
            new StudentWerknemer("Jeroen", "Pannekoek", 6, 3500)
        };

        return studentWerknemer;
    }
    
    private static Werknemer[] createWerknemers() {
        Werknemer[] werknemers = {
            new Werknemer("Marie", "Peeters", 1, 20000),
            new Werknemer("Tom", "Van Hool", 2, 12000)
        };

        return werknemers;
    }
    
}
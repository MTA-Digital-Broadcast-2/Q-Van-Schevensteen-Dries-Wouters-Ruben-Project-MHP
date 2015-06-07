import java.lang.*;

public class Main {

    public static void main(String[] args) {
        Werknemer[] werknemers = createWerknemers();
        
        verhoogSalarisEerste2Werknemers(werknemers);

        for (int i = 0; i < werknemers.length; i++)
            System.out.println(werknemers[i].getSalaris());
    }
    
    private static Werknemer[] createWerknemers() {
        Werknemer[] werknemers = {new Werknemer("Dries", "Van Schevensteen", 1, 10000),
                                  new Werknemer("Bart", "Janssens", 2, 9500),
                                  new Werknemer("Tom", "Peeters", 3, 8000),
                                  new Werknemer("Emma", "Van Hool", 4, 9000)
        };
        
        return werknemers;
    }
    
    private static void verhoogSalarisEerste2Werknemers(Werknemer[] werknemers) {
        if (werknemers.length >= 2)
            for (int i = 0; i < 2; i++)
                werknemers[i].salarisVerhogen(10);
    }
}
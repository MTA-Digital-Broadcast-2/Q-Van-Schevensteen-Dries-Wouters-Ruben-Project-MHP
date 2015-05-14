import java.lang.*;

public class Main {

    public static void main(String[] args) {
        Factuur[] facturen = createFacturen();
        for (int i = 0; i < facturen.length; i++)
            facturen[i].betaal();
    }
    
    private static Factuur[] createFacturen() {
        Factuur[] facuren = {
            new Factuur(1, 42000),
            new Factuur(2, 54000)
        };

        return facuren;
    }

}
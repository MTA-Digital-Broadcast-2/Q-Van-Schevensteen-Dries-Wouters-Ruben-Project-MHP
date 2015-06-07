import java.lang.*;

public class Factuur implements Betaalbaar {

    public int factuurNr;
    public int factuurBedrag;
    
    public Factuur(int factuurNr, int factuurBedrag) {
        this.factuurNr = factuurNr;
        this.factuurBedrag = factuurBedrag;
    }
    
    public void betaal() {
        System.out.println("Betaal het facuur: " + this.factuurNr + " voor een bedrag van: " + this.factuurBedrag);
    }
    
}
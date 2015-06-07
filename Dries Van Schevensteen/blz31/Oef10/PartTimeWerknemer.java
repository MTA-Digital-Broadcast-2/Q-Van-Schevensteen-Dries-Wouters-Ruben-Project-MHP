import java.lang.*;

public class PartTimeWerknemer extends Werknemer {

    public int urenGewerkt;
    
    public PartTimeWerknemer(String voornaam, String achternaam, int werknemerNummer, float salaris, int urenGewerkt) {
        super(voornaam, achternaam, werknemerNummer, salaris);
        this.urenGewerkt = urenGewerkt;
    }
    
    public float getWeekLoon() {
        return this.salaris * (float)this.urenGewerkt;
    }
    
    public void salarisVerhogen(int percentage) {
        if(percentage < 5) {
            super.salarisVerhogen(percentage);
        } else {
            percentage = 0;
            System.out.println("Fout: slechts 5% opstalg toegestaan!");
        }
    }
    
}
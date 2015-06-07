import java.lang.*;

public class Werknemer {
    
    public String voornaam;
    public String achternaam;
    public int werknemerNummer;
    protected float salaris;
    private float RSZPercentage;
    
    public Werknemer(String voornaam, String achternaam, int werknemerNummer, float salaris) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.werknemerNummer = werknemerNummer;
        this.salaris = salaris;
        this.RSZPercentage = 33;
    }
    
    public void salarisVerhogen(int percentage) {
        float verhogingsfactor = (float)percentage/100;
        salaris += salaris * verhogingsfactor;
    }
    
    public float getSalaris() {
        return salaris;
    }
    
    public void setRSZ(float percentage) {
        this.RSZPercentage = percentage;
    }
    
    public float getRSZ() {
        return this.RSZPercentage;
    }

}
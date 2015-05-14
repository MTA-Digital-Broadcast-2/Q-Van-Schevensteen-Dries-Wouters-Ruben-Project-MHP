import java.lang.*;

public class StudentWerknemer extends Werknemer {
    
    public StudentWerknemer(String voornaam, String achternaam, int werknemerNummer, float salaris) {
        super(voornaam, achternaam, werknemerNummer, salaris);
        setRSZ(5);
    }
    
}
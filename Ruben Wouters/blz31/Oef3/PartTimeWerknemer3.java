import java.lang. *;

public class PartTimeWerknemer3 extends Werknemer3{

	public int urenGewerkt;

	public PartTimeWerknemer3(String voornaam, String achternaam, int nr, float sal, int urengw)
	{
		super(voornaam, achternaam, nr, sal);
		this.urenGewerkt = urengw;
	}

	public float getWeekLoon()
	{
		return this.salaris * (float)this.urenGewerkt;
	}



}
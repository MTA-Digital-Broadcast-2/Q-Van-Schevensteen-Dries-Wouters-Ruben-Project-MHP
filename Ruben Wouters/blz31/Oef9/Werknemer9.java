import java.lang. *; 


/**
* Deze klasse is een java programma
* @author Ruben Wouters
* @version 1,5
*/

public class Werknemer9 implements Betaalbaar9{

	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float rszPercentage = 33;

	public Werknemer9(String voornaam, String achternaam, int wNummer, float salaris)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.werknemerNummer = wNummer;
		this.salaris = salaris;
	}

	public void salarisVerhogen(int percentage)
	{
		float verhogingsfactor = (float)percentage/100;
		salaris += salaris * verhogingsfactor;
	}

	public float getSalaris()
	{
		return salaris;
	}

	public float getRSZ()
	{
		return this.rszPercentage;
	}

	public void setRSZ(float rsz)
	{
		this.rszPercentage = rsz;
	}

	public void betaal()
	{
		System.out.println("Betaal het salaris van " + this.salaris + " aan de werknemer " + this.voornaam);
	}
}
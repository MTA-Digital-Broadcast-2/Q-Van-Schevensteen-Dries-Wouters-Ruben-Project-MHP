import java.lang. *;

public class PartTimeWerknemer9 extends Werknemer9{

	public int urenGewerkt;

	public PartTimeWerknemer9(String voornaam, String achternaam, int nr, float sal, int urengw)
	{
		super(voornaam, achternaam, nr, sal);
		this.urenGewerkt = urengw;
	}

	public float getWeekLoon()
	{
		return this.salaris * (float)this.urenGewerkt;
	}

	public void salarisVerhogen(int percentage)
	{
		if(percentage > 5)
		{
			percentage = 0;
			System.out.println("Je mag niet zoveel opslag geven!");
		}
		else
		{
			System.out.println("Opslag geven gelukt!");
			super.salarisVerhogen(percentage);
		}
	}



}
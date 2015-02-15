import java.lang. *; 


/**
* Deze klasse is een java programma
* @author Ruben Wouters
* @version 1,5
*/

public class Factuur10 implements Betaalbaar10{

	public int factuurNr;
	public int factuurBedrag;

	public Factuur10(int fctNr, int fctBedrag)
	{
		this.factuurNr = fctNr;
		this.factuurBedrag = fctBedrag;
	}

	public void betaal()
	{
		System.out.println("Betaal het factuur van " + this.factuurNr + " voor een bedrag van " + this.factuurBedrag);
	}

}
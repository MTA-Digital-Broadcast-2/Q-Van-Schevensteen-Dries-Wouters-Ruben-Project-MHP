import java.lang.*;

public class Oef2 {

	public static void main(String[] args) {
		printDaysInFebruari2009();
	}

	private static void printDaysInFebruari2009() {
		String days[] = {"maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag"};
		String month = "februari";
		int daysInMonth = 28;

		int day = days.length - 1;
		for (int i = 1; i <= daysInMonth; i++) {
			System.out.print(days[day] + " " + i + " " + month + ", ");
			
			day ++;
			if (day > days.length - 1) day = 0;
		}
		
		System.out.println("");
	}

}
import java.lang.*;

public class Oef3 {

	public static void main(String[] args) {		
		System.out.println("Solution = " + calculatePi());
	}

	private static double calculatePi() {
		double solution = 0.0f;
		boolean add = true;

		for (int i = 1; i <= 30000; i += 2) {
		    if(add) solution += 1.0f/i; 
		    else solution -= 1.0f/i;
			add = !add;
		}

		return (solution *= 4);
	}

}
import java.lang.*;

public class Oef5 {

	public static void main(String[] args) {
		System.out.print("Prime numbers: ");
		for (int i = 3; i < 100; i++)
			if (isPrimeNumber(i))
				System.out.print(i + " ");

		System.out.println("");
	}

	private static boolean isPrimeNumber(int primeNumber) {
		for (int i = 2; i < primeNumber; i++)
			if (primeNumber / (i + 0.0f) == (int)(primeNumber / (i + 0.0f)))
					return false;

		return true;
	}
	
}
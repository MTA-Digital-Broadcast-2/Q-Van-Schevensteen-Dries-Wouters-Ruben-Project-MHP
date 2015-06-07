import java.lang.*;

public class Oef6 {

	public static void main(String[] args) {
		int a[] = {12, 34, 56, 78, 123, 234, 99, 88};
		System.out.println("Grootse getal: " + getLargestInArray(a));
	}

	private static int getLargestInArray(int[] numbers) {
		int largest = 0;
		for (int i = 0; i < numbers.length; i++)
			if (numbers[i] > largest) 
				largest = numbers[i];

		return largest;
	}

}
import java.lang.*;

public class Oef7 {

	public static void main(String[] args) {
		int a[] = {12, 34, 56, 78, 123, 234, 99, 88};
		int b[] = orderArrayByLargest(a);

		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");

		System.out.println("");
	}

	private static int[] orderArrayByLargest(int[] numbers) {
		int ordered[] = new int[numbers.length];
		
		int largest = 0;
		for (int i = 0; i < ordered.length; i++) {
			int largestIndex = 0;

			for (int j = 0; j < numbers.length; j++)
				if (numbers[j] > largest) {
					largest = numbers[j];
					largestIndex = j;
				}

			ordered[i] = largest;
			numbers[largestIndex] = largest = 0;
		}

		return ordered;
	}

}
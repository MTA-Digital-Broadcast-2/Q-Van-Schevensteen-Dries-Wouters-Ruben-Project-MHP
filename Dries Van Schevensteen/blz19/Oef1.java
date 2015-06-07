import java.lang.*;

public class Oef1 {

	public static void main(String[] args) {
		multiply(9, 9);
	}

	private static void multiply(int maxRange1, int maxRange2) {
		for (int i = 1; i <= maxRange1; i++)
			for (int j = 1; j <= maxRange2; j++)
				System.out.print(i + "x" + j + "=" + i*j + ", ");

		System.out.println("");
	}

}